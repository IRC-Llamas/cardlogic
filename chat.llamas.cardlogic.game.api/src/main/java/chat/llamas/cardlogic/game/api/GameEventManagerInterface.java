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
package chat.llamas.cardlogic.game.api;

import chat.llamas.cardlogic.domain.GameState;
import chat.llamas.cardlogic.domain.commands.CancelGameCommand;
import chat.llamas.cardlogic.domain.commands.JoinGameCommand;
import chat.llamas.cardlogic.domain.commands.LeaveGameCommand;
import chat.llamas.cardlogic.domain.commands.StartGameCommand;
import chat.llamas.cardlogic.domain.game.GameMessageInterface;
import io.reactivex.rxjava3.core.Observable;

public interface GameEventManagerInterface {
	GameInterface getGame();
	
	Observable<StartGameCommand> onStartGame();
	
	Observable<CancelGameCommand> onCancelGame();
	
	Observable<JoinGameCommand> onJoinGame();
	
	Observable<LeaveGameCommand> onLeaveGame();
	
	Observable<GameMessageInterface> onMessage();
	
	default void startGame(StartGameCommand command) throws UnsupportedOperationException {
		if (getGame().getGameState() == GameState.INACTIVE) {
			fireStartGame(command);
		}
		else {
			throw new UnsupportedOperationException("Game state must be inactive.");
		}
	}
	
	void sendMessage(GameMessageInterface message);
	
	void cancelGame(CancelGameCommand command) throws UnsupportedOperationException;
	
	void joinGame(JoinGameCommand command) throws UnsupportedOperationException;
	
	void leaveGame(LeaveGameCommand command) throws UnsupportedOperationException;
	
	void fireStartGame(StartGameCommand command);
	
	void fireCancelGameCommand(CancelGameCommand command);
	
	void fireJoinGameCommand(JoinGameCommand command);
	
	void fireLeaveGameCommand(LeaveGameCommand command);
}
