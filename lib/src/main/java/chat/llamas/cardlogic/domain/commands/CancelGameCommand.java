package chat.llamas.cardlogic.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import chat.llamas.cardlogic.GameConstants;

@Parameters(commandNames = CancelGameCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class CancelGameCommand implements BaseCommand {
	
	public static final String COMMAND_NAME = "cancelgame";

	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public final CommandDelegate getDelegate() {
		return delegate;
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}
}
