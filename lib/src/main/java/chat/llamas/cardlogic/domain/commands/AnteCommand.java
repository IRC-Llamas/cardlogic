package chat.llamas.cardlogic.domain.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;

@Parameters(commandNames = AnteCommand.COMMAND_NAME, separators = "=")
public class AnteCommand {
	public static final String COMMAND_NAME = "ante";
	
	@Parameter(names = "--required", description = "Is the ante required to view the hole cards?")
	private boolean required = false;

	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public CommandDelegate getDelegate() {
		return delegate;
	}
	
	public final boolean isRequired() {
		return required;
	}
	
}
