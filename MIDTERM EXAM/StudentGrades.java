import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentGrades {

    static class Student {
        String name;
        List<Double> scores = new ArrayList<>();

        Student(String name) {
            this.name = name;
        }

        double calculateAverage() {
            double sum = 0;
            for (double score : scores) {
                sum += score;
            }
            return sum / scores.size();
        }

        char getLetterGrade() {
            double average = calculateAverage();
            if (average >= 90) return 'A';
            else if (average >= 80) return 'B';
            else if (average >= 70) return 'C';
            else if (average >= 60) return 'D';
            else return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        int numStudents = getPositiveIntegerInput(scanner, "Enter the number of students in the class: ");
        int numAssignments = 3; // You can change this to however many assignments you want

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student's name: ");
            String name = scanner.next();
            Student student = new Student(name);

            for (int j = 0; j < numAssignments; j++) {
                double score = getValidScore(scanner, j + 1);
                student.scores.add(score);
            }

            students.add(student);
        }

        // Output each student's information
        System.out.println("\nStudent Grades:");
        for (Student student : students) {
            double average = student.calculateAverage();
            char grade = student.getLetterGrade();
            System.out.printf("%s: Average Score = %.2f, Letter Grade = %c%n", student.name, average, grade);
        }

        // Bonus Features
        if (!students.isEmpty()) {
            double classAverage = calculateClassAverage(students);
            double highestScore = getHighestScore(students);
            double lowestScore = getLowestScore(students);

            System.out.printf("%nClass Average Score: %.2f%n", classAverage);
            System.out.printf("Highest Average Score: %.2f%n", highestScore);
            System.out.printf("Lowest Average Score: %.2f%n", lowestScore);
        }

        scanner.close();
    }

    private static int getPositiveIntegerInput(Scanner scanner, String prompt) {
        int value;
        while (true) {
            try {
                System.out.print(prompt);
                value = scanner.nextInt();
                if (value <= 0) {
                    throw new IllegalArgumentException("Must be a positive integer.");
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double getValidScore(Scanner scanner, int assignmentNumber) {
        double score;
        while (true) {
            try {
                System.out.printf("Enter score for assignment %d: ", assignmentNumber);
                score = scanner.nextDouble();
                if (score < 0 || score > 100) {
                    throw new IllegalArgumentException("Score must be between 0 and 100.");
                }
                return score;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric score.");
                scanner.next(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double calculateClassAverage(List<Student> students) {
        double sum = 0;
        for (Student student : students) {
            sum += student.calculateAverage();
        }
        return sum / students.size();
    }

    private static double getHighestScore(List<Student> students) {
        double highest = Double.NEGATIVE_INFINITY;
        for (Student student : students) {
            double average = student.calculateAverage();
            if (average > highest) {
                highest = average;
            }
        }
        return highest;
    }

    private static double getLowestScore(List<Student> students) {
        double lowest = Double.POSITIVE_INFINITY;
        for (Student student : students) {
            double average = student.calculateAverage();
            if (average < lowest) {
                lowest = average;
            }
        }
        return lowest;
    }
}
