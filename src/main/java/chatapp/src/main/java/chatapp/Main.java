package chatapp;

import java.util.Scanner;

/**
 * Main.java
 *
 * Console entry point for PROG5121 Part 1 - Registration and Login.
 * Walks the user through registering an account and then logging in,
 * using the Login class to validate and store their details.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== Welcome to the Chat App Registration ===");

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        String username;
        do {
            System.out.print("Enter a username (must contain an underscore and be no more than 5 characters): ");
            username = scanner.nextLine();
            if (!login.checkUserName(username)) {
                System.out.println("Username is not correctly formatted; please ensure that your "
                        + "username contains an underscore and is no more than five characters in length.");
            }
        } while (!login.checkUserName(username));

        String password;
        do {
            System.out.print("Enter a password (min 8 characters, 1 capital letter, 1 number, 1 special character): ");
            password = scanner.nextLine();
            if (!login.checkPasswordComplexity(password)) {
                System.out.println("Password is not correctly formatted; please ensure that the "
                        + "password contains at least eight characters, a capital letter, a number, "
                        + "and a special character.");
            }
        } while (!login.checkPasswordComplexity(password));

        String cellphoneNumber;
        do {
            System.out.print("Enter your cell phone number (with international code, e.g. +27838968976): ");
            cellphoneNumber = scanner.nextLine();
            if (!login.checkCellPhoneNumber(cellphoneNumber)) {
                System.out.println("Cell number is incorrectly formatted or does not contain "
                        + "international code; please correct the number and try again.");
            }
        } while (!login.checkCellPhoneNumber(cellphoneNumber));

        String registrationMessage = login.registerUser(firstName, lastName, username, password, cellphoneNumber);
        System.out.println(registrationMessage);

        System.out.println("\n=== Please log in ===");
        System.out.print("Enter your username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String loginPassword = scanner.nextLine();

        boolean loginStatus = login.loginUser(loginUsername, loginPassword);
        System.out.println(login.returnLoginStatus(loginStatus));

        scanner.close();
    }
}
