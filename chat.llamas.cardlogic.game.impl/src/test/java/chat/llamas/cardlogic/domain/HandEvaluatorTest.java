// Copyright 2022 Llamas
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package chat.llamas.cardlogic.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import chat.llamas.cardlogic.domain.evaluators.PairEvaluator;
import chat.llamas.cardlogic.domain.evaluators.StraightEvaluator;
import chat.llamas.cardlogic.domain.impl.StandardCard;

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
