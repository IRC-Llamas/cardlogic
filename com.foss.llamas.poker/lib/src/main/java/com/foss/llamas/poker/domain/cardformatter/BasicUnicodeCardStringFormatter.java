package com.foss.llamas.poker.domain.cardformatter;

import java.util.Objects;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.Rank;

public class BasicUnicodeCardStringFormatter implements CardStringFormatter {

	@Override
	public String apply(Card card) {
		String result;
		String suit = null;
		String rank = null;
		if (Objects.equals(card.getRank(), Rank.JOKER)) {
			result = "[*]";
		}
		else {
			switch (card.getRank()) {
			case ACE:
				rank = "A";
				break;
			case EIGHT:
				rank = "8";
				break;
			case FIVE:
				rank = "5";
				break;
			case FOUR:
				rank = "4";
				break;
			case JACK:
				rank = "J";
				break;
			case KING:
				rank = "K";
				break;
			case NINE:
				rank = "9";
				break;
			case QUEEN:
				rank = "Q";
				break;
			case SEVEN:
				rank = "7";
				break;
			case SIX:
				rank = "6";
				break;
			case TEN:
				rank = "10";
				break;
			case THREE:
				rank = "3";
				break;
			case TWO:
				rank = "2";
				break;
			default:
				rank = "?";
				break;
			
			}
			switch (card.getSuit()) {
			case CLUBS:
				suit = "♣";
				break;
			case DIAMONDS:
				suit = "♦";
				break;
			case HEARTS:
				suit = "♥";
				break;
			case SPADES:
				suit = "♠";
				break;
			default:
				break;
			
			}
			result = "[" + rank + suit + "]";
		}
		return result;
	}

}
