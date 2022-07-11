package com.foss.llamas.poker.domain;

import java.util.Stack;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/// A deck to draw cards from.
public class Deck implements DeckInterface {
	private final Stack<Card> cards;
	private final Stack<Card> drawnCards;

	public Deck(Collection<Card> cards) {
		this.cards = new Stack<>();
		this.drawnCards = new Stack<>();
		this.cards.addAll(cards);
		shuffle();
	}
	
	@Override
	public void refresh() {
		this.cards.addAll(drawnCards);
		this.drawnCards.clear();
		shuffle();
	}
	
	private void shuffle() {
		Collections.shuffle(cards);
	}
	
	@Override
	public int getCardsDrawn() {
		return this.drawnCards.size();
	}
	
	@Override
	public int getCardsRemaining() {
		return this.cards.size();
	}
	
	@Override
	public Optional<Card> draw() {
		if (this.getCardsRemaining() == 0) {
			return Optional.empty();
		} else {
			Card card = this.cards.pop();
			this.drawnCards.push(card);
			return Optional.of(card);
		}
	}
}
