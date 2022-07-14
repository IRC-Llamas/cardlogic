package chat.llamas.cardlogic.domain.commands;

import java.math.BigDecimal;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import chat.llamas.cardlogic.GameConstants;

@Parameters(commandNames = BetCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class BetCommand {

	public static final String COMMAND_NAME = "bet";
	
	@Parameter
	private BigDecimal amount;
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public final CommandDelegate getDelegate() {
		return delegate;
	}
}
