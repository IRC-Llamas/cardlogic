package com.foss.llamas.poker.domain.evaluators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.tuple.Triple;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.CardComparator;
import com.foss.llamas.poker.domain.ComparableAtomicInteger;
import com.foss.llamas.poker.domain.HandResult;
import com.foss.llamas.poker.domain.HandResultType;
import com.foss.llamas.poker.domain.Rank;
import com.foss.llamas.poker.domain.RankValueMapBuilder;
import com.foss.llamas.poker.domain.StandardCard;
import com.google.common.collect.Multimap;

public class PairEvaluator extends HandResult {

	private Multimap<Rank, Integer> rankValueMap;
	public PairEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.PAIR);
		this.rankValueMap = rankValueMap;
	}
	public PairEvaluator() {
		super(HandResultType.PAIR);
		this.rankValueMap = RankValueMapBuilder.builder()
			.addStandardPokerMappings().build();
	}
	@Override
	public boolean test(List<Card> arg0) {

		List<Card> cardQueue = new LinkedList<>(arg0);
		
		List<Card> wildCards = new LinkedList<>();
		
		// Step 1: Collect the wild cards.
        ListIterator<Card> iter = cardQueue.listIterator();
        while(iter.hasNext()){
        	Card card = iter.next();
            if (card.isWild()) {
                iter.remove();
                wildCards.add(card);
            }
        }
        
        // Step 2: Sort the remaining cards by rank.
        Collections.sort(cardQueue, CardComparator.get(rankValueMap));
		
	List<Card> topFiveCards = new ArrayList<>();

	topFiveCards.addAll(wildCards);

	iter = cardQueue.listIterator();

	while (iter.hasNext() && topFiveCards.size() < 5) {
		Card card = iter.next();
		iter.remove();
		topFiveCards.add(card);
	}

	setCards(new ArrayList<>(topFiveCards));

	// Step 3: Identify which rank values have pairs
	LinkedHashMap<Integer, ComparableAtomicInteger> pairMap = new LinkedHashMap<>();

	iter = topFiveCards.listIterator();
	while (iter.hasNext()) {

		Card card = iter.next();
		if (!card.isWild()) {
			iter.remove();

			Rank rank = card.getRank();

			Integer valueToCheckFor = Collections.max(rankValueMap.get(rank));

			if (pairMap.containsKey(valueToCheckFor)) {
				pairMap.get(valueToCheckFor).incrementAndGet();
			}
			else {
				pairMap.put(valueToCheckFor, new ComparableAtomicInteger(1));
			}
		}
	}

	sortByValue(pairMap);

	if (!topFiveCards.isEmpty() && !pairMap.isEmpty()) {

		iter = topFiveCards.listIterator();
		while (iter.hasNext()) {

			Card card = iter.next();
			if (card.isWild()) {
				iter.remove();

				pairMap.entrySet().iterator().next().getValue().incrementAndGet();
			}
		}
	}
	Iterator<Entry<Integer, ComparableAtomicInteger>> pairIter = pairMap.entrySet().iterator();

	while (pairIter.hasNext()) {
		if (pairIter.next().getValue().get() > 1) {
			return true;
		}
	}

	return false;
}
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
