package chat.llamas.cardlogic.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import chat.llamas.cardlogic.GameConstants;

@Parameters(commandNames = MuckCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class MuckCommand {

	public static final String COMMAND_NAME = "muck";
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public final CommandDelegate getDelegate() {
		return delegate;
	}
}
