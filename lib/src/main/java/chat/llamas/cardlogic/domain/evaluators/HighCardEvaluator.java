package chat.llamas.cardlogic.domain.evaluators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.CardComparator;
import chat.llamas.cardlogic.domain.HandResult;
import chat.llamas.cardlogic.domain.HandResultType;
import chat.llamas.cardlogic.domain.Rank;
import com.google.common.collect.Multimap;

public class HighCardEvaluator extends HandResult {
	public HighCardEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.HIGH, rankValueMap);
	}

	@Override
	public boolean test(List<Card> arg0) {

		List<Card> cardQueue = new LinkedList<>(arg0);

		// Step 1: Collect the wild cards.
		List<Card> wildCards = collectWildCards(cardQueue);

		// Step 2: Sort the remaining cards by rank.
		Collections.sort(cardQueue, CardComparator.get(getRankValueMap()));

		// Step 3: Set the top five cards.
		List<Card> topFiveCards = collectTopFiveCards(cardQueue, wildCards);

		setCards(new ArrayList<>(topFiveCards));
		
		return true;
	}
}
