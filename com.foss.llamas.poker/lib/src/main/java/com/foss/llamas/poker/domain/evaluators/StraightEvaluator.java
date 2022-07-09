package com.foss.llamas.poker.domain.evaluators;

import java.util.ArrayList;
import java.util.Arrays;
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
		// TODO: Make this better.
		for (Integer[] straightPossibility : possibleStraights()) {
			
			Map<Rank, Card> cardsToSet = new LinkedHashMap<>();
			for (Card card : cardQueue) {
				Rank rank = card.getRank();
				
				int value = Collections.max(getRankValueMap().get(rank));
				
				if (!cardsToSet.containsKey(card.getRank()) && Arrays.asList(straightPossibility).contains(value)) {
					cardsToSet.put(card.getRank(), card);
				}
			}
			if (cardsToSet.size() - wildCards.size() >= 5) {
				setCards(new ArrayList<>(cardsToSet.values()));
				
				return true;
			}
		}
		
		// Same thing but for low values instead of high.
		for (Integer[] straightPossibility : possibleStraights()) {
			
			Map<Rank, Card> cardsToSet = new LinkedHashMap<>();
			for (Card card : cardQueue) {
				Rank rank = card.getRank();
				
				int value = Collections.min(getRankValueMap().get(rank));
				
				if (!cardsToSet.containsKey(card.getRank()) && Arrays.asList(straightPossibility).contains(value)) {
					cardsToSet.put(card.getRank(), card);
				}
			}
			if (cardsToSet.size() - wildCards.size() >= 5) {
				setCards(new ArrayList<>(cardsToSet.values()));
				
				return true;
			}
		}
		
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
	
	private static Collection<Integer[]> possibleStraights() {
		Integer[] straight1 = { 1, 2, 3, 4, 5 };
		Integer[] straight2 = { 2, 3, 4, 5, 6 };
		Integer[] straight3 = { 3, 4, 5, 6, 7 };
		Integer[] straight4 = { 4, 5, 6, 7, 8 };
		Integer[] straight5 = { 5, 6, 7, 8, 9 };
		Integer[] straight6 = { 6, 7, 8, 9, 10 };
		Integer[] straight7 = { 7, 8, 9, 10, 11 };
		Integer[] straight8 = { 8, 9, 10, 11, 12 };
		Integer[] straight9 = { 9, 10, 11, 12, 13 };
		Integer[] straight10 = { 10, 11, 12, 13, 14 };
		Integer[] straight11 = { 11, 12, 13, 14, 15 };

		return Arrays.asList(straight1, 
				straight2,
				straight3,
				straight4,
				straight5,
				straight6,
				straight7,
				straight8,
				straight9,
				straight10,
				straight11);
	}

}
