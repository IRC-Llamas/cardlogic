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

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.naming.OperationNotSupportedException;

import chat.llamas.cardlogic.domain.GameState;
import chat.llamas.cardlogic.domain.game.PlayerInterface;

public interface GameInterface extends AutoCloseable {
	void acceptCommand(String command) throws OperationNotSupportedException;
	
	RoundInterface getCurrentRound();
	
	GameState getGameState();
	
	GameEventMediatorInterface getGameEventMediator();
	
	default Optional<PlayerInterface> getStartingPlayer() {
		if (!Objects.equals(getGameState(), GameState.INACTIVE)) {
			return Optional.of(getPlayers().entrySet().iterator().next().getKey());
		}
		else {
			return Optional.empty();
		}
	}
	
	Map<PlayerInterface, Boolean> getPlayers();
	
	CommandEventBusInterface getCommandEventBus();
	
	void setGameState(GameState gameState) throws OperationNotSupportedException;
}
