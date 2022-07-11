package com.foss.llamas.poker.domain.evaluators;

import java.util.ArrayList;
import java.util.Collection;
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
