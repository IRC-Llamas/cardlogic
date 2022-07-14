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
