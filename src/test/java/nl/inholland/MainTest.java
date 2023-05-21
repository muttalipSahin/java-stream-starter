package nl.inholland;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    private List<Student> students;

    @BeforeEach
    void setUp() {
        students = Arrays.asList(
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
    }

    @Test
    void assignment1ShouldReturnStudentsWithHighGrades() {
        List<Student> highGrades = Main.assignment1(students);
        assertEquals(7, highGrades.size());
        assertEquals("John", highGrades.get(0).getName());
        assertEquals("Emma", highGrades.get(1).getName());
        assertEquals("James", highGrades.get(2).getName());
        assertEquals("Lucas", highGrades.get(3).getName());
        assertEquals("Willem", highGrades.get(4).getName());
        assertEquals("Charlotte", highGrades.get(5).getName());
        assertEquals("Mark", highGrades.get(6).getName());
    }

    @Test
    void assignment2ShouldReturnListOfStudentNames() {
        List<String> studentNames = Main.assignment2(students);
        List<String> expectedNames = Arrays.asList("John", "Emma", "Sofie", "Michael", "James",
                "Oliver", "Mia", "Lucas", "Grace", "Willem", "Elisabeth", "Daan", "Charlotte", "Matthijs", "Mark");
        assertEquals(expectedNames, studentNames);
    }

    @Test
    void assignment3ShouldReturnTotalOfGrades() {
        double totalGrades = Main.assignment3(students);
        double expectedTotal = 126.2;
        assertEquals(expectedTotal, totalGrades, 0.001);
    }

    @Test
    void assignment4ShouldReturnCountOfStudentsWhoAre20YearsOld() {
        long numberOf20YearOlds = Main.assignment4(students);
        long expectedNumber = 0;
        for (Student student : students) {
            if (student.getBirthdate().getYear() == (2023 - 20)) {
                expectedNumber++;
            }
        }
        assertEquals(expectedNumber, numberOf20YearOlds);
    }

    @Test
    void assignment5ShouldReturnStudentWithHighestGrade() {
        Optional<Student> studentWithHighestGrade = Main.assignment5(students);

        Student expectedStudent = null;
        double highestGrade = Double.MIN_VALUE;
        for (Student student : students) {
            if (student.getGrade() > highestGrade) {
                highestGrade = student.getGrade();
                expectedStudent = student;
            }
        }

        assertTrue(studentWithHighestGrade.isPresent());
        assertEquals(expectedStudent, studentWithHighestGrade.get());
    }

    @Test
    void assignment6ShouldGroupStudentsByAge() {
        Map<Integer, List<Student>> groupedStudents = Main.assignment6(students);

        Map<Integer, List<Student>> expectedGrouping = new HashMap<>();
        for (Student student : students) {
            if (!expectedGrouping.containsKey(student.getAge())) {
                expectedGrouping.put(student.getAge(), new ArrayList<>());
            }
            expectedGrouping.get(student.getAge()).add(student);
        }

        assertEquals(expectedGrouping.size(), groupedStudents.size());
        assertEquals(expectedGrouping, groupedStudents);
    }

    @Test
    void assignment7ShouldReturnTotalOfGradesUsingParallelStream() throws Exception {
        double totalGrades = Main.assignment7(students);
        double expectedTotal = 126.2;
        assertEquals(expectedTotal, totalGrades, 0.001);
    }
}