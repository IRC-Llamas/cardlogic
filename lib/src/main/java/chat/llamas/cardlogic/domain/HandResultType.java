package chat.llamas.cardlogic.domain;

public enum HandResultType {
	BETTER_THAN_ROYAL_FLUSH(true),
	ROYAL_FLUSH(false),
	STRAIGHT_FLUSH(false),
	FOUR_KIND(false),
	FULL_HOUSE(false),
	FLUSH(false),
	STRAIGHT(false),
	FOUR_FLUSH(true),
	THREE_KIND(false),
	TWO_PAIR(false),
	PAIR(false),
	HIGH(false),
	NONE(false);
	
	private boolean custom;
	HandResultType(boolean custom) {
		this.custom = custom;
	}
	
	public boolean isCustom() {
		return custom;
	}
	
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
}
