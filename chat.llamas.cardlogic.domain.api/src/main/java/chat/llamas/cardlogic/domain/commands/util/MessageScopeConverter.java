package chat.llamas.cardlogic.domain.commands.util;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;

import chat.llamas.cardlogic.domain.game.MessageScope;

public class MessageScopeConverter implements IStringConverter<MessageScope> {
	 
    @Override
    public MessageScope convert(String value) {
    	MessageScope convertedValue = MessageScope.fromString(value);
 
        if(convertedValue == null) {
            throw new ParameterException("Value " + value + "can not be converted to MessageType. " +
                    "Available values are: NOTICE, PLAYER_PUBLIC, GLOBAL.");
        }
        return convertedValue;
    }
}
