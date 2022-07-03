package com.foss.llamas.poker.domain.evaluators;

import com.foss.llamas.poker.domain.Rank;
import com.google.common.collect.Multimap;

public class QuadsEvaluator extends MultiplesEvaluator {

	public QuadsEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(4, rankValueMap);
	}

	public QuadsEvaluator() {
		super(4);
	}
}
