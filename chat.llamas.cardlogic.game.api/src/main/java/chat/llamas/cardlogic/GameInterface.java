package chat.llamas.cardlogic;

import javax.naming.OperationNotSupportedException;

import chat.llamas.cardlogic.domain.GameState;
import chat.llamas.cardlogic.domain.commands.CancelGameCommand;
import chat.llamas.cardlogic.domain.commands.JoinGameCommand;
import chat.llamas.cardlogic.domain.commands.LeaveGameCommand;
import chat.llamas.cardlogic.domain.commands.StartGameCommand;
import chat.llamas.cardlogic.domain.game.Player;
import io.reactivex.rxjava3.core.Observable;

public interface GameInterface {
	void acceptCommand(String command) throws OperationNotSupportedException;
	
	RoundInterface getCurrentRound();
	
	GameState getGameState();
	
	GameEventManagerInterface getGameEventManager();
	
	Player getStartingPlayer();
}
