package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.foss.llamas.poker.GameConstants;

@Parameters(commandNames = CheckMoneyCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class CheckMoneyCommand {

	public static final String COMMAND_NAME = "checkmoney";
	
	@Parameter
	private String targetPlayerName;
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();
	
	public final CommandDelegate getDelegate() {
		return delegate;
	}

	public String getTargetPlayerName() {
		return targetPlayerName;
	}
}
