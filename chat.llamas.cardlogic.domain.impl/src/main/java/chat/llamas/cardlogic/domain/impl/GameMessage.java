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
package chat.llamas.cardlogic.domain.impl;

import java.util.Optional;

import chat.llamas.cardlogic.domain.game.GameMessageInterface;
import chat.llamas.cardlogic.domain.game.MessageScope;
import chat.llamas.cardlogic.domain.game.MessageType;
import chat.llamas.cardlogic.domain.game.Player;

public class GameMessage implements GameMessageInterface {
	private MessageType messageType;
	private MessageScope messageScope;
	private Optional<Player> sender;
	private Optional<Player> recipient;
	private String message;
	public GameMessage(MessageType messageType,
		MessageScope messageScope,
		Optional<Player> sender,
		Optional<Player> recipient,
		String message) {
		this.messageType = messageType;
		this.messageScope = messageScope;
		this.sender = sender;
		this.recipient = recipient;
		this.message = message;
	}
	@Override
	public MessageType getMessageType() {
		return messageType;
	}

	@Override
	public MessageScope getMessageScope() {
		return messageScope;
	}

	@Override
	public Optional<Player> getRecipient() {
		return recipient;
	}

	@Override
	public Optional<Player> getSender() {
		return sender;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
