package chat.llamas.cardlogic.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import chat.llamas.cardlogic.GameConstants;

@Parameters(commandNames = JoinGameCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class JoinGameCommand {

	public static final String COMMAND_NAME = "joingame";
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();
	
	public CommandDelegate getDelegate() {
		return delegate;
	}
}
