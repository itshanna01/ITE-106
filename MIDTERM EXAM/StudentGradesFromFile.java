import java.io.*;
import java.util.*;

public class StudentGradesFromFile {

    public static void main(String[] args) {
        String inputFileName = "student_data.txt";
        String outputFileName = "student_grades.txt";

        List<Student> students = new ArrayList<>();

        // Read student data from file
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                parseStudentData(line, students);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFileName);
            return;
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            return;
        }

        // Calculate averages and grades
        for (Student student : students) {
            student.calculateAverage();
        }

        // Write output to file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            bw.write(String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-15s %-10s%n",
                    "Name", "Quiz 1", "Quiz 2", "Homework", "Midterm", "Final", "Average Score", "Grade"));
            bw.write("--------------------------------------------------------------------------\n");
            for (Student student : students) {
                bw.write(student.toString());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void parseStudentData(String line, List<Student> students) {
        String[] parts = line.split(",");

        // Trim and validate the input
        if (parts.length < 6) {
            System.out.println("Insufficient data: " + line);
            return;
        }

        String name = parts[0].trim();
        double[] scores = new double[5]; // Assuming 5 scores (Quiz1, Quiz2, Homework, Midterm, Final)

        try {
            for (int i = 0; i < 5; i++) {
                scores[i] = Double.parseDouble(parts[i + 1].trim());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid score format: " + line);
            return;
        }

        // Format name as "LastName, FirstName"
        String formattedName = formatName(name);

        students.add(new Student(formattedName, scores));
    }

    private static String formatName(String name) {
        String[] nameParts = name.split(" ");
        if (nameParts.length < 2) return name; // Return as is if format is incorrect
        return nameParts[1] + ", " + nameParts[0]; // LastName, FirstName
    }
}

class Student {
    String name;
    double[] scores;
    double averageScore;
    char grade;

    public Student(String name, double[] scores) {
        this.name = name;
        this.scores = scores;
    }

    public void calculateAverage() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        averageScore = sum / scores.length;
        grade = getLetterGrade(averageScore);
    }

    private char getLetterGrade(double average) {
        if (average >= 90) return 'A';
        else if (average >= 80) return 'B';
        else if (average >= 70) return 'C';
        else if (average >= 60) return 'D';
        else return 'F';
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20.2f %-20.2f %-20.2f %-20.2f %-20.2f %-15.2f %-10c%n",
                name, scores[0], scores[1], scores[2], scores[3], scores[4], averageScore, grade);
    }
}
