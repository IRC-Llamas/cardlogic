package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.foss.llamas.poker.GameConstants;

@Parameters(commandNames = CheckCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class CheckCommand {

	public static final String COMMAND_NAME = "check";
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public final CommandDelegate getDelegate() {
		return delegate;
	}

}
