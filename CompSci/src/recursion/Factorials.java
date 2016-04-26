package recursion;

import java.util.Scanner;

public class Factorials
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out
				.println("enter a number  and il tell you the factorial of it");
		int number = input.nextInt();
		int result = factorial(number);
		System.out.println(result);

	}

	public static int factorial(int number)
	{
		if (number == 1)
		{
			//System.out.println(number);
			return 1;
		} else
		{
			//System.out.println(number);
			return number * factorial(number - 1);
		}
	}
}
