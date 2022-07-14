package chat.llamas.cardlogic;

import java.math.BigDecimal;
import java.util.Map;

import chat.llamas.cardlogic.domain.game.Player;

public interface IPot {
	
	RoundInterface getRound();

	Map<Player, BigDecimal> getPot();
	
	Map<Player, BigDecimal> getUnsatisfiedPot();
	
	BigDecimal getPotSize();
	
	default boolean isPotSatisfied() {
		return getUnsatisfiedPot().isEmpty();
	}
}
