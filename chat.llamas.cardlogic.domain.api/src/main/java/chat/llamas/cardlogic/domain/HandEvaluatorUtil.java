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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

public class HandEvaluatorUtil {
	public static boolean isColor(Card joker, Color color) {
		return Objects.equals(color, joker.getColor()) ||
				Objects.equals(Color.JOKER, joker.getColor()) ||
				Objects.equals(Color.ANY, joker.getColor()) ||
					joker.isWild();
	
	}

	public static boolean isSuit(Card card, Suit suit) {
		return Objects.equals(suit, card.getSuit()) ||
				Objects.equals(Suit.JOKER, card.getSuit()) ||
				Objects.equals(Suit.ANY, card.getSuit()) ||
					card.isWild();
	
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
		list.sort(Entry.comparingByValue());

		Map<K, V> result = new LinkedHashMap<>();
		for (Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}
}
