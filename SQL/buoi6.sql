create database middle_test;

create table Categories
(
category_id int primary key,
category_name varchar(50)
);
create table Products
(
product_id int primary key,
product_name varchar(50),
category_id int,
price double,
FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);
create table Customers
(
customer_id int primary key,
customer_name varchar(50),
email varchar(50)
);
create table Orders
(
order_id int primary key,
customer_id int,
order_date date,
foreign key (customer_id) references Customers(customer_id)
);
create table OrderDetails
(
order_detail_id int primary key,
order_id int,
product_id int,
quantity int,
foreign key (order_id) references Orders(order_id),
foreign key (product_id) references Products(product_id)
);

insert into Categories values 
(1,'Laptop'),
(2,'Dien Thoai'),
(3,'Phu Kien'),
(4,'PC'),
(5,'Dong Ho');

insert into Products values
(1,'Macbook Pro M2',1,1900),
(2,'Macbook Pro M1',1,1500),
(3,'Iphone 15 Pro Max',2,999),
(4,'Iphone 15 Pro',2,888),
(5,'Sac Khong Day',3,50),
(6,'Tai Nghe Air Pod',3,100),
(7,'PC Gaming 1',4,2000),
(10,'PC Gaming 2',4,2000),
(8,'Rolex',5,50000),
(9,'Casio',5,500);

insert into Customers values
(1,'Pham Thanh Tu','pttu612002@gmail.com'),
(2,'Pham Kim Hue','pkhue02052002@gmail.com'),
(3,'Le Van Anh','lvanh1999@gmail.com'),
(4,'Nguyen Tan Thanh','ntthanh2000@gmail.com'),
(5,'Ly Thi Lien','ltlien2001@gmail.com');

insert into Orders values
(1,1,'2023/09/05'),
(2,1,'2023/08/05'),
(3,3,'2023/06/06'),
(4,3,'2023/10/04'),
(5,4,'2023/04/30'),
(6,4,'2023/05/01'),
(7,5,'2023/01/06'),
(8,5,'2023/02/05'),
(9,1,'2023/05/02'),
(10,3,'2023/10/20'),
(11,4,'2023/11/11'),
(12,5,'2023/12/12'),
(13,3,'2023/01/01'),
(14,2,'2023/08/08');

insert into OrderDetails values
(1,1,1,2),
(2,2,1,1),
(3,3,2,3),
(4,4,2,4),
(5,5,3,100),
(6,6,4,80),
(7,7,5,200),
(8,8,6,500),
(9,9,5,5),
(10,10,5,7),
(11,11,6,15),
(12,12,7,20),
(13,13,8,1),
(14,14,9,100);