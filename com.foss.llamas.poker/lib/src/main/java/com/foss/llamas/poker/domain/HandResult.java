package com.foss.llamas.poker.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

import com.google.common.collect.Multimap;

public abstract class HandResult implements Predicate<List<Card>> {

	private Multimap<Rank, Integer> rankValueMap;

	private List<Card> cards = new ArrayList<>();
	private HandResultType handResultType;

	protected HandResult(HandResultType handResultType) {
		this.handResultType = handResultType;
		this.rankValueMap = RankValueMapBuilder.builder().addStandardPokerMappings().build();
	}

	protected HandResult(HandResultType handResultType, Multimap<Rank, Integer> rankValueMap) {
		this.handResultType = handResultType;
		this.rankValueMap = rankValueMap;
	}

	protected Multimap<Rank, Integer> getRankValueMap() {
		return rankValueMap;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Card> getCards() {
		return cards;
	}

	public HandResultType getHandResultType() {
		return handResultType;
	}

	protected static LinkedHashMap<Integer, ComparableAtomicInteger> getMultiplesByValues(List<Card> topFiveCards,
			Multimap<Rank, Integer> rankValueMap) {
		LinkedHashMap<Integer, ComparableAtomicInteger> pairMap = new LinkedHashMap<>();

		ListIterator<Card> iter = topFiveCards.listIterator();
		while (iter.hasNext()) {

			Card card = iter.next();
			if (!card.isWild()) {
				iter.remove();

				Rank rank = card.getRank();

				Integer valueToCheckFor = Collections.max(rankValueMap.get(rank));

				if (pairMap.containsKey(valueToCheckFor)) {
					pairMap.get(valueToCheckFor).incrementAndGet();
				} else {
					pairMap.put(valueToCheckFor, new ComparableAtomicInteger(1));
				}
			}
		}

		HandEvaluatorUtil.sortByValue(pairMap);
		return pairMap;
	}

	protected List<Card> collectTopFiveCards(List<Card> cardQueue, List<Card> wildCards) {
		List<Card> topFiveCards = new ArrayList<>();

		topFiveCards.addAll(wildCards);

		wildCards.clear();

		ListIterator<Card> iter = cardQueue.listIterator();

		while (iter.hasNext() && topFiveCards.size() < 5) {
			Card card = iter.next();
			iter.remove();
			topFiveCards.add(card);
		}

		return topFiveCards;
	}

	protected List<Card> collectWildCards(List<Card> cardQueue) {
		ListIterator<Card> iter = cardQueue.listIterator();

		List<Card> wildCards = new LinkedList<>();

		while (iter.hasNext()) {
			Card card = iter.next();
			if (card.isWild()) {
				iter.remove();
				wildCards.add(card);
			}
		}

		return wildCards;
	}

	protected void factorWildCards(List<Card> topFiveCards, LinkedHashMap<Integer, ComparableAtomicInteger> pairMap) {

		if (!topFiveCards.isEmpty() && !pairMap.isEmpty()) {

			ListIterator<Card> iter = topFiveCards.listIterator();
			while (iter.hasNext()) {

				Card card = iter.next();
				if (card.isWild()) {
					iter.remove();

					pairMap.entrySet().iterator().next().getValue().incrementAndGet();
				}
			}
		}
	}

}
