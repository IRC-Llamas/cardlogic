package chat.llamas.cardlogic.domain;

import java.util.Arrays;
import java.util.Collection;

public enum Rank {
	MAX,
	ACE,
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	JACK,
	QUEEN,
	KING,
	JOKER,
	OTHER,
	ANY;
	
	public static Collection<Rank> getStandardRanks() {
		return Arrays.asList(ACE, KING, QUEEN, JACK,
				TEN, NINE, EIGHT, SEVEN, SIX,
				FIVE, FOUR, THREE, TWO);
	}
}
