package sample;

public class TwoLargestSum {

	public static void main(String[] args) {
		
		int[] sumArray = {4, 9, 8, 6, 5, 7, 1};
		int big = 0;
		int bigger = 0;
		int sum = 0;
		
		for (int i = 0; i < sumArray.length; i++) {
			if (sumArray[i] > bigger) {
				big = bigger;
				bigger = sumArray[i];
			}
			else if (sumArray[i] > big && sumArray[i] <= bigger) {
				big = sumArray[i];
			}
		}
		
		sum = bigger + big;
		
		System.out.println("The sum of " + bigger + " + " + big + " = " + sum);
		
	}

}
