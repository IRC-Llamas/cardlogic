package chat.llamas.cardlogic.game.api;

import java.util.HashMap;
import java.util.Map;

import com.beust.jcommander.JCommander;

import chat.llamas.cardlogic.domain.ArgumentTokenizer;
import chat.llamas.cardlogic.domain.commands.BaseCommand;
import chat.llamas.cardlogic.domain.commands.BetCommand;
import chat.llamas.cardlogic.domain.commands.CallCommand;
import chat.llamas.cardlogic.domain.commands.CancelGameCommand;
import chat.llamas.cardlogic.domain.commands.CheckCommand;
import chat.llamas.cardlogic.domain.commands.FoldCommand;
import chat.llamas.cardlogic.domain.commands.JoinGameCommand;
import chat.llamas.cardlogic.domain.commands.LeaveGameCommand;
import chat.llamas.cardlogic.domain.commands.MuckCommand;
import chat.llamas.cardlogic.domain.commands.RaiseCommand;
import chat.llamas.cardlogic.domain.commands.ShowCommand;
import chat.llamas.cardlogic.domain.commands.StartGameCommand;
import chat.llamas.cardlogic.domain.commands.ViewCardsCommand;
import io.reactivex.rxjava3.core.Observable;

public interface CommandEventBusInterface {
	
	default void execute(String str) {
		String[] argv = ArgumentTokenizer.tokenize(str).toArray(String[]::new);
		
		// Game Commands
		StartGameCommand startGameCommand = new StartGameCommand();
		CancelGameCommand cancelGameCommand = new CancelGameCommand();
		JoinGameCommand joinGameCommand = new JoinGameCommand();
		LeaveGameCommand leaveGameCommand = new LeaveGameCommand();
		
		// Round Commands
		FoldCommand foldCommand = new FoldCommand();
		MuckCommand muckCommand = new MuckCommand();
		ShowCommand showCommand = new ShowCommand();
		CallCommand callCommand = new CallCommand();
		RaiseCommand raiseCommand = new RaiseCommand();
		BetCommand betCommand = new BetCommand();
		CheckCommand checkCommand = new CheckCommand();
		ViewCardsCommand viewCardsCommand = new ViewCardsCommand();
		
		Map<Class<?>, BaseCommand> classMap = new HashMap<>();
		classMap.put(StartGameCommand.class, startGameCommand);
		classMap.put(CancelGameCommand.class, cancelGameCommand);
		classMap.put(JoinGameCommand.class, joinGameCommand);
		classMap.put(LeaveGameCommand.class, leaveGameCommand);
		classMap.put(FoldCommand.class, foldCommand);
		classMap.put(MuckCommand.class, muckCommand);
		classMap.put(ShowCommand.class, showCommand);
		classMap.put(CallCommand.class, callCommand);
		classMap.put(RaiseCommand.class, raiseCommand);
		classMap.put(BetCommand.class, betCommand);
		classMap.put(CheckCommand.class, checkCommand);
		classMap.put(ViewCardsCommand.class, viewCardsCommand);
		
		// Admin Commands
		// TODO: Add here.
		
		JCommander jc = JCommander.newBuilder()
				.addCommand(startGameCommand)
				.addCommand(cancelGameCommand)
				.addCommand(joinGameCommand)
				.addCommand(leaveGameCommand)
				.addCommand(foldCommand)
				.addCommand(muckCommand)
				.addCommand(showCommand)
				.addCommand(callCommand)
				.addCommand(raiseCommand)
				.addCommand(betCommand)
				.addCommand(checkCommand)
				.addCommand(viewCardsCommand)
			  .build();
			jc.parse(argv);		

		String commandName = jc.getParsedCommand();
    	
    	jc = jc.getCommands().get(commandName);

    	Object command = jc.getObjects().iterator().next();
    	
    	boolean isCorrectCommand = (command.getClass().isInstance(BaseCommand.class));
    	
    	if (isCorrectCommand) {
    		executeCommand(classMap.get(command.getClass()));
    	}
	}

	<T extends BaseCommand> void executeCommand(T command) throws UnsupportedOperationException;
	
	<T extends BaseCommand> Observable<T> onExecute();
}
