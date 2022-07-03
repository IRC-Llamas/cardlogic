package com.foss.llamas.poker.domain.game;

import java.util.List;
import java.util.Map;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.Deck;

public interface RoundInterface {
	Map<Player, Boolean> getPlayers();
	
	IPot getPot();
	
	int getRoundCount();
	
	Deck getDeck();
	
	List<Card> getBurnCards();
		
	void join(Player player);
	
	void leave(Player player);
	
	void nextTurn();
	
	Player getCurrentTurnPlayer();
	
	Player getNextTurnPlayer();
	
	void nextRound();
	
	boolean isPotSatisfied();
	
	TurnType getTurnType();
	
	TurnType getNextTurnType();

	RoundEventManagerInterface getRoundEventManager();
	
}
