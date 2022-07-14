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
