package chat.llamas.cardlogic.domain.game;

public interface TurnManagerInterface {
	
	RoundInterface getRound();
	
	void nextTurn();
	
	Player getCurrentTurnPlayer();
	
	Player getNextTurnPlayer();
}
