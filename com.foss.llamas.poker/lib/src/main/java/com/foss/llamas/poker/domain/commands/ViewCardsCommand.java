package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.foss.llamas.poker.GameConstants;

@Parameters(commandNames = ViewCardsCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class ViewCardsCommand {

	public static final String COMMAND_NAME = "peek";
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public final CommandDelegate getDelegate() {
		return delegate;
	}
}
