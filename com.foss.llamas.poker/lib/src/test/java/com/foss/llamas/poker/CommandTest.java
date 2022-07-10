package com.foss.llamas.poker;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.beust.jcommander.JCommander;
import com.foss.llamas.poker.domain.ArgumentTokenizer;
import com.foss.llamas.poker.domain.commands.BetCommand;
import com.foss.llamas.poker.domain.commands.CallCommand;
import com.foss.llamas.poker.domain.commands.CancelGameCommand;
import com.foss.llamas.poker.domain.commands.CheckCommand;
import com.foss.llamas.poker.domain.commands.FoldCommand;
import com.foss.llamas.poker.domain.commands.JoinGameCommand;
import com.foss.llamas.poker.domain.commands.LeaveGameCommand;
import com.foss.llamas.poker.domain.commands.MuckCommand;
import com.foss.llamas.poker.domain.commands.RaiseCommand;
import com.foss.llamas.poker.domain.commands.ShowCommand;
import com.foss.llamas.poker.domain.commands.StartGameCommand;
import com.foss.llamas.poker.domain.commands.ViewCardsCommand;

public class CommandTest {
	
	private static final String PLAYER_NAME = "joe";

    JCommander jc;

    void resetJCommander() {
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
		
		// Admin Commands
		// TODO: Add here.
		
		jc = JCommander.newBuilder()
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
    }
    
    @Test
    void testFoldCommand() {
    	
    }

    @Test
    void testMuckCommand() {
    	
    }

    @Test
    void testShowCommand() {
    	
    }

    @Test
    void testCallCommand() {
    	
    }

    @Test
    void testRaiseCommand() {
    	
    }
    @Test
    void testBetCommand() {
    	
    }
    @Test
    void testCheckCommand() {
    	
    }
    @Test
    void testViewCardsCommand() {
    	
    }

    @Test
    void testCancelGameCommand() {
    	resetJCommander();

    	List<String> argumentsList = new ArrayList<>();
    	argumentsList.add(CancelGameCommand.COMMAND_NAME);
    	argumentsList.add("--player=joe");
    	
    	String arguments[] = tokenize(String.join(" ", argumentsList));
    	
    	jc.parse(arguments);
    	
    	String commandName = jc.getParsedCommand();
    	
    	Assertions.assertEquals(CancelGameCommand.COMMAND_NAME, commandName);
    	
    	Assertions.assertFalse(jc.getCommands().isEmpty());
    	
    	jc = jc.getCommands().get(commandName);
    	
    	Assertions.assertFalse(jc.getObjects().isEmpty());
    	
    	Object command = jc.getObjects().iterator().next();
    	
    	boolean isCorrectCommand = (command instanceof CancelGameCommand);
    	
    	Assertions.assertTrue(isCorrectCommand);
    	
    	CancelGameCommand cancelGameComand = (CancelGameCommand)command;
    	
    	Assertions.assertEquals(cancelGameComand.getDelegate().getPlayerName(), "joe");
    }

    @Test
    void testJoinGameCommand() {
    	resetJCommander();
    }

    @Test
    void testLeaveGameCommand() {
    	resetJCommander();
    }
    
    @Test
    void testStartGameCommand() {
    	resetJCommander();

    	List<String> argumentsList = new ArrayList<>();
    	argumentsList.add("startgame");
    	argumentsList.add("--player=joe");
    	argumentsList.add("--joker-count=2");
    	
    	String arguments[] = tokenize(String.join(" ", argumentsList));
    	
    	jc.parse(arguments);
    	
    	String commandName = jc.getParsedCommand();
    	
    	Assertions.assertEquals("startgame", commandName);
    	
    	Assertions.assertFalse(jc.getCommands().isEmpty());
    	
    	jc = jc.getCommands().get(commandName);
    	
    	Assertions.assertFalse(jc.getObjects().isEmpty());
    	
    	Object command = jc.getObjects().iterator().next();
    	
    	boolean isCorrectCommand = (command instanceof StartGameCommand);
    	
    	Assertions.assertTrue(isCorrectCommand);
    	
    	StartGameCommand startGameCommand = (StartGameCommand)command;
    	
    	Assertions.assertEquals(startGameCommand.getJokerCount(), 2);
    	
    	Assertions.assertEquals(startGameCommand.getDelegate().getPlayerName(), "joe");
    	
    	Assertions.assertEquals(startGameCommand.getJoinDelay(), 30);

    	Assertions.assertEquals(startGameCommand.getAnte(), 0);
    	
    	Assertions.assertEquals(startGameCommand.getMaxPlayers(), 9);
    }
    
    private static String[] tokenize(String str) {
		return ArgumentTokenizer.tokenize(str).toArray(String[]::new);
		
    }
}
