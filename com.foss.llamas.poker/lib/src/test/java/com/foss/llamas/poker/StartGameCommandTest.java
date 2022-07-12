package com.foss.llamas.poker;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.foss.llamas.poker.domain.commands.StartGameCommand;

public class StartGameCommandTest extends BaseCommandTest<StartGameCommand> {

	@ParameterizedTest
	@MethodSource
	@Override
    public void testCommand(Map<String, Optional<String>> input) {
    	    	
		StartGameCommand startGameCommand = getCommandFromJCommander(
			input);
    	
		checkPlayerName(startGameCommand, input);
		
		checkJokerCount(startGameCommand, input);
		
		checkJoinDelay(startGameCommand, input);

		checkMaxPlayers(startGameCommand, input);
		
		checkAnte(startGameCommand, input);
    }
	
	private void checkJokerCount(StartGameCommand command, Map<String, Optional<String>> input) {
    	Assertions.assertEquals(
    		String.valueOf(command.getJokerCount()), 
    		getValue(
	    		input, 
	    		StartGameCommand.JOKER_COUNT_DEFAULT, 
	    		StartGameCommand.JOKER_COUNT_FLAG_SHORT,
	    		StartGameCommand.JOKER_COUNT_FLAG_LONG));
	}

	private void checkJoinDelay(StartGameCommand command, Map<String, Optional<String>> input) {
	 	Assertions.assertEquals(
			String.valueOf(command.getJoinDelay()), 
			getValue(
	    		input, 
	    		StartGameCommand.JOIN_DELAY_DEFAULT, 
	    		StartGameCommand.JOIN_DELAY_FLAG_SHORT,
	    		StartGameCommand.JOIN_DELAY_FLAG_LONG));
	}
	
	private void checkAnte(StartGameCommand command, Map<String, Optional<String>> input) {
    	Assertions.assertEquals(
    		String.valueOf(command.getAnte()), 
    		getValue(
	    		input, 
	    		StartGameCommand.ANTE_DEFAULT, 
	    		StartGameCommand.ANTE_FLAG_SHORT,
	    		StartGameCommand.ANTE_FLAG_LONG));
	}
	
	private void checkMaxPlayers(StartGameCommand command, Map<String, Optional<String>> input) {
    	Assertions.assertEquals(
    		String.valueOf(command.getMaxPlayers()), 
    		getValue(
	    		input, 
	    		StartGameCommand.MAX_PLAYERS_DEFAULT, 
	    		StartGameCommand.MAX_PLAYERS_FLAG_SHORT,
	    		StartGameCommand.MAX_PLAYERS_FLAG_LONG));
	}
	
	private static Stream<Map<String, Optional<String>>> testCommand() {
	    return Stream.of(
	    	getCommandWithFlags(
    			getPlayerArgument(getPlayerName()),
    			getJokerCountArgument(2)),
        	getCommandWithFlags(
				getPlayerArgument(getPlayerName()),
	    		getAnteArgument(10)));
	}

	private static final String getJokerCountArgument(int jokerCount) {
		return getArgument(
			StartGameCommand.JOKER_COUNT_FLAG_SHORT,
			jokerCount);
	}

	private static final String getAnteArgument(int ante) {
		return getArgument(
			StartGameCommand.ANTE_FLAG_SHORT,
			ante);
	}

	@Override
	protected String getCommandName() {
		return StartGameCommand.COMMAND_NAME;
	}

	// TODO: Consider using this.
    /*private static final class StartGameCommandAggregator implements ArgumentsAggregator {

		@Override
		public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context)
				throws ArgumentsAggregationException {
			Map<String, Optional<String>> arguments = new LinkedHashMap<>();
			
			arguments.put(StartGameCommand.COMMAND_NAME, Optional.empty());

			arguments.put(CommandDelegate.PLAYER_FLAG_SHORT, Optional.of(getPlayerName()));
			
			arguments.put(StartGameCommand.JOKER_COUNT_FLAG_SHORT, Optional.of("2"));
			
			
			return arguments;
		}
    }*/
}
