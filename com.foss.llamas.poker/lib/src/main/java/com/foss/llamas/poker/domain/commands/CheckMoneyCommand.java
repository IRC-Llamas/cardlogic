package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;

@Parameters(commandNames = "checkmoneys")
public class CheckMoneyCommand {

	@Parameter
	private String playerName;
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();
}
