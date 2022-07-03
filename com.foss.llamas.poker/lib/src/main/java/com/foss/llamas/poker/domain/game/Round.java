package com.foss.llamas.poker.domain.game;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.Deck;

public class Round {
	private RoundState roundState;
	
	private Map<Player, Boolean> players = new LinkedHashMap<>();
	
	private BigDecimal potSize;
	
	private int roundCount;
	
	private Deck dec;
	
	private List<Card> burnCards;
}
