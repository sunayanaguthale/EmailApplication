package email.app;

import java.util.Random;
import java.util.Scanner;

class Email {
    private String emailAddress;
    private String password;
    private int mailboxCapacity;
    private String alternateEmail;

    // Constructor to initialize the email address
    public Email(String firstName, String lastName) {
        this.emailAddress = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@company.com";
        this.password = generateRandomPassword(8);
        this.mailboxCapacity = 500;
    }

    // Method to generate a random password
    private String generateRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randomIndex);
        }
        return new String(password);
    }

    // Setters and getters for mailbox capacity and alternate email
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Method to change the password
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    // Method to display information about the email
    public void showInfo() {
        System.out.println("Email Address: " + emailAddress);
        System.out.println("Password: " + password);
        System.out.println("Mailbox Capacity: " + mailboxCapacity + "MB");
        System.out.println("Alternate Email: " + (alternateEmail != null ? alternateEmail : "Not set"));
    }
}

public class EmailApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user information
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        // Create an email object
        Email email = new Email(firstName, lastName);

        // Display initial information
        System.out.println("\nInitial Information:");
        email.showInfo();

        // Set alternate email
        System.out.print("\nEnter an alternate email address (or leave blank to skip): ");
        String alternateEmail = scanner.nextLine();
        if (!alternateEmail.isEmpty()) {
            email.setAlternateEmail(alternateEmail);
            System.out.println("Alternate Email set successfully.");
        }

        // Set mailbox capacity
        System.out.print("Set the mailbox capacity (in MB): ");
        int newCapacity = scanner.nextInt();
        email.setMailboxCapacity(newCapacity);
        System.out.println("Mailbox capacity set successfully.");

        // Change password
        System.out.print("Change password (or leave blank to skip): ");
        scanner.nextLine(); // consume the newline character
        String newPassword = scanner.nextLine();
        if (!newPassword.isEmpty()) {
            email.changePassword(newPassword);
            System.out.println("Password changed successfully.");
        }

        // Display final information
        System.out.println("\nFinal Information:");
        email.showInfo();

        scanner.close();
    }
}