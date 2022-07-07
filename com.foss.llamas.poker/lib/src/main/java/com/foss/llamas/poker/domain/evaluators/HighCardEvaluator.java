package com.foss.llamas.poker.domain.evaluators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.CardComparator;
import com.foss.llamas.poker.domain.HandResult;
import com.foss.llamas.poker.domain.HandResultType;
import com.foss.llamas.poker.domain.Rank;
import com.google.common.collect.Multimap;

public class HighCardEvaluator extends HandResult {
	public HighCardEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.HIGH, rankValueMap);
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
		
		return true;
	}
}
