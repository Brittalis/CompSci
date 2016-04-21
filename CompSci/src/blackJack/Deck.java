package blackJack;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings({ "serial" })
public class Deck extends ArrayList<Card> {

	public Deck() {
		createDeck();
		shuffleDeck();
	}

	public void shuffleDeck() {
		Collections.shuffle(this);
	}

	public void deal(Hand hand) {
		hand.add(this.get(0));
		this.remove(0);
	}

	public void createDeck() {
		String[] suit = { "Diamond", "Club", "Heart", "Spade" };
		int[] value = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		for (int i = 0; i < value.length; i++) {
			for (int j = 0; j < suit.length; j++) {
				this.add(new Card(suit[j], value[i]));
			}
		}

	}
	//feeling lazy and dont want to do this
/*	public void saveDeck(){
		
	}
	public void loadDeck(){
		
	}*/
	
	public void showDeck(){
		for(int i=0;i<this.size();i++)
		{
			this.get(i).displayCard();
		}
	}
}