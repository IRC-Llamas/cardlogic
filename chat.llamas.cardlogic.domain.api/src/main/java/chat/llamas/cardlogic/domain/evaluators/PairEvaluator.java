package chat.llamas.cardlogic.domain.evaluators;

import chat.llamas.cardlogic.domain.HandResultType;
import chat.llamas.cardlogic.domain.Rank;
import com.google.common.collect.Multimap;

public class PairEvaluator extends MultiplesEvaluator {

	public PairEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.PAIR, 2, rankValueMap);
	}

	public PairEvaluator() {
		super(HandResultType.PAIR, 2);
	}
}
