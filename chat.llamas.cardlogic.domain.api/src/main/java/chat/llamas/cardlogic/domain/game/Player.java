package chat.llamas.cardlogic.domain.game;

import java.math.BigDecimal;

import io.reactivex.rxjava3.core.Observable;

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
