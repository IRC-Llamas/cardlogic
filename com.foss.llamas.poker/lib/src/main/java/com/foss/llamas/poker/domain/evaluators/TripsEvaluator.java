package com.foss.llamas.poker.domain.evaluators;

import com.foss.llamas.poker.domain.Rank;
import com.google.common.collect.Multimap;

public class TripsEvaluator extends MultiplesEvaluator {

	public TripsEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(3, rankValueMap);
	}

	public TripsEvaluator() {
		super(3);
	}
}
