package com.foss.llamas.poker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.foss.llamas.poker.domain.commands.CommandDelegate;
import com.foss.llamas.poker.domain.commands.StartGameCommand;

public class StartGameCommandTest extends BaseCommandTest {

	@ParameterizedTest
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
	        		getArgument(key, value.get()));
    		}
    		else {
    			argumentsList.add(key);
    		}
    	}
    	
    	String arguments[] = tokenize(String.join(" ", argumentsList));
    	
    	jc.parse(arguments);
    	
    	String commandName = jc.getParsedCommand();
    	
    	Assertions.assertEquals(StartGameCommand.COMMAND_NAME, commandName);
    	
    	Assertions.assertFalse(jc.getCommands().isEmpty());
    	
    	jc = jc.getCommands().get(commandName);
    	
    	Assertions.assertFalse(jc.getObjects().isEmpty());
    	
    	Object command = jc.getObjects().iterator().next();
    	
    	boolean isCorrectCommand = (command instanceof StartGameCommand);
    	
    	Assertions.assertTrue(isCorrectCommand);
    	
    	StartGameCommand startGameCommand = (StartGameCommand)command;
    	
    	Assertions.assertEquals(
    		String.valueOf(startGameCommand.getJokerCount()), 
    		getValue(
    	    		input, 
    	    		StartGameCommand.JOKER_COUNT_DEFAULT, 
    	    		StartGameCommand.JOKER_COUNT_FLAG_SHORT,
    	    		StartGameCommand.JOKER_COUNT_FLAG_LONG));

    	Assertions.assertEquals(
        		String.valueOf(startGameCommand.getDelegate().getPlayerName()), 
        		getValue(
        	    		input, 
        	    		getPlayerName(), 
        	    		CommandDelegate.PLAYER_FLAG_SHORT,
        	    		CommandDelegate.PLAYER_FLAG_LONG));

    	Assertions.assertEquals(
        		String.valueOf(startGameCommand.getJoinDelay()), 
        		getValue(
        	    		input, 
        	    		StartGameCommand.JOIN_DELAY_DEFAULT, 
        	    		StartGameCommand.JOIN_DELAY_FLAG_SHORT,
        	    		StartGameCommand.JOIN_DELAY_FLAG_LONG));
    	Assertions.assertEquals(
        		String.valueOf(startGameCommand.getAnte()), 
        		getValue(
        	    		input, 
        	    		StartGameCommand.ANTE_DEFAULT, 
        	    		StartGameCommand.ANTE_FLAG_SHORT,
        	    		StartGameCommand.ANTE_FLAG_LONG));

    	Assertions.assertEquals(
        		String.valueOf(startGameCommand.getMaxPlayers()), 
        		getValue(
        	    		input, 
        	    		StartGameCommand.MAX_PLAYERS_DEFAULT, 
        	    		StartGameCommand.MAX_PLAYERS_FLAG_SHORT,
        	    		StartGameCommand.MAX_PLAYERS_FLAG_LONG));
    }
	
	//private static <T> T defaultValue(T object, T defaultValue) 


	private static String getValue(Map<String, Optional<String>> input, Object defaultValue, String... flags) {
		return Stream.of(flags)
			.filter(input::containsKey)
			.map(input::get)
			.findFirst()
			.orElse(Optional.of(String.valueOf(defaultValue)))
			.get();
	}
	
	private static Stream<Map<String, Optional<String>>> testStartGameCommand() {
	    return Stream.of(
	    	getCommandWithFlags(
    			getArgument(
    				CommandDelegate.PLAYER_FLAG_SHORT,
	    			getPlayerName()),
        		getArgument(
        			StartGameCommand.JOKER_COUNT_FLAG_SHORT,
        			2)),
        	getCommandWithFlags(
        		getArgument(
        			CommandDelegate.PLAYER_FLAG_LONG, 
        			getPlayerName()),
        		getArgument(
        			StartGameCommand.ANTE_FLAG_SHORT,
        			10)));
	}
	
	private static final String getArgument(String key, Object... args) {
		final String returnValue;
		if (args != null && args.length > 0 && args[0] != null) {
			if (args.length > 1) {
				returnValue = String.format("%s%s%s", 
        			key,
        			GameConstants.COMMAND_SEPARATOR, 
        			Stream.of(args)
        				.map(String::valueOf)
        				.collect(
        					Collectors.joining(GameConstants.ARGUMENT_SEPARATOR)));
			}
			else {
				returnValue = String.format("%s%s%s", 
        			key,
        			GameConstants.COMMAND_SEPARATOR, 
        			String.valueOf(args[0]));
			}
		}
		else {
			returnValue = key;
		}
		
		return returnValue;
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
