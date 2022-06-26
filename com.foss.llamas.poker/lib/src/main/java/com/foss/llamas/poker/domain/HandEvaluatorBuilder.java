package com.foss.llamas.poker.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.Multimap;

public class HandEvaluatorBuilder {

	private Multimap<Rank, Integer> rankValueMap = RankValueMapBuilder.builder()
			.addStandardPokerMappings().build();
	
	private List<HandResult> handResults = new ArrayList<>();
	
	public static final HandEvaluatorBuilder builder() {
		return new HandEvaluatorBuilder();
	}
	private static boolean isColor(StandardCard card, Color color) {
		return Objects.equals(color, card.getColor()) ||
				Objects.equals(Color.JOKER, card.getColor()) ||
				Objects.equals(Color.ANY, card.getColor()) ||
					card.isWild();
	
	}

	private static boolean isSuit(StandardCard card, Suit suit) {
		return Objects.equals(suit, card.getSuit()) ||
				Objects.equals(Suit.JOKER, card.getSuit()) ||
				Objects.equals(Suit.ANY, card.getSuit()) ||
					card.isWild();
	
	}
	
	private static List<StandardCard> checkRoyalFlush(List<StandardCard> arg0, Suit suit) {
		Deque<StandardCard> suitedCards = new LinkedList<>(arg0.stream().filter(card -> isSuit(card, suit)).collect(Collectors.toList()));
		
		List<StandardCard> potentialRoyalFlush = new ArrayList<>();
		
		Iterator<StandardCard> cardIterator = suitedCards.iterator();
		
		while (cardIterator.hasNext() && potentialRoyalFlush.size() < 5) {
			StandardCard card = cardIterator.next();
			boolean isRoyal = 
			Objects.equals(card.getRank(), Rank.ACE) ||
			Objects.equals(card.getRank(), Rank.KING) ||
			Objects.equals(card.getRank(), Rank.QUEEN) ||
			Objects.equals(card.getRank(), Rank.JACK) ||
			Objects.equals(card.getRank(), Rank.TEN);
			if (isRoyal) {
				cardIterator.remove();
				potentialRoyalFlush.add(card);
			}
		}
		if (potentialRoyalFlush.size() == 5) {
			return potentialRoyalFlush;
		}
		
		cardIterator = suitedCards.iterator();
		
		while (cardIterator.hasNext() && potentialRoyalFlush.size() < 5) {
			StandardCard card = cardIterator.next();
			boolean isRoyal = 
				Objects.equals(card.getRank(), Rank.JOKER) ||
				Objects.equals(card.getRank(), Rank.ANY) ||
			card.isWild();
			
			if (isRoyal) {
				cardIterator.remove();
				potentialRoyalFlush.add(card);
			}

		}
		if (potentialRoyalFlush.size() == 5) {
			return potentialRoyalFlush;
		}
		return Collections.emptyList();		
	}

	public HandEvaluatorBuilder addPairEvaluator() {
		HandResult handResult = new HandResult(HandResultType.PAIR) {
			
			@Override
			public boolean test(List<StandardCard> arg0) {
				// TODO: Use rankValueMap to find the highest pair.
				Map<Rank, AtomicInteger> rankMap = new HashMap<>();
				for (StandardCard card : arg0) {
					if (rankMap.containsKey(card.getRank())) {
						rankMap.get(card.getRank()).getAndIncrement();
					}
					else {
						rankMap.put(card.getRank(), new AtomicInteger(1));
					}
				}
				for (Entry<Rank, AtomicInteger> entry : rankMap.entrySet()) {
					if (entry.getValue().get() > 1) {
						// TODO: Need to set the cards here, but they must be the proper
						// cards and include both the pair and the next highest cards.
						return true;
					}
				}
				return false;
			}
		};
		
		handResults.add(handResult);
		
		return this;
	}
	
	public HandEvaluatorBuilder addRoyalFlushEvaluator() {
		HandResult handResult = new HandResult(HandResultType.ROYAL_FLUSH) {
			
			@Override
			public boolean test(List<StandardCard> arg0) {
				List<StandardCard> royalFlush = checkRoyalFlush(arg0, Suit.CLUBS);
				if (royalFlush.size() == 5) {
					setCards(royalFlush);
					return true;
				}
				royalFlush = checkRoyalFlush(arg0, Suit.DIAMONDS);
				if (royalFlush.size() == 5) {
					setCards(royalFlush);
					return true;
				}
				royalFlush = checkRoyalFlush(arg0, Suit.SPADES);
				if (royalFlush.size() == 5) {
					setCards(royalFlush);
					return true;
				}
				royalFlush = checkRoyalFlush(arg0, Suit.HEARTS);
				if (royalFlush.size() == 5) {
					setCards(royalFlush);
					return true;
				}
				return false;
			}
		};
		
		handResults.add(handResult);
		
		return this;
	}
}
