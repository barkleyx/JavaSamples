package sample;
import java.util.*;

public class PasswordCheck {

	/*
	A simple password checker
	*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String password = new String();
		
		System.out.println("Input a password that follows the guidelines below:");
		System.out.println("1. A password must have at least eight characters");
		System.out.println("2. A password consists of only letters and numbers (no special characters)");
		System.out.println("3. A password must contain at least two numbers");
		System.out.println("4. Passwords are case-sensitive");
		System.out.print("Password: ");
		password = input.nextLine();
		
		lengthCheck(password);
		alphanumeric(password);
		retype(password);
		
		input.close();
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

	//check if length of password is at least 8
	public static void lengthCheck(String password){
		if (password.length() < 8){
			System.out.println("Your password does not have at least 8 characters");
			System.exit(0);
		}
	}

	//check if password has at least 1 letter and 2 numbers
	public static void alphanumeric(String password){
		int lCount = 0;
		int dCount = 0;
		for (int i = 0; i < password.length(); i++){
			if (Character.isLetter(password.charAt(i))){
				lCount++;
			}else if (Character.isDigit(password.charAt(i))){
				dCount++;
			}else{
				System.out.println("Your password does not consist of only letters or numbers");
				System.exit(0);
			}
		}
		
		if (lCount == 0){
			System.out.println("Your password needs at least 1 letter");
			System.exit(0);
		}else if (dCount < 2){
			System.out.println("Your password needs at least 2 numbers");
			System.exit(0);
		}
	}
	
	//check if retyped password is the same as password
	public static void retype(String password){
		Scanner reInput = new Scanner(System.in);
		String reType = new String();
		
		System.out.print("Retype password: ");
		reType = reInput.nextLine();
		
		reInput.close();
		if (reType.equals(password)){
			System.out.println("Your password meets all the requirements");
		}else{
			System.out.println("Your password does not match your previous password");
			System.exit(0);
		}	
	}
	
}
