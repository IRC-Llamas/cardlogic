package com.foss.llamas.poker.domain.cardformatter;

import java.util.Objects;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.Rank;

public class UnicodeCardStringFormatter implements CardStringFormatter {

	String wild = "🃟";
	
	String joker = "🃏";
	
	@Override
	public String apply(Card card) {
		final String result;
		if (card.isWild()) {
			if (Objects.equals(card.getRank(), Rank.JOKER)) {
				result = joker;
			}
			else {
				result = wild;
			}
		}
		else {
			Rank rank = card.getRank();
			if (Objects.equals(rank, Rank.ACE)) {
				switch (card.getSuit()) {

				case CLUBS:
					result = "🃑";
					break;
				case DIAMONDS:
					result = "🃁";
					break;
				case HEARTS:
					result = "🂱";
					break;
				case SPADES:
					result = "🂡";
					break;
				default:
					result = "🂠";
					break;
				}
			}
			else if (Objects.equals(rank, Rank.KING)) {
				switch (card.getSuit()) {
				case CLUBS:
					result = "🃞";
					break;
				case DIAMONDS:
					result = "🃎";
					break;
				case HEARTS:
					result = "🂾";
					break;
				case SPADES:
					result = "🂮";
					break;
				default:
					result = "🂠";
					break;
				
				}
			}
			else if (Objects.equals(rank, Rank.QUEEN)) {
				switch (card.getSuit()) {
				case CLUBS:
					result = "🃝";
					break;
				case DIAMONDS:
					result = "🃍";
					break;
				case HEARTS:
					result = "🂽";
					break;
				case SPADES:
					result = "🂭";
					break;
				default:
					result = "🂠";
					break;
				
				}
			}			
			else if (Objects.equals(rank, Rank.JACK)) {
				switch (card.getSuit()) {
				case CLUBS:
					result = "🃛";
					break;
				case DIAMONDS:
					result = "🃋";
					break;
				case HEARTS:
					result = "🂻";
					break;
				case SPADES:
					result = "🂫";
					break;
				default:
					result = "🂠";
					break;
				
				}
			}
			else if (Objects.equals(rank, Rank.TEN)) {
				switch (card.getSuit()) {
				case CLUBS:
					result = "🃚";
					break;
				case DIAMONDS:
					result = "🃊";
					break;
				case HEARTS:
					result = "🂺";
					break;
				case SPADES:
					result = "🂪";
					break;
				default:
					result = "🂠";
					break;
				
				}	
			}
			else if (Objects.equals(rank, Rank.NINE)) {
				switch (card.getSuit()) {
				case CLUBS:
					result = "🃙";
					break;
				case DIAMONDS:
					result = "🃉";
					break;
				case HEARTS:
					result = "🂹";
					break;
				case SPADES:
					result = "🂩";
					break;
				default:
					result = "🂠";
					break;
				
				}	
			}
			else if (Objects.equals(rank, Rank.EIGHT)) {
				switch (card.getSuit()) {
					case CLUBS:
						result = "🃘";
						break;
					case DIAMONDS:
						result = "🃈";
						break;
					case HEARTS:
						result = "🂸";
						break;
					case SPADES:
						result = "🂨";
						break;
					default:
						result = "🂠";
						break;
				}	
			}
			else if (Objects.equals(rank, Rank.SEVEN)) {
				switch (card.getSuit()) {
					case CLUBS:
						result = "🃗";
						break;
					case DIAMONDS:
						result = "🃇";
						break;
					case HEARTS:
						result = "🂷";
						break;
					case SPADES:
						result = "🂧";
						break;
					default:
						result = "🂠";
						break;
				}
			}
			else if (Objects.equals(rank, Rank.SIX)) {
				switch (card.getSuit()) {
					case CLUBS:
						result = "🃖";
						break;
					case DIAMONDS:
						result = "🃆";
						break;
					case HEARTS:
						result = "🂶";
						break;
					case SPADES:
						result = "🂦";
						break;
					default:
						result = "🂠";
						break;
				}
			}
			else if (Objects.equals(rank, Rank.FIVE)) {
				switch (card.getSuit()) {
					case CLUBS:
						result = "🃕";
						break;
					case DIAMONDS:
						result = "🃆";
						break;
					case HEARTS:
						result = "🂵";
						break;
					case SPADES:
						result = "🂥";
						break;
					default:
						result = "🂠";
						break;
				}
			}
			else if (Objects.equals(rank, Rank.FOUR)) {
				switch (card.getSuit()) {
					case CLUBS:
						result = "🃔";
						break;
					case DIAMONDS:
						result = "🃄";
						break;
					case HEARTS:
						result = "🂴";
						break;
					case SPADES:
						result = "🂤";
						break;
					default:
						result = "🂠";
						break;
				}
			}
			else if (Objects.equals(rank, Rank.THREE)) {
				switch (card.getSuit()) {
					case CLUBS:
						result = "🃓";
						break;
					case DIAMONDS:
						result = "🃃";
						break;
					case HEARTS:
						result = "🂳";
						break;
					case SPADES:
						result = "🂣";
						break;
					default:
						result = "🂠";
						break;
				}
			}
			else if (Objects.equals(rank, Rank.TWO)) {
				switch (card.getSuit()) {
					case CLUBS:
						result = "🃒";
						break;
					case DIAMONDS:
						result = "🃂";
						break;
					case HEARTS:
						result = "🂲";
						break;
					case SPADES:
						result = "🂢";
						break;
					default:
						result = "🂠";
						break;
				}
			}
			else {
				result = "🂠";
			}
		}
		return result;
	}

}
