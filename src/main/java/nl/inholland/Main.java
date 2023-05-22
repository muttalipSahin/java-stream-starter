package nl.inholland;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(1, "John", LocalDate.of(2003, 6, 15), 8.5),
                new Student(2, "Emma", LocalDate.of(2004, 3, 10), 9.0),
                new Student(3, "Sofie", LocalDate.of(2002, 8, 22), 7.9),
                new Student(4, "Michael", LocalDate.of(2003, 1, 31), 8.2),
                new Student(5, "James", LocalDate.of(2004, 12, 5), 8.7),
                new Student(6, "Oliver", LocalDate.of(2003, 5, 14), 7.5),
                new Student(7, "Mia", LocalDate.of(2003, 9, 18), 8.0),
                new Student(8, "Lucas", LocalDate.of(2002, 7, 7), 9.1),
                new Student(9, "Grace", LocalDate.of(2004, 4, 21), 7.7),
                new Student(10, "Willem", LocalDate.of(2003, 11, 30), 8.9),
                new Student(11, "Elisabeth", LocalDate.of(2002, 12, 20), 8.3),
                new Student(12, "Daan", LocalDate.of(2004, 1, 11), 7.8),
                new Student(13, "Charlotte", LocalDate.of(2003, 2, 19), 9.2),
                new Student(14, "Matthijs", LocalDate.of(2002, 3, 28), 8.4),
                new Student(15, "Mark", LocalDate.of(2004, 8, 6), 9.0)
        );

        List<Student> filteredStudents = assignment1(students);
        System.out.println("Filtered Students: " + filteredStudents);

        List<String> studentNames = assignment2(students);
        System.out.println("Student Names: " + studentNames);

        double totalGrades = assignment3(students);
        System.out.println("Total Grades: " + totalGrades);

        long studentCount = assignment4(students);
        System.out.println("Student Count: " + studentCount);

        Optional<Student> highestGradeStudent = assignment5(students);
        highestGradeStudent.ifPresentOrElse(
                student -> System.out.println("Highest Grade Student: " + student.getName()),
                () -> System.out.println("No student found"));

        Map<Integer, List<Student>> studentsByAge = assignment6(students);
        System.out.println("Students Grouped by Age: " + studentsByAge);

        double totalGradesParallel = assignment7(students);
        System.out.println("Total Grades (Parallel): " + totalGradesParallel);
    }

    // Assignment 1: Filtering Students
    // Goal: Filter students who have a grade of 8.5 and above and return them.
    public static List<Student> assignment1(List<Student> students) {
        Stream<Student> stream = students.stream();
        return stream.filter(student -> student.getGrade() >= 8.5).collect(Collectors.toList());
    }

    // Assignment 2: Transforming Students
    // Goal: Transform the list of students into a list of their names.
    public static List<String> assignment2(List<Student> students) {
        Stream<Student> stream = students.stream();
        return stream.map(Student::getName).collect(Collectors.toList());
    }

    // Assignment 3: Summing with Stream
    // Goal: Calculate the total of all students' grades and return the resulting total.
    public static double assignment3(List<Student> students) {
        Stream<Student> stream = students.stream();
        return stream.mapToDouble(Student::getGrade).sum();
    }

    // Assignment 4: Counting Students
    // Goal: Count how many students are 20 years old and return the resulting number.
    public static long assignment4(List<Student> students) {
        Stream<Student> stram = students.stream();
        return stram.filter(student -> student.getAge() == 20).count();
    }

    // Assignment 5: Using Optional
    // Goal: Find the student with the highest grade. Return an Optional to handle the case where the students list is empty.
    public static Optional<Student> assignment5(List<Student> students){
      Stream<Student> studentStream = students.stream();
        return studentStream.max((s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade()));
    }

    // Assignment 6: Grouping Students
    // Goal: Group students by age. Return a Map<Integer, List<Student>> where the key is the age and the value is a list of students of that age.
    public static Map<Integer, List<Student>> assignment6(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(Student::getAge));
    }

    // Assignment 7: Parallel Streams
    // Goal: Convert your solution from assignment 3 to use a parallel stream and note any difference in performance.
    // Challenge: Show elapsed time in milliseconds in both assignment 3 and assignment 7.
    public static double assignment7(List<Student> students) {
        return students.parallelStream().mapToDouble(Student::getGrade).sum();
    }
}