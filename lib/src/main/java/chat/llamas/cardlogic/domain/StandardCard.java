// Copyright 2022 Llamas
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package chat.llamas.cardlogic.domain;

public class StandardCard implements Card {
	private Color color;
	private final Rank rank;
	private final Suit suit;
	
	private boolean wild;
	private StandardCard(Color color, Rank rank, Suit suit) {
		this.color = color;
		this.rank = rank;
		this.suit = suit;
	}
	private StandardCard(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		if (suit == Suit.CLUBS) {
			this.color = Color.BLACK;
		}
		else if (suit == Suit.SPADES) {
			this.color = Color.BLACK;
		}
		else if (suit == Suit.DIAMONDS) {
			this.color = Color.RED;
		}
		else if (suit == Suit.HEARTS) {
			this.color = Color.RED;
		}
		else if (suit == Suit.ANY) {
			this.color = Color.ANY;
		}
		else if (suit == Suit.JOKER) {
			this.color = Color.JOKER;
		}
		else {
			this.color = Color.OTHER;
		}
		
	}
	/*@Override
	public int compareTo(StandardCard arg0) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
	public static Card build(Color color, Rank rank, Suit suit) {
		StandardCard card = new StandardCard(color, rank, suit);
		if ((color == Color.JOKER || color == Color.ANY) &&
			(rank == Rank.ANY || rank == Rank.JOKER) &&
			(suit == Suit.ANY || suit == Suit.JOKER)) {
			card.wild = true;
		}
		return card;
	}

	public static Card build(Rank rank, Suit suit) {
		StandardCard card = new StandardCard(rank, suit);
		if ((rank == Rank.ANY || rank == Rank.JOKER) &&
			(suit == Suit.ANY || suit == Suit.JOKER)) {
			if (rank == Rank.JOKER || suit == Suit.JOKER) {
				card.color = Color.JOKER;				
			}
			else {
				card.color = Color.ANY;				
			}
			card.wild = true;
		}
		return card;
	}
	
	public static Card buildJoker() {
		StandardCard card = new StandardCard(Color.JOKER, Rank.JOKER, Suit.JOKER);
		card.wild = true;
		return card;
	}

	public boolean isWild() {
		return wild;
	}
	public Color getColor() {
		return color;
	}
	public Rank getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit;
	}
}
