package chat.llamas.cardlogic.domain.commands.util;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;

import chat.llamas.cardlogic.domain.game.MessageType;

public class MessageTypeConverter implements IStringConverter<MessageType> {
 
    @Override
    public MessageType convert(String value) {
    	MessageType convertedValue = MessageType.fromString(value);
 
        if(convertedValue == null) {
            throw new ParameterException("Value " + value + "can not be converted to MessageType. " +
                    "Available values are: INFO, WARNING, ERROR.");
        }
        return convertedValue;
    }
}
