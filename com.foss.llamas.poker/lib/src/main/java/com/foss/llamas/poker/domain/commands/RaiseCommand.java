package com.foss.llamas.poker.domain.commands;

import java.math.BigDecimal;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.foss.llamas.poker.GameConstants;

@Parameters(commandNames = RaiseCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class RaiseCommand {

	public static final String COMMAND_NAME = "raise";
	
	@Parameter
	private BigDecimal amount;
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public CommandDelegate getDelegate() {
		return delegate;
	}
}
