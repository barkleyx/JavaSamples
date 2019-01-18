package sample;
import java.util.Scanner;

public class TowersOfHanoi {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int disks = input.nextInt();
		System.out.println("The moves are: ");
		moveDisks(disks, 'A', 'B', 'C');
		input.close();
	}

	private static int count = 0;
	
	public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
		// base case
		if(n == 1) {
			count++;
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			System.out.println("The disk moved " + count + " times");
		}
		else {
			count++;
			moveDisks(n - 1, fromTower, auxTower, toTower);
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			moveDisks(n - 1, auxTower, toTower, fromTower);
		}
	}
	
}
