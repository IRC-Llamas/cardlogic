package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class CommandDelegate {
	public static final String PLAYER_FLAG_LONG = "--player";
	
	public static final String PLAYER_FLAG_SHORT = "-p";
	
	@Parameter(names = { PLAYER_FLAG_SHORT, PLAYER_FLAG_LONG }, required = true)
	private String playerName;
	
	public String getPlayerName() {
		return playerName;
	}
}
