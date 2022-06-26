package com.foss.llamas.poker.domain;

import java.util.Objects;

public class HandEvaluatorUtil {
	public static boolean isColor(Card joker, Color color) {
		return Objects.equals(color, joker.getColor()) ||
				Objects.equals(Color.JOKER, joker.getColor()) ||
				Objects.equals(Color.ANY, joker.getColor()) ||
					joker.isWild();
	
	}

	public static boolean isSuit(Card card, Suit suit) {
		return Objects.equals(suit, card.getSuit()) ||
				Objects.equals(Suit.JOKER, card.getSuit()) ||
				Objects.equals(Suit.ANY, card.getSuit()) ||
					card.isWild();
	
	}
}
