package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;

@Parameters(commandNames = CallCommand.COMMAND_NAME)
public class CallCommand implements BaseCommand {

	public static final String COMMAND_NAME = "call";
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();
	

	public final CommandDelegate getDelegate() {
		return delegate;
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}
}
