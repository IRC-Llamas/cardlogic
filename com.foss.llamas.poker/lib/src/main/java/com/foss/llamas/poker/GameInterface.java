package com.foss.llamas.poker;

import javax.naming.OperationNotSupportedException;

import com.foss.llamas.poker.domain.GameState;
import com.foss.llamas.poker.domain.commands.CancelGameCommand;
import com.foss.llamas.poker.domain.commands.JoinGameCommand;
import com.foss.llamas.poker.domain.commands.LeaveGameCommand;
import com.foss.llamas.poker.domain.commands.StartGameCommand;
import com.foss.llamas.poker.domain.game.GameEventManagerInterface;
import com.foss.llamas.poker.domain.game.RoundInterface;

import io.reactivex.rxjava3.core.Observable;

public interface GameInterface {
	void acceptCommand(String command) throws OperationNotSupportedException;
	
	RoundInterface getCurrentRound();
	
	GameState getGameState();
	
	GameEventManagerInterface getGameEventManager();
}
