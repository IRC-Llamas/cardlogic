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
