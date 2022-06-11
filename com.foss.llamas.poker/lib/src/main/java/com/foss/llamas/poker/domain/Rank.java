package com.foss.llamas.poker.domain;

public enum Rank {
	MAX(Integer.MAX_VALUE),
	ACE,
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	JACK,
	QUEEN,
	KING,
	JOKER,
	OTHER,
	ANY;
	
	private int rankValue;
	public Rank(int rankValue) {
		this.rankValue = rankValue;
	}
}
