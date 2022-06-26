package com.foss.llamas.poker.domain;

public interface Card {
	boolean isWild();
	Color getColor();
	Rank getRank();
	Suit getSuit();
}
