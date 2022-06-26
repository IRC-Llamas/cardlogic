package com.foss.llamas.poker.domain;

import java.util.ArrayList;
import java.util.List;

public class DeckBuilder {
	private List<StandardCard> deck = new ArrayList<>();
	
	private List<Plugin<List<StandardCard>>> plugins = new ArrayList<>();
	
	public DeckBuilder addPlugin(Plugin<List<StandardCard>> plugin) {
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
	
	public DeckBuilder addCard(StandardCard card) {
		deck.add(card);
		return this;
	}
	
	public List<StandardCard> build() {
		for (Plugin<List<StandardCard>> plugin : plugins) {
			plugin.apply(deck);
		}
		
		return deck;
	}
}
