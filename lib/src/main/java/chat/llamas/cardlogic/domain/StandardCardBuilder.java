package chat.llamas.cardlogic.domain;

public class StandardCardBuilder {
	private Suit suit = Suit.OTHER;
	private Color color = Color.OTHER;
	private Rank rank = Rank.OTHER;
	
	public static final StandardCardBuilder builder() {
		return new StandardCardBuilder();
	}
	public StandardCardBuilder withSuit(Suit suit) {
		this.suit = suit;
		return this;
	}
	public StandardCardBuilder withRank(Rank rank) {
		this.rank = rank;
		return this;
	}
	public StandardCardBuilder withColor(Color color) {
		this.color = color;
		return this;
	}
	public Card build() {
		if (color == Color.OTHER) {
			return StandardCard.build(rank, suit);
		}
		else {
			
			return StandardCard.build(color, rank, suit);
		}
	}
}
