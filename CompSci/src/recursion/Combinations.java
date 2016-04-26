package recursion;

import java.util.Scanner;

public class Combinations
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out
				.println("enter a n value");
		int n = input.nextInt();
		System.out
		.println("enter a r value");
		int r = input.nextInt();
		int result = combo(n,r);
		System.out.println(result);

	}

	public static int combo(int n, int r)
	{
	return Factorials.factorial(n)/(Factorials.factorial(n-r))*(Factorials.factorial(r));
	}
}
