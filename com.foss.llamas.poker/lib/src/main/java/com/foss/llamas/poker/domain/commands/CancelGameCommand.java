package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;

@Parameters(commandNames = {"cancelgame"}, separators = "=")
public class CancelGameCommand {

	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();
}
