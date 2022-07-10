package com.foss.llamas.poker.domain.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.foss.llamas.poker.GameConstants;

@Parameters(commandNames = StartGameCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class StartGameCommand {
	
	public static final String COMMAND_NAME = "startgame";

	public static final String JOKER_COUNT_FLAG_SHORT = "-j";

	public static final String JOKER_COUNT_FLAG_LONG = "--joker-count";
	
	public static final Integer JOKER_COUNT_DEFAULT = 0;

	public static final String ANTE_FLAG_SHORT = "-a";
	
	public static final String ANTE_FLAG_LONG = "--ante";

	public static final String MAX_PLAYERS_FLAG_SHORT = "-m";
	
	public static final String MAX_PLAYERS_FLAG_LONG = "--max-players";

	public static final String JOIN_DELAY_FLAG_SHORT = "-d";
	
	public static final String JOIN_DELAY_FLAG_LONG = "--join-delay";
	
	@Parameter(names = {JOKER_COUNT_FLAG_SHORT, JOKER_COUNT_FLAG_LONG},
		description = "The number of jokers to be included in the deck.",
		required = false)
	private int jokerCount = JOKER_COUNT_DEFAULT;
	
	// TODO: Use Moneta type.
	@Parameter(names = { ANTE_FLAG_SHORT, ANTE_FLAG_LONG })
	private int ante = 0;
	
	// NOTE: This cannot be greater than 9.
	@Parameter(names = { MAX_PLAYERS_FLAG_SHORT, MAX_PLAYERS_FLAG_LONG})
	private int maxPlayers = 9;
	
	@Parameter(names = { JOIN_DELAY_FLAG_SHORT, JOIN_DELAY_FLAG_LONG })
	private int joinDelay = 30;
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public int getJokerCount() {
		return jokerCount;
	}

	public int getAnte() {
		return ante;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public int getJoinDelay() {
		return joinDelay;
	}

	public CommandDelegate getDelegate() {
		return delegate;
	}
}
