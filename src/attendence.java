import java.util.*;
import java.io.*;
public class attendence {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Student> students = new LinkedHashMap<>();
    static final String FILE_NAME = "attendance_data.txt";

    static class Student {
        String rollNo;
        String name;
        int totalClasses;
        int classesAttended;

        Student(String rollNo, String name) {
            this.rollNo = rollNo;
            this.name = name;
            this.totalClasses = 0;
            this.classesAttended = 0;
        }

        double getPercentage() {
            if (totalClasses == 0) return 0;
            return (classesAttended * 100.0) / totalClasses;
        }
    }

    public static void main(String[] args) {
        loadData();
        int choice;
        do {
            printMenu();
            choice = readInt();
            switch (choice) {
                case 1: addStudent(); break;
                case 2: markAttendance(); break;
                case 3: viewAttendance(); break;
                case 4: viewAllStudents(); break;
                case 5: showDefaulters(); break;
                case 6: saveData(); System.out.println("Data saved. Exiting..."); break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);
    }

    static void printMenu() {
        System.out.println("\n===== Attendance Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. Mark Today's Attendance");
        System.out.println("3. View Attendance of a Student");
        System.out.println("4. View All Students");
        System.out.println("5. Show Defaulters (<75% attendance)");
        System.out.println("6. Save & Exit");
        System.out.print("Enter your choice: ");
    }

    static int readInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static void addStudent() {
        System.out.print("Enter Roll No: ");
        String rollNo = sc.nextLine().trim();
        if (students.containsKey(rollNo)) {
            System.out.println("Student already exists!");
            return;
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine().trim();
        students.put(rollNo, new Student(rollNo, name));
        System.out.println("Student added successfully!");
    }

    static void markAttendance() {
        if (students.isEmpty()) {
            System.out.println("No students found. Add students first.");
            return;
        }
        System.out.println("Marking attendance for today's class:");
        for (Student s : students.values()) {
            System.out.print("Is " + s.name + " (" + s.rollNo + ") present? (y/n): ");
            String ans = sc.nextLine().trim().toLowerCase();
            s.totalClasses++;
            if (ans.equals("y")) {
                s.classesAttended++;
            }
        }
        System.out.println("Attendance marked for all students.");
    }

    static void viewAttendance() {
        System.out.print("Enter Roll No: ");
        String rollNo = sc.nextLine().trim();
        Student s = students.get(rollNo);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.printf("Name: %s | Attended: %d/%d | Percentage: %.2f%%\n",
                s.name, s.classesAttended, s.totalClasses, s.getPercentage());
        if (s.getPercentage() < 75) {
            System.out.println("Warning: Attendance below 75%!");
        }
    }

    static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.printf("\n%-10s %-15s %-10s %-8s %-10s\n", "RollNo", "Name", "Attended", "Total", "Percent");
        for (Student s : students.values()) {
            System.out.printf("%-10s %-15s %-10d %-8d %.2f%%\n",
                    s.rollNo, s.name, s.classesAttended, s.totalClasses, s.getPercentage());
        }
    }

    static void showDefaulters() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\nStudents below 75% attendance:");
        boolean found = false;
        for (Student s : students.values()) {
            if (s.totalClasses > 0 && s.getPercentage() < 75) {
                System.out.printf("%s (%s) - %.2f%%\n", s.name, s.rollNo, s.getPercentage());
                found = true;
            }
        }
        if (!found) System.out.println("No defaulters. Everyone is above 75%.");
    }

    static void saveData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students.values()) {
                pw.println(s.rollNo + "," + s.name + "," + s.totalClasses + "," + s.classesAttended);
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    static void loadData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                Student s = new Student(parts[0], parts[1]);
                s.totalClasses = Integer.parseInt(parts[2]);
                s.classesAttended = Integer.parseInt(parts[3]);
                students.put(s.rollNo, s);
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
