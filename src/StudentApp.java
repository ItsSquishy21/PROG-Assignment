import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {



    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Press 1 to launch the menu or any other key to exit: ");
            String userInput = scanner.nextLine();

            if ("1".equals(userInput)) {
                displayMenu(scanner);
            } else {
                System.out.println("Exiting the application. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    private static void displayMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n Student Management Menu ");
            System.out.println("1. Capture a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Print student report");
            System.out.println("5. Exit application");

            System.out.print("Enter your choice (1-5): ");
            String choiceInput = scanner.nextLine();
            int choice = parseInteger(choiceInput);

            switch (choice) {
                case 1:
                    captureStudent(scanner);
                    break;
                case 2:
                    searchStudent(scanner);
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    printStudentReport();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    return; // Exit the menu loop and application
                default:
                    System.out.println("Invalid choice. Please select between 1 and 5.");
                    break;
            }
        }
    }

    private static void captureStudent(Scanner scanner) {

        System.out.print("Enter student's ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        int age = -1;
        while (age < 16) {
            System.out.print("Enter student's age (16 or above): ");
            String ageInput = scanner.nextLine();
            age = parseInteger(ageInput);
            if (age < 16) {
                System.out.println("Age must be at least 16.");
            }
        }
        System.out.print("Enter student's email address: ");
        String email = scanner.nextLine();

        System.out.print("Enter student's course: ");
        String course = scanner.nextLine();

        students.add(new Student(id, name, age, email, course));
        System.out.println("Student captured successfully!");
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter student's name to search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student.name.equalsIgnoreCase(name)) {
                System.out.println("Student found: " + student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student's name to delete: ");
        String name = scanner.nextLine();
        boolean removed = students.removeIf(student -> student.name.equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void printStudentReport() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("Student Report:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Return an invalid number if input is not a valid integer
        }
    }
}
