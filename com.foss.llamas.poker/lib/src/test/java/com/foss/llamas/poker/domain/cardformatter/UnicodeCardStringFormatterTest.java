package com.foss.llamas.poker.domain.cardformatter;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.Rank;
import com.foss.llamas.poker.domain.StandardCard;
import com.foss.llamas.poker.domain.Suit;
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
