package com.foss.llamas.poker;

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
		List<Card> noStraight = new ArrayList<>();

		noStraight.add(StandardCard.build(Rank.ACE, Suit.CLUBS));
		noStraight.add(StandardCard.build(Rank.ACE, Suit.HEARTS));
		noStraight.add(StandardCard.build(Rank.THREE, Suit.SPADES));
		noStraight.add(StandardCard.build(Rank.FOUR, Suit.CLUBS));
		noStraight.add(StandardCard.build(Rank.FIVE, Suit.DIAMONDS));

		Assertions.assertFalse(new StraightEvaluator().test(noStraight));

		/*List<Card> straight = new ArrayList<>();

		straight.add(StandardCard.build(Rank.ACE, Suit.CLUBS));
		straight.add(StandardCard.build(Rank.TWO, Suit.HEARTS));
		straight.add(StandardCard.build(Rank.THREE, Suit.SPADES));
		straight.add(StandardCard.build(Rank.FOUR, Suit.CLUBS));
		straight.add(StandardCard.build(Rank.FIVE, Suit.DIAMONDS));
		
		Assertions.assertTrue(new StraightEvaluator().test(straight));*/
	}
}
