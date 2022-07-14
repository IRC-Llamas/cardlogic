package chat.llamas.cardlogic.domain.evaluators;

import chat.llamas.cardlogic.domain.HandResultType;
import chat.llamas.cardlogic.domain.Rank;
import com.google.common.collect.Multimap;

public class QuadsEvaluator extends MultiplesEvaluator {

	public QuadsEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.FOUR_KIND, 4, rankValueMap);
	}

	public QuadsEvaluator() {
		super(HandResultType.FOUR_KIND, 4);
	}
}
