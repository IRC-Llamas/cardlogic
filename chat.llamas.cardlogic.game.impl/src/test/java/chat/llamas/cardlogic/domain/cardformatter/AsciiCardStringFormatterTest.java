package chat.llamas.cardlogic.domain.cardformatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.base.Objects;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.Rank;
import chat.llamas.cardlogic.domain.Suit;
import chat.llamas.cardlogic.domain.impl.StandardCard;

public class AsciiCardStringFormatterTest {
	
	private CardStringFormatter formatter = new AsciiCardStringFormatter();
	
	@Test
	void testCardFormats() {
		Card aceSpades = StandardCard.build(Rank.ACE, Suit.SPADES);
		
		Assertions.assertTrue(checkFormat(aceSpades, "[A-SPADES]"));
		
		Card aceHearts = StandardCard.build(Rank.ACE, Suit.HEARTS);
		
		Assertions.assertTrue(checkFormat(aceHearts, "[A-HEARTS]"));
		
	}
	
	private boolean checkFormat(Card card, String representation) {
		
		return Objects.equal(representation, formatter.apply(card));
	}
}
