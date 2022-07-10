package com.foss.llamas.poker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import com.foss.llamas.poker.domain.commands.CommandDelegate;
import com.foss.llamas.poker.domain.commands.StartGameCommand;

public class StartGameCommandTest extends BaseCommandTest {

	@ParameterizedTest
	/*@CsvSource({
		(StartGameCommand.COMMAND_NAME + ","), 
		(CommandDelegate.PLAYER_FLAG_SHORT + "," + PLAYER_NAME),
		(StartGameCommand.JOKER_COUNT_FLAG_SHORT + "," + "2")})*/
	
	@MethodSource
    void testStartGameCommand(Map<String, Optional<String>> input) {
    	resetJCommander();

    	final List<String> argumentsList = new ArrayList<>();
    	
    	argumentsList.add(StartGameCommand.COMMAND_NAME);
    	
    	for (Entry<String, Optional<String>> entry : input.entrySet()) {
    		String key = entry.getKey();
    		
    		Optional<String> value = entry.getValue();
    		
    		if (value.isPresent()) {
    	    	argumentsList.add(
	        		String.format("%s%s%s", 
	        			key,
	        			GameConstants.COMMAND_SEPARATOR, 
	        			value.get()));
    		}
    		else {
    			argumentsList.add(key);
    		}
    	}
    	
    	String arguments[] = tokenize(String.join(" ", argumentsList));
    	
    	jc.parse(arguments);
    	
    	String commandName = jc.getParsedCommand();
    	
    	Assertions.assertEquals("startgame", commandName);
    	
    	Assertions.assertFalse(jc.getCommands().isEmpty());
    	
    	jc = jc.getCommands().get(commandName);
    	
    	Assertions.assertFalse(jc.getObjects().isEmpty());
    	
    	Object command = jc.getObjects().iterator().next();
    	
    	boolean isCorrectCommand = (command instanceof StartGameCommand);
    	
    	Assertions.assertTrue(isCorrectCommand);
    	
    	StartGameCommand startGameCommand = (StartGameCommand)command;
    	
    	Optional<String> inputJokerCount;
    	if (input.containsKey(StartGameCommand.JOKER_COUNT_FLAG_SHORT)) {
    		inputJokerCount = input.get(StartGameCommand.JOKER_COUNT_FLAG_SHORT);
    	}
    	else if (input.containsKey(StartGameCommand.JOKER_COUNT_FLAG_LONG)) {
    		inputJokerCount = input.get(StartGameCommand.JOKER_COUNT_FLAG_LONG);
    	}
    	else {
    		inputJokerCount = Optional.of(
    			String.valueOf(StartGameCommand.JOKER_COUNT_DEFAULT));
    	}
    	
    	Assertions.assertEquals(
    		String.valueOf(startGameCommand.getJokerCount()), 
    		inputJokerCount.get());
    	
    	Assertions.assertEquals(startGameCommand.getDelegate().getPlayerName(), getPlayerName());
    	
    	Assertions.assertEquals(startGameCommand.getJoinDelay(), 30);

    	Assertions.assertEquals(startGameCommand.getAnte(), 0);
    	
    	Assertions.assertEquals(startGameCommand.getMaxPlayers(), 9);
    }
	
	//private static <T> T defaultValue(T object, T defaultValue) 


	private static Stream<Map<String, Optional<String>>> testStartGameCommand() {
	    return Stream.of(
	    	getCommandWithFlags(
    			String.format("%s%s%s", 
	    			CommandDelegate.PLAYER_FLAG_SHORT,
	    			GameConstants.COMMAND_SEPARATOR, 
	    			getPlayerName()),
        		String.format("%s%s%s", 
        			StartGameCommand.JOKER_COUNT_FLAG_SHORT,
        			GameConstants.COMMAND_SEPARATOR, 
        			"2")));
	}
	
	private static Map<String, Optional<String>> getCommandWithFlags(String... args) {
		Map<String, Optional<String>> argumentsMap = new LinkedHashMap<>();
		
		for (String arg : args) {
			String[] argParts = arg.split(GameConstants.COMMAND_SEPARATOR);
			if (argParts.length > 1) {
				if (argParts.length == 2) {
					argumentsMap.put(argParts[0], Optional.of(argParts[1]));
				}
				else {
					List<String> argValues = new LinkedList<>();
					for (int x = 1; x < argParts.length; x++) {
						argValues.add(argParts[x]);
					}
					argumentsMap.put(argParts[0], Optional.of(String.join(GameConstants.ARGUMENT_SEPARATOR, args)));
				}
			}
			else {
				argumentsMap.put(argParts[0], Optional.empty());
			}
		}
		
		return argumentsMap;
		
	}
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
