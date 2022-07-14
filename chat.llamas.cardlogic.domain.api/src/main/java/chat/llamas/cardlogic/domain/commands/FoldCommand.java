package chat.llamas.cardlogic.domain.commands;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import chat.llamas.cardlogic.GameConstants;

@Parameters(commandNames = FoldCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class FoldCommand implements BaseCommand {

	public static final String COMMAND_NAME = "fold";
	
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
