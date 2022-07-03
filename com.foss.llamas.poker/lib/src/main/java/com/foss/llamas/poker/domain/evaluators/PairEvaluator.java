package com.foss.llamas.poker.domain.evaluators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.CardComparator;
import com.foss.llamas.poker.domain.ComparableAtomicInteger;
import com.foss.llamas.poker.domain.HandResult;
import com.foss.llamas.poker.domain.HandResultType;
import com.foss.llamas.poker.domain.Rank;
import com.foss.llamas.poker.domain.RankValueMapBuilder;
import com.google.common.collect.Multimap;

public class PairEvaluator extends HandResult {


	public PairEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.PAIR, rankValueMap);
	}

	public PairEvaluator() {
		super(HandResultType.PAIR, RankValueMapBuilder.builder().addStandardPokerMappings().build());
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
		
		var pairIter = pairMap.entrySet().iterator();

		while (pairIter.hasNext()) {
			if (pairIter.next().getValue().get() > 1) {
				return true;
			}
		}

		return false;
	}
}
