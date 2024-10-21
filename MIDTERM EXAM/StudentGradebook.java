import java.util.Scanner;

public class StudentGradebook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Input number of assignments
        System.out.print("Enter the number of assignments: ");
        int numAssignments = scanner.nextInt();

        // Array for student names and 2D array for grades
        String[] names = new String[numStudents];
        double[][] grades = new double[numStudents][numAssignments];
        double[] averageScores = new double[numStudents];

        // Input student names and grades
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            names[i] = scanner.next();

            for (int j = 0; j < numAssignments; j++) {
                grades[i][j] = getValidScore(scanner, j + 1);
            }
        }

        // Calculate average scores and assign letter grades
        for (int i = 0; i < numStudents; i++) {
            averageScores[i] = calculateAverage(grades[i]);
        }

        // Output formatted table
        System.out.printf("\n%-15s", "Name");
        for (int j = 0; j < numAssignments; j++) {
            System.out.printf("Assignment %d ", j + 1);
        }
        System.out.printf("Average Score  Grade\n");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-15s", names[i]);
            for (int j = 0; j < numAssignments; j++) {
                System.out.printf("%.2f        ", grades[i][j]);
            }
            System.out.printf("%.2f           %c\n", averageScores[i], getLetterGrade(averageScores[i]));
        }

        // Find highest and lowest average scores
        double highestAverage = findHighest(averageScores);
        double lowestAverage = findLowest(averageScores);

        System.out.printf("\nHighest Average Score: %.2f\n", highestAverage);
        System.out.printf("Lowest Average Score: %.2f\n", lowestAverage);

        // Sort students by average score
        sortStudents(names, grades, averageScores);

        System.out.println("\nSorted Students by Average Score:");
        System.out.printf("%-15s", "Name");
        for (int j = 0; j < numAssignments; j++) {
            System.out.printf("Assignment %d ", j + 1);
        }
        System.out.printf("Average Score  Grade\n");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-15s", names[i]);
            for (int j = 0; j < numAssignments; j++) {
                System.out.printf("%.2f        ", grades[i][j]);
            }
            System.out.printf("%.2f %c\n", averageScores[i], getLetterGrade(averageScores[i]));
        }

        scanner.close();
    }

    private static double getValidScore(Scanner scanner, int assignmentNumber) {
        double score;
        while (true) {
            System.out.printf("Enter score for assignment %d: ", assignmentNumber);
            try {
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

    private static double calculateAverage(double[] scores) {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    private static char getLetterGrade(double average) {
        if (average >= 90) return 'A';
        else if (average >= 80) return 'B';
        else if (average >= 70) return 'C';
        else if (average >= 60) return 'D';
        else return 'F';
    }

    private static double findHighest(double[] averages) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double avg : averages) {
            if (avg > highest) {
                highest = avg;
            }
        }
        return highest;
    }

    private static double findLowest(double[] averages) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double avg : averages) {
            if (avg < lowest) {
                lowest = avg;
            }
        }
        return lowest;
    }

    private static void sortStudents(String[] names, double[][] grades, double[] averages) {
        for (int i = 0; i < averages.length - 1; i++) {
            for (int j = 0; j < averages.length - 1 - i; j++) {
                if (averages[j] < averages[j + 1]) { // Sort in descending order
                    // Swap averages
                    double tempAvg = averages[j];
                    averages[j] = averages[j + 1];
                    averages[j + 1] = tempAvg;

                    // Swap names
                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;

                    // Swap grades
                    double[] tempGrades = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = tempGrades;
                }
            }
        }
    }
}
