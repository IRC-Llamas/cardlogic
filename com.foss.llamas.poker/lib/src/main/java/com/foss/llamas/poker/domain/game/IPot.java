package com.foss.llamas.poker.domain.game;

import java.math.BigDecimal;
import java.util.Map;

public interface IPot {

	Map<Player, BigDecimal> getPot();
	
	Map<Player, BigDecimal> getUnsatisfiedPot();
	
	BigDecimal getPotSize();
}
