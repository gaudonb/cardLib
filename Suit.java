package cardLib;

public enum Suit {
	Heart(1),
	Diamond(2),
	Spade(3),
	Club(4);
	
	private final int value;
	
	Suit(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
