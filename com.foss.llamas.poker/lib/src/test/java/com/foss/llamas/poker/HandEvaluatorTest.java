package com.foss.llamas.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.foss.llamas.poker.domain.StandardCard;
import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.Color;
import com.foss.llamas.poker.domain.HandEvaluatorBuilder;
import com.foss.llamas.poker.domain.HandEvaluatorUtil;
import com.foss.llamas.poker.domain.Suit;

public class HandEvaluatorTest {

	@Test
	public void testJoker() {
		Card joker = StandardCard.buildJoker();
		
		Assertions.assertTrue(HandEvaluatorUtil.isColor(joker, Color.JOKER), "Color should be Color.JOKER");
		Assertions.assertTrue(HandEvaluatorUtil.isSuit(joker, Suit.JOKER), "Suit should be Suit.JOKER");
	}
}
