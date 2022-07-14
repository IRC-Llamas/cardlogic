package chat.llamas.cardlogic.domain;

import java.util.Optional;

public interface DeckInterface {

	void refresh();

	int getCardsDrawn();

	int getCardsRemaining();

	Optional<Card> draw();

}
