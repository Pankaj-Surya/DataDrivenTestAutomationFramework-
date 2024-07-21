package utility;

import java.util.Random;
import java.util.UUID;

public class GenerateUniqueData {

	private static final Random RANDOM = new Random();
	private static final String[] GENDERS = { "Male", "Female" };
	private static final String[] OCCUPATIONS = { "Doctor", "Scientist", "Engineer" };

	// Method to generate a unique username
	public static String generateUniqueUsername() {
		return "user_" + UUID.randomUUID().toString().replace("-", "").substring(0, 2);
	}

	// Method to generate a unique and complex password
	public static String generateUniquePassword() {
		String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacters = "!@#$%^&*()-_=+<>?";
		String numbers = "0123456789";

		Random random = new Random();

		StringBuilder password = new StringBuilder();

		// Ensure at least one character from each category
		password.append(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
		password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
		password.append(numbers.charAt(random.nextInt(numbers.length())));
		password.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));

		// Fill the rest of the password to ensure it is at least 8 characters long
		for (int i = 4; i < 8; i++) {
			String allCharacters = upperCaseLetters + lowerCaseLetters + specialCharacters + numbers;
			password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
		}

		return password.toString();
	}

	// Method to generate a unique email address ending with @gmail.com
	public static String generateUniqueEmail() {
		return generateUniqueUsername() + "@gmail.com";
	}

	// Method to generate a unique 10-digit phone number
	public static String generateUniquePhoneNumber() {
		Random random = new Random();
		int num1 = random.nextInt(900) + 100;
		int num2 = random.nextInt(900) + 100;
		int num3 = random.nextInt(9000) + 1000;
		return num1 + "" + num2 + "" + num3;
	}

	public static int generateRandomNumber(int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			throw new IllegalArgumentException("Start index must be less than end index");
		}

		Random random = new Random();
		// Generate a random number between startIndex (inclusive) and endIndex
		// (exclusive)
		return random.nextInt(endIndex - startIndex) + startIndex;
	}

	public static String generateRandomGender() {
		return GENDERS[RANDOM.nextInt(GENDERS.length)];
	}

	public static String generateRandomOccupation() {
		return OCCUPATIONS[RANDOM.nextInt(OCCUPATIONS.length)];
	}

	public static String[] generateData() {
		//registerPage.enterRegisterInfo(us, "Doe", email, num, "Engineer", "Male", pass, pass);
		   String firstName = generateUniqueUsername();
		    String lastName = generateUniqueUsername();
		    String password = generateUniquePassword();
		    String phoneNumber = generateUniquePhoneNumber();
		    String occupation = generateRandomOccupation();
		    String email = generateUniqueEmail();
		    String gender = generateRandomGender();

		    // Ensure the returned array has exactly 6 elements
		    return new String[] { firstName, lastName, email, phoneNumber, occupation, gender, password };
	}
}
