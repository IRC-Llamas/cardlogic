package com.foss.llamas.poker.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> originalCards;
	private List<Card> cards;
	public Deck(List<Card> cards) {
		this.cards = cards;
		this.originalCards = new ArrayList<>(originalCards);
		shuffle();
	}
	
	public void refresh() {
		cards.clear();
		cards.addAll(originalCards);
		shuffle();
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public int getRemainingCardCount() {
		return cards.size();
	}
	
	public Card draw() throws UnsupportedOperationException {
		if (!cards.isEmpty()) {
			return cards.remove(0);
		}
		else {
			throw new UnsupportedOperationException("Deck is out of cards.");
		}
	}
}
