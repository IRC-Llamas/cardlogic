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
package chat.llamas.cardlogic.domain.impl;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.Color;
import chat.llamas.cardlogic.domain.Rank;
import chat.llamas.cardlogic.domain.Suit;

public class StandardCardBuilder {
	private Suit suit = Suit.OTHER;
	private Color color = Color.OTHER;
	private Rank rank = Rank.OTHER;
	
	public static final StandardCardBuilder builder() {
		return new StandardCardBuilder();
	}
	public StandardCardBuilder withSuit(Suit suit) {
		this.suit = suit;
		return this;
	}
	public StandardCardBuilder withRank(Rank rank) {
		this.rank = rank;
		return this;
	}
	public StandardCardBuilder withColor(Color color) {
		this.color = color;
		return this;
	}
	public Card build() {
		if (color == Color.OTHER) {
			return StandardCard.build(rank, suit);
		}
		else {
			
			return StandardCard.build(color, rank, suit);
		}
	}
}
