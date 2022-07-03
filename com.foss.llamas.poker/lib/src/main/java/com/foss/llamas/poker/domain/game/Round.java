package com.foss.llamas.poker.domain.game;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.Deck;

public class Round implements RoundInterface {
	private RoundState roundState;
	
	private Map<Player, Boolean> players = new LinkedHashMap<>();
	
	private Map<Player, BigDecimal> pot = new LinkedHashMap<>();
	
	private BigDecimal potSize;
	
	private int roundCount;
	
	private Deck deck;
	
	private List<Card> burnCards;
	
	public void join(Player player) {
		
	}
	
	public void leave(Player player) {
		
	}
	
	public void nextTurn() {
		
	}
	
	public void fold(Player player) {
		
	}
	
	public void nextRound() {
		
	}

	@Override
	public Map<Player, Boolean> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Player, BigDecimal> getPot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Player, BigDecimal> getUnsatisfiedPot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getPotSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRoundCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Deck getDeck() {
		return deck;
	}

	@Override
	public List<Card> getBurnCards() {
		return burnCards;
	}

	@Override
	public boolean isPotSatisfied() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TurnType getTurnType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TurnType getNextTurnType() {
		// TODO Auto-generated method stub
		return null;
	}
}