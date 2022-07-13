package com.foss.llamas.poker;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.foss.llamas.poker.domain.commands.CallCommand;

public class CallCommandTest extends BaseCommandTest<CallCommand>{

	private CallCommand command;
	
	private Map<String, Optional<String>> input;
	
	@Override
	protected String getCommandName() {
		return CallCommand.COMMAND_NAME;
	}

	@ParameterizedTest
	@MethodSource
	@Override
	public void testCommand(Map<String, Optional<String>> input) {
 
		this.input = input;
    	
    	this.command = getCommandFromJCommander(input);

		checkPlayerName();
	}

	@Override
	protected Map<String, Optional<String>> getInput() {
	    return input;
	}

	@Override
	protected CallCommand getCommand() {
		return command;
	}
	
	private static Stream<Map<String, Optional<String>>> testCommand() {
	    return Stream.of(
	    	getCommandWithFlags(
    			getPlayerArgument(getPlayerName())));
	}

}