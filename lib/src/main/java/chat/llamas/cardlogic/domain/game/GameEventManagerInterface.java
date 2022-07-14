package chat.llamas.cardlogic.domain.game;

import chat.llamas.cardlogic.GameInterface;
import chat.llamas.cardlogic.domain.GameState;
import chat.llamas.cardlogic.domain.commands.CancelGameCommand;
import chat.llamas.cardlogic.domain.commands.JoinGameCommand;
import chat.llamas.cardlogic.domain.commands.LeaveGameCommand;
import chat.llamas.cardlogic.domain.commands.StartGameCommand;

import io.reactivex.rxjava3.core.Observable;

public interface GameEventManagerInterface {
	GameInterface getGame();
	
	Observable<StartGameCommand> onStartGame();
	
	Observable<CancelGameCommand> onCancelGame();
	
	Observable<JoinGameCommand> onJoinGame();
	
	Observable<LeaveGameCommand> onLeaveGame();
	
	Observable<GameMessageInterface> onMessage();
	
	default void startGame(StartGameCommand command) throws UnsupportedOperationException {
		if (getGame().getGameState() == GameState.INACTIVE) {
			fireStartGame(command);
		}
		else {
			throw new UnsupportedOperationException("Game state must be inactive.");
		}
	}
	
	void sendMessage(GameMessageInterface message);
	
	void cancelGame(CancelGameCommand command) throws UnsupportedOperationException;
	
	void joinGame(JoinGameCommand command) throws UnsupportedOperationException;
	
	void leaveGame(LeaveGameCommand command) throws UnsupportedOperationException;
	
	void fireStartGame(StartGameCommand command);
	
	void fireCancelGameCommand(CancelGameCommand command);
	
	void fireJoinGameCommand(JoinGameCommand command);
	
	void fireLeaveGameCommand(LeaveGameCommand command);
}
