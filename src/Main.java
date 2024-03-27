import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StudentGroup {
    public String name;
    private List<Student> students = new ArrayList<Student>();

    public void addStudent(Student student) throws IllegalStateException {
        if (this.students.size() > 15)
            throw new IllegalArgumentException("Number of students in a group cannot exceed 15");
        else if (this.students.contains(student))
            throw new IllegalArgumentException("Student was already added to the group");

        this.students.add(student);
    }
}

class Student {
    public String fname;
    public String lname;
    public String indexNumber;
    public String email;
    public String address;
    public List<Double> grades = new ArrayList<Double>();

    public Student(String fname, String lname, String indexNumber, String email, String address) {
        this.fname = fname;
        this.lname = lname;
        this.indexNumber = indexNumber;
        this.email = email;
        this.address = address;
    }

    public Student(String fname, String lname, String indexNumber, String email, String address, List<Double> grades) {
        this(fname, lname, indexNumber, email, address);
        this.grades = grades;
    }

    private static double getListSum(List<Double> list) {
        int sum = 0;
        for (double number : list)
            sum += number;
        return sum;
    }

    public double calculateGradesAverage() throws IllegalArgumentException {
        if (this.grades.isEmpty())
            throw new IllegalArgumentException("Grades cannot be empty");
        else if (this.grades.size() > 20)
            throw new IllegalArgumentException("Number of grades cannot exceed 20");

        return getListSum(this.grades) / this.grades.size();
    }

    public void addToGroup(StudentGroup targetGroup) throws IllegalStateException {
//        throw new IllegalStateException("The number of students in a group exceeds 15");
        targetGroup.addStudent(this);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> kacperekGrades = Arrays.asList(5, 4, 4, 3, 6);
        Student kacperek = new Student("Kacper", "Kisielewski", "s30670", "s30670@pjwstk.edu.pl", "NA", kacperekGrades);
        System.out.println(kacperek.calculateGradesAverage());
    }
}