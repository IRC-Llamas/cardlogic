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
package chat.llamas.cardlogic.domain.impl;

import org.junit.jupiter.api.Test;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.DeckInterface;
import chat.llamas.cardlogic.domain.impl.DeckBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
	@Test
	void refresh() {
		DeckInterface deck = new DeckBuilder().addStandardPokerCards().build();
		deck.refresh();
		assertEquals(0, deck.getCardsDrawn());
		assertEquals(52, deck.getCardsRemaining());
	}

	@Test
	void getCardsDrawn() {
		DeckInterface deck = new DeckBuilder().addStandardPokerCards().build();
		assertEquals(0, deck.getCardsDrawn());
		deck.draw();
		assertEquals(1, deck.getCardsDrawn());
		for (int i = 0; i < 12; i++) {
			deck.draw();
		}
		assertEquals(13, deck.getCardsDrawn());
		deck.refresh();
		assertEquals(0, deck.getCardsDrawn());
	}

	@Test
	void getCardsRemaining() {
		DeckInterface deck = new DeckBuilder().addStandardPokerCards().build();
		assertEquals(52, deck.getCardsRemaining());
		deck.draw();
		assertEquals(51, deck.getCardsRemaining());
		for (int i = 0; i < 12; i++) {
			deck.draw();
		}
		assertEquals(39, deck.getCardsRemaining());
		deck.refresh();
		assertEquals(52, deck.getCardsRemaining());
	}

	@Test
	void draw() {
		DeckInterface deck = new DeckBuilder().addStandardPokerCards().build();
		Map<String, Boolean> seen = new HashMap<>();
		for (int i = 0; i < 52; i++) {
			Optional<Card> card = deck.draw();
			assertTrue(card.isPresent());
			String cardString = card.get().getRank().toString() + card.get().getSuit().toString();
			assertFalse(seen.containsKey(cardString));
			seen.put(cardString, true);
		}
		Optional<Card> card = deck.draw();
		assertFalse(card.isPresent());
	}
}
