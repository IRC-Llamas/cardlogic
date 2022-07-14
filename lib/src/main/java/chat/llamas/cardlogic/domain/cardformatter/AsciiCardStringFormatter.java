package chat.llamas.cardlogic.domain.cardformatter;

import chat.llamas.cardlogic.domain.Card;

public class AsciiCardStringFormatter implements CardStringFormatter {

	@Override
	public String apply(Card card) {
		String suit = null;
		String rank = null;
		String result = null;
		if (card.isWild()) {
			result = "[WILD]";
		}
		else {
			switch (card.getSuit()) {
			case CLUBS:
				suit = "CLUBS";
				break;
			case DIAMONDS:
				suit = "DIAMONDS";
				break;
			case HEARTS:
				suit = "HEARTS";
				break;
			case SPADES:
				suit = "SPADES";
				break;
			default:
				suit = "?";
				break;
			
			}
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
			result = "[" + rank + "-" + suit + "]";
		}
		return result;
	}

}
