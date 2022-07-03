package com.foss.llamas.poker.domain.evaluators;

import com.foss.llamas.poker.domain.HandResultType;
import com.foss.llamas.poker.domain.Rank;
import com.google.common.collect.Multimap;

public class QuadsEvaluator extends MultiplesEvaluator {

	public QuadsEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.FOUR_KIND, 4, rankValueMap);
	}

	public QuadsEvaluator() {
		super(HandResultType.FOUR_KIND, 4);
	}
}
