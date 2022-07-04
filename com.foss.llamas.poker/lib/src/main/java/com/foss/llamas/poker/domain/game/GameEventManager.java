package com.foss.llamas.poker.domain.game;

import java.util.Objects;

import com.foss.llamas.poker.GameInterface;
import com.foss.llamas.poker.domain.GameState;
import com.foss.llamas.poker.domain.commands.CancelGameCommand;
import com.foss.llamas.poker.domain.commands.JoinGameCommand;
import com.foss.llamas.poker.domain.commands.LeaveGameCommand;
import com.foss.llamas.poker.domain.commands.StartGameCommand;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class GameEventManager implements GameEventManagerInterface {

	private GameInterface game;

	private PublishSubject<StartGameCommand> startGameEventPublisher;
	
	private PublishSubject<CancelGameCommand> cancelGameEventPublisher;

	private PublishSubject<JoinGameCommand> joinGameEventPublisher;
	
	private PublishSubject<LeaveGameCommand> leaveGameEventPublisher;
	
	private PublishSubject<GameMessageInterface> messageEventPublisher;
	
	public GameEventManager(GameInterface game) {
		this.game = game;
	}
	
	@Override
	public GameInterface getGame() {
		return game;
	}

	@Override
	public Observable<StartGameCommand> onStartGame() {
		return getStartGameEventPublisher();
	}
	
	private PublishSubject<StartGameCommand> getStartGameEventPublisher() {
		if (Objects.isNull(startGameEventPublisher)) {
			startGameEventPublisher = PublishSubject.create();
		}
		return startGameEventPublisher;
		
	}

	@Override
	public Observable<CancelGameCommand> onCancelGame() {
		return getCancelGameEventPublisher();
		
	}

	private PublishSubject<CancelGameCommand> getCancelGameEventPublisher() {
		if (Objects.isNull(cancelGameEventPublisher)) {
			cancelGameEventPublisher = PublishSubject.create();
		}
		return cancelGameEventPublisher;
		
	}
	
	@Override
	public Observable<JoinGameCommand> onJoinGame() {
		return getJoinGameEventPublisher();
	}
	
	private PublishSubject<JoinGameCommand> getJoinGameEventPublisher() {
		if (Objects.isNull(joinGameEventPublisher)) {
			joinGameEventPublisher = PublishSubject.create();
		}
		return joinGameEventPublisher;
		
	}
	
	@Override
	public Observable<LeaveGameCommand> onLeaveGame() {
		return getLeaveGameEventPublisher();
	}
	
	private PublishSubject<LeaveGameCommand> getLeaveGameEventPublisher() {
		if (Objects.isNull(leaveGameEventPublisher)) {
			leaveGameEventPublisher = PublishSubject.create();
		}
		return leaveGameEventPublisher;
		
	}

	private PublishSubject<GameMessageInterface> getMessageEventPublisher() {
		if (Objects.isNull(messageEventPublisher)) {
			messageEventPublisher = PublishSubject.create();
		}
		return messageEventPublisher;
	}
	@Override
	public Observable<GameMessageInterface> onMessage() {
		return getMessageEventPublisher();
	}

	@Override
	public void sendMessage(GameMessageInterface message) {
		getMessageEventPublisher().onNext(message);
	}

	@Override
	public void cancelGame(CancelGameCommand command) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void joinGame(JoinGameCommand command) throws UnsupportedOperationException {
		if (game.getGameState() == GameState.PENDING) {
			RoundInterface round = getGame().getCurrentRound();
			
			if (Objects.equals(round.getRoundType(), RoundType.PRE_GAME)) {
				
				// TODO: Add the player to the game.
			}
			else {
				throw new UnsupportedOperationException("Game is already in progress.");
			}
		}
		else {
			throw new UnsupportedOperationException("Game state must be pending to join.");
		}
	}

	@Override
	public void leaveGame(LeaveGameCommand command) throws UnsupportedOperationException {
		if (Objects.equals(game.getGameState(), GameState.PENDING)) {
			// TODO: Just remove the player.
		}
		else if (Objects.equals(game.getGameState(), GameState.ACTIVE)) {
			// TODO: Fold the player if they haven't already,
			// and then remove the player.
		}
		else {
			throw new UnsupportedOperationException("Game state must be pending or active to leave.");
		}
	}

	@Override
	public void fireStartGame(StartGameCommand command) {
		getStartGameEventPublisher().onNext(command);
	}

	@Override
	public void fireCancelGameCommand(CancelGameCommand command) {
		getCancelGameEventPublisher().onNext(command);
	}

	@Override
	public void fireJoinGameCommand(JoinGameCommand command) {
		getJoinGameEventPublisher().onNext(command);
	}

	@Override
	public void fireLeaveGameCommand(LeaveGameCommand command) {
		getLeaveGameEventPublisher().onNext(command);
	}

}
