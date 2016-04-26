package recursion;

import java.util.Scanner;

public class Aids
{

	static double a;
	static int n;
	static double d;
	static double sum = 0;

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out
				.println("What kind of function do you want? 1 for arithmeticsequence, 2 for geomtertic sequence, 3 for arithemticseries, 4 for geometric series. ");
		int answer = input.nextInt();

		while (answer != 1 && answer != 2 && answer != 3 && answer != 4)
		{
			System.out.println("please enter 1 or 0");
			answer = input.nextInt();
		}
		System.out.println("please enter an A value");
		a = input.nextDouble();
		System.out.println("please enter r or d value");
		d = input.nextInt();
		System.out.println("what term do you want to know (N)");
		n = input.nextInt();

		switch (answer)
		{
		case 1:

			System.out.println(arithmeticSequence(n));
			break;
		case 2:
			System.out.println(geometricSequence(n));
			break;
		case 3:
			n++;
			arithmeticSeries(n);
			System.out.println(sum);
			break;
		case 4:
			n++;
			geometricSeries(n);
			System.out.println(sum);
			break;
		}

	}

	public static double arithmeticSequence(int n)
	{
		if (n == 1)
		{
			return a;
		} else
		{
			return arithmeticSequence(n - 1) + d;
		}
	}

	public static double geometricSequence(int n)
	{
		if (n == 1)
		{
			return a;
		} else
		{
			return geometricSequence(n - 1) * d;
		}
	}

	public static double arithmeticSeries(int n)
	{

		if (n == 1)
		{
			return a;
		} else
		{
			sum += arithmeticSequence(n - 1);
			return arithmeticSeries(n - 1);

		}
	}

	public static double geometricSeries(int n)
	{

		if (n == 1)
		{
			return a;
		} else
		{
			sum += geometricSequence(n - 1);
			return geometricSeries(n - 1);
		}
	}
}
