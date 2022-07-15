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
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.CardComparator;
import chat.llamas.cardlogic.domain.HandResult;
import chat.llamas.cardlogic.domain.HandResultType;
import chat.llamas.cardlogic.domain.Rank;
import com.google.common.collect.Multimap;

public class StraightEvaluator extends HandResult {

	public StraightEvaluator() {
		super(HandResultType.STRAIGHT);
	}

	public StraightEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.STRAIGHT, rankValueMap);
	}

	@Override
	public boolean test(List<Card> arg0) {

		List<Card> cardQueue = new LinkedList<>(arg0);

		// Step 1: Collect the wild cards.
		List<Card> wildCards = collectWildCards(cardQueue);
		
		// Step 2: Sort the remaining cards by rank.
		cardQueue.sort(CardComparator.get(getRankValueMap()));

		Multimap<Rank, Integer> rankValueMap = getRankValueMap();
		// Step 3: Look for straights.
		for (int endOfStraight = 14; endOfStraight >= 5; endOfStraight--) {
			int startOfStraight = endOfStraight - 4;
			
			Map<Rank, Card> cardsToSet = new LinkedHashMap<>();
			for (Card card : cardQueue) {
				Rank rank = card.getRank();

				Collection<Integer> values = rankValueMap.get(rank);
				for (Integer value : values) {
					if (value >= startOfStraight && value <= endOfStraight) {
						cardsToSet.put(rank, card);
					}
				}
			}
			if (cardsToSet.size() + wildCards.size() >= 5) {
				setCards(new ArrayList<>(cardsToSet.values()));
				
				return true;
			}
		}

		setCards(new ArrayList<>(collectTopFiveCards(cardQueue, wildCards)));
		return false;
	}
}
