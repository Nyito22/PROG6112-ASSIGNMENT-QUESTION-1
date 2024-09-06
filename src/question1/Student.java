/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class Student {
    // Define constants and arrays to store student data
    private static final int MAX_SIZE = 100;
    private String[] STUDENTID = new String[MAX_SIZE];
    private String[] Studentname = new String[MAX_SIZE];
    private int[] Studentage = new int[MAX_SIZE];
    private String[] studentemail = new String[MAX_SIZE];
    private String[] studentcourse = new String[MAX_SIZE];
    private int studentCount = 0; // Counter for the number of students
    private Scanner scanner = new Scanner(System.in); // Scanner for console input

    // Method to display the initial view option
    public void viewOption() {
        System.out.print("Enter 1 to view menu or any key to exit this application: ");
        String choose = scanner.nextLine(); // Read user input

        // Check user choice
        if (choose.equals("1")) {
            DisplayMenu(); // Display menu if user inputs 1
        } else {
            System.out.println("Goodbye"); // Exit if user inputs anything other than 1
            System.exit(0);
        }
    }

    // Method to display the menu and handle user choices
    public void DisplayMenu() {
        while (true) { // Infinite loop to keep displaying the menu
            System.out.println("Please select one of the following menu items:");
            System.out.println("1: Capture a new student");
            System.out.println("2: Search for a student");
            System.out.println("3: Delete a student");
            System.out.println("4: Print student report");
            System.out.println("5: Exit Application");
            System.out.print("Your choice: ");
            String options = scanner.nextLine(); // Read user choice

            // Handle menu choice using a switch statement
            switch (options) {
                case "1":
                    CaptureStudent(); // Capture student details
                    break;
                case "2":
                    SEARCHSTUDENT(); // Search for a student
                    break;
                case "3":
                    DeleteStudent(); // Delete a student
                    break;
                case "4":
                    DisplayReport(); // Display student report
                    break;
                case "5":
                    System.out.println("Goodbye"); // Exit application
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again."); // Handle invalid input
            }
        }
    }

    // Method to capture student details and add them to the arrays
    public void CaptureStudent() {
        // Check if the maximum number of students has been reached
        if (studentCount >= MAX_SIZE) {
            System.out.println("Cannot add more students. Maximum limit reached.");
            return;
        }

        // Prompt user for student details
        System.out.print("Enter student id: ");
        String id = scanner.nextLine();
        System.out.print("Enter student surname and initials: ");
        String name = scanner.nextLine();
        int age = VERIFYAGE(); // Get validated age
        System.out.print("Enter the student's email: ");
        String email = scanner.nextLine();
        System.out.print("Enter the student's course: ");
        String course = scanner.nextLine();

        // Store student details in arrays
        STUDENTID[studentCount] = id;
        Studentname[studentCount] = name;
        Studentage[studentCount] = age;
        studentemail[studentCount] = email;
        studentcourse[studentCount] = course;

        studentCount++; // Increment student count
        System.out.println("Student added successfully.");
        viewOption(); // Return to main menu
    }

    // Method to search for a student by ID and display their details
    public void SEARCHSTUDENT() {
        System.out.print("Enter student id to search for a student: ");
        String find = scanner.nextLine();

        boolean found = false; // Flag to check if student is found
        for (int p = 0; p < studentCount; p++) {
            if (find.equalsIgnoreCase(STUDENTID[p])) {
                // Display student details if found
                System.out.println("Student id: " + STUDENTID[p]
                        + "\nStudent name: " + Studentname[p]
                        + "\nStudent age: " + Studentage[p]
                        + "\nStudent email: " + studentemail[p]
                        + "\nStudent course: " + studentcourse[p]);
                found = true;
                break;
            }
        }

        // Inform user if student was not found
        if (!found) {
            System.out.println("This student is not found.");
        }
        viewOption(); // Return to main menu
    }

    // Method to display a report of all students
    public void DisplayReport() {
        // Check if there are any students to display
        if (studentCount == 0) {
            System.out.println("No students to display.");
            return;
        }

        // Build report string
        StringBuilder report = new StringBuilder();
        for (int p = 0; p < studentCount; p++) {
            report.append("\nStudent id: ").append(STUDENTID[p])
                    .append("\nStudent name: ").append(Studentname[p])
                    .append("\nStudent age: ").append(Studentage[p])
                    .append("\nStudent email: ").append(studentemail[p])
                    .append("\nStudent course: ").append(studentcourse[p])
                    .append("\n<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>> \n");
        }
        System.out.println(report.toString()); // Print the report
        viewOption(); // Return to main menu
    }

    // Method to delete a student by ID
    public void DeleteStudent() {
        System.out.print("Enter student id to delete a student: ");
        String delet = scanner.nextLine();

        boolean found = false; // Flag to check if student is found
        for (int p = 0; p < studentCount; p++) {
            if (delet.equalsIgnoreCase(STUDENTID[p])) {
                // Confirm deletion
                System.out.print("Do you want to delete the student with ID: " + delet + "? (yes/no): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("yes")) {
                    // Shift elements to remove the student
                    for (int j = p; j < studentCount - 1; j++) {
                        STUDENTID[j] = STUDENTID[j + 1];
                        Studentname[j] = Studentname[j + 1];
                        Studentage[j] = Studentage[j + 1];
                        studentemail[j] = studentemail[j + 1];
                        studentcourse[j] = studentcourse[j + 1];
                    }
                    // Clear the last entry
                    STUDENTID[studentCount - 1] = null;
                    Studentname[studentCount - 1] = null;
                    Studentage[studentCount - 1] = 0;
                    studentemail[studentCount - 1] = null;
                    studentcourse[studentCount - 1] = null;

                    studentCount--; // Decrement student count
                    System.out.println("Student deleted successfully.");
                    found = true;
                }
                break;
            }
        }

        // Inform user if student was not found
        if (!found) {
            System.out.println("This student is not found.");
        }
        viewOption(); // Return to main menu
    }

    // Method to verify and return a valid age (16 or older)
    public int VERIFYAGE() {
        int age;
        while (true) {
            System.out.print("Enter student age (must be 16 or older): ");
            String input = scanner.nextLine(); // Read input as a string
            
            // Check if the input is a valid integer using regex
            if (input.matches("\\d+")) {
                 age = Integer.parseInt(input); // Parse the input to an integer
                if (age >= 16) {
                    return age; // Return valid age
                } else {
                    System.out.println("Age is invalid. Please enter a valid age (16 or older)."); // Prompt again
                }
            } else {
                System.out.println("Invalid input. Please enter a number."); // Prompt again if input is not a number
            }
        }
    
    }
}