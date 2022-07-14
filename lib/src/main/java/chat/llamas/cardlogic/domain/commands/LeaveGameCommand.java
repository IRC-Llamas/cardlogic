package chat.llamas.cardlogic.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import chat.llamas.cardlogic.GameConstants;

@Parameters(commandNames = LeaveGameCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class LeaveGameCommand {

	public static final String COMMAND_NAME = "leavegame";
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();
	
	public CommandDelegate getDelegate() {
		return delegate;
	}
}
