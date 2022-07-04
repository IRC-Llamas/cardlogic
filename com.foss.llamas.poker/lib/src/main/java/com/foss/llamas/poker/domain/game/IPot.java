package com.foss.llamas.poker.domain.game;

import java.math.BigDecimal;
import java.util.Map;

public interface IPot {
	
	RoundInterface getRound();

	Map<Player, BigDecimal> getPot();
	
	Map<Player, BigDecimal> getUnsatisfiedPot();
	
	BigDecimal getPotSize();
	
	default boolean isPotSatisfied() {
		return getUnsatisfiedPot().isEmpty();
	}
}
