USE master

drop database UserManagement

CREATE DATABASE [UserManagement]

USE [UserManagement]

CREATE TABLE tblRoles (
	roleID nvarchar(50) PRIMARY KEY,
	roleName nvarchar(50) NULL,
	status int null
)

CREATE TABLE tblCategory(
	categoryID INT IDENTITY(1,1) PRIMARY KEY,
	categoryName nvarchar(50) null,
	status int null
)

CREATE TABLE tblUsers (
	userID nvarchar(50) PRIMARY KEY,
	fullName nvarchar(50) NULL,
	password nvarchar(50) NULL,
	roleID nvarchar(50) FOREIGN KEY REFERENCES tblRoles(roleID),
	address nvarchar(50) NULL,
	DOB date null,
	phone nvarchar(50) NULL,
	email nvarchar(50) NULL,
	status int null
)

CREATE TABLE tblProduct (
	productID INT IDENTITY(1,1) PRIMARY KEY,
	productName nvarchar(50) NULL,
	image nvarchar(50) NULL,
	price DECIMAL(10, 2) null,
	quantity int null,
	memory int null,
	categoryID int FOREIGN KEY REFERENCES tblCategory(categoryID),
	status int null
)

CREATE TABLE tblOrder (
	orderID INT IDENTITY(1,1) PRIMARY KEY,
	orderDate date null,
	total DECIMAL(10, 2) null,
	userID nvarchar(50) FOREIGN KEY REFERENCES tblUsers(userID)
)

CREATE TABLE tblOrderDetail (
	detailID INT IDENTITY(1,1) PRIMARY KEY,
	price DECIMAL(10, 2) null,
	quantity int null,
	orderID int FOREIGN KEY REFERENCES tblOrder(orderID),
	productID int FOREIGN KEY REFERENCES tblProduct(productID)
)

INSERT tblRoles(roleID, roleName, status) VALUES ('US','USER',1)
INSERT tblRoles(roleID, roleName, status) VALUES ('AD','ADMIN',1)

INSERT tblCategory(categoryName,status) VALUES ('PHONE',1)
INSERT tblCategory(categoryName,status) VALUES ('WATCH',1)
INSERT tblCategory(categoryName,status) VALUES ('MAC',1)

INSERT tblUsers(userID, fullName, password, roleID, address, DOB, phone, email, status) 
VALUES 
	('user','Toi la user', 1 , 'US', 'Binh Duong', '2003/09/10','0368474553','locptse171129@fpt.edu.vn',1),
	('admin','Toi la admin', 1 , 'AD', 'Binh Duong', '2003/09/10','0368474553','locptse171129@fpt.edu.vn',1),
    ('user1', 'John Doe', 1 , 'US', 'New York', '1990/05/15', '1234567890', 'john.doe@example.com', 1),
    ('user2', 'Jane Smith', 1 , 'US', 'Los Angeles', '1985/08/20', '0987654321', 'jane.smith@example.com', 1),
    ('user3', 'Michael Johnson', 1 , 'US', 'Chicago', '1978/12/10', '5551234567', 'michael.j@example.com', 1),
    ('user4', 'Emily Brown', 1 , 'US', 'Houston', '1995/03/25', '9876543210', 'emily.b@example.com', 1),
    ('user5', 'William Wilson', 1 , 'US', 'Phoenix', '1980/07/05', '3216549870', 'will.w@example.com', 1),
    ('user6', 'Samantha Martinez', 1 , 'US', 'Philadelphia', '1992/10/18', '4567890123', 'samantha.m@example.com', 1),
    ('user7', 'David Taylor', 1 , 'US', 'San Antonio', '1987/02/28', '7890123456', 'david.t@example.com', 1),
    ('user8', 'Olivia Anderson', 1 , 'US', 'San Diego', '1998/06/30', '2109876543', 'olivia.a@example.com', 1),
    ('user9', 'James Thomas', 1 , 'US', 'Dallas', '1976/09/12', '6543210987', 'james.t@example.com', 1),
    ('user10', 'Sophia Garcia', 1 , 'US', 'San Jose', '1983/11/22', '8901234567', 'sophia.g@example.com', 1),
    ('admin2', 'Adam Wilson', 1 , 'AD', 'Seattle', '1982/04/14', '1234567890', 'adam.w@example.com', 1),
    ('admin3', 'Ella Thompson', 1 , 'AD', 'Denver', '1975/08/27', '0987654321', 'ella.t@example.com', 1),
    ('admin4', 'Ryan Martinez', 1 , 'AD', 'Portland', '1990/12/05', '5551234567', 'ryan.m@example.com', 1),
    ('admin5', 'Grace Harris', 1 , 'AD', 'Miami', '1988/03/20', '9876543210', 'grace.h@example.com', 1),
    ('admin6', 'Jacob Lee', 1 , 'AD', 'San Francisco', '1984/06/10', '3216549870', 'jacob.l@example.com', 1);


INSERT tblProduct(productName, image, price, quantity, memory, categoryID, status)
VALUES
    ('iPhone 11 Pro Max 64GB', NULL, 12000000.0, 10, 64, 1, 1),
    ('iPhone 11 Pro Max 128GB', NULL, 14000000.0, 15, 128, 1, 1),
    ('iPhone 12 64GB', NULL, 15000000.0, 20, 64, 1, 1),
    ('iPhone 12 128GB', NULL, 17000000.0, 18, 128, 1, 1),
    ('iPhone 12 Pro 256GB', NULL, 20000000.0, 12, 256, 1, 1),
    ('iPhone 12 Pro Max 128GB', NULL, 22000000.0, 10, 128, 1, 1),
    ('iPhone 12 Pro Max 256GB', NULL, 24000000.0, 8, 256, 1, 1),
    ('iPhone 13 128GB', NULL, 25000000.0, 20, 128, 1, 1),
    ('iPhone 13 256GB', NULL, 27000000.0, 15, 256, 1, 1),
    ('iPhone 13 Pro 512GB', NULL, 30000000.0, 10, 512, 1, 1),
    ('Apple Watch Series 6 40mm', NULL, 8000000.0, 15, 8, 2, 1),
    ('Apple Watch Series 6 44mm', NULL, 8500000.0, 20, 8, 2, 1),
    ('Apple Watch SE 40mm', NULL, 6000000.0, 10, 8, 2, 1),
    ('Apple Watch SE 44mm', NULL, 6500000.0, 12, 8, 2, 1),
    ('Apple Watch Series 7 41mm', NULL, 10000000.0, 8, 8, 2, 1),
	('MacBook Air 13-inch M1', NULL, 2000000.0, 10, 128, 3, 1),
    ('MacBook Air 13-inch M1', NULL, 25000000.0, 10, 256, 3, 1),
    ('MacBook Pro 13-inch M1', NULL, 30000000.0, 12, 256, 3, 1),
    ('MacBook Pro 14-inch M1 Pro', NULL, 35000000.0, 8, 128, 3, 1),
    ('MacBook Pro 16-inch M1 Pro', NULL, 40000000.0, 5, 512, 3, 1),
    ('MacBook Pro 16-inch M1 Max', NULL, 45000000.0, 6, 1024, 3, 1),
	('MacBook Pro 16-inch M1 Max', NULL, 37000000.0, 6, 128, 3, 1);

