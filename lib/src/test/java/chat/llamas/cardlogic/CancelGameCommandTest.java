package chat.llamas.cardlogic;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import chat.llamas.cardlogic.domain.commands.CancelGameCommand;

public class CancelGameCommandTest extends BaseCommandTest<CancelGameCommand>{

	private CancelGameCommand command;
	
	private Map<String, Optional<String>> input;
	
	@Override
	protected String getCommandName() {
		return CancelGameCommand.COMMAND_NAME;
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
	protected CancelGameCommand getCommand() {
		return command;
	}
	
	private static Stream<Map<String, Optional<String>>> testCommand() {
	    return Stream.of(
	    	getCommandWithFlags(
    			getPlayerArgument(getPlayerName())));
	}

}
