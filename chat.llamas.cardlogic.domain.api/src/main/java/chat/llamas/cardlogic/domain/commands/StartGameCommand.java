// Copyright 2022 Llamas
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package chat.llamas.cardlogic.domain.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import chat.llamas.cardlogic.GameConstants;

@Parameters(commandNames = StartGameCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class StartGameCommand implements BaseCommand {
	
	public static final String COMMAND_NAME = "startgame";

	public static final String JOKER_COUNT_FLAG_SHORT = "-j";

	public static final String JOKER_COUNT_FLAG_LONG = "--joker-count";
	
	public static final Integer JOKER_COUNT_DEFAULT = 0;

	public static final String ANTE_FLAG_SHORT = "-a";
	
	public static final String ANTE_FLAG_LONG = "--ante";
	
	public static final Integer ANTE_DEFAULT = 0;

	public static final String MAX_PLAYERS_FLAG_SHORT = "-m";
	
	public static final String MAX_PLAYERS_FLAG_LONG = "--max-players";
	
	public static final Integer MAX_PLAYERS_DEFAULT = 9;

	public static final String JOIN_DELAY_FLAG_SHORT = "-d";
	
	public static final String JOIN_DELAY_FLAG_LONG = "--join-delay";
	
	public static final Integer JOIN_DELAY_DEFAULT = 30;

	public final String getCommandName() {
		return COMMAND_NAME;
	}
	
	@Parameter(names = {JOKER_COUNT_FLAG_SHORT, JOKER_COUNT_FLAG_LONG},
		description = "The number of jokers to be included in the deck.",
		required = false)
	private int jokerCount = JOKER_COUNT_DEFAULT;
	
	// TODO: Use Moneta type.
	@Parameter(names = { ANTE_FLAG_SHORT, ANTE_FLAG_LONG })
	private int ante = ANTE_DEFAULT;
	
	// NOTE: This cannot be greater than 9.
	@Parameter(names = { MAX_PLAYERS_FLAG_SHORT, MAX_PLAYERS_FLAG_LONG})
	private int maxPlayers = MAX_PLAYERS_DEFAULT;
	
	@Parameter(names = { JOIN_DELAY_FLAG_SHORT, JOIN_DELAY_FLAG_LONG })
	private int joinDelay = JOIN_DELAY_DEFAULT;
	
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

	public final CommandDelegate getDelegate() {
		return delegate;
	}
}
