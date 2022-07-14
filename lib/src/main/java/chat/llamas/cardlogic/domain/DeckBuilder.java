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
package chat.llamas.cardlogic.domain;

import java.util.ArrayList;
import java.util.List;

public class DeckBuilder {
	private List<Card> deck = new ArrayList<>();
	
	private List<Plugin<List<Card>>> plugins = new ArrayList<>();
	
	public DeckBuilder addPlugin(Plugin<List<Card>> plugin) {
		plugins.add(plugin);
		return this;
	}
	
	public DeckBuilder addStandardPokerCards() {
		return this
		.addRank(Rank.ACE)
		.addRank(Rank.TWO)
		.addRank(Rank.THREE)
		.addRank(Rank.FOUR)
		.addRank(Rank.FIVE)
		.addRank(Rank.SIX)
		.addRank(Rank.SEVEN)
		.addRank(Rank.EIGHT)
		.addRank(Rank.NINE)
		.addRank(Rank.TEN)
		.addRank(Rank.JACK)
		.addRank(Rank.QUEEN)
		.addRank(Rank.KING);
	}
	
	public DeckBuilder addRank(Rank rank) {
		return this
		.addCard(StandardCard.build(rank, Suit.CLUBS))
		.addCard(StandardCard.build(rank, Suit.SPADES))
		.addCard(StandardCard.build(rank, Suit.HEARTS))
		.addCard(StandardCard.build(rank, Suit.DIAMONDS));
	}
	
	public DeckBuilder addJokers(int count) {
		for (int x = 0; x < count; x++) {
			addCard(StandardCard.build(Rank.JOKER, Suit.JOKER));
		}
		return this;
	}
	
	public DeckBuilder addCard(Card card) {
		deck.add(card);
		return this;
	}
	
	public DeckInterface build() {
		for (Plugin<List<Card>> plugin : plugins) {
			plugin.apply(deck);
		}
		
		return new Deck(deck);
	}
}
