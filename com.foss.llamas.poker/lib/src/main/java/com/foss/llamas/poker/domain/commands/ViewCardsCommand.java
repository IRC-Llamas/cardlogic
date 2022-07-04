package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;

@Parameters(commandNames = "peek")
public class ViewCardsCommand {

	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();
}
