package com.foss.llamas.poker.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/// A deck to draw cards from.
public class Deck {
	private List<Card> cards;
	private int cardsDrawn;
	// TODO: Default constructor for a 52 card deck.
	public Deck(Collection<Card> cards) {
		this.cards = new ArrayList<>(cards);
		cardsDrawn = 0;
		shuffle();
	}
	
	public void refresh() {
		this.cardsDrawn = 0;
		shuffle();
	}
	
	private void shuffle() {
		Collections.shuffle(cards);
	}
	
	public int getCardsDrawn() {
		return this.cardsDrawn;
	}
	
	public int getCardsRemaining() {
		return this.cards.size() - this.cardsDrawn;
	}
	
	public Optional<Card> draw() {
		if (this.getCardsRemaining() == 0) {
			return Optional.empty();
		} else {
			final var index = this.cardsDrawn;
			++this.cardsDrawn;
			return Optional.of(this.cards.get(index));
		}
	}
}
