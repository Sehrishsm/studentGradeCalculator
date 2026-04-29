package oopCode;

class ResultFormatter {
    public static void print(Student student, String grade, String status, String remarks) {
        System.out.println("\n================================");
        System.out.println("       STUDENT RESULT");
        System.out.println("================================");
        System.out.printf("Student Name : %-12s%n", student.getName());
        System.out.printf("Subjects     : %-12d%n", student.getSubjectCount());
        System.out.printf("Highest Mark : %-12.2f%n", student.getHighestMark());
        System.out.printf("Lowest Mark  : %-12.2f%n", student.getLowestMark());
        System.out.printf("Total Marks  : %-12.2f%n", student.getTotalMarks());
        System.out.printf("Percentage   : %-12.1f%%%n", student.getAveragePercentage());
        System.out.printf("Grade        : %-12s%n", grade);
        System.out.printf("Status       : %-12s%n", status);
        System.out.printf("Remarks      : %-12s%n", remarks);
        System.out.println("================================");
    }
}