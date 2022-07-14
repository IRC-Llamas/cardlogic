package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.foss.llamas.poker.GameConstants;

@Parameters(commandNames = JoinGameCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class JoinGameCommand {

	public static final String COMMAND_NAME = "joingame";
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();
	
	public CommandDelegate getDelegate() {
		return delegate;
	}
}
