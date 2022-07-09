package com.foss.llamas.poker.domain.evaluators;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.CardComparator;
import com.foss.llamas.poker.domain.HandResult;
import com.foss.llamas.poker.domain.HandResultType;
import com.foss.llamas.poker.domain.Rank;
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
		Collections.sort(cardQueue, CardComparator.get(getRankValueMap()));

		// Step 3: Look for straights.
		// TODO: Implement this.
		
		return false;
	}

	private static Map<Rank, Boolean> getRankMap(List<Card> cards) {
		Collection<Rank> standardRanks = Rank.getStandardRanks();
		
		Map<Rank, Boolean> rankMap = new LinkedHashMap<>();
		
		for (Rank rank : standardRanks) {
			rankMap.put(rank, false);
		}
		
		for (Card card : cards) {
			if (!card.isWild()) {
				rankMap.put(card.getRank(), true);
			}
		}
		
		return rankMap;
	}

}
