package password_validator;

import java.util.Scanner;

public class PasswordValidator {
	
	private static String currentUsername = "John Doe";
	private static String currentPassword = "ABC_12345"; 
	
	public static void main(String[] args) {
		printPasswordRules();
		Scanner scanner = new Scanner(System.in);		
        boolean valid;
        
        do {
        	System.out.println("Enter your new password: ");
        	String proposedPassword = scanner.nextLine();
        	valid = changePassword(proposedPassword);
        }
        while (!valid);
        
        System.out.println("The password is valid.");
        
        scanner.close();
	}
	
	public static void printPasswordRules() {
		System.out.println("Your new password must meet the following requirements:");
		System.out.println("* at least 8 characters long");
		System.out.println("* contain an uppercase letter");
		System.out.println("* contain a special character");
		System.out.println("* not contain the username");
		System.out.println("* not be the same as the old password");
		System.out.println();
	}
	
	public static boolean changePassword(String newPassword) {
		
		boolean valid = true;
		String errorMessage = "";
		
		if (newPassword.length() < 8) {
			valid = false;
			errorMessage += "\nYour password must be at least 8 characters.";
		}
		
		// Alternatively, can loop through string and use Character.isUpperCase on each char
		if (newPassword.equals(newPassword.toLowerCase())) {
			valid =  false;
			errorMessage += "\nYour password must include an uppercase letter.";
		}
		
		if (newPassword.matches("[a-zA-Z0-9]*")) {
			valid = false;
			errorMessage += "\nYour password must include a special character (e.g., %, $, [:]).";
		}
		
		if (newPassword.toUpperCase().contains(currentUsername.toUpperCase())) {
			valid = false;
			errorMessage += "\nYour password cannot contain your username."; 
		}
		
		if (newPassword.equals(currentPassword)) {
			valid = false;
			errorMessage += "\nYour password must be different from your current password.";
		}
		
		if(!valid) {
			System.out.println(errorMessage);
		}
		
		return valid;
	}
}
