package chat.llamas.cardlogic.domain.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;

import chat.llamas.cardlogic.GameConstants;
import chat.llamas.cardlogic.domain.commands.util.MessageScopeConverter;
import chat.llamas.cardlogic.domain.commands.util.MessageTypeConverter;
import chat.llamas.cardlogic.domain.game.MessageScope;
import chat.llamas.cardlogic.domain.game.MessageType;

@Parameters(commandNames = MessageCommand.COMMAND_NAME, separators = GameConstants.COMMAND_SEPARATOR)
public class MessageCommand implements BaseCommand {

	public static final String COMMAND_NAME = "sendmessage";

	public static final String MESSAGE_TYPE_FLAG_SHORT = "-m";

	public static final String MESSAGE_TYPE_FLAG_LONG = "--message-type";

	public static final String MESSAGE_SCOPE_FLAG_SHORT = "-s";

	public static final String MESSAGE_SCOPE_FLAG_LONG = "--message-scope";
	
	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public final CommandDelegate getDelegate() {
		return delegate;
	}

	private MessageType messageType;
	
	private MessageScope messageScope;
	
	private String recipient;
	
	private String message;
	
	@Parameter(names = { MESSAGE_TYPE_FLAG_SHORT, MESSAGE_TYPE_FLAG_LONG }, description = "The type of message to send", required = true, converter = MessageTypeConverter.class)
	public MessageType getMessageType() {
		return messageType;
	}
	
	@Parameter(names = { MESSAGE_SCOPE_FLAG_SHORT, MESSAGE_SCOPE_FLAG_LONG} , description = "The scope of the message", required = true, converter = MessageScopeConverter.class)
	public MessageScope getMessageScope() {
		return messageScope;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public String getMessage() {
		return message;
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}
}
