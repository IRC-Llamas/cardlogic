package com.foss.llamas.poker.domain.evaluators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.CardComparator;
import com.foss.llamas.poker.domain.ComparableAtomicInteger;
import com.foss.llamas.poker.domain.HandResult;
import com.foss.llamas.poker.domain.HandResultType;
import com.foss.llamas.poker.domain.Rank;
import com.foss.llamas.poker.domain.RankValueMapBuilder;
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
