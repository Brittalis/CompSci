package blackJack;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Hand extends ArrayList<Card> {
	public int evalauteHand() {
		int aceCount = 0;

		int handValue = 0;
		for (int i = 0; i < this.size(); i++) {
			int cardValue = this.get(i).getRealValue();
			if (this.get(i).getRealValue() == 11) {
				aceCount++;
			}
			handValue += cardValue;
		}

		while (handValue > 21 && aceCount > 1) {
			handValue -= 10;
			aceCount--;
		}

		return handValue;

	}

	public void showHand() {
		for (int i = 0; i < this.size(); i++) {
			this.get(i).displayCard();
		}
		if(this.size()==0){
			System.out.println("your hand is empty lmao");
			System.out.println("\n");
		}
	}
}
