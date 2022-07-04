package com.foss.llamas.poker.domain.game;

import java.util.List;
import java.util.Map;

import com.foss.llamas.poker.GameInterface;
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
	
	void nextRound();
	
	boolean isPotSatisfied();
	
	RoundEventManagerInterface getRoundEventManager();
	
	GameInterface getGame();
	
	TurnManager getTurnManager();
	
	RoundType getRoundType();
	
	RoundType getNextRoundType();
}
