package cardLib;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	/***
	 * Array list of cards that contains all the cards in the deck
	 */
	private ArrayList<Card> deck;

	/***
	 * Constructor
	 */
	public Deck() {
		deck = new ArrayList<Card>();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r,s));
			}
		}
	}
	
	/***
	 * Copy constructor
	 * @param oldDeck The deck to copy
	 */
	public Deck(Deck oldDeck) {
		deck = new ArrayList<Card>();
		for (Card c : oldDeck.deck) {
			deck.add(c);
		}
	}
	
	/***
	 * Draws and removes the last card from the deck
	 * @return The drawn card
	 */
	public Card drawCard() {
		return this.getDeck().remove(this.deck.size()-1);
	}
	
	/***
	 * Shuffles whatever cards are in the deck
	 */
	public void shuffleDeck() {
		Deck oldDeck = new Deck(this);
		Random rand = new Random();
		this.clearDeck();
		
		while (oldDeck.getDeck().size() > 0) {
			int randInt = rand.nextInt(oldDeck.getDeck().size());
			
			this.getDeck().add(oldDeck.getDeck().remove(randInt));
		}
	}
	
	public void resetDeck() {
		this.clearDeck();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				this.getDeck().add(new Card(r,s));
			}
		}	
	}
	
	/***
	 * Empties out the Deck
	 */
	public void clearDeck() {
		this.getDeck().clear();
	}
	
	public ArrayList<Card> getDeck(){
		return this.deck;
	}
	
	/***
	 * Testing purposes
	 */
	public void listDeck() {
		int clubsCount = 0;
		int heartsCount = 0;
		int diamondsCount = 0;
		int spadesCount = 0;
		
		for (Card c : this.deck) {
			System.out.println(c.toString());
			switch (c.getSuit()) {
				case Spade :	spadesCount += 1;
								break;
				case Heart :	heartsCount += 1;
								break;
				case Diamond :	diamondsCount += 1;
								break;
				case Club :		clubsCount += 1;
								break;
			}
		}
		
		System.out.println("Spades: " + spadesCount);
		System.out.println("Clubs: " + clubsCount);
		System.out.println("Hearts: " + heartsCount);
		System.out.println("Diamonds: " + diamondsCount);
		
		System.out.println(this.deck.size());
	}
}
