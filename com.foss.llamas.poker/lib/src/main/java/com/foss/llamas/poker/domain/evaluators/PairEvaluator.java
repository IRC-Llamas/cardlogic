package com.foss.llamas.poker.domain.evaluators;

import com.foss.llamas.poker.domain.HandResultType;
import com.foss.llamas.poker.domain.Rank;
import com.google.common.collect.Multimap;

public class PairEvaluator extends MultiplesEvaluator {

	public PairEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.PAIR, 2, rankValueMap);
	}

	public PairEvaluator() {
		super(HandResultType.PAIR, 2);
	}
}
