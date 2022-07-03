package com.foss.llamas.poker.domain.game;

import java.math.BigDecimal;

public class Player {
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
}
