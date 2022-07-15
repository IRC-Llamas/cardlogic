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

import java.util.Objects;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.Rank;

public class BasicUnicodeCardStringFormatter implements CardStringFormatter {

	@Override
	public String apply(Card card) {
		String result;
		String suit = null;
		String rank = null;
		if (card.isWild()) {
			if (Objects.equals(card.getRank(), Rank.JOKER)) {
				result = "[*]";
			}
			else {
				result = "[*]";
			}
		}
		else {
			switch (card.getRank()) {
			case ACE:
				rank = "A";
				break;
			case EIGHT:
				rank = "8";
				break;
			case FIVE:
				rank = "5";
				break;
			case FOUR:
				rank = "4";
				break;
			case JACK:
				rank = "J";
				break;
			case KING:
				rank = "K";
				break;
			case NINE:
				rank = "9";
				break;
			case QUEEN:
				rank = "Q";
				break;
			case SEVEN:
				rank = "7";
				break;
			case SIX:
				rank = "6";
				break;
			case TEN:
				rank = "10";
				break;
			case THREE:
				rank = "3";
				break;
			case TWO:
				rank = "2";
				break;
			default:
				rank = "?";
				break;
			
			}
			switch (card.getSuit()) {
			case CLUBS:
				suit = "♣";
				break;
			case DIAMONDS:
				suit = "♦";
				break;
			case HEARTS:
				suit = "♥";
				break;
			case SPADES:
				suit = "♠";
				break;
			default:
				break;
			
			}
			result = "[" + rank + suit + "]";
		}
		return result;
	}

}
