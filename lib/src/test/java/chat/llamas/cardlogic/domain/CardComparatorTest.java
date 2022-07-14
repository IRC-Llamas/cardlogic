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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CardComparatorTest {

	private final CardComparator comparator = CardComparator.get();

	private static Stream<Arguments> compareNegative1() {
		return Stream.of(
				Arguments.of(
						StandardCard.build(Rank.TWO, Suit.ANY),
						StandardCard.build(Rank.THREE, Suit.ANY)
				),
				Arguments.of(
						StandardCard.build(Rank.TWO, Suit.ANY),
						StandardCard.build(Rank.ACE, Suit.ANY)
				),
				Arguments.of(
						StandardCard.build(Rank.KING, Suit.ANY),
						StandardCard.build(Rank.ACE, Suit.ANY)
				),
				Arguments.of(
						StandardCard.build(Rank.TEN, Suit.ANY),
						StandardCard.build(Rank.JACK, Suit.ANY)
				)
		);
	}

	private static Stream<Arguments> compareEqual() {
		return Stream.of(
				Arguments.of(
						StandardCard.build(Rank.TWO, Suit.ANY),
						StandardCard.build(Rank.TWO, Suit.ANY)
				),
				Arguments.of(
						StandardCard.build(Rank.ACE, Suit.ANY),
						StandardCard.build(Rank.ACE, Suit.ANY)
				),
				Arguments.of(
						StandardCard.build(Rank.KING, Suit.ANY),
						StandardCard.build(Rank.KING, Suit.ANY)
				),
				Arguments.of(
						StandardCard.build(Rank.TEN, Suit.ANY),
						StandardCard.build(Rank.TEN, Suit.ANY)
				)
		);
	}

	private static Stream<Arguments> compare1() {
		return Stream.of(
				Arguments.of(
						StandardCard.build(Rank.THREE, Suit.ANY),
						StandardCard.build(Rank.TWO, Suit.ANY)
				),
				Arguments.of(
						StandardCard.build(Rank.ACE, Suit.ANY),
						StandardCard.build(Rank.KING, Suit.ANY)
				),
				Arguments.of(
						StandardCard.build(Rank.JACK, Suit.ANY),
						StandardCard.build(Rank.TEN, Suit.ANY)
				),
				Arguments.of(
						StandardCard.build(Rank.ACE, Suit.ANY),
						StandardCard.build(Rank.TWO, Suit.ANY)
				)
		);
	}

	@ParameterizedTest
	@MethodSource
	void compareNegative1(Card card1, Card card2) {
		Assertions.assertEquals(-1, comparator.compare(card1, card2));
	}

	@ParameterizedTest
	@MethodSource
	void compareEqual(Card card1, Card card2) {
		Assertions.assertEquals(0, comparator.compare(card1, card2));
	}

	@ParameterizedTest
	@MethodSource
	void compare1(Card card1, Card card2) {
		Assertions.assertEquals(1, comparator.compare(card1, card2));
	}
}
