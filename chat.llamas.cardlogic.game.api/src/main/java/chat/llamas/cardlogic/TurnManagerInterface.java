package chat.llamas.cardlogic;

import chat.llamas.cardlogic.domain.game.Player;

public interface TurnManagerInterface {
	
	RoundInterface getRound();
	
	void nextTurn();
	
	Player getCurrentTurnPlayer();
	
	Player getNextTurnPlayer();
}
