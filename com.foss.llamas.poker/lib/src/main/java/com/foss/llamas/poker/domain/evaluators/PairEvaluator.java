package com.foss.llamas.poker.domain.evaluators;

import java.util.List;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.HandResult;
import com.foss.llamas.poker.domain.HandResultType;
import com.foss.llamas.poker.domain.Rank;
import com.foss.llamas.poker.domain.RankValueMapBuilder;
import com.foss.llamas.poker.domain.StandardCard;
import com.google.common.collect.Multimap;

public class PairEvaluator extends HandResult {

	private Multimap<Rank, Integer> rankValueMap;
	public PairEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.PAIR);
		this.rankValueMap = rankValueMap;
	}
	public PairEvaluator() {
		super(HandResultType.PAIR);
		this.rankValueMap = RankValueMapBuilder.builder()
			.addStandardPokerMappings().build();
	}
	@Override
	public boolean test(List<Card> arg0) {
		// TODO Needs to check for the highest pair and additionally a high card,
		// and call {@link #setCards} and set the value to the highest pair and then
		// the highest other three cards, based on the Rank Value Map.
		return false;
	}

}
