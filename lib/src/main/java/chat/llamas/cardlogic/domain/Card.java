package chat.llamas.cardlogic.domain;

import java.util.Comparator;

public interface Card {
	boolean isWild();
	Color getColor();
	Rank getRank();
	Suit getSuit();
}
