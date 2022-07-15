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
package chat.llamas.cardlogic.game.impl;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import chat.llamas.cardlogic.GameInterface;
import chat.llamas.cardlogic.IPot;
import chat.llamas.cardlogic.RoundEventManagerInterface;
import chat.llamas.cardlogic.RoundInterface;
import chat.llamas.cardlogic.TurnManagerInterface;
import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.DeckInterface;
import chat.llamas.cardlogic.domain.game.PlayerInterface;
import chat.llamas.cardlogic.domain.game.RoundType;

public class Round implements RoundInterface {
	
	private RoundType roundType = RoundType.PRE_GAME;
	
	private int roundCount;
	
	private DeckInterface deck;
	
	private List<Card> burnCards;
	
	private Map<PlayerInterface, List<Card>> holeCards;
	
	private List<Card> communityCards;
	
	public void join(PlayerInterface player) {
		
	}
	
	public void leave(PlayerInterface player) {
		
	}
	
	public void nextTurn() {
		
	}
	
	public void fold(PlayerInterface player) {
		
	}
	
	public void nextRound() {
		
	}

	@Override
	public Map<PlayerInterface, Boolean> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRoundCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DeckInterface getDeck() {
		return deck;
	}

	@Override
	public List<Card> getBurnCards() {
		return burnCards;
	}

	@Override
	public boolean isPotSatisfied() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IPot getPot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoundEventManagerInterface getRoundEventManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameInterface getGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TurnManagerInterface getTurnManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoundType getRoundType() {
		return roundType;
	}

	@Override
	public RoundType getNextRoundType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getRoundID() {
		// TODO Auto-generated method stub
		return 0;
	}
}
