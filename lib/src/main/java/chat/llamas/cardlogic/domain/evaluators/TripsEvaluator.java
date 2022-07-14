package chat.llamas.cardlogic.domain.evaluators;

import chat.llamas.cardlogic.domain.HandResultType;
import chat.llamas.cardlogic.domain.Rank;
import com.google.common.collect.Multimap;

public class TripsEvaluator extends MultiplesEvaluator {

	public TripsEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.THREE_KIND, 3, rankValueMap);
	}

	public TripsEvaluator() {
		super(HandResultType.THREE_KIND, 3);
	}
}
