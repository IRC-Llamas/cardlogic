package com.foss.llamas.poker.domain.commands;

public interface BaseCommand {
	String getCommandName();
	
	CommandDelegate getDelegate();
}
