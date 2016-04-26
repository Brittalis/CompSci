package recursion;

import java.util.Scanner;

public class triangles
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out
				.println("enter the ammount of rows you would like your triangle to have");
		int number = input.nextInt();
		int result = triangle(number);
		System.out.println(result);


	}
	
	
	public static int triangle(int param1){
		if(param1==1){
			return 1;
		}else{
			return triangle(param1-1)+param1;
		}
	}

}
