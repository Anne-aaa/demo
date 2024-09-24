import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class Student {
    private int id;
    private String name;
    private int grade;
    private double mathScore;
    private double languageScore;
    private double scienceScore;

    public Student(int id, String name, int grade, double mathScore, double languageScore, double scienceScore) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.mathScore = mathScore;
        this.languageScore = languageScore;
        this.scienceScore = scienceScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getLanguageScore() {
        return languageScore;
    }

    public void setLanguageScore(double languageScore) {
        this.languageScore = languageScore;
    }

    public double getScienceScore() {
        return scienceScore;
    }

    public void setScienceScore(double scienceScore) {
        this.scienceScore = scienceScore;
    }

    double getTotalScore(){
        return this.mathScore+this.scienceScore+this.languageScore;
    }
}


public class StudentProcessor {
    // 1.  Filter out students who have a score greater than 90 from any subject and collect them into a new list
    public List<Student> filterStudentsWithHighScore(List<Student> students) {
        //TODO

    }



    //2. Find the Top student with the highest total score by grade
    public Map<Integer, Optional<Student>> getTopStudentByGrade(List<Student> students) {
        // Implement using Stream API

    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1, "Alice", 10, 95, 85, 90),
                new Student(2, "Bob", 10, 88, 92, 80),
                new Student(3, "Charlie", 11, 78, 85, 88),
                new Student(4, "David", 11, 92, 90, 95),
                new Student(5, "Eve", 12, 85, 87, 89),
                new Student(6, "Frank", 10, 90, 91, 85),
                new Student(7, "Grace", 10, 87, 89, 92),
                new Student(8, "Hannah", 11, 80, 82, 84),
                new Student(9, "Ivy", 11, 85, 88, 90),
                new Student(10, "Jack", 12, 92, 94, 91),
                new Student(11, "Kathy", 12, 88, 86, 87),
                new Student(12, "Leo", 10, 93, 90, 88),
                new Student(13, "Mia", 10, 89, 85, 91),
                new Student(14, "Nina", 11, 84, 87, 85),
                new Student(15, "Oscar", 11, 90, 92, 89),
                new Student(16, "Paul", 12, 91, 89, 90),
                new Student(17, "Quinn", 12, 87, 85, 88)
        );

        StudentProcessor processor = new StudentProcessor();

        // Test each method
        System.out.println("Students with any subject score > 90: " + processor.filterStudentsWithHighMathScore(students));

        System.out.println("Top student by grade: " + processor.getTopStudentByGrade(students));
    }
}