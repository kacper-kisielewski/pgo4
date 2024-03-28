import java.util.ArrayList;
import java.util.List;

public class StudentGroup {
    public String name;
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) throws IllegalStateException {
        if (this.students.size() + 1 > 15)
            throw new IllegalArgumentException("Number of students in a group cannot exceed 15");
        else if (this.students.contains(student))
            throw new IllegalArgumentException("Student was already added to the group");

        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public List<Student> getStudents() {
        return this.students;
    }

    ;

    public void printStudents() {
        for (Student student : getStudents())
            System.out.printf("%s %s (%s)\n", student.fname, student.lname, student.indexNumber);
    }

    public StudentGroup(String name) {
        this.name = name;
    }

    public StudentGroup(String name, List<Student> students) {
        this(name);
        for (Student student : students)
            this.addStudent(student);
    }
}
