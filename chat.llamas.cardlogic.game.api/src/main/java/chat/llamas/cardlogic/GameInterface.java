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
package chat.llamas.cardlogic;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.naming.OperationNotSupportedException;

import chat.llamas.cardlogic.domain.GameState;
import chat.llamas.cardlogic.domain.commands.CancelGameCommand;
import chat.llamas.cardlogic.domain.commands.JoinGameCommand;
import chat.llamas.cardlogic.domain.commands.LeaveGameCommand;
import chat.llamas.cardlogic.domain.commands.StartGameCommand;
import chat.llamas.cardlogic.domain.game.PlayerInterface;
import io.reactivex.rxjava3.core.Observable;

public interface GameInterface {
	void acceptCommand(String command) throws OperationNotSupportedException;
	
	RoundInterface getCurrentRound();
	
	GameState getGameState();
	
	GameEventManagerInterface getGameEventManager();
	
	PlayerInterface getStartingPlayer();
	
	Map<PlayerInterface, Boolean> getPlayers();
}
