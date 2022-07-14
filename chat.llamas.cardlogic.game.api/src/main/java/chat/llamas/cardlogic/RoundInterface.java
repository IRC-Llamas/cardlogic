package chat.llamas.cardlogic;

import java.util.List;
import java.util.Map;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.DeckInterface;
import chat.llamas.cardlogic.domain.game.Player;
import chat.llamas.cardlogic.domain.game.RoundType;

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
