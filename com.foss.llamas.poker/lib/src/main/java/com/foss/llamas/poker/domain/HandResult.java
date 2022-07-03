package com.foss.llamas.poker.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class HandResult implements Predicate<List<Card>> {

	private List<Card> cards = new ArrayList<>();
	private HandResultType handResultType;
	public HandResult(HandResultType handResultType) {
		this.handResultType = handResultType;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	public List<Card> getCards() {
		return cards;
	}
	public HandResultType getHandResultType() {
		return handResultType;
	}
}
