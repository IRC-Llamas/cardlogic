package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class CommandDelegate {
	@Parameter(names = "--player", required = true)
	private String playerName;
	
	public String getPlayerName() {
		return playerName;
	}
}
