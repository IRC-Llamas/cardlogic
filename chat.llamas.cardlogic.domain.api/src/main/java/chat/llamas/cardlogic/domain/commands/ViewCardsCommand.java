package chat.llamas.cardlogic.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import chat.llamas.cardlogic.GameConstants;

@Parameters(commandNames = ViewCardsCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class ViewCardsCommand {

	public static final String COMMAND_NAME = "peek";
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public final CommandDelegate getDelegate() {
		return delegate;
	}
}
