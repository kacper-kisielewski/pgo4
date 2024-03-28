import java.util.ArrayList;
import java.util.List;

public class Student {
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

        double gradesSum = getListSum(grades);
        double gradesAverage = gradesSum / this.grades.size();
        return gradesAverage;
    }

    public void addToGroup(StudentGroup targetGroup) throws IllegalStateException {
        targetGroup.addStudent(this);
    }

    public void addGrade(double grade) {
        this.grades.add(grade);
    }

    public List<Double> getGrades() { return this.grades; }

    public void setGrades(List<Double> grades) {
        this.grades = new ArrayList<>();
        for (double grade : grades)
            this.grades.add(grade);
    }
}
