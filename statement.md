# Attendance Management System

## Overview

The **Attendance Management System** is a Java-based command-line application designed to simplify and organize classroom attendance management. It helps teachers or attendance administrators maintain student records, mark attendance, calculate attendance percentages, and identify students whose attendance is below the required **75%** threshold.

The system reduces the need for manual attendance calculations and keeps records organized. It stores attendance data locally in a text file, allowing saved records to be loaded again when the application is restarted. The project is designed as a simple and lightweight solution for small classrooms without requiring a database, internet connection, or server.

## 1. Problem Statement

Manual attendance registers are time-consuming to maintain, especially when the number of students and classes increases. Calculating attendance percentages manually can also lead to repeated work and mistakes.

The **Attendance Management System** solves this problem by providing a menu-driven application that allows the user to add students, mark daily attendance, view attendance records, automatically calculate attendance percentages, and identify students whose attendance is below 75%.

## 2. Scope

The project is designed for **small classrooms and educational organizations**. It covers the basic activities required for maintaining attendance records.

The system includes:

- Adding students using a unique roll number and name.
- Marking attendance for each class.
- Calculating attendance percentages automatically.
- Viewing individual student attendance.
- Viewing attendance records of all students.
- Generating a defaulter report for students below 75%.
- Saving records in `attendance_data.txt`.
- Loading previously saved records when the program starts.

The current system is intended for a single user on one computer and does not require a database, internet connection, server, or web interface.

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
