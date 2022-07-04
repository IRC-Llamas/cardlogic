package com.foss.llamas.poker.domain.game;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.foss.llamas.poker.GameInterface;
import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.Deck;

public class Round implements RoundInterface {
	
	private RoundType roundType = RoundType.PRE_GAME;
	
	private Map<Player, Boolean> players = new LinkedHashMap<>();
	
	private int roundCount;
	
	private Deck deck;
	
	private List<Card> burnCards;
	
	private Map<Player, List<Card>> holeCards;
	
	private List<Card> communityCards;
	
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
	public IPot getPot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoundEventManagerInterface getRoundEventManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameInterface getGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TurnManagerInterface getTurnManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoundType getRoundType() {
		return roundType;
	}

	@Override
	public RoundType getNextRoundType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getRoundID() {
		// TODO Auto-generated method stub
		return 0;
	}
}