import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> marks = new ArrayList<>();

        System.out.println("===== STUDENT GRADE TRACKER =====");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;
        double highest = -1;
        double lowest = 101;

        String highestStudent = "";
        String lowestStudent = "";

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            double mark = sc.nextDouble();
            sc.nextLine();

            names.add(name);
            marks.add(mark);

            total += mark;

            if (mark > highest) {
                highest = mark;
                highestStudent = name;
            }

            if (mark < lowest) {
                lowest = mark;
                lowestStudent = name;
            }
        }

        double average = total / n;

        System.out.println("\n========== STUDENT REPORT ==========");

        System.out.printf("%-15s %-10s %-10s\n", "Name", "Marks", "Grade");
        System.out.println("-------------------------------------");

        for (int i = 0; i < n; i++) {

            double mark = marks.get(i);
            String grade;

            if (mark >= 90) {
                grade = "A";
            } else if (mark >= 80) {
                grade = "B";
            } else if (mark >= 70) {
                grade = "C";
            } else if (mark >= 60) {
                grade = "D";
            } else {
                grade = "Fail";
            }

            System.out.printf("%-15s %-10.2f %-10s\n",
                    names.get(i), mark, grade);
        }

        System.out.println("\n====================================");
        System.out.printf("Average Marks : %.2f\n", average);
        System.out.printf("Highest Marks : %.2f (%s)\n",
                highest, highestStudent);
        System.out.printf("Lowest Marks  : %.2f (%s)\n",
                lowest, lowestStudent);

        System.out.println("====================================");

        sc.close();
    }
}