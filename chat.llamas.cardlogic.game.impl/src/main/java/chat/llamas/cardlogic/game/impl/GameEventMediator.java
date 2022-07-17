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
import chat.llamas.cardlogic.domain.commands.MessageCommand;
import chat.llamas.cardlogic.domain.game.RoundType;
import chat.llamas.cardlogic.game.api.GameEventMediatorInterface;
import chat.llamas.cardlogic.game.api.GameInterface;
import chat.llamas.cardlogic.game.api.RoundInterface;

public class GameEventMediator implements GameEventMediatorInterface {

	private GameInterface game;

	public GameEventMediator(GameInterface game) {
		this.game = game;
	}
	
	@Override
	public GameInterface getGame() {
		return game;
	}
	
	@Override
	public void cancelGame(CancelGameCommand command) throws UnsupportedOperationException {
		if (game.getGameState() == GameState.PENDING) {

			RoundInterface round = getGame().getCurrentRound();
			
			if (Objects.equals(round.getRoundType(), RoundType.PRE_GAME)) {
				if (Objects.equals( game.getStartingPlayer().getName(), command.getDelegate().getPlayerName())) {
					// TODO: Cancel the game
				}
				else {
					throw new UnsupportedOperationException("Game can only be cancelled by the player who started it.");
				}
			}
			else {
				throw new UnsupportedOperationException("Game is already in progress.");
			}
		}
		else {
			throw new UnsupportedOperationException("Game state must be pending to cancel.");
		}
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
	public void sendMessage(MessageCommand command) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		
	}
}
