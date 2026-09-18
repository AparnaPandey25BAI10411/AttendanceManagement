# Attendance Management System

A simple console-based Java application for tracking and managing student attendance.

## 📌 Overview

**Attendance Management System** is a command-line Java application designed to make classroom attendance tracking simple and reliable.

The application allows a teacher or administrator to:

* Register students
* Mark attendance class by class
* View individual attendance records
* View attendance of all students
* Identify students below the required **75% attendance threshold**
* Save attendance data locally for future sessions

Student records are stored in memory while the program is running and are automatically saved to a local text file when the user exits. The saved data is loaded automatically when the application starts again.

The project does not require a database, internet connection, or external libraries.

---

## ✨ Features

### 1. Add Students

* Register students using a unique roll number and name.
* Duplicate roll numbers are automatically rejected.
* Displays a success message when a student is added.

### 2. Mark Daily Attendance

* Mark attendance for all registered students in one pass.
* Enter `y` for Present and `n` for Absent.
* Total classes increase for every student.
* Attended classes increase only for students marked present.

### 3. View Individual Attendance

* Search for a student using their roll number.
* Displays:

  * Student name
  * Classes attended
  * Total classes
  * Attendance percentage

### 4. View All Students

* Displays all registered students in a formatted summary.
* Shows attendance statistics for every student.

### 5. Defaulter Report

* Automatically identifies students with attendance below **75%**.
* Students with exactly **75% attendance are not considered defaulters**.

### 6. Persistent Storage

* Attendance records are saved to `attendance_data.txt`.
* Data is automatically loaded when the application starts.
* No database setup is required.

### 7. Robust Input Handling

* Invalid menu inputs are handled gracefully.
* The application does not crash when a non-numeric menu value is entered.

---

## 🛠️ Technologies / Tools Used

| Technology / Tool              | Purpose                             |
| ------------------------------ | ----------------------------------- |
| **Java (JDK 8+)**              | Core programming language           |
| **Java Collections Framework** | Managing student records            |
| **LinkedHashMap**              | Ordered and fast student lookups    |
| **java.io**                    | Reading and writing attendance data |
| **BufferedReader**             | Reading saved data                  |
| **PrintWriter**                | Writing attendance data             |
| **FileWriter**                 | File-based persistence              |
| **Scanner**                    | Console input handling              |
| **Plain Text File**            | Lightweight data storage            |

### No External Libraries Required

The project uses only standard Java libraries and does not require MySQL, a database server, or an internet connection.

---

## 📂 Project Structure

```text
AttendanceManagementSystem/
│
├── AttendanceManagementSystem.java
├── attendance_data.txt
└── README.md
```

> `attendance_data.txt` is created automatically after saving the application data.

---

## 💻 Prerequisites

Before running the project, make sure you have:

* **Java Development Kit (JDK) 8 or higher**
* Java added to the system `PATH`
* A terminal or command prompt

To verify Java installation:

```bash
java -version
```

To verify the Java compiler:

```bash
javac -version
```

---

## 🚀 Installation & Running

### Step 1: Get the Source Code

Download or copy:

```text
AttendanceManagementSystem.java
```

into a folder on your computer.

### Step 2: Open Terminal

Open a terminal or command prompt in the project folder.

```bash
cd path/to/project-folder
```

### Step 3: Compile the Program

```bash
javac AttendanceManagementSystem.java
```

### Step 4: Run the Program

```bash
java AttendanceManagementSystem
```

The main menu will appear in the console.

---

## 📋 Main Menu

```text
===== Attendance Management System =====

1. Add Student
2. Mark Today's Attendance
3. View Attendance of a Student
4. View All Students
5. Show Defaulters (<75% attendance)
6. Save & Exit

Enter your choice:
```

---

## 🧪 Testing Instructions

The application can be manually tested using the following scenarios.

### Test 1: Add a Student

1. Select option `1`.
2. Enter a roll number.
3. Enter the student's name.
4. Confirm that:

```text
Student added successfully!
```

is displayed.

Try entering the same roll number again.

Expected result:

```text
Student already exists!
```

The duplicate student should not be created.

---

### Test 2: Mark Attendance

1. Select option `2`.
2. Enter `y` or `n` for each student.
3. Verify that the total class count increases for every student.
4. Verify that the attended count increases only for students marked `y`.

---

### Test 3: View Individual Attendance

1. Select option `3`.
2. Enter a valid roll number.
3. Verify that the student's:

   * Name
   * Classes attended
   * Total classes
   * Attendance percentage

are displayed correctly.

Try entering an unknown roll number.

Expected result:

```text
Student not found!
```

---

### Test 4: View All Students

1. Select option `4`.
2. Verify that every registered student is displayed.
3. Check that the attendance statistics are correct.

---

### Test 5: Defaulter Report

1. Select option `5`.
2. Verify that only students with attendance **below 75%** are displayed.

A student with exactly **75% attendance must not appear** in the defaulter list.

---

### Test 6: Empty System

Before adding any students, try:

* Option `2` — Mark Attendance
* Option `4` — View All Students
* Option `5` — Show Defaulters

The program should display an appropriate message indicating that no students are available and should not crash.

---

### Test 7: Invalid Input

At the main menu, enter a non-numeric value such as:

```text
abc
```

Expected result:

```text
Invalid choice! Try again.
```

The application should continue running instead of crashing or exiting.

---

### Test 8: Data Persistence

1. Add one or more students.
2. Mark attendance.
3. Select option `6` to save and exit.
4. Confirm that `attendance_data.txt` has been created.
5. Start the application again.
6. Select option `4`.

Previously saved student and attendance records should be loaded automatically.

---



## 🖥️ Sample Output

```text
===== Attendance Management System =====

1. Add Student
2. Mark Today's Attendance
3. View Attendance of a Student
4. View All Students
5. Show Defaulters (<75% attendance)
6. Save & Exit

Enter your choice: 1

Enter Roll No: 101
Enter Name: Asha

Student added successfully!
```

---

## 💾 Data Storage

The application uses a simple text file:

```text
attendance_data.txt
```

The file is stored in the same directory as the Java program.

When the user selects **Save & Exit**, student records and attendance information are written to this file.

When the application starts again, the file is read automatically and the previous data is restored.

This provides basic persistence without requiring a database.

---

## 🎯 Attendance Calculation

Attendance percentage is calculated using:

```text
Attendance Percentage =
(Classes Attended / Total Classes) × 100
```

### Example

If a student attended 8 out of 10 classes:

```text
(8 / 10) × 100 = 80%
```

Since 80% is greater than or equal to 75%, the student is **not** a defaulter.

If a student attended 7 out of 10 classes:

```text
(7 / 10) × 100 = 70%
```

The student is below the 75% threshold and will appear in the defaulter report.

---

## 🔐 Data & Limitations

This is a lightweight console-based application intended for learning and small-scale attendance management.

* Data is stored locally.
* No database is used.
* No login or authentication system is included.
* The application is designed for a single local user.
* The text-file storage approach is not intended for large-scale or multi-user systems.

---

## 🔮 Future Enhancements

Possible future improvements include:

* GUI-based interface
* MySQL or other database integration
* Teacher/admin login
* Multiple classes or subjects
* Date-wise attendance history
* Attendance reports and charts
* Export reports to PDF/Excel
* Search and filter functionality
* Edit or delete student records
* Monthly and semester-wise reports
* Automatic attendance percentage alerts

---

## 👩‍💻 Project Type

**Type:** Console-Based Java Application
**Domain:** Student Attendance Management
**Language:** Java
**Minimum JDK:** 8
**Database:** Not Required
**External Libraries:** None
**Storage:** Local Text File

---
