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
