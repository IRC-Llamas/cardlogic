package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandNames = {"startgame"}, separators = "=")
public class StartGameCommand {
	
	@Parameter(names = "--joker-count")
	private int jokerCount = 0;
	
	// TODO: Use Moneta type.
	@Parameter(names = "--ante")
	private int ante = 0;
	
	// NOTE: This cannot be greater than 9.
	@Parameter(names = "--max-players")
	private int maxPlayers = 9;
	
	@Parameter(names = "--join-delay")
	private int joinDelay = 30;
}
