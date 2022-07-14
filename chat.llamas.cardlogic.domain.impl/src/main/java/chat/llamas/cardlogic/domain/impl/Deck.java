package chat.llamas.cardlogic.domain.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.DeckInterface;

/// A deck to draw cards from.
public class Deck implements DeckInterface {
	private List<Card> cards;
	private int cardsDrawn;
	// TODO: Default constructor for a 52 card deck.
	public Deck(Collection<Card> cards) {
		this.cards = new ArrayList<>(cards);
		cardsDrawn = 0;
		shuffle();
	}
	
	@Override
	public void refresh() {
		this.cardsDrawn = 0;
		shuffle();
	}
	
	private void shuffle() {
		Collections.shuffle(cards);
	}
	
	@Override
	public int getCardsDrawn() {
		return this.cardsDrawn;
	}
	
	@Override
	public int getCardsRemaining() {
		return this.cards.size() - this.cardsDrawn;
	}
	
	@Override
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
