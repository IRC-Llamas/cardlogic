package com.foss.llamas.poker.domain.game;

import java.math.BigDecimal;

public class Player implements PlayerInterface {
	private String name;
	
	// TODO: Change to Moneta's type
	// See:
	// https://www.baeldung.com/java-money-and-currency
	private BigDecimal availableMoney;
	
	private int gamesPlayed;
	
	private int gamesWon;
	
	private int gamesTied;
	
	private int gamesLost;
	
	private BigDecimal totalWinnings;
	
	private BigDecimal totalLosses;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public BigDecimal getAvailableMoney() {
		return availableMoney;
	}

	@Override
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	@Override
	public int getGamesWon() {
		return gamesWon;
	}

	@Override
	public int getGamesTied() {
		return gamesTied;
	}

	@Override
	public int getGamesLost() {
		return gamesLost;
	}

	@Override
	public BigDecimal getTotalWinnings() {
		return totalWinnings;
	}

	@Override
	public BigDecimal getTotalLosses() {
		return totalLosses;
	}
}
