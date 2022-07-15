// Copyright 2022 Llamas
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package chat.llamas.cardlogic.domain.evaluators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.stream.Collectors;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.CardComparator;
import chat.llamas.cardlogic.domain.HandResult;
import chat.llamas.cardlogic.domain.HandResultType;
import chat.llamas.cardlogic.domain.Rank;
import chat.llamas.cardlogic.domain.Suit;
import com.google.common.collect.Multimap;

public class FlushEvaluator extends HandResult {

	public FlushEvaluator() {
		super(HandResultType.FLUSH);
	}

	public FlushEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.FLUSH, rankValueMap);
	}

	@Override
	public boolean test(List<Card> arg0) {

		List<Card> cardQueue = new LinkedList<>(arg0);

		// Step 1: Collect the wild cards.
		List<Card> wildCards = collectWildCards(cardQueue);
		
		// Step 2: Sort the remaining cards by rank.
		Collections.sort(cardQueue, CardComparator.get(getRankValueMap()));

		
		// Step 3: Look for Flushes.
		List<Suit> checkedSuits = new ArrayList<>();
		
		List<Card> flushCards = new ArrayList<>();
		
		ListIterator<Card> iterator = cardQueue.listIterator();
		
		// These are sorted.
		while (iterator.hasNext()) {
			Card card = iterator.next();
			
			Suit suit = card.getSuit();
			if (!checkedSuits.contains(suit)) {
				checkedSuits.add(suit);
				
				
			    List<Card> cardsToCheck = cardQueue.stream().filter(checkedCard -> Objects.equals(suit, checkedCard.getSuit())).collect(Collectors.toList());
			    
			    if (cardsToCheck.size() + wildCards.size() >= 5 ) {
			    	flushCards.addAll(wildCards);
			    	
			    	Iterator<Card> cardsToCheckIterator = cardsToCheck.listIterator();
			    	
			    	while (flushCards.size() < 5 && cardsToCheckIterator.hasNext()) {
			    		flushCards.add(cardsToCheckIterator.next());
			    	}
			    	
			    	break;
			    }
			}
		}
		
		List<Card> topFiveCards;
		if (flushCards.size() == 5) {
			topFiveCards = flushCards;
		}
		else {
			topFiveCards = new ArrayList<>();
			
			iterator = cardQueue.listIterator();
			
			while (topFiveCards.size() < 5 && iterator.hasNext()) {
				topFiveCards.add(iterator.next());
			}
		}
		setCards(topFiveCards);
		
		if (flushCards.size() == 5) {
			return true;
		}
		
		return false;
	}

}
