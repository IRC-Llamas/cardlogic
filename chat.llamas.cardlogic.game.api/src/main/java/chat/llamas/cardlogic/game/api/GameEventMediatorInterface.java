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

import java.util.Objects;
import java.util.Optional;

import javax.naming.OperationNotSupportedException;

import chat.llamas.cardlogic.GameConstants;
import chat.llamas.cardlogic.domain.GameState;
import chat.llamas.cardlogic.domain.commands.CancelGameCommand;
import chat.llamas.cardlogic.domain.commands.CommandDelegate;
import chat.llamas.cardlogic.domain.commands.FoldCommand;
import chat.llamas.cardlogic.domain.commands.JoinGameCommand;
import chat.llamas.cardlogic.domain.commands.LeaveGameCommand;
import chat.llamas.cardlogic.domain.commands.MessageCommand;
import chat.llamas.cardlogic.domain.commands.StartGameCommand;
import chat.llamas.cardlogic.domain.game.PlayerInterface;
import chat.llamas.cardlogic.domain.game.RoundType;

public interface GameEventMediatorInterface {
	GameInterface getGame();
	
	default void startGame(StartGameCommand command) throws OperationNotSupportedException {
		if (getGame().getGameState() == GameState.INACTIVE) {
			//fireStartGame(command);
		}
		else {
			throw new OperationNotSupportedException("Game state must be inactive.");
		}
	}
	
	void sendMessage(MessageCommand command) throws OperationNotSupportedException;
	
	default void cancelGame(CancelGameCommand command) throws OperationNotSupportedException {
		if (getGame().getGameState() == GameState.PENDING) {
			if (getGame().getStartingPlayer().isPresent()) {
				RoundInterface round = getGame().getCurrentRound();
				
				if (Objects.equals(round.getRoundType(), RoundType.PRE_GAME)) {
					if (Objects.equals( getGame().getStartingPlayer().get().getName(), command.getDelegate().getPlayerName())) {
						// TODO: Cancel the game
					}
					else {
						throw new OperationNotSupportedException("Game can only be cancelled by the player who started it.");
					}
				}
				else {
					throw new OperationNotSupportedException("Game is already in progress.");
				}
			}
			else {
				throw new OperationNotSupportedException("There is no starting player.");
			}
		}
		else {
			throw new OperationNotSupportedException("Game state must be pending to cancel.");
		}
	}

	default void leaveGame(LeaveGameCommand command) throws OperationNotSupportedException {
		if (Objects.equals(getGame().getGameState(), GameState.PENDING)) {
			// The game state is still pending,
			// just remove the player.
			removePlayerFromGame(command);
			
		}
		else if (Objects.equals(getGame().getGameState(), GameState.ACTIVE)) {
			// Fold the player if they haven't already,
			// and then remove the player.
			
			try {
				getGame().acceptCommand(
					String.join(" ",
						FoldCommand.COMMAND_NAME,
						CommandDelegate.PLAYER_FLAG_LONG +
						GameConstants.ARGUMENT_SEPARATOR +
						command.getDelegate().getPlayerName()));
				
				removePlayerFromGame(command);
			}
			catch (OperationNotSupportedException e) {
				throw e;
			}
		}
		else {
			throw new OperationNotSupportedException("Game state must be pending or active to leave.");
		}
	}
	
	default void joinGame(JoinGameCommand command) throws OperationNotSupportedException {
		if (getGame().getGameState() == GameState.PENDING) {
			RoundInterface round = getGame().getCurrentRound();
			
			if (Objects.equals(round.getRoundType(), RoundType.PRE_GAME)) {
				//if (!game.getPlayers().containsKey(round))
			}
			else {
				throw new OperationNotSupportedException("Game is already in progress.");
			}
		}
		else {
			throw new OperationNotSupportedException("Game state must be pending to join.");
		}
	}
	
	private void removePlayerFromGame(LeaveGameCommand command) throws OperationNotSupportedException {
		Optional<PlayerInterface> leavingPlayer = Optional.empty();
		
		for (PlayerInterface player : getGame().getPlayers().keySet()) {
			if (Objects.equals(player.getName(), command.getDelegate().getPlayerName())) {
				leavingPlayer = Optional.of(player);
				
				break;
			}
		}
		
		if (leavingPlayer.isPresent()) {
			getGame().getPlayers().remove(leavingPlayer.get());
		}
		else {
			throw new OperationNotSupportedException("Player is not in the game.");
		}
	}
}
