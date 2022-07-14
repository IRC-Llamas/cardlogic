package chat.llamas.cardlogic.domain.game;

import java.util.Objects;
import java.util.Optional;

public enum RoundType {
	PRE_GAME(0),
	PRE_FLOP(1),
	FLOP(2),
	TURN(3),
	RIVER(4),
	SHOWDOWN(5);
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