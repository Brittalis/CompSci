package recursion;

import java.util.Scanner;

public class Fibinacci
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
		int result = fib(number);
		System.out.println(result);

	}

	public static int fib(int termNumber)
	{
		if (termNumber == 1 || termNumber==2)
		{
			//System.out.println(termNumber);
			return 1;
		} else
		{
			//System.out.println(termNumber);
			return fib(termNumber - 1)+fib(termNumber-2);
		}
	}
}
