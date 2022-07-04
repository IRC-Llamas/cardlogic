package com.foss.llamas.poker.domain.game;

public interface TurnManager {
	
	RoundInterface getRound();
	
	void nextTurn();
	
	Player getCurrentTurnPlayer();
	
	Player getNextTurnPlayer();
}
