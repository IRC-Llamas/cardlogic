package com.foss.llamas.poker.domain.game;

import java.math.BigDecimal;

import io.reactivex.rxjava3.core.Observable;

public interface PlayerInterface {

	/**
	 * Return the name of the player.
	 * 
	 * @return	The name of the player
	 */
	String getName();
	
	/**
	 * Return the money available to the 
	 * player.
	 * 
	 * @return	The available money
	 */
	BigDecimal getAvailableMoney();
	
	/**
	 * Return the number of times poker has
	 * been played by the player.
	 * 
	 * @return	The number of games
	 */
	int getGamesPlayed();
	
	int getGamesWon();
	
	int getGamesTied();
	
	int getGamesLost();
	
	BigDecimal getTotalWinnings();
	
	BigDecimal getTotalLosses();
	
	void sendMessage(GameMessageInterface message);
	
	Observable<GameMessageInterface> onMessageReceived();
}
