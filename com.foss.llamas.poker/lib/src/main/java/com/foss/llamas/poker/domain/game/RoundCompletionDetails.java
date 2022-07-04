package com.foss.llamas.poker.domain.game;

import java.math.BigDecimal;
import java.util.Map;

public class RoundCompletionDetails {
	private Map<Player, BigDecimal> potWinnings;
	
	private RoundType finishTurn;
}
