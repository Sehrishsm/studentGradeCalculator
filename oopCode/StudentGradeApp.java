package oopCode;

import java.util.Scanner;

public class StudentGradeApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🎓 Welcome to the OOP Student Grade Calculator!");
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\n--- New Student Entry ---");

            // 1. Create Domain Object
            String name = promptName();
            Student student = new Student(name);

            // 2. Collect Data
            int subjectCount = promptSubjectCount();
            inputMarks(student, subjectCount);

            // 3. Process Business Logic
            double avg = student.getAveragePercentage();
            String grade = GradeService.getGrade(avg);
            String status = GradeService.getStatus(grade);
            String remarks = GradeService.getRemarks(avg);

            // 4. Render Output
            ResultFormatter.print(student, grade, status, remarks);

            // 5. Loop Control
            keepRunning = promptContinue();
        }

        System.out.println("Thank you for using the application. Goodbye! 👋");
        scanner.close();
    }

    // ================= UI HELPERS =================
    private static String promptName() {
        String name;
        do {
            System.out.print("Enter student name: ");
            name = scanner.nextLine().trim();
        } while (name.isEmpty());
        return name;
    }

    private static int promptSubjectCount() {
        int count = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter number of subjects: ");
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                if (count > 0)
                    valid = true;
                else
                    System.out.println("⚠️ Error: Must be greater than 0.");
            } else {
                System.out.println("⚠️ Error: Invalid number. Try again.");
                scanner.next(); // clear invalid token
            }
        }
        scanner.nextLine(); // consume newline
        return count;
    }

    private static void inputMarks(Student student, int count) {
        for (int i = 1; i <= count; i++) {
            boolean valid = false;
            while (!valid) {
                System.out.printf("Enter marks for Subject %d (0-100): ", i);
                if (scanner.hasNextDouble()) {
                    double mark = scanner.nextDouble();
                    if (student.addMark(mark)) {
                        valid = true;
                    } else {
                        System.out.println("⚠️ Error: Marks must be between 0 and 100.");
                    }
                } else {
                    System.out.println("⚠️ Error: Invalid decimal number.");
                    scanner.next(); // clear invalid token
                }
            }
        }
        scanner.nextLine(); // consume newline
    }

    private static boolean promptContinue() {
        System.out.print("\nCalculate for another student? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }
}