package com.foss.llamas.poker.domain.commands;

import java.math.BigDecimal;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandNames = "bet")
public class BetCommand {
	
	@Parameter
	private BigDecimal amount;
}
