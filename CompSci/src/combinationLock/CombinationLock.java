package combinationLock;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@SuppressWarnings("unused")
	public class CombinationLock {
	private int minValue = 0;
	private int maxValue = 9;
	private int[] combination = new int[3];
	private int health = 10;
	private boolean locked = true;
	private boolean broken = false;
	private String password = "BenBoyd";
	// private boolean disabled = false;
	private int attempts = 0;
	private Scanner input = new Scanner(System.in);

	public int getAttempts() {
		return this.attempts;
	}

	public CombinationLock(int[] combination) {

		this.combination = combination;

	}

	public CombinationLock() {

		this.combination = null;

	}

	public boolean unlock(int[] guess) {
		int matches = 0;
		for (int i = 0; i < 3; i++) {
			if (guess[i] == this.combination[i]) {
				matches++;

				if (matches >= 3) {
					locked = false;
					System.out.println("the lock is now unlocked");
					return true;
				}
				// System.out.println("match");
			} else {
				this.attempts++;
				return false;
			}
		}

		return true;

	}

	public void lock() {

		this.locked = true;
		System.out.println("the lock is now locked");
	}

	public void smash() {

		if (health > 0) {
			System.out.println(health);
			this.health -= 1;
		} else {
			// this.disabled = true;
			broken = true;
			this.locked = false;
		}

	}

	public String getPassword() {
		return this.password;
	}

	public boolean isBroken() {
		if (broken) {
			System.out.println("the lock is broken and all other functionality is disabled untill it is reset");
		}

		return broken;
	}

	public boolean isLocked() {
		if (locked) {
			System.out.println("the lock is locked");
		} else if (!locked) {
			System.out.println("the lock is unlocked");
		}
		return locked;
	}

	public int[] getCombination() {
		return combination;
	}

	public void setCombination() {
		int[] combination = new int[3];

		System.out.println("please enter the first digit of your new combination");
		combination[0] = this.input.nextInt();
		System.out.println("please enter the second digit of your new combination");
		combination[1] = this.input.nextInt();
		System.out.println("please enter the third digit of your new combination");
		combination[2] = this.input.nextInt();
		while (!checkCombination(combination)) {

			System.out.println("please enter the first digit of your new combination");
			combination[0] = this.input.nextInt();
			System.out.println("please enter the second digit of your new combination");
			combination[1] = this.input.nextInt();
			System.out.println("please enter the third digit of your new combination");
			combination[2] = this.input.nextInt();
		}

		this.combination = combination;
	}

	public boolean checkCombination(int[] combination) {
		for (int i = 0; i < combination.length; i++) {
			if (combination[i] < this.minValue || combination[i] > this.maxValue) {
				System.out.println("Your Combination is Invalid, all digits mus be between " + this.minValue + " and "
						+ this.maxValue + " , please input a new one");
				return false;
			}

		}
		System.out.println("valid combination!");
		return true;
	}

	public void resetHealth() {
		this.health = 10;
		this.broken = false;
	}

	public void changeMinMax() {
		System.out.println("please enter a new minimum");
		this.minValue = this.input.nextInt();
		System.out.println("please enter a new maximum");
		this.maxValue = this.input.nextInt();
		while (this.maxValue < this.minValue) {
			System.out.println("please enter a maximum larger than your minumum");
			this.maxValue = this.input.nextInt();
		}
		System.out.println();
		checkCombination(this.combination);
	}

	public void save() throws IOException {
		FileReader in = null;
		FileWriter out = null;

		try {
			in = new FileReader("input.txt");
			out = new FileWriter("output.txt");

			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMaxValue() {
		return this.maxValue;
	}

	public int getMinValue() {
		return this.minValue;
	}

	public void tostring() {
		this.toString();
	}

	public int getHealth() {
		System.out.println("the lock has " + this.health + " health");
		return this.health;
	}
}
