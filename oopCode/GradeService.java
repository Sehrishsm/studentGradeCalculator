package oopCode;

class GradeService {
    public static String getGrade(double average) {
        if (average >= 90)
            return "A+";
        if (average >= 80)
            return "A";
        if (average >= 70)
            return "B";
        if (average >= 60)
            return "C";
        if (average >= 50)
            return "D";
        return "F";
    }

    public static String getStatus(String grade) {
        return grade.equals("F") ? "FAIL" : "PASS";
    }

    public static String getRemarks(double average) {
        if (average >= 85)
            return "Excellent";
        if (average >= 70)
            return "Good";
        if (average >= 50)
            return "Average";
        return "Needs Improvement";
    }

}
