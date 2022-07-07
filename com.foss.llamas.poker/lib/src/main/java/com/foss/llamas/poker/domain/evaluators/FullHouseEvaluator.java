package com.foss.llamas.poker.domain.evaluators;

import java.util.List;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.HandResult;
import com.foss.llamas.poker.domain.HandResultType;
import com.foss.llamas.poker.domain.Rank;
import com.google.common.collect.Multimap;

public class FullHouseEvaluator extends HandResult {

	public FullHouseEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.FULL_HOUSE, rankValueMap);
	}

	@Override
	public boolean test(List<Card> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
