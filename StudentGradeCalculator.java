import java.util.Scanner;

public class StudentGradeCalculator {
    /**
     * Student Grade Calculator
     * A beginner-friendly console application that calculates grades, percentages,
     * and provides academic feedback based on user input.
     */

    public static void main(String[] args) {
        // scanner read input from user
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("Welcome to the Student Grade Calculator!");

        // loop to allow multiple calculations
        while (keepRunning) {
            System.out.println("\n --- new student entry ---");

            // Gather basic information
            String studentName = getStudentName(scanner);
            int subjectCount = getSubjectCount(scanner);

            // 2. Input and validate marks
            double[] marks = inputMarks(scanner, subjectCount);

            // perform calculation

            double totalMarks = calculateMarks(marks);
            double averagePercentage = calculateAverage(totalMarks, subjectCount);
            String grade = calculateGrade(averagePercentage);
            String status = (grade.equals('F') ? "Fail" : "Pass");
            String remarks = getRemarks(averagePercentage);

            // 4. Find highest & lowest marks (Bonus)
            double highestMarks = getHighestMarks(marks);
            double lowestMarks = getLowestMarks(marks);
            // 5. Display formatted result
            displayResult(studentName, subjectCount, totalMarks, averagePercentage,
                    grade, status, remarks, highestMarks, lowestMarks);

            // 6. Ask to continue or exit
            keepRunning = askToContinue(scanner);

        }

        System.out.println("Thank you for using the application. Goodbye! 👋");
        scanner.close(); // Always close resources to prevent memory leaks
    }

    // ================= METHOD DEFINITIONS =================

    /**
     * Prompts user for student name and trims extra spaces.
     */
    /**
     * Displays the final result in a clean, formatted console table.
     */
    private static void displayResult(String studentName, int subjectCount, double totalMarks, double averagePercentage,
            String grade, String status, String remarks, double highestMarks, double lowestMarks) {
        System.out.println("\n================================");
        System.out.println("       STUDENT RESULT");
        System.out.println("================================");
        System.out.printf("Student Name : %-10s%n", studentName);
        System.out.printf("Subjects     : %-10d%n", subjectCount);
        System.out.printf("Highest Mark : %-10.2f%n", highestMarks);
        System.out.printf("Lowest Mark  : %-10.2f%n", lowestMarks);
        System.out.printf("Total Marks  : %-10.2f%n", totalMarks);
        System.out.printf("Percentage   : %-10.1f%%%n", averagePercentage);
        System.out.printf("Grade        : %-10s%n", grade);
        System.out.printf("Status       : %-10s%n", status);
        System.out.printf("Remarks      : %-10s%n", remarks);
        System.out.println("================================");

    }

    private static boolean askToContinue(Scanner scanner) {
        System.out.print("\nCalculate for another student? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }

    /**
     * Finds the lowest mark in the array.
     */
    private static double getLowestMarks(double[] marks) {
        double lowest = marks[0];
        for (double m : marks)
            if (m < lowest)
                lowest = m;
        return lowest;
    }

    /**
     * Finds the highest mark in the array.
     */
    private static double getHighestMarks(double[] marks) {
        double highest = marks[0];
        for (double m : marks)
            if (m > highest)
                highest = m;
        return highest;
    }

    /**
     * Provides academic remarks based on performance.
     */
    private static String getRemarks(double averagePercentage) {
        if (averagePercentage >= 85)
            return "Excellent";
        if (averagePercentage >= 70)
            return "Good";
        if (averagePercentage >= 50)
            return "Average";
        return "Needs Improvement";
    }

    // Assigns a letter grade based on average percentage.

    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90)
            return "A+";
        if (averagePercentage >= 80)
            return "A";
        if (averagePercentage >= 70)
            return "B";
        if (averagePercentage >= 60)
            return "C";
        if (averagePercentage >= 50)
            return "D";
        return "F";
    }

    /**
     * Calculates average percentage.
     */
    private static double calculateAverage(double totalMarks, int subjectCount) {
        return totalMarks / subjectCount;

    }

    /**
     * Sums all elements in the marks array.
     */
    private static double calculateMarks(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    /**
     * Loops through each subject, prompts for marks, and validates range [0, 100].
     */
    private static double[] inputMarks(Scanner scanner, int subjectCount) {
        double[] marks = new double[subjectCount];
        for (int i = 0; i < subjectCount; i++) {
            boolean validMarks = false;
            while (!validMarks) {
                System.out.printf("Enter marks for Subject %d (0-100): ", i + 1);
                if (scanner.hasNextDouble()) {
                    double mark = scanner.nextDouble();
                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        validMarks = true;
                    } else {
                        System.out.println("Error: Marks must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Error: Please enter a valid number for marks.");
                    scanner.next(); // Clear invalid input

                }
            }
        }
        // Consume leftover newline before next string input
        scanner.nextLine();
        return marks;

    }

    /**
     * Prompts user for number of subjects. Validates input > 0.
     */

    private static int getSubjectCount(Scanner scanner) {
        int count = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter number of subjects: ");
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                if (count > 0) {
                    validInput = true;

                } else {
                    System.out.println("Error: Subject count must be greater than 0.");
                }
            } else {
                System.out.println("Error: Please enter a valid integer for subject count.");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.nextLine(); // Consumes the leftover newline character
        return count;
    }

    private static String getStudentName(Scanner scanner) {
        System.out.println("Enter Student name: ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty. Please enter a valid name: ");
            name = scanner.nextLine().trim();

        }
        return name;
    }

}
