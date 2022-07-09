package com.foss.llamas.poker.domain;

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
						new StandardCard(Color.ANY, Rank.TWO, Suit.ANY),
						new StandardCard(Color.ANY, Rank.THREE, Suit.ANY)
				),
				Arguments.of(
						new StandardCard(Color.ANY, Rank.TWO, Suit.ANY),
						new StandardCard(Color.ANY, Rank.ACE, Suit.ANY)
				),
				Arguments.of(
						new StandardCard(Color.ANY, Rank.KING, Suit.ANY),
						new StandardCard(Color.ANY, Rank.ACE, Suit.ANY)
				),
				Arguments.of(
						new StandardCard(Color.ANY, Rank.TEN, Suit.ANY),
						new StandardCard(Color.ANY, Rank.JACK, Suit.ANY)
				)
		);
	}

	private static Stream<Arguments> compareEqual() {
		return Stream.of(
				Arguments.of(
						new StandardCard(Color.ANY, Rank.TWO, Suit.ANY),
						new StandardCard(Color.ANY, Rank.TWO, Suit.ANY)
				),
				Arguments.of(
						new StandardCard(Color.ANY, Rank.ACE, Suit.ANY),
						new StandardCard(Color.ANY, Rank.ACE, Suit.ANY)
				),
				Arguments.of(
						new StandardCard(Color.ANY, Rank.KING, Suit.ANY),
						new StandardCard(Color.ANY, Rank.KING, Suit.ANY)
				),
				Arguments.of(
						new StandardCard(Color.ANY, Rank.TEN, Suit.ANY),
						new StandardCard(Color.ANY, Rank.TEN, Suit.ANY)
				)
		);
	}

	private static Stream<Arguments> compare1() {
		return Stream.of(
				Arguments.of(
						new StandardCard(Color.ANY, Rank.THREE, Suit.ANY),
						new StandardCard(Color.ANY, Rank.TWO, Suit.ANY)
				),
				Arguments.of(
						new StandardCard(Color.ANY, Rank.ACE, Suit.ANY),
						new StandardCard(Color.ANY, Rank.KING, Suit.ANY)
				),
				Arguments.of(
						new StandardCard(Color.ANY, Rank.JACK, Suit.ANY),
						new StandardCard(Color.ANY, Rank.TEN, Suit.ANY)
				),
				Arguments.of(
						new StandardCard(Color.ANY, Rank.ACE, Suit.ANY),
						new StandardCard(Color.ANY, Rank.TWO, Suit.ANY)
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
