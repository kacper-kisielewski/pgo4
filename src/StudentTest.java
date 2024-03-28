import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

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