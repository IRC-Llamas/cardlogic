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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.CardComparator;
import chat.llamas.cardlogic.domain.ComparableAtomicInteger;
import chat.llamas.cardlogic.domain.HandResult;
import chat.llamas.cardlogic.domain.HandResultType;
import chat.llamas.cardlogic.domain.Rank;
import chat.llamas.cardlogic.domain.RankValueMapBuilder;
import com.google.common.collect.Multimap;

public class MultiplesEvaluator extends HandResult {

	private int count;
	
	public MultiplesEvaluator(HandResultType handResultType, int count, Multimap<Rank, Integer> rankValueMap) {
		super(handResultType, rankValueMap);
		this.count = count;
	}

	public MultiplesEvaluator(HandResultType handResultType, int count) {
		super(handResultType, RankValueMapBuilder.builder().addStandardPokerMappings().build());
		this.count = count;
	}

	@Override
	public boolean test(List<Card> arg0) {

		List<Card> cardQueue = new LinkedList<>(arg0);

		// Step 1: Collect the wild cards.
		List<Card> wildCards = collectWildCards(cardQueue);

		// Step 2: Sort the remaining cards by rank.
		Collections.sort(cardQueue, CardComparator.get(getRankValueMap()));

		// Step 3: Set the top five cards.
		List<Card> topFiveCards = collectTopFiveCards(cardQueue, wildCards);

		setCards(new ArrayList<>(topFiveCards));

		// Step 4: Identify which rank values have duplicate ranks.
		LinkedHashMap<Integer, ComparableAtomicInteger> pairMap = getMultiplesByValues(topFiveCards, getRankValueMap());

		// Step 5: Factor in the wild cards to the duplicates.
		// Every wild card means there is a duplicate.
		factorWildCards(topFiveCards, pairMap);
		
		// Return true if we find a pair.
		return isDuplicateRankCount(count, pairMap);
	}
}
