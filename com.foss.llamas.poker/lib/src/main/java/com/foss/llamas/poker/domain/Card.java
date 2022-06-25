package com.foss.llamas.poker.domain;

public class Card implements Comparable<Card> {
	private Color color;
	private Rank rank;
	private Suit suit;
	
	private boolean wild;
	private Card(Color color, Rank rank, Suit suit) {
		this.color = color;
		this.rank = rank;
		this.suit = suit;
	}
	@Override
	public int compareTo(Card arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static Card build(Color color, Rank rank, Suit suit) {
		Card card = new Card(color, rank, suit);
		if ((color == Color.JOKER || color == Color.ANY) &&
			(rank == Rank.ANY || rank == Rank.JOKER) &&
			(suit == Suit.ANY || suit == Suit.JOKER)) {
			card.setWild(true);
		}
		return card;
	}
	
	public void setWild(boolean wild) {
		this.wild = wild;
	}
	public boolean isWild() {
		return wild;
	}
}
