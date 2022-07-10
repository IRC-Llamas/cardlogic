package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;

@Parameters(commandNames = CancelGameCommand.COMMAND_NAME, separators = "=")
public class CancelGameCommand {
	
	public static final String COMMAND_NAME = "cancelgame";

	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public final CommandDelegate getDelegate() {
		return delegate;
	}
}
