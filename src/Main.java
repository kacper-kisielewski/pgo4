import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentGroup mainGroup = new StudentGroup("main group");

        List<Double> kacperekGrades = Arrays.asList(5.0, 4.0, 4.5, 3.5, 6.0);
        Student kacperek = new Student("Kacper", "Kisielewski", "s30670", "s30670@pjwstk.edu.pl", "NA", kacperekGrades);
        System.out.println(kacperek.calculateGradesAverage());

        mainGroup.addStudent(kacperek);
        mainGroup.printStudents();

        try {
            kacperek.addToGroup(mainGroup);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}