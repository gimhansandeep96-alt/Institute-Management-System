# Institute Management System (IJSE SYSTEM)

A comprehensive, enterprise-grade desktop application designed to streamline administrative and academic operations for educational institutes. This system simplifies student registration, course scheduling, and overall institutional coordination.

---

## 🏗️ Technical Architecture

This application is built using a strict **Layered Architecture (N-Tier Architecture)** pattern. This architectural pattern ensures separation of concerns, high maintainability, and clean scalability by dividing the system into distinct responsibility layers:

* **Presentation Layer (UI):** Built using JavaFX / Java Swing to handle user interaction and present dashboards cleanly.
* **Controller Layer:** Acts as an intermediary between the UI and Business Logic, capturing user inputs and delegating actions.
* **Service Layer (BO - Business Objects):** Contains core business logic, validations, and rules specific to the institute's operations.
* **Data Access Object (DAO / Repository) Layer:** Handles direct communication, data persistence, and retrieval from the relational database without exposing business rules.
* **Entity / Model Layer:** Represents the database tables and domain models passed across various layers.

---

## 🔐 Login Credentials

The system provides role-based access control. Use the credentials below to log in:

### 1. Admin Account
* **Username:** `admin`
* **Password:** `admin123`

### 2. Lecturer Account
* **Username:** `lecturer`
* **Password:** `lec123`

---





## 🛠️ Main Features

The system offers a centralized management dashboard featuring the following core modules:

* **Course Management:** Efficiently create, update, and manage various courses and curriculum details.
* **Student Management:** Handle student registrations, profiles, and academic records seamlessly.
* **Lecturer Management:** Manage faculty profiles, designations, and assignments.
* **Class Schedule:** Organize, update, and view upcoming lectures and classroom timetables.
* **Student Attendance:** Track and monitor daily student attendance for different batches.

---



## 🚀 Getting Started

### Prerequisites
* **Java Development Kit (JDK):** Version 8 or higher
* **IDE:** NetBeans IDE
* **Database:** MySQL Database Engine



### How to Run
1. Clone or download this project repository.
2. Open the project in **NetBeans IDE**.
3. Configure your database schema and properties within the database utility configuration file.
4. Clean and Build the project.
5. Click **Run** to launch the login screen.
