package blackJack;

public class Card {

	private int value;
	String suit;

	Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
	}

	Card(Card card) {
		this.suit = card.suit;
		this.value = card.value;
	}

	public String getFace() {

		switch (value) {
		case 1:
			return "Ace";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		case 10:
			return "Ten";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
	
		default:
			return "THIS IS AN ERROR";
		}

	}

	public String getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public int getRealValue() {
		if (value == 1)
			return 11;
		else if (value == 11 || value == 12 || value == 13)
			return 10;

		return value;
	
	}

	public void displayCard() {
		System.out.println(" " + getFace() + " " + suit);
	}
}
