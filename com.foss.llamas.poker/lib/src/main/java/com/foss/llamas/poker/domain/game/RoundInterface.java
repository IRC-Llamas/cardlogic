package com.foss.llamas.poker.domain.game;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.Deck;

public interface RoundInterface {
	Map<Player, Boolean> getPlayers();
	
	Map<Player, BigDecimal> getPot();
	
	Map<Player, BigDecimal> getUnsatisfiedPot();
	
	BigDecimal getPotSize();
	
	int getRoundCount();
	
	Deck getDeck();
	
	List<Card> getBurnCards();
	
	void join(Player player);
	
	void leave(Player player);
	
	void nextTurn();
	
	void nextRound();
	
	boolean isPotSatisfied();
	
	TurnType getTurnType();
	
	TurnType getNextTurnType();
	
	
}
