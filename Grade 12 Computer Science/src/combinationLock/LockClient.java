package combinationLock;

import java.util.Scanner;

public class LockClient {
	Scanner input = new Scanner(System.in);
	int[] combination = { 1, 2, 3 };
	static boolean playing = true;
	CombinationLock lock = new CombinationLock(combination);
	Boolean adminLocked = true;

	public static void main(String[] args) {

		LockClient game = new LockClient();
		while (playing) {
			game.mainMenu();
		}
		System.out.println("Exciting");

	}

	
	
	
	
	
	
	
	
	public void mainMenu() {
		System.out.println("");
		System.out.println("Welcome to the main menu!");
		System.out.println("Enter the number corrosponding with the task you would like to complete");
		System.out.println("1. Enter admin section");
		System.out.println("2. Check lock status");
		System.out.println("3. Lock the Lock");
		System.out.println("4. Attempt to open the lock with a 3-digit code");
		System.out.println("5. Check the lock’s health");
		System.out.println(
				"6. Smash the lock (a totally smashed lock disables all other functionality until reset by admin)");
		System.out.println("7. Brute force computer attack ");
		System.out.println("8. Exit");
		int menuChoice = input.nextInt();
		if (lock.isBroken()) {
			System.out.println("all functionality is disabled until the lock is reset, redirecting to the admin menu");
			menuChoice = 1;
		}
		switch (menuChoice) {

		case 1:
			if (adminLocked) {
				System.out.println("Please enter the password");
				if (input.next().equals(lock.getPassword())) {
					adminMenu();
					adminLocked = false;
				}
			} else {
				adminMenu();
			}

			break;
		case 2:
			lock.isLocked();
			if (!lock.isBroken()) {
				System.out.println("the lock is not broken");
			}

			break;
		case 3:
			lock.lock();

			break;
		case 4:

			int[] guess = new int[3];

			System.out.println("please enter the first digit of your new combination");
			guess[0] = this.input.nextInt();
			System.out.println("please enter the second digit of your new combination");
			guess[1] = this.input.nextInt();
			System.out.println("please enter the third digit of your new combination");
			guess[2] = this.input.nextInt();

			lock.unlock(guess);

			break;
		case 5:
			lock.getHealth();
			break;
		case 6:
			lock.smash();
			break;
		case 7:
			bruteForce();
			break;
		case 8:
			playing = false;
			break;
		}
	}

	public void adminMenu() {
		
		lock.tostring();
		System.out.println("");
		System.out.println("Welcome to the admin menu!");
		System.out.println("Enter the number corrosponding with the task you would like to complete");
		System.out.println("1. See the lock combination");
		System.out.println("2. Reset the lock’s health");
		System.out.println("3. Change the min/max values");
		System.out.println("4. Change the combination");
		System.out.println("5. Changes the password");
		System.out.println("6. Accesses the toString() method");
		System.out.println("7. Accesses the Save method ");
		System.out.println("8. Accesses the Load method");

		switch (input.nextInt()) {
		case 1:
			combination = lock.getCombination();
			System.out.println(combination[0]);
			System.out.println(combination[1]);
			System.out.println(combination[2]);
			break;
		case 2:
			lock.resetHealth();
			break;
		case 3:
			lock.changeMinMax();

			break;
		case 4:
			lock.setCombination();

			break;
		case 5:
			System.out.println("please enter a new password");
			lock.setPassword(input.next());
			break;
		case 6:
			/*lock.smash();*/
			break;
		case 7:
			/*bruteForce();*/
			break;
		case 8: // exit
			break;
		}
	}

	public void bruteForce() {
		int[] guess = new int[3];
		for (int i = 0; i <= lock.getMaxValue(); i++) {

			for (int j = lock.getMinValue(); j <= lock.getMaxValue(); j++) {

				for (int k = lock.getMinValue(); k <= lock.getMaxValue(); k++) {
					// System.out.println(i);
					// System.out.println(j);
					// System.out.println(k);
					// System.out.println("");
					guess[0] = i;
					guess[1] = j;
					guess[2] = k;
					if (lock.unlock(guess)) {
						i = lock.getMaxValue();
						j = lock.getMaxValue();
						k = lock.getMaxValue();
					}
				}
			}

		}
		System.out.println("the correct combination is " + guess[0] + "" + guess[1] + "" + guess[2]);
		System.out.println("it took " + lock.getAttempts() + " attempts");
	}


	
	

}