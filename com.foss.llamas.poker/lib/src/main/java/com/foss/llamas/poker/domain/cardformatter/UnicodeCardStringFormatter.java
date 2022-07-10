package com.foss.llamas.poker.domain.cardformatter;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.Rank;
import com.foss.llamas.poker.domain.Suit;
import static java.util.Map.entry;

public class UnicodeCardStringFormatter implements CardStringFormatter {

	private static final String wild = "🃟";
	
	private static final String joker = "🃏";

	private static final Map<Suit, Integer> aces = Map.ofEntries(
			entry(Suit.SPADES, 127137),
			entry(Suit.HEARTS, 127153),
			entry(Suit.DIAMONDS, 127169),
			entry(Suit.CLUBS, 127185)
	);
	private static final Rank[] ranks = {
			Rank.ACE,
			Rank.TWO,
			Rank.THREE,
			Rank.FOUR,
			Rank.FIVE,
			Rank.SIX,
			Rank.SEVEN,
			Rank.EIGHT,
			Rank.NINE,
			Rank.TEN,
			Rank.JACK,
			null, // characters contain a Knight
			Rank.QUEEN,
			Rank.KING
	};


	
	@Override
	public String apply(Card card) {
		if (card.isWild()) {
			if (Objects.equals(card.getRank(), Rank.JOKER)) {
				return joker;
			}
			else {
				return wild;
			}
		}
		int rankIndex = Arrays.asList(ranks).indexOf(card.getRank());
		if (rankIndex < 0 || !aces.containsKey(card.getSuit())) {
			return "🂠";
		}
		return String.valueOf(
				Character.toChars(
						aces.get(card.getSuit()) + rankIndex
				)
		);
	}

}
