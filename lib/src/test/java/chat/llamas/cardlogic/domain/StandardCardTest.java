package chat.llamas.cardlogic.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StandardCardTest {

	@Test
	void build_ColorRankSuit() {
		Card card = StandardCard.build(Color.RED, Rank.FOUR, Suit.CLUBS);
		Assertions.assertFalse(card.isWild());
		Assertions.assertEquals(Color.RED, card.getColor());
		Assertions.assertEquals(Rank.FOUR, card.getRank());
		Assertions.assertEquals(Suit.CLUBS, card.getSuit());

		card = StandardCard.build(Color.ANY, Rank.ANY,Suit.ANY);
		Assertions.assertTrue(card.isWild());
	}

	@Test
	void build_RankSuit() {
		Card card = StandardCard.build(Rank.FOUR, Suit.CLUBS);
		Assertions.assertEquals(Color.BLACK, card.getColor());
		Assertions.assertEquals(Rank.FOUR, card.getRank());
		Assertions.assertEquals(Suit.CLUBS, card.getSuit());
	}

	@Test
	void buildJoker() {
		Card card = StandardCard.buildJoker();
		Assertions.assertTrue(card.isWild());
		Assertions.assertEquals(Color.JOKER, card.getColor());
		Assertions.assertEquals(Rank.JOKER, card.getRank());
		Assertions.assertEquals(Suit.JOKER, card.getSuit());
	}
}
