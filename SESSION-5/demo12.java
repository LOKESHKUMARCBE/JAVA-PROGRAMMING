import java.io.*;
import java.util.*;

public class demo12
{
    public static void main(String[] args) 
	{
        try (PrintWriter writer = new PrintWriter(new FileWriter("results1.txt", true))) 
		{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter student registration number: ");
            int registerNumber = scanner.nextInt();
            System.out.print("Enter number of subjects: ");
            int numOfSubjects = scanner.nextInt();
            int[] marks = new int[numOfSubjects];
            for (int i = 0; i < numOfSubjects; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
            }
            char grade = calculateGrade(marks);
            writer.println("Student Name: " + studentName);
            writer.println("Student Registration Number: " + registerNumber);
            writer.println("Grade: " + grade);
            writer.println(); 

            System.out.println("Grade calculated and stored in results1.txt successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static char calculateGrade(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        double average = totalMarks / (double) marks.length;

        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
