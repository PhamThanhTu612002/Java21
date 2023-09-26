-- 1.Tìm địa chỉ có chứa từ ‘San’.
select * from address where address like '%San%';
-- 2.Tìm địa chỉ bắt đầu bằng ‘1’ và kết thúc bằng ‘y’
select * from address where address like '1%y';
-- 3.Tìm địa chỉ chứa chữ ‘a’ vị trí thứ 3
select * from address where address like '__a%';
-- 4.Tìm tên khách hàng có địa chỉ bằng có kết thúc chữ ‘o’
select first_name,last_name from customer
inner join address
on customer.address_id = address.address_id
where address like '%o';
-- 5.Tìm tên bộ phim có chứa category = ‘Games’;
select film.title from film 
inner join film_category
on film.film_id = film_category.film_id
inner join category
on category.category_id = film_category.category_id
where category.name = 'Games';
-- 6.Từ bảng Person tìm nhân viên lương trong khoảng 2000 đến 300 (sử dụng between)
select * from Person where salary between 300 and 2000;
-- 7.Từ bảng Person tìm nhân viên sinh tháng 7 đến tháng 12. (sử dụng between)
select * from Person where month(birthday) between 7 and 12;
-- 8.Lấy danh sách những người có sinh nhật trong tháng này và hiện thị thông tin “Happy birthday”!
select fullname, case
when month(birthday) = month(curdate()) then 'Happy birthday'
when month(birthday) != month(curdate()) then 'No Happy birthday'
end as BirthdayText from Person;
-- 9.Tìm tất cả những có năm sinh 2000, 1990, 1991 bảng Person.
select * from Person where year(birthday) = '2000' or year(birthday) = '1990' or year(birthday) = '1991';