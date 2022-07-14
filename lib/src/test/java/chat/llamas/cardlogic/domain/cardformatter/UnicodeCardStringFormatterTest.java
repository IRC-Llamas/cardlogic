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
package chat.llamas.cardlogic.domain.cardformatter;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.Rank;
import chat.llamas.cardlogic.domain.StandardCard;
import chat.llamas.cardlogic.domain.Suit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnicodeCardStringFormatterTest {
	UnicodeCardStringFormatter formatter = new UnicodeCardStringFormatter();

	@Test
	void apply_AceOfSpades() {
		Card card = StandardCard.build(Rank.ACE, Suit.SPADES);
		assertEquals("🂡", formatter.apply(card));
	}

	@Test
	void apply_JackOfSpades() {
		Card card = StandardCard.build(Rank.JACK, Suit.SPADES);
		assertEquals("🂫", formatter.apply(card));
	}

	@Test // Two hearts that beat as oonnnnne.
	void apply_TwoOfHearts() {
		Card card = StandardCard.build(Rank.TWO, Suit.HEARTS);
		assertEquals("🂲", formatter.apply(card));
	}

	@Test
	void apply_SevenOfDiamonds() {
		Card card = StandardCard.build(Rank.SEVEN, Suit.DIAMONDS);
		assertEquals("🃇", formatter.apply(card));
	}

	@Test
	void apply_KingOfDiamonds() {
		Card card = StandardCard.build(Rank.KING, Suit.DIAMONDS);
		assertEquals("🃎", formatter.apply(card));
	}

	@Test
	void apply_QueenOfClubs() {
		Card card = StandardCard.build(Rank.QUEEN, Suit.CLUBS);
		assertEquals("🃝", formatter.apply(card));
	}

	@Test
	void apply_Joker() {
		Card card = StandardCard.build(Rank.JOKER, Suit.JOKER);
		assertEquals("🃏", formatter.apply(card));
	}

	@Test
	void apply_AnyOfHearts() {
		Card card = StandardCard.build(Rank.ANY, Suit.HEARTS);
		assertEquals("🂠", formatter.apply(card));
	}

	@Test
	void apply_FourOfAny() {
		Card card = StandardCard.build(Rank.FOUR, Suit.ANY);
		assertEquals("🂠", formatter.apply(card));
	}
}
