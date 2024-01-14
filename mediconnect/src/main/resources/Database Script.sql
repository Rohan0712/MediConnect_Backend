DROP TABLE OrderDetails;
DROP TABLE Orders;
DROP TABLE Users;
DROP TABLE Support;
DROP TABLE Doctor;
DROP TABLE Medicine;

-- Create a table for Medicine
CREATE TABLE Medicine (
    medicineID INT PRIMARY KEY AUTO_INCREMENT,
    quantity INT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    content VARCHAR(255) NOT NULL,    
    imageUrl VARCHAR(255) NOT NULL,
    price DECIMAL(10,2)
);

-- Create a table for Doctor
CREATE TABLE Doctor (
    name VARCHAR(255) NOT NULL,
    specialization VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL,
	 description TEXT,
	 price DECIMAL(10,2)
);

-- Create a table for Support
CREATE TABLE Support (
    supportId INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    message TEXT
);

-- Create a table for Users
CREATE TABLE Users (
    userID VARCHAR(255) PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15),
    address VARCHAR(255),
	 accountVerification Boolean default false,
	 password VARCHAR(255)
);

-- Create a table for orders
CREATE TABLE Orders (
    orderID VARCHAR(255) PRIMARY KEY,
    userID VARCHAR(255) NOT NULL,
    orderDate DATETIME NOT NULL,
    storeAddress VARCHAR(255),
    totalAmount DECIMAL(10, 2) NOT NULL,
    referenceNumber VARCHAR(255),
    FOREIGN KEY (userID) REFERENCES Users(userID)
);

-- Create a table for order details
CREATE TABLE OrderDetails (
    orderDetailID VARCHAR(255) PRIMARY KEY,
    orderID VARCHAR(255) NOT NULL,
    medicineID INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    quantity INT,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (orderID) REFERENCES Orders(orderID)
);

insert into Medicine VALUES(1,1,'Aspirin','Each tablet contains 325mg of aspirin.','Aspirin is a nonsteroidal anti-inflammatory drug (NSAID) used to reduce pain and as an antithrombotic. Specific inflammatory conditions which aspirin is used to treat include pericarditis, and rheumatic fever.','../assets/aspirin.png',3);
insert into Medicine VALUES(2,1,'Ibuprofen','Each tablet contains 200mg of ibuprofen.','Ibuprofen is a nonsteroidal anti-inflammatory drug (NSAID) used to relieve pain, reduce inflammation, and lower fever. It is commonly used to treat conditions such as arthritis, menstrual cramps, and minor injuries.','../assets/ibuprofen.png',5);
insert into Medicine VALUES(3,1,'Levothyroxine','Levothyroxine is a medicine used to treat an underactive thyroid gland','Levothyroxine medication used to replace or supplement thyroid hormone in the body. It is also used with surgery and radioactive iodine therapy to treat thyroid cancer.','../assets/Levothyroxine.png',7);
insert into Medicine VALUES(4,1,'Metformin','Metformin an oral medication (in the biguanide group), used to treat type 2 diabetes, which lowers blood sugar levels.','Metformin USP 500 mg and 750 mg tablets contain the inactive ingredients hypromellose, magnesium stearate, and polyvinyl pyrrolidone','../assets/Metformin.png',9);
insert into Medicine VALUES(5,1,'Atorvastatin','Atorvastatin is used together with a proper diet to lower cholesterol and triglyceride (fats) levels in the blood','An HMG-CoA reductase inhibitor (or ‘statin’) used to lower cholesterol levels in the blood, commonly prescribed for high cholesterol.','../assets/Atorvastatin.png',8);
insert into Medicine VALUES(6,1,'Dolo 650','Each contains Paracetamol, an analgesic (pain killer) and antipyretic.','Dolo 650 Tablet is a medicine used to relieve pain and reduce fever. It is used to treat many conditions such as headaches, body aches, toothaches, and the common cold.','../assets/dolo.png',4);

insert into Doctor values('Dr. John Doe','Cardiologist','../assets/doctor_male.png','Dr. John Doe has over 20 years of experience in Cardiology',75);
insert into Doctor values('Dr. Jane Smith','Dermatologist','../assets/doctor_female.png','Dr. Jane Smith is a board-certified UCI Health dermatologist',50);
insert into Doctor values('Dr. Sarah Wilson','Orthopedic Surgeon','../assets/doctor_female.png','Dr. Sarah J Wilson is a Orthopedic Surgeon at the Belfast Health.',60);
insert into Doctor values('Dr. Michael Lee','Ophthalmologist','../assets/doctor_male.png','Dr. Michael Lee is an Ophthalmology Specialist and has 18 years experience.',70);
insert into Doctor values('Dr. Emily Davis','Neurologist','../assets/doctor_female.png','Veterinary Neurologist at Sugar Land Veterinary Specialists.',100);
insert into Doctor values('Dr. Emily Davis, NP','Geriatric Medicine','../assets/doctor_female.png','Emily Davis, NP is a geriatric medicine specialist in Chicago, IL.',40);

INSERT INTO Users VALUES('tandel.rohan07','Rohan','Tandel','rohan@mediconnect.com',2132342311,'14 Clive St, Bolton BL1 1AP, United Kingdom',1,'mediconnect'); 
INSERT INTO Users VALUES('rohan007','Rohan','Tandel','tandelrohan07@gmail.com',2132342311,'14 Clive St, Bolton BL1 1AP, United Kingdom',1,'mediconnect'); 
