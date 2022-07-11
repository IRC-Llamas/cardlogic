package com.foss.llamas.poker.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.foss.llamas.poker.domain.StandardCard;
import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.Color;
import com.foss.llamas.poker.domain.HandEvaluatorBuilder;
import com.foss.llamas.poker.domain.HandEvaluatorUtil;
import com.foss.llamas.poker.domain.Rank;
import com.foss.llamas.poker.domain.Suit;
import com.foss.llamas.poker.domain.evaluators.PairEvaluator;
import com.foss.llamas.poker.domain.evaluators.StraightEvaluator;

public class HandEvaluatorTest {

	@Test
	public void testJoker() {
		Card joker = StandardCard.buildJoker();
		
		Assertions.assertTrue(HandEvaluatorUtil.isColor(joker, Color.JOKER), "Color should be Color.JOKER");
		Assertions.assertTrue(HandEvaluatorUtil.isSuit(joker, Suit.JOKER), "Suit should be Suit.JOKER");
	}
	
	@Test 
	public void testPair() {
		List<Card> noPairs = new ArrayList<>();

		noPairs.add(StandardCard.build(Rank.ACE, Suit.CLUBS));
		noPairs.add(StandardCard.build(Rank.TWO, Suit.HEARTS));
		noPairs.add(StandardCard.build(Rank.THREE, Suit.SPADES));
		noPairs.add(StandardCard.build(Rank.FOUR, Suit.CLUBS));
		noPairs.add(StandardCard.build(Rank.FIVE, Suit.DIAMONDS));

		Assertions.assertFalse(new PairEvaluator().test(noPairs));

		List<Card> pairs = new ArrayList<>();

		pairs.add(StandardCard.build(Rank.ACE, Suit.CLUBS));
		pairs.add(StandardCard.build(Rank.ACE, Suit.HEARTS));
		pairs.add(StandardCard.build(Rank.THREE, Suit.SPADES));
		pairs.add(StandardCard.build(Rank.FOUR, Suit.CLUBS));
		pairs.add(StandardCard.build(Rank.FIVE, Suit.DIAMONDS));
		
		Assertions.assertTrue(new PairEvaluator().test(pairs));
	}	
	
	@Test 
	public void testStraight() {
		List<Card> cards = new ArrayList<>(5);
		HandResult eval = new StraightEvaluator();

		cards.add(StandardCard.build(Rank.ACE, Suit.CLUBS));
		cards.add(StandardCard.build(Rank.ACE, Suit.HEARTS));
		cards.add(StandardCard.build(Rank.THREE, Suit.SPADES));
		cards.add(StandardCard.build(Rank.FOUR, Suit.CLUBS));
		cards.add(StandardCard.build(Rank.FIVE, Suit.DIAMONDS));
		Assertions.assertFalse(eval.test(cards));
		Assertions.assertTrue(doesResultContainCards(eval, cards));

		cards.clear();
		cards.add(StandardCard.build(Rank.ACE, Suit.CLUBS));
		cards.add(StandardCard.build(Rank.TWO, Suit.HEARTS));
		cards.add(StandardCard.build(Rank.THREE, Suit.SPADES));
		cards.add(StandardCard.build(Rank.FOUR, Suit.CLUBS));
		cards.add(StandardCard.build(Rank.FIVE, Suit.DIAMONDS));
		Assertions.assertTrue(eval.test(cards));
		Assertions.assertTrue(doesResultContainCards(eval, cards));

		cards.clear();
		cards.add(StandardCard.build(Rank.TEN, Suit.DIAMONDS));
		cards.add(StandardCard.build(Rank.JACK, Suit.HEARTS));
		cards.add(StandardCard.build(Rank.QUEEN, Suit.SPADES));
		cards.add(StandardCard.build(Rank.KING, Suit.CLUBS));
		cards.add(StandardCard.build(Rank.ACE, Suit.DIAMONDS));
		Assertions.assertTrue(eval.test(cards));
		Assertions.assertTrue(doesResultContainCards(eval, cards));
		
		cards.clear();
		cards.add(StandardCard.build(Rank.JACK, Suit.CLUBS));
		cards.add(StandardCard.build(Rank.QUEEN, Suit.HEARTS));
		cards.add(StandardCard.build(Rank.KING, Suit.SPADES));
		cards.add(StandardCard.build(Rank.ACE, Suit.CLUBS));
		cards.add(StandardCard.build(Rank.TWO, Suit.DIAMONDS));
		Assertions.assertFalse(eval.test(cards));
		Assertions.assertTrue(doesResultContainCards(eval, cards));
		
		cards.clear();
		cards.add(StandardCard.build(Rank.SEVEN, Suit.CLUBS));
		cards.add(StandardCard.build(Rank.EIGHT, Suit.HEARTS));
		cards.add(StandardCard.build(Rank.NINE, Suit.SPADES));
		cards.add(StandardCard.build(Rank.TEN, Suit.CLUBS));
		cards.add(StandardCard.build(Rank.JACK, Suit.DIAMONDS));
		Assertions.assertTrue(eval.test(cards));
		Assertions.assertTrue(doesResultContainCards(eval, cards));

		cards.clear();
		cards.add(StandardCard.build(Rank.JOKER, Suit.JOKER));
		cards.add(StandardCard.build(Rank.FOUR, Suit.HEARTS));
		cards.add(StandardCard.build(Rank.FIVE, Suit.SPADES));
		cards.add(StandardCard.build(Rank.SIX, Suit.CLUBS));
		cards.add(StandardCard.build(Rank.SEVEN, Suit.DIAMONDS));
		Assertions.assertTrue(eval.test(cards));
		Assertions.assertTrue(doesResultContainCards(eval, cards));
	}

	private boolean doesResultContainCards(HandResult result, List<Card> cards) {
		for (Card card : cards) {
			if (card.getRank() == Rank.JOKER) {
				continue;
			}
			if (!result.getCards().contains(card)) {
				return false;
			}
		}
		return true;
	}
}
