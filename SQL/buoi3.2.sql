create database Test;

create table Students
(
student_id int primary key,
student_name varchar(50),
student_age int
);
create table Courses
(
course_id int primary key,
course_name varchar(50),
course_description text
);
create table Enrollments
(
enrollment_id int primary key,
student_id int,
course_id int,
foreign key (student_id) references Students(student_id),
foreign key (course_id) references Courses(course_id)
);

insert into Students values
(1,'Pham Thanh Tu',21),
(2,'Nguyen Van A',21),
(3,'Tran Thi B',22),
(4,'Dang Van C',20),
(5,'Hoang Thi E',19),
(6,'Ngo Van H',20),
(7,'Lo Thi V',20),
(8,'Le Van N',20),
(9,'Nguyen Thanh Trung',21),
(10,'Pham Thi Kim Hue',21);

insert into Courses values
(1,'Java','Co Ban'),
(2,'HTML','Co Ban'),
(3,'PHP','Co Ban'),
(4,'Python','Co Ban'),
(5,'Javascript','Co Ban');

insert into Enrollments values
(1,1,1),
(2,2,3),
(3,3,3),
(4,4,4),
(5,5,5),
(6,5,1),
(7,5,3),
(8,4,3),
(9,4,1),
(10,4,2),
(11,2,5),
(12,10,5),
(13,9,2),
(14,8,3),
(15,7,4),
(16,6,5),
(17,6,4),
(18,1,4),
(19,9,1),
(20,10,2);

-- Bài tập 1: Lấy danh sách tất cả sinh viên và thông tin khóa học mà họ đã đăng ký.
select student_name,course_name from Courses inner join Enrollments on Courses.course_id = Enrollments.course_id inner join Students on Students.student_id = Enrollments.student_id;
-- Bài tập 2: Lấy tên của tất cả các khóa học mà một sinh viên cụ thể đã đăng ký (sử dụng tham số student_id).
select course_name from Courses inner join Enrollments on Courses.course_id = Enrollments.course_id inner join Students on Students.student_id = Enrollments.student_id where Students.student_id = 5;
-- Bài tập 3: Lấy danh sách tất cả sinh viên và số lượng khóa học mà họ đã đăng ký.
select Students.student_name, count(Courses.course_id) from Courses inner join Enrollments on Courses.course_id = Enrollments.course_id inner join Students on Students.student_id = Enrollments.student_id group by Students.student_id;
-- Bài tập 4: Lấy tất cả các khóa học mà chưa có sinh viên nào đăng ký.
select * from Courses right join Enrollments on Courses.course_id = Enrollments.course_id where course_name is null;
-- Bài tập 5: Lấy tất cả sinh viên và thông tin khóa học mà họ đã đăng ký, sắp xếp theo tên sinh viên và tên khóa học.
select Students.student_name, Courses.course_name from Courses inner join Enrollments on Courses.course_id = Enrollments.course_id inner join Students on Students.student_id = Enrollments.student_id order by Students.student_name,Courses.course_name;
-- Bài tập 6: Lấy tất cả các sinh viên và thông tin của họ, cùng với tên khóa học mà họ đăng ký (nếu có).
select course_name,student_name,student_age from Courses inner join Enrollments on Courses.course_id = Enrollments.course_id inner join Students on Students.student_id = Enrollments.student_id;
-- Bài tập 7: Lấy danh sách tất cả sinh viên và thông tin của họ, cùng với tên khóa học mà họ đăng ký (nếu có). Sắp xếp theo tên sinh viên và tuổi từ cao xuống thấp.
select course_name,student_name,student_age from Courses inner join Enrollments on Courses.course_id = Enrollments.course_id inner join Students on Students.student_id = Enrollments.student_id order by Students.student_name asc,Students.student_age desc;
-- Bài tập 8: Lấy tất cả các khóa học và số lượng sinh viên đã đăng ký vào mỗi khóa học.
select Courses.course_name, count(Students.student_id) from Courses inner join Enrollments on Courses.course_id = Enrollments.course_id inner join Students on Students.student_id = Enrollments.student_id group by Courses.course_name;

