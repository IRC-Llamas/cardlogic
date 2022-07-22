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
package chat.llamas.cardlogic;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.beust.jcommander.JCommander;
import chat.llamas.cardlogic.domain.ArgumentTokenizer;
import chat.llamas.cardlogic.domain.commands.BaseCommand;
import chat.llamas.cardlogic.domain.commands.BetCommand;
import chat.llamas.cardlogic.domain.commands.CallCommand;
import chat.llamas.cardlogic.domain.commands.CancelGameCommand;
import chat.llamas.cardlogic.domain.commands.CheckCommand;
import chat.llamas.cardlogic.domain.commands.CommandDelegate;
import chat.llamas.cardlogic.domain.commands.FoldCommand;
import chat.llamas.cardlogic.domain.commands.JoinGameCommand;
import chat.llamas.cardlogic.domain.commands.LeaveGameCommand;
import chat.llamas.cardlogic.domain.commands.MuckCommand;
import chat.llamas.cardlogic.domain.commands.RaiseCommand;
import chat.llamas.cardlogic.domain.commands.ShowCommand;
import chat.llamas.cardlogic.domain.commands.StartGameCommand;
import chat.llamas.cardlogic.domain.commands.ViewCardsCommand;

public abstract class BaseCommandTest<T extends BaseCommand> {

	protected static final String PLAYER_NAME = "joe";
	
	protected static final String getPlayerName() {
		return "joe";
	}

    protected JCommander jc;

    void resetJCommander() {
		// Game Commands
		StartGameCommand startGameCommand = new StartGameCommand();
		CancelGameCommand cancelGameCommand = new CancelGameCommand();
		JoinGameCommand joinGameCommand = new JoinGameCommand();
		LeaveGameCommand leaveGameCommand = new LeaveGameCommand();
		
		// Round Commands
		FoldCommand foldCommand = new FoldCommand();
		MuckCommand muckCommand = new MuckCommand();
		ShowCommand showCommand = new ShowCommand();
		CallCommand callCommand = new CallCommand();
		RaiseCommand raiseCommand = new RaiseCommand();
		BetCommand betCommand = new BetCommand();
		CheckCommand checkCommand = new CheckCommand();
		ViewCardsCommand viewCardsCommand = new ViewCardsCommand();
		
		// Admin Commands
		// TODO: Add here.
		
		jc = JCommander.newBuilder()
				.addCommand(startGameCommand)
				.addCommand(cancelGameCommand)
				.addCommand(joinGameCommand)
				.addCommand(leaveGameCommand)
				.addCommand(foldCommand)
				.addCommand(muckCommand)
				.addCommand(showCommand)
				.addCommand(callCommand)
				.addCommand(raiseCommand)
				.addCommand(betCommand)
				.addCommand(checkCommand)
				.addCommand(viewCardsCommand)
			  .build();
    }
    
    @Test
    void testFoldCommand() {
    	
    }

    @Test
    void testMuckCommand() {
    	
    }

    @Test
    void testShowCommand() {
    	
    }

    @Test
    void testCallCommand() {
    	
    }

    @Test
    void testRaiseCommand() {
    	
    }
    @Test
    void testBetCommand() {
    	
    }
    @Test
    void testCheckCommand() {
    	
    }
    @Test
    void testViewCardsCommand() {
    	
    }

    @Test
    void testJoinGameCommand() {
    	resetJCommander();
    }

    @Test
    void testLeaveGameCommand() {
    	resetJCommander();
    }
    
	protected static final String getArgument(String key, Object... args) {
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
	
	protected static Map<String, Optional<String>> getCommandWithFlags(String... args) {
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
	
	protected final T getCommandFromJCommander(Map<String, Optional<String>> input) {
		resetJCommander();
		
		String commandName = getCommandName();
		
		String[] argumentArray = getArgumentArray(input, commandName);
		
		jc.parse(argumentArray);
		
    	String commandNameFromJComannder = jc.getParsedCommand();
    	
    	Assertions.assertEquals(commandName, commandNameFromJComannder);

    	Assertions.assertFalse(jc.getCommands().isEmpty());
    	
    	jc = jc.getCommands().get(commandNameFromJComannder);

    	Assertions.assertFalse(jc.getObjects().isEmpty());
    	
    	Object command = jc.getObjects().iterator().next();
    	
    	Class<T> classType = getClassType();
    	
    	boolean isCorrectCommand = (classType.isInstance(command));

    	Assertions.assertTrue(isCorrectCommand);
    	
    	T commandInstance = classType.cast(command);
    			
    	Assertions.assertEquals(commandInstance.getCommandName(), commandNameFromJComannder);
    	
    	return commandInstance;
	}
	
	protected static final String[] getArgumentArray(Map<String, Optional<String>> input, String commandName) {
    	final List<String> argumentsList = new ArrayList<>();

    	argumentsList.add(commandName);
    	
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

    	return arguments;
	}
	protected static final String getPlayerArgument(String playerName) {
		return getArgument(
			CommandDelegate.PLAYER_FLAG_SHORT,
			playerName);
	}
	
	protected static String getValue(Map<String, Optional<String>> input, Object defaultValue, String... flags) {
		return Stream.of(flags)
			.filter(input::containsKey)
			.map(input::get)
			.findFirst()
			.orElse(Optional.of(String.valueOf(defaultValue)))
			.get();
	}
	
    protected static String[] tokenize(String str) {
		return ArgumentTokenizer.tokenize(str).toArray(String[]::new);
		
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Class<T> getClassType() {
      return ((Class) ((ParameterizedType) getClass()
          .getGenericSuperclass()).getActualTypeArguments()[0]);
    }
    
	protected void checkPlayerName() {
    	Assertions.assertEquals(
    		String.valueOf(getCommand().getDelegate().getPlayerName()), 
    		getValue(
	    		getInput(), 
	    		getPlayerName(), 
	    		CommandDelegate.PLAYER_FLAG_SHORT,
	    		CommandDelegate.PLAYER_FLAG_LONG));
	}
    
    protected abstract String getCommandName();
    
    public abstract void testCommand(Map<String, Optional<String>> input);
    
    protected abstract Map<String, Optional<String>> getInput();
    
    protected abstract T getCommand();
}
