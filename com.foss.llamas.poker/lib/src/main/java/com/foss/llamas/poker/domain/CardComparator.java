package com.foss.llamas.poker.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

import com.google.common.collect.Multimap;

public class CardComparator implements Comparator<Card> {

	private Multimap<Rank, Integer> rankValueMap;
	
	private CardComparator(Multimap<Rank, Integer> rankValueMap) {
		this.rankValueMap = rankValueMap;
	}
	
	public static final CardComparator get(Multimap<Rank, Integer> rankValueMap) {
		return new CardComparator(rankValueMap);
	}
	
	public static final CardComparator get() {
		return new CardComparator(RankValueMapBuilder.builder()
			.addStandardPokerMappings().build());
	}
	@Override
	public int compare(Card arg0, Card arg1) {
		
		for (Integer rank1 : rankValueMap.get(arg0.getRank())) {
			for (Integer rank2 : rankValueMap.get(arg1.getRank())) {
				if (rank1 < 0 && rank2 >= 0) {
					return 1;
				}
				if (rank1 >= 0 && rank2 < 0) {
					return -1;
				}
				if (Objects.equals(rank1, rank2)) {
					return 0;
				}
			}
		}
		
        int rank1 = Collections.max(rankValueMap.get(arg0.getRank()));
        int rank2 = Collections.max(rankValueMap.get(arg1.getRank()));

        if (rank1 < 0 && rank2 >= 0) {
        	return 1;
        }
        if (rank1 >= 0 && rank2 < 0) {
        	return -1;
        }
        if (rank1 < 0 && rank2 < 0) {
        	return 0;
        }
        if (rank1 < rank2) {
            return -1;
        }
        if (rank1 > rank2) {
            return 1; 
        }
        return 0;
	}
}
