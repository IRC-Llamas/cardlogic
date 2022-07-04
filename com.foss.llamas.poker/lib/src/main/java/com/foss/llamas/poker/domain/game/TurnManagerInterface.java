package com.foss.llamas.poker.domain.game;

public interface TurnManagerInterface {
	
	RoundInterface getRound();
	
	void nextTurn();
	
	Player getCurrentTurnPlayer();
	
	Player getNextTurnPlayer();
}
