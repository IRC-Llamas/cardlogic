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
import jakarta.persistence.Entity;

@Entity
public class Player implements PlayerInterface {
	private String name;
	
	// TODO: Change to Moneta's type
	// See:
	// https://www.baeldung.com/java-money-and-currency
	private BigDecimal availableMoney;
	
	private int gamesPlayed;
	
	private int gamesWon;
	
	private int gamesTied;
	
	private int gamesLost;
	
	private BigDecimal totalWinnings;
	
	private BigDecimal totalLosses;
	
	private long winningStreak;
	
	private long bestWinningStreak;

	private long losingStreak;
	
	private long bestLosingStreak;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public BigDecimal getAvailableMoney() {
		return availableMoney;
	}

	@Override
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	@Override
	public int getGamesWon() {
		return gamesWon;
	}

	@Override
	public int getGamesTied() {
		return gamesTied;
	}

	@Override
	public int getGamesLost() {
		return gamesLost;
	}

	@Override
	public BigDecimal getTotalWinnings() {
		return totalWinnings;
	}

	@Override
	public BigDecimal getTotalLosses() {
		return totalLosses;
	}

	@Override
	public void sendMessage(GameMessageInterface message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Observable<GameMessageInterface> onMessageReceived() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getWinningStreak() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getBestWinningStreak() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLosingStreak() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getBestLosingStreak() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
