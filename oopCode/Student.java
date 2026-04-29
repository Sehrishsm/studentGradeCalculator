package oopCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
    private final String name;
    private final List<Double> marks;

    public Student(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        this.name = name.trim();
        this.marks = new ArrayList<>();
    }

    /** Returns true if mark is valid & added, false otherwise */
    public boolean addMark(double mark) {
        if (mark < 0 || mark > 100)
            return false;
        marks.add(mark);
        return true;
    }

    public double getTotalMarks() {
        return marks.stream().mapToDouble(Double::doubleValue).sum();
    }

    public double getAveragePercentage() {
        return marks.isEmpty() ? 0.0 : getTotalMarks() / marks.size();
    }

    public double getHighestMark() {
        return Collections.max(marks);
    }

    public double getLowestMark() {
        return Collections.min(marks);
    }

    public int getSubjectCount() {
        return marks.size();
    }

    public String getName() {
        return name;
    }
}