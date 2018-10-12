package cardLib;

public class Card {
	
	/***
	 * The rank of the card
	 */
	private Rank rank;
	
	/***
	 * The suit of the card
	 */
	private Suit suit;
	
	/***
	 * The trump Suit
	 */
	public static Suit trump = Suit.Club;
	
	/***
	 * Determine whether or not aces are high
	 */
	public static boolean aceHigh = false;
	
	/***
	 * Determine whether or not trumps suits are used
	 */
	public static boolean useTrumps = false;
	
	/***
	 * Creates a new card object with a defined rank and suit.
	 * 
	 * @param rank The rank of the new card
	 * @param suit The suit of the new card
	 * 
	 */
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/***
	 * Checks to see if two cards are equal to each other
	 * @param card1 Card object
	 * @param card2 Card object
	 * @return Returns true if the two cards are of equal value, false if not
	 */
	public static boolean equals(Card card1, Card card2){
		if (useTrumps) {
			if (card1.getSuit() == card2.getSuit() && card1.getRank() == card2.getRank()) {
				return true;
			}else {
				return false;
			}
		}else {
			if (card1.getRank().getValue() == card2.getRank().getValue()) {
				return true;
			}else {
				return false;
			}
		}
	}
		
	public static boolean greaterThan(Card card1, Card card2) {
		if (Card.equals(card1, card2)) return false;		
		if (useTrumps) {
			if (card1.getSuit().getValue() == card2.getSuit().getValue()){
				if (aceHigh) {
					if (card1.getRank() == Rank.Ace) {
						return true;
					}else if (card2.getRank() == Rank.Ace) {
						return false;
					}else {
						return (card1.getRank().getValue() > card2.getRank().getValue());
					}
				}else {
					return (card1.getRank().getValue() > card2.getRank().getValue());
				}
			}else if (card1.getSuit() == trump) {
				return true;				
			}else if (card2.getSuit() == trump) {
				return false;
			}else {
				if (aceHigh) {
					if (card1.getRank() == Rank.Ace) {
						return true;
					}else if (card2.getRank() == Rank.Ace) {
						return false;
					}else {
						return (card1.getRank().getValue() > card2.getRank().getValue());
					}
				}else {
					return (card1.getRank().getValue() > card2.getRank().getValue());
				}	
			}
		}else {
			if (aceHigh) {
				if (card1.getRank() == Rank.Ace) {
					return true;
				}else if (card2.getRank() == Rank.Ace) {
					return false;
				}else {
					return (card1.getRank().getValue() > card2.getRank().getValue());
				}
			}else {
				return (card1.getRank().getValue() > card2.getRank().getValue());
			}	
		}
		
	}
	
	@Override
	public String toString() {
		return "The " + this.getRank() + " of " + this.getSuit() +"s";
	}
	
	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
}
