package chat.llamas.cardlogic.domain;

import java.util.Objects;
import java.util.function.Function;

public class CustomCard implements Card {
	private Function<Card, Color> getColorFunction = null;
	private Function<Card, Rank> getRankFunction = null;
	private Function<Card, Suit> getSuitFunction = null;
	private Function<Card, Boolean> isWildFunction = null;
	
	public static final Card build(
			Function<Card, Color> getColorFunction,
			Function<Card, Rank> getRankFunction,
			Function<Card, Suit> getSuitFunction,
			Function<Card, Boolean> isWildFunction) {
		return null;
		
	}
	@Override
	public boolean isWild() {
		if (Objects.nonNull(isWildFunction)) {
			return isWildFunction.apply(this);
		}
		else {
			return false;
		}
	}

	@Override
	public Color getColor() {
		if (Objects.nonNull(getColorFunction)) {
			return getColorFunction.apply(this);
		}
		else {
			return Color.OTHER;
		}
	}

	@Override
	public Rank getRank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit getSuit() {
		// TODO Auto-generated method stub
		return null;
	}

}
