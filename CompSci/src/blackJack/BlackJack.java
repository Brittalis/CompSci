package blackJack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJack {
	private int bankRoll = 0;
	private int bet = 0;
	private Deck deck = new Deck();
	private Hand playersHand = new Hand();
	private Hand dealersHand = new Hand();
	private boolean isPlayerDone = false;
	boolean runGame = true;

	public static void main(String[] args) throws IOException {
		BlackJack blackjack = new BlackJack();
		blackjack.play();
	}

	public void play() throws IOException {

		System.out.println("What would you like your bet to be?");
		boolean validEntry = false;
		while (validEntry == false) {

			try {
				bet = Integer.parseInt(options());
				validEntry = true;
			} catch (NumberFormatException e) {
				System.out.println("Thats not a valid bet!");
				validEntry = false;
			}
		}
		// System.out.println(bet + "");
		while (runGame) {
			System.out.print("deal, hit, double, stand, exit: ");
			if (isPlayerDone == false) {
				validEntry = false;
				switch (options()) {
				case "deal":
					deal();
					validEntry = true;
					break;
				case "hit":
					hit();
					validEntry = true;
					break;
				case "double":
					doubleDown();
					validEntry = true;
					break;
				case "stand":
					stand();
					validEntry = true;
					break;
				case "exit":
					runGame = false;
					validEntry = false;
					System.out.println("Game Over\n\n");
					break;
				default:
					;
					System.out.println("Invalid entry\n\n");
				}
				// System.out.println("" + playersHand.evalauteHand());
			}
			if (validEntry) {
				endOfRound();
			}
		}
	}

	public void stand() {

		if (playersHand.size() == 0) {
			System.out.println("you need cards to stand");
		} else {
			isPlayerDone = true;
		}

	}

	public void doubleDown() {
		if (playersHand.size() == 2) {
			System.out.println("your bet has been doubled!!!");
			bet *= 2;
			deck.deal(playersHand);
		} else {
			System.out.println("You must have exactly two cards to doubledown");
		}
		playersHand.showHand();
	}

	public void hit() {

		if (playersHand.size() == 0) {
			System.out.println("You must deal cards first!\n\n");
		} else {
			deck.deal(playersHand);
		}
		System.out.println("Your hand:\n");
		playersHand.showHand();

	}

	public void endOfRound() {

		if (dealersHand.evalauteHand() < 17) {
			System.out.println("\n\n");
			System.out.println("dealer hits");
			System.out.println("Dealers Hand:\n");
			deck.deal(dealersHand);

			dealersHand.showHand();
		} else if (isPlayerDone == true) {

			System.out.println("dealer stands");
			System.out.println("Dealers Hand:\n");
			if (playerWon()) {
				bankRoll += bet;
			} else {
				bankRoll -= bet;
			}
			runGame = false;
		} else {
			System.out.println("dealer stands");
		}

	}

	public boolean playerWon() {
		boolean dealerBust = false;
		boolean playerBust = false;

		if (playersHand.evalauteHand() > 21) {
			playerBust = true;
		}
		if (dealersHand.evalauteHand() > 21) {
			dealerBust = true;
		}
		if (dealerBust || playerBust) {
			if (playerBust) {
				System.out.println("dealer wins");
				return false;
			} else if (dealerBust) {
				System.out.println("player wins");
				return true;
			} else if (dealerBust && playerBust) {
				System.out.println("dealer wins ties!");
				return false;
			}

		}
		if (playersHand.evalauteHand() > dealersHand.evalauteHand()) {
			System.out.println("player wins");
			return true;
		} else if (playersHand.evalauteHand() < dealersHand.evalauteHand()) {
			System.out.println("dealer wins");

		}
		return false;
	}

	public void deal() {
		deck.deal(playersHand);
		deck.deal(playersHand);
		deck.deal(dealersHand);
		deck.deal(dealersHand);
		playersHand.showHand();
		System.out.println("\n");
	}

	private String options() throws IOException {

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader BufferedReader = new BufferedReader(input);
		String output = BufferedReader.readLine();
		System.out.print("\n");
		return output;

	}
}
