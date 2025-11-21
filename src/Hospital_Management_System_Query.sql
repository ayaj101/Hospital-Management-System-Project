create database hospital_management_system;
use hospital_management_system;
create table login(ID varchar(20), PW varchar(20));
select * from login;
insert into login value("LLHC_Hospital","@Ayaj2005mansuri");
insert into login value("LLHC_Hospital","@Ayaj123");

create table patient_info(ID varchar(20), Number varchar(40), Name varchar(20),	Gender varchar(20),	Patient_Disease varchar(20),	Room_No	varchar(20), Time varchar(100),	Deposite varchar(20), Pending_Amount varchar(20));	
select * from patient_info;

select * from Room;
insert	into Room values("15 Bed1", "Availabil","2500",	"ICU Bed 1");
insert into Room values("15 Bed2", "Availabil", "2500", "ICU Bed 2");
insert into Room values("15 Bed3", "Availabil", "2500", "ICU Bed 3");
insert into Room values("15 Bed4", "Availabil", "2500", "ICU Bed 4");
insert into Room values("15 Bed5", "Availabil", "2500", "ICU Bed 5");
insert into Room values("15 Bed6", "Availabil", "2500", "ICU Bed 6");
insert into Room values("16 DR", "Availabil", "3500", "Deluxe Room");
insert into Room values("17 DR", "Availabil", "3500", "Deluxe Room");
insert into Room values("18 DR", "Availabil", "3500", "Deluxe Room");
insert into Room values("19 DR", "Availabil", "3500", "Deluxe Room");
insert into Room values("20 DR", "Availabil", "3500", "Deluxe Room");
insert into Room values("21 DR", "Availabil", "3500", "Deluxe Room");
insert into Room values("101 GB1", "Availabil", "500", "G Bed 1");
insert into Room values("101 GB2", "Availabil", "500", "G Bed 2");
insert into Room values("101 GB3", "Availabil", "500", "G Bed 3");
insert into Room values("101 GB4", "Availabil", "500", "G Bed 4");
insert into Room values("101 GB5", "Availabil", "500", "G Bed 5");
insert into Room values("101 GB6", "Availabil", "500", "G Bed 6");
insert into Room values("102 GB1", "Availabil", "500", "G Bed 1");
insert into Room values("102 GB2", "Availabil", "500", "G Bed 2");
insert into Room values("102 GB3", "Availabil", "500", "G Bed 3");
insert into Room values("102 GB4", "Availabil", "500", "G Bed 4");
insert into Room values("102 GB5", "Availabil", "500", "G Bed 5");
insert into Room values("102 GB6", "Availabil", "500", "G Bed 6");
insert into Room values("103 GB1", "Availabil", "500", "G Bed 1");
insert into Room values("103 GB2", "Availabil", "500", "G Bed 2");
insert into Room values("103 GB3", "Availabil", "500", "G Bed 3");
insert into Room values("103 GB4", "Availabil", "500", "G Bed 4");
insert into Room values("103 GB5", "Availabil", "500", "G Bed 5");
insert into Room values("103 GB6", "Availabil", "500", "G Bed 6");
insert into Room values("201 SPB1", "Availabil", "1000", "Semi Private Bed 1");
insert into Room values("201 SPB2", "Availabil", "1000", "Semi Private Bed 2");
insert into Room values("202 SPB1", "Availabil", "1000", "Semi Private Bed 1");
insert into Room values("202 SPB2", "Availabil", "1000", "Semi Private Bed 2");
insert into Room values("203 SPB1", "Availabil", "1000", "Semi Private Bed 1");
insert into Room values("203 SPB2", "Availabil", "1000", "Semi Private Bed 2");
insert into Room values("204 SPB1", "Availabil", "1000", "Semi Private Bed 1");
insert into Room values("204 SPB2", "Availabil", "1000", "Semi Private Bed 2");
insert into Room values("205 SPB1", "Availabil", "1000", "Semi Private Bed 1");
insert into Room values("205 SPB2", "Availabil", "1000", "Semi Private Bed 5");
insert into Room values("301 PR", "Availabil", "1500", "Private Room");
insert into Room values("302 PR", "Availabil", "1500", "Private Room");
insert into Room values("303 PR", "Availabil", "1500", "Private Room");
insert into Room values("304 PR", "Availabil", "1500", "Private Room");
insert into Room values("305 PR", "Availabil", "1500", "Private Room");



create table department(Department varchar(100),Phone_no varchar(20));
select * from department;
insert into department values("Surgical_Department","+91 7001-560-01");
insert into department values("Nursing_Department","+91 7001-560-02");
insert into department values("Operation_Theater complex (OT)","+91 7001-560-03");
insert into department values("Paramedical_Department","+91 7001-560-04");
insert into department values("Billing_Department","+91 7001-560-06");
insert into department values("Insoranse_Department","+91 7001-560-07");
insert into department values("Medical_Department","+91 7001-560-08");
insert into department values("Burn_Department","+91 7001-560-09");
insert into department values("ChildBirth_Department","+91 7001-560-10");
insert into department values("Mortuary_Department","+91 7001-560-11");
insert into department values("OPD_Department","+91 7001-560-12");
insert into department values("ICU_Department","+91 7001-560-13");
insert into department values("Pethalogy_Department","+91 7001-560-14");
insert into department values("Aayushman_Department","+91 7001-560-15");

create table EMP_INFO(Name varchar(100),Age varchar(20), Phone_Number varchar(20), salary varchar(20),Gmail varchar(20), Aadhar_Number varchar(20));
select * from EMP_INFO;

insert into EMP_INFO values ("Dr. Meena","32","+91 7001-561-02","64000","meena32@gmail.com","658912459987");
insert into EMP_INFO values ("Dr. Ramesh","45","+91 7001-561-03","70000","ramesh45@gmail.com","789623147890");
insert into EMP_INFO values ("Dr. Sneha","28","+91 7001-561-04","68000","sneha28@gmail.com","623587412546");
insert into EMP_INFO values ("Dr. Anil","40","+91 7001-561-05","72000","anil40@gmail.com","158935624789");
insert into EMP_INFO values ("Dr. Nisha","35","+91 7001-561-06","66000","nisha35@gmail.com","958214786952");
insert into EMP_INFO values ("Dr. Manav","38","+91 7001-561-07","69000","manav38@gmail.com","367489214756");
insert into EMP_INFO values ("Dr. Aarti","42","+91 7001-561-08","71000","aarti42@gmail.com","852136897412");
insert into EMP_INFO values ("Dr. Rajat","29","+91 7001-561-09","67000","rajat29@gmail.com","456298312145");
insert into EMP_INFO values ("Dr. Priya","31","+91 7001-561-10","64000","priya31@gmail.com","901245128456");
insert into EMP_INFO values ("Dr. Akash","36","+91 7001-561-11","69000","akash36@gmail.com","789024561234");
insert into EMP_INFO values ("Dr. Kavita","33","+91 7001-561-12","66500","kavita33@gmail.com","349852147984");
insert into EMP_INFO values ("Dr. Harsh","44","+91 7001-561-13","73000","harsh44@gmail.com","875496321023");
insert into EMP_INFO values ("Dr. Neha","27","+91 7001-561-14","65000","neha27@gmail.com","145826987412");
insert into EMP_INFO values ("Dr. Sameer","39","+91 7001-561-15","70000","sameer39@gmail.com","698574122356");
insert into EMP_INFO values ("Dr. Divya","30","+91 7001-561-16","67000","divya30@gmail.com","453214789654");
insert into EMP_INFO values ("Dr. Aditya","37","+91 7001-561-17","71500","aditya37@gmail.com","852136987415");
insert into EMP_INFO values ("Dr. Ritu","26","+91 7001-561-18","65500","ritu26@gmail.com","985632146547");
insert into EMP_INFO values ("Dr. Vivek","46","+91 7001-561-19","74000","vivek46@gmail.com","145269328745");
insert into EMP_INFO values ("Dr. Alka","41","+91 7001-561-20","69500","alka41@gmail.com","256347891236");
insert into EMP_INFO values ("Dr. Gaurav","43","+91 7001-561-21","72000","gaurav43@gmail.com","963278954521");
insert into EMP_INFO values ("Dr. Tanya","34","+91 7001-561-22","68000","tanya34@gmail.com","781234677890");
insert into EMP_INFO values ("Dr. Nikhil","38","+91 7001-561-23","70500","nikhil38@gmail.com","295174156321");
insert into EMP_INFO values ("Dr. Preeti","29","+91 7001-561-24","67500","preeti29@gmail.com","965812478532");
insert into EMP_INFO values ("Dr. Sahil","30","+91 7001-561-25","69000","sahil30@gmail.com","741236589210");

create table Ambulence(Name varchar(20), Gender varchar(20), Car_name varchar(20) , Available varchar(20) , Location varchar(20));

INSERT INTO Ambulence (Name, Gender, Car_name, Available, Location) VALUES
('Raj', 'Male', 'Innova', 'Available', 'Bhopal'),
('Neha', 'Female', 'Bolero', 'Available', 'Indore'),
('Amit', 'Male', 'Ertiga', 'Available', 'Jabalpur'),
('Divya', 'Female', 'Tavera', 'Available', 'Gwalior'),
('Rohit', 'Male', 'Xylo', 'Available', 'Ujjain'),
('Sunita', 'Female', 'Innova', 'Available', 'Sagar'),
('Arjun', 'Male', 'Scorpio', 'Available', 'Rewa'),
('Sneha', 'Female', 'Ertiga', 'Available', 'Satna'),
('Karan', 'Male', 'Bolero', 'Available', 'Ratlam'),
('Pooja', 'Female', 'Tavera', 'Available', 'Chhindwara'),
('Vikram', 'Male', 'Xylo', 'Available', 'Khandwa'),
('Meena', 'Female', 'Innova', 'Available', 'Dewas'),
('Sanjay', 'Male', 'Scorpio', 'Available', 'Katni'),
('Ayesha', 'Female', 'Ertiga', 'Available', 'Sehore'),
('Nikhil', 'Male', 'Bolero', 'Available', 'Hoshangabad'),
('Kavya', 'Female', 'Tavera', 'Available', 'Mandsaur'),
('Harsh', 'Male', 'Xylo', 'Available', 'Shivpuri'),
('Ritu', 'Female', 'Innova', 'Available', 'Vidisha'),
('Manoj', 'Male', 'Scorpio', 'Available', 'Dhar'),
('Priya', 'Female', 'Ertiga', 'Available', 'Betul');


CREATE TABLE Billing (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    total_bill INT NOT NULL,
    amount_paid INT NOT NULL,
    billing_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Patient_History (
    history_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id VARCHAR(50),
    name VARCHAR(100),
    gender VARCHAR(10),
    disease VARCHAR(100),
    room_no VARCHAR(50),
    admission_time DATETIME,
    discharge_time DATETIME,
    total_bill INT,
    amount_paid INT,
    status VARCHAR(20), -- "Admitted" or "Discharged"
    remarks VARCHAR(255)
);

	

