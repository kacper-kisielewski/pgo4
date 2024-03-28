import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentGroupTest {
    private static List<Double> grades = new ArrayList<>();
    public static Student student = new Student("John", "Doe", "s00000", "john.doe@example.com", "NA", grades);

    @Test
    void constructorStudent() {
        List<Student> studentList = Arrays.asList(student);
        StudentGroup group = new StudentGroup("Test Group", studentList);

        assertEquals(studentList, group.getStudents());
    }

    @Test
    void addStudent() {
        StudentGroup group = new StudentGroup("Test Group");
        group.addStudent(student);

        assertTrue(group.getStudents().contains(student));
    }

    @Test
    void exceedsLimitAddStudent() {
        StudentGroup group = new StudentGroup("Test Group");
        IllegalArgumentException expectedError = new IllegalArgumentException("Number of students in a group cannot exceed 15");

        assertThrowsExactly(expectedError.getClass(), () -> {
            for (int i = 0; i < 16; i++) {
                group.addStudent(new Student("John" + i, "Doe", "s00000", "nothing@example.com", "NA"));
            }
        });
    }

    @Test
    void studentAlreadyAddedAddStudent() {
        StudentGroup group = new StudentGroup("Test Group");
        IllegalArgumentException expectedError = new IllegalArgumentException("Student was already added to the group");

        assertThrowsExactly(expectedError.getClass(), () -> {
            group.addStudent(student);
            group.addStudent(student);
        });
    }

    @Test
    void removeStudent() {
        StudentGroup group = new StudentGroup("Test Group");
        group.addStudent(student);
        group.removeStudent(student);

        assertFalse(group.getStudents().contains(student));
    }
}