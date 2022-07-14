package chat.llamas.cardlogic.domain.game;

import java.util.List;
import java.util.Map;

import chat.llamas.cardlogic.GameInterface;
import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.DeckInterface;

public interface RoundInterface {
	long getRoundID();
	
	Map<Player, Boolean> getPlayers();
	
	IPot getPot();
	
	int getRoundCount();
	
	DeckInterface getDeck();
	
	List<Card> getBurnCards();
		
	void join(Player player);
	
	void leave(Player player);
	
	void nextRound();
	
	boolean isPotSatisfied();
	
	RoundEventManagerInterface getRoundEventManager();
	
	GameInterface getGame();
	
	TurnManagerInterface getTurnManager();
	
	RoundType getRoundType();
	
	RoundType getNextRoundType();
}
