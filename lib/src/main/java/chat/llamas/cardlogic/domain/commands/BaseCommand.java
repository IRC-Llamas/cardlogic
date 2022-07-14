package chat.llamas.cardlogic.domain.commands;

public interface BaseCommand {
	String getCommandName();
	
	CommandDelegate getDelegate();
}
