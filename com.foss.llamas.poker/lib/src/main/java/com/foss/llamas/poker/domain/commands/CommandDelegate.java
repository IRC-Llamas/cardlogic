package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameter;

public class CommandDelegate {
	@Parameter(names = "--player")
	private String playerName;
}
