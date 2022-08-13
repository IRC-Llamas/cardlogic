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

import javax.naming.OperationNotSupportedException;

import chat.llamas.cardlogic.domain.commands.MessageCommand;
import chat.llamas.cardlogic.game.api.GameEventMediatorInterface;
import chat.llamas.cardlogic.game.api.GameInterface;

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
	public void sendMessage(MessageCommand command) throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		
	}
}
