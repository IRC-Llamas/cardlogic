package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandNames = "checkmoneys")
public class CheckMoneyCommand {

	@Parameter
	private String playerName;
}
