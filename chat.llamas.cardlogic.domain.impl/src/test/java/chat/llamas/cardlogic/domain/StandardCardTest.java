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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import chat.llamas.cardlogic.domain.impl.StandardCard;

class StandardCardTest {

	@Test
	void build_ColorRankSuit() {
		Card card = StandardCard.build(Color.RED, Rank.FOUR, Suit.CLUBS);
		Assertions.assertFalse(card.isWild());
		Assertions.assertEquals(Color.RED, card.getColor());
		Assertions.assertEquals(Rank.FOUR, card.getRank());
		Assertions.assertEquals(Suit.CLUBS, card.getSuit());

		card = StandardCard.build(Color.ANY, Rank.ANY,Suit.ANY);
		Assertions.assertTrue(card.isWild());
	}

	@Test
	void build_RankSuit() {
		Card card = StandardCard.build(Rank.FOUR, Suit.CLUBS);
		Assertions.assertEquals(Color.BLACK, card.getColor());
		Assertions.assertEquals(Rank.FOUR, card.getRank());
		Assertions.assertEquals(Suit.CLUBS, card.getSuit());
	}

	@Test
	void buildJoker() {
		Card card = StandardCard.buildJoker();
		Assertions.assertTrue(card.isWild());
		Assertions.assertEquals(Color.JOKER, card.getColor());
		Assertions.assertEquals(Rank.JOKER, card.getRank());
		Assertions.assertEquals(Suit.JOKER, card.getSuit());
	}
}
