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
package chat.llamas.cardlogic.domain.game;

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
	
	long getWinningStreak();
	
	long getBestWinningStreak();
	
	long getLosingStreak();
	
	long getBestLosingStreak();
}
