package sample;
import java.util.Scanner;

public class RussianRoulette {

	/*
	Simulation of the game Russian Roulette
	*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int bullets = 6;
		int count = 0;
		
		System.out.println("Press Enter to pull the trigger:");
		input.nextLine();
		int chance = random(bullets);
		while(chance != 0){
			count++;
			System.out.println("\"Click!\" You're alive. " + count + "/" + bullets + " barrels shot.");
			System.out.println("Press Enter to pull the trigger:");
			input.nextLine();
			chance = random(bullets - count);
		}
		input.close();
		System.out.println("\"BANG!\" You died.");
	}

	//calculate shot chance
	public static int random(int b){
		int rdm = 0;
		rdm = (int)(Math.random() * b);
		return rdm;
	}
}
