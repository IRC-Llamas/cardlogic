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
package chat.llamas.cardlogic.domain.game;

import java.util.Objects;
import java.util.Optional;

public enum RoundType {
	PRE_GAME(0),
	PRE_FLOP(1),
	FLOP(2),
	TURN(3),
	RIVER(4),
	SHOWDOWN(5),
	POST_GAME(6);
	
	private int roundIndex;
	
	private RoundType(int roundIndex) {
		this.roundIndex = roundIndex;
	}
	
	public static RoundType getRoundType(int roundIndex) {
		for (RoundType roundType : RoundType.values()) {
			if (Objects.equals(roundType.roundIndex, roundIndex)) {
				return roundType;
			}
		}
		return null;
	}
	
	public static Optional<RoundType> getNextRoundType(RoundType roundType) {
		return Optional.ofNullable(getRoundType(roundType.roundIndex + 1));
	}
}
