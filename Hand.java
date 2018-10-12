package cardLib;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand;
	
	public Hand() {
		this.hand = new ArrayList<Card>();
	}
	
	public void addCard(Card newCard) {
		this.getHand().add(newCard);
	}
	
	public void removeCard(Card cardToRemove) {
		this.getHand().remove(cardToRemove);
	}
	
	public void clearHand() {
		this.getHand().clear();
	}
	
	public ArrayList<Card> getHand(){
		return this.hand;
	}
}
