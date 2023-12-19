package com.coderscampus;

import java.util.Scanner;

public class UserLogin {

	public static void main(String[] args) {
		
		UserService userService = new UserService("data.txt");

		
		for (int attempt = 1; attempt <= 5; attempt++) {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter username: ");
			String enteredUsername = scanner.nextLine();
			System.out.println("Enter password: ");
			String enteredPassword = scanner.nextLine();
			
			User AuthenticatedUser = userService.validateCredentials(enteredUsername, enteredPassword);
			
			if (AuthenticatedUser != null) {
				System.out.println("Welcome " + AuthenticatedUser.getName());
				scanner.close();
				return;
			} else {
				System.out.println("Invalid login, please try again. Attempts left: " + (5 - attempt));
			}
		}
		
		System.out.println("Too many failed login attempts, you are now locked out.");
	}

}
