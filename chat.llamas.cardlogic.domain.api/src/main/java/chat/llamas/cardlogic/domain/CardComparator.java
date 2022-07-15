// Copyright 2022 Llamas
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package chat.llamas.cardlogic.domain;

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
