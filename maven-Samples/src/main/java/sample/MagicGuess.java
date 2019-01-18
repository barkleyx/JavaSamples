package sample;
import java.util.*;

public class MagicGuess {

	/*
	Think of a number between 1 to 21 and input the row number 3 times for the
	program to guess your number. Based on a magic card trick.
	 */
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		int[] row1 = new int[7];
		int[] row2 = new int[7];
		int[] row3 = new int[7];
		int count = 0;
		int answer = 0;
		
		System.out.println("Think of a number between 1 to 21");
		System.out.println();
		
		//function to shuffle the deck
		shuffle(cards);
		
		//function to split the deck into 3 rows
		for (int j = 0; j < 3; j++){
			count = 0;
			for (int i = 0; i < cards.length; i++){
				if (i % 3 == 0){
					row1[count] = cards[i];
				}
				else if(i % 3 == 1){
					row2[count] = cards[i];
				}
				else if(i % 3 == 2){
					row3[count] = cards[i];
					count++;
				}	
			}
			//print each row of cards
			System.out.println("Row 1: " + Arrays.toString(row1));
			System.out.println("Row 2: " + Arrays.toString(row2));
			System.out.println("Row 3: " + Arrays.toString(row3));
			
			System.out.println();
			System.out.println("Which row is your number in: ");
			int rowNum = input.nextInt();
			
			//combine the rows
			cards = combine(row1, row2, row3, rowNum);
		}
		
		//print out the answer
		for (int i = cards.length-1; i > 9; i--){
			answer = cards[i];
		}
		System.out.println("The number you were thinking of is " + answer + ".");
		
		input.close();
		
	}
	
///////////////////////////////////////////////////////////////////////////	
	
	//shuffle the deck
	public static int[] shuffle(int array[]){
		//new object for Random class
		Random rdm = new Random();
		
		//go through every element, except the first element, and swap values
		for (int i = array.length-1; i > 0; i--){
			//picks a random index from 0 to i
			int j = rdm.nextInt(i);
			
			//swap array[i] with the element at random index
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		return array;
	}
	
	//combine with the rowNum in the middle
	public static int[] combine(int[] row1, int[] row2, int[] row3, int rowNum){
		int[] cards = new int[21];
		if (rowNum == 1){
			System.arraycopy(row2, 0, cards, 0, row2.length);
			System.arraycopy(row1, 0, cards, 7, row1.length);
			System.arraycopy(row3, 0, cards, 14, row3.length);
		}
		else if (rowNum == 2){
			System.arraycopy(row1, 0, cards, 0, row1.length);
			System.arraycopy(row2, 0, cards, 7, row2.length);
			System.arraycopy(row3, 0, cards, 14, row3.length);	
		}
		else if (rowNum == 3){
			System.arraycopy(row1, 0, cards, 0, row1.length);
			System.arraycopy(row3, 0, cards, 7, row3.length);
			System.arraycopy(row2, 0, cards, 14, row2.length);
		}
		return cards;
	}
}
