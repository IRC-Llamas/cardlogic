package com.foss.llamas.poker.domain.game;

import java.util.Optional;

public interface GameMessageInterface {
	MessageType getMessageType();
	
	MessageScope getMessageScope();
	
	Optional<Player> getRecipient();
	
	Optional<Player> getSender();
	
	String getMessage();
}
