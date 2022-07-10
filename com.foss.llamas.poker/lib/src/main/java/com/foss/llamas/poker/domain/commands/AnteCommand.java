package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;

@Parameters(commandNames = AnteCommand.COMMAND_NAME, separators = "=")
public class AnteCommand {
	public static final String COMMAND_NAME = "ante";

	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public CommandDelegate getDelegate() {
		return delegate;
	}
	
}
