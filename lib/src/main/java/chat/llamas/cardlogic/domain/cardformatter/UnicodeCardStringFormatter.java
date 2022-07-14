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
package chat.llamas.cardlogic.domain.cardformatter;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.Rank;
import chat.llamas.cardlogic.domain.Suit;
import static java.util.Map.entry;

public class UnicodeCardStringFormatter implements CardStringFormatter {

	private static final String wild = "🃟";
	
	private static final String joker = "🃏";

	private static final Map<Suit, Integer> aces = Map.ofEntries(
			entry(Suit.SPADES, 127137),
			entry(Suit.HEARTS, 127153),
			entry(Suit.DIAMONDS, 127169),
			entry(Suit.CLUBS, 127185)
	);
	private static final Rank[] ranks = {
			Rank.ACE,
			Rank.TWO,
			Rank.THREE,
			Rank.FOUR,
			Rank.FIVE,
			Rank.SIX,
			Rank.SEVEN,
			Rank.EIGHT,
			Rank.NINE,
			Rank.TEN,
			Rank.JACK,
			null, // characters contain a Knight
			Rank.QUEEN,
			Rank.KING
	};


	
	@Override
	public String apply(Card card) {
		if (card.isWild()) {
			if (Objects.equals(card.getRank(), Rank.JOKER)) {
				return joker;
			}
			else {
				return wild;
			}
		}
		int rankIndex = Arrays.asList(ranks).indexOf(card.getRank());
		if (rankIndex < 0 || !aces.containsKey(card.getSuit())) {
			return "🂠";
		}
		return String.valueOf(
				Character.toChars(
						aces.get(card.getSuit()) + rankIndex
				)
		);
	}

}
