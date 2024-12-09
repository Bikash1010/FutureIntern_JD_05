package org.com.random_password_generator;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerate {
	public static void main(String[] args) {
		// Scanner for user input
		Scanner scanner = new Scanner(System.in);

		// Get password length from user
		System.out.print("Enter the desired password length: ");
		int length = scanner.nextInt();
		scanner.nextLine(); // consume newline left-over

		// Ask the user for password complexity preferences
		System.out.print("Include uppercase letters? (yes/no): ");
		boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("yes");

		System.out.print("Include lowercase letters? (yes/no): ");
		boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("yes");

		System.out.print("Include numbers? (yes/no): ");
		boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("yes");

		System.out.print("Include special characters? (yes/no): ");
		boolean includeSpecialChars = scanner.nextLine().equalsIgnoreCase("yes");

		// Generate the password
		String password = generatePassword(length, includeUppercase, includeLowercase, includeNumbers,
				includeSpecialChars);

		// Display the generated password
		System.out.println("Generated password: " + password);

		scanner.close();
	}

	private static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
			boolean includeNumbers, boolean includeSpecialChars) {
		// Define character sets
		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialChars = "!@#$%^&*()-_+=<>?";

		// Create a pool of characters based on user preferences
		StringBuilder charPool = new StringBuilder();
		if (includeUppercase)
			charPool.append(uppercase);
		if (includeLowercase)
			charPool.append(lowercase);
		if (includeNumbers)
			charPool.append(numbers);
		if (includeSpecialChars)
			charPool.append(specialChars);

		// If no character types are selected, throw an error
		if (charPool.length() == 0) {
			throw new IllegalArgumentException("You must select at least one type of character.");
		}

		// Generate the password using the pool of characters
		Random random = new Random();
		StringBuilder password = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(charPool.length());
			password.append(charPool.charAt(index));
		}

		return password.toString();
	}
}
