# 🏥 Hospital Management System  
### Java Swing • MySQL • JDBC • IntelliJ IDEA

A complete **Hospital Management Desktop Application** built using  
**Java Swing (GUI)** + **JDBC** + **MySQL**, designed to manage hospital workflows such as patient registration, billing, pending amounts, discharge, and full patient history.

---

## 🚀 Features

### 🔹 Patient Management
- Add New Patient  
- Update Patient Details  
- Delete Patient Details  
- Automatic sync with Billing + History

### 🔹 Billing System
- Auto-generate billing when a patient is added  
- Update deposits & pending amounts  
- Final bill calculation on discharge  

### 🔹 Patient History
- Maintains full timeline from admission → updates → discharge  
- Updated automatically from all modules  

### 🔹 Discharge System
- Enter discharge details  
- Auto syncs with Billing and Pending Amount  

### 🔹 Login & Security
- Secure login validation  
- Forgot Password Module (Java Swing UI)

### 🔹 Backend Database
- MySQL database with tables for:
  - Patients  
  - Billing  
  - Pending Amount  
  - Discharge  
  - Patient History  
  - Login  

---

## 📂 **Project Structure**

src/
├── AddNewPatient.java
├── Billing.java
├── Conne.java
├── DeletePatientDetails.java
├── Discharge.java
├── ForgetPassword.java
├── Hospital_Management_System_Query.sql
├── Login.java
├── PatientHistory.java
├── PendingAmount.java
├── UpdatePatientDetails.java
│
└── images/
├── 1.png
├── 2.png
├── 3.png
├── 4.png
├── 5.png
├── 6.png
├── 7.png
├── 8.png
├── addpatient.png
├── bg.png
├── billing.png
├── discharge.png
├── exit.png
├── folder.png
├── forgot.png
├── home.png
├── icon.png
├── logo.png
├── login_bg.png
├── newpatient.png
├── patient_history.png
├── pending.png
├── search.png
├── update.png
├── updated.png
├── welcome_line.png



---

## 🧑‍💻 **How to Run the Project in IntelliJ IDEA**

### **1. Requirements**
- Java JDK 8+  
- IntelliJ IDEA  
- MySQL Server  
- MySQL Workbench  
- MySQL Connector/J (JDBC Driver)

---

### **2. Open Project in IntelliJ**
1. Open **IntelliJ IDEA**  
2. Click **File → Open**  
3. Select the project folder  
4. IntelliJ will load the `/src` directory automatically

---

### **3. Add MySQL JDBC Driver**
1. Download: https://dev.mysql.com/downloads/connector/j/  
2. IntelliJ → **File → Project Structure**  
3. Go to **Modules → Dependencies**  
4. Click **+ → JARs or Directories**  
5. Add `mysql-connector-j-8.x.x.jar`  
6. Apply → OK  

---

### **4. Set Up MySQL Database**
1. Open MySQL Workbench  
2. Create DB:
   ```sql
   CREATE DATABASE hospital_management;
Run:

Hospital_Management_System_Query.sql

5. Configure Database Connection

Open:
src/Conn.java
String url = "jdbc:mysql://localhost:3306/hospital_management";
String username = "root";            
String password = "@Ayaj2005mansuri";   

6. Run the Program
Right click Login.java
Click Run 'Login.main()'
Application GUI will launch

📘 Future Enhancements

Doctor Management Module
Appointment Booking
Export Bill to PDF
Email/SMS Notification System
Admin vs Receptionist Roles
