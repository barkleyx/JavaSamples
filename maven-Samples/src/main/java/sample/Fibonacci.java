package sample;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		/*
		Calculate sum of fibonacci index input
		*/
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an index for the Fibonacci number: ");
		int index = input.nextInt();
		System.out.println("Fibonacci number at index " + index + " is " + fib(index));
		input.close();
	}

	public static long fib(long idx) {
		// base case
		if(idx == 0) {
			return 0;
		}
		// base case
		else if(idx == 1) {
			return 1;
		}
		else {
			// recursive calls
			return fib(idx - 1) + fib(idx - 2);
		}
	}
}
