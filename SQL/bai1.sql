create database lab1;

create table Person(
	id int primary key,
    fullname nvarchar(50),
    job nvarchar(50),
    birthday date,
    salary float,
    address nvarchar(100)
);

insert into person values
(1,"Pham Thanh Tu","dev","2002/01/06",1000,"Ha Nam"),
(2,"Nguyen Van A","dev","2001/11/16",900,"Nam Dinh"),
(3,"Pham Van B","dev","1999/10/26",900,"Thai Binh"),
(4,"Le Thi C","tester","1998/02/08",600,"Hung Yen"),
(5,"Hoang Thi D","tester","2003/05/05",600,"Hai Phong"),
(6,"Ma Van Dan","dev","2002/08/04",1000,"Hai Duong"),
(7,"Ly Thi Lien","tester","2003/12/16",600,"Ha Nam"),
(8,"Nguyen Huu Dat","dev","2002/11/24",1000,"Nghe An"),
(9,"Hoang Van Thang","dev","2002/09/05",1000,"Thanh Hoa"),
(10,"Le Van Dai","dev","2002/07/07",1000,"Tuyen Quang");

select * from person