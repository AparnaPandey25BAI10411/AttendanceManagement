# Attendance Management System

## Overview

The Attendance Management System is a Java command line application that simplifies and organizes the processes of maintaining students’ presence in class. It allows the teacher or attendance administrator to store student data, mark attendance, calculate the percentage, and display students with an insufficient number of visits (below 75%).

The program eliminates the need for time-consuming attendance calculations and stores the data in an organized manner. The data can be saved in a text file locally on a computer and reimported upon starting the application anew. The project is a simple utility with few features intended for a small class of students without a database, server, or internet connection.
## 1. Problem Statement

Manual attendance registers are a tedious task to maintain especially when the strength of students and classes increases. Manually calculating attendance percentages can also prove to be a cumbersome task.

The Attendance Management System solves the above-mentioned problems by giving the user a menu-driven application to enter student details, enter daily attendance, view attendance, view percentage of attendance and view the list of students who have less than 75% attendance.
## 2. Scope

The project is designed for the purpose of small class or organizations maintaining attendance records of students. The basic day to day activities of such organizations are involved in this project.

The system contains the following:

-Student registration with a unique roll number and name,
marking attendance for every class,
calculating attendance percentage,
displaying a particular student's attendance,
displaying the attendance of all the students,
generating a report of those students who are having less than 75% attendance (defaulter report),
storing the information in a file called attendance_data.txt,
and lastly loading the data from the previously saved file when the program starts.

The current system is intended for the purpose of single user and is not database driven. It also doesn't involve any server or internet connection.

## 3. Target Users

The system is mainly intended for:

- **Teachers** – to record and monitor student attendance.
- **Attendance Administrators** – to manage attendance records.
- **Small Educational Organizations** – to maintain basic classroom attendance.
- **Classroom Users** – who need a simple and organized attendance tracking system.

## 4. High-Level Features

### Student Management
- Add students with roll number and name.
- Maintain unique roll numbers.
- Prevent duplicate student records.

### Attendance Management
- Mark attendance for all students.
- Record present and absent status.
- Automatically update total and attended classes.

### Attendance Monitoring
- Automatically calculate attendance percentage.
- View individual attendance details.
- View attendance statistics of all students.
- Display warnings for attendance below 75%.
- Generate a list of attendance defaulters.

### Data Storage
- Save attendance records to `attendance_data.txt`.
- Load saved records when the application starts.
- Preserve attendance data between program executions.

### Simple User Interface
- Menu-driven command-line interface.
- Clear prompts and messages.
- Handles invalid menu input without crashing.
