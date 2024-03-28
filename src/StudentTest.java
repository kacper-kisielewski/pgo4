import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void AddGrade() {
        double exampleGrade = 4.5;
        Student student = new Student("John", "Doe", "s00000", "john.doe@example.com", "NA");
        student.addGrade(exampleGrade);

        assertTrue(student.getGrades().contains(exampleGrade));
    }

    @Test
    void setGrades() {
        List<Double> grades = Arrays.asList(4.5, 5.0, 3.0);
        Student student = new Student("John", "Doe", "s00000", "john.doe@example.com", "NA");
        student.setGrades(grades);

        assertEquals(grades, student.getGrades());
    }

    @Test
    void limitCalculateGradesAverage() {
        List<Double> grades = Arrays.asList(5.0, 4.0);
        Student student = new Student("John", "Doe", "s00000", "john.doe@example.com", "NA", grades);

        assertEquals(4.5, student.calculateGradesAverage());
        Arrays.asList(5.0, 4.0, 4.5, 3.5, 6.0);
    }

    @Test
    void errorEmptyCalculateGradesAverage() {
        List<Double> grades = new ArrayList<>();
        Student student = new Student("John", "Doe", "s00000", "john.doe@example.com", "NA", grades);
        IllegalArgumentException expectedError = new IllegalArgumentException("Grades cannot be empty");

        assertThrowsExactly(expectedError.getClass(), () -> student.calculateGradesAverage());
    }

    @Test
    void errorExceedsLimitCalculateGradesAverage() {
        IllegalArgumentException expectedError = new IllegalArgumentException("Number of grades cannot exceed 20");
        List<Double> grades = new ArrayList<>();
        for (int i = 1; i <= 21; i++)
            grades.add(0.0);
        Student student = new Student("John", "Doe", "s00000", "john.doe@example.com", "NA", grades);

        assertThrowsExactly(expectedError.getClass(), () -> student.calculateGradesAverage());
    }
}