package recursion;

import java.util.Scanner;

public class CompoundInterest
{
	static int counter = 0;
	static double periodInterest;
	static double totalPeriods;

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("principal?");
		double principal = input.nextDouble();

		System.out.println("yearly rate?");
		double yearlyInterest = input.nextDouble();

		System.out.println("years?");
		double years = input.nextDouble();

		System.out.println("compounding frequency");
		double compoundingFrequency = input.nextDouble();

		periodInterest = yearlyInterest / compoundingFrequency;
		totalPeriods = years * compoundingFrequency;
		System.out.println("you have " + calculateInterest(principal));
	}

	public static double calculateInterest(double startAmmount)
	{

		if (counter == totalPeriods)
		{
			return startAmmount;
		} else
		{
			counter++;
			return calculateInterest(startAmmount * (1 + periodInterest));

		}

	}

}
