// Copyright 2022 Llamas
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package chat.llamas.cardlogic.game.impl;

import java.util.Objects;

import chat.llamas.cardlogic.domain.GameState;
import chat.llamas.cardlogic.domain.commands.CancelGameCommand;
import chat.llamas.cardlogic.domain.commands.JoinGameCommand;
import chat.llamas.cardlogic.domain.commands.LeaveGameCommand;
import chat.llamas.cardlogic.domain.commands.StartGameCommand;
import chat.llamas.cardlogic.domain.game.GameMessageInterface;
import chat.llamas.cardlogic.domain.game.RoundType;
import chat.llamas.cardlogic.game.api.GameEventManagerInterface;
import chat.llamas.cardlogic.game.api.GameInterface;
import chat.llamas.cardlogic.game.api.RoundInterface;
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
				//if (!game.getPlayers().containsKey(round))
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
