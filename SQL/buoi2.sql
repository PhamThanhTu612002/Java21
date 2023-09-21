-- 1.Lấy ra danh sách các nghề nghiệp (job) duy nhất mà người trong bảng không làm trùng lặp.
select distinct job from Persons;
-- 2.Lấy ra danh sách các người có nghề nghiệp (job) là ‘Manager’ và lương (salary) lớn hơn 70000.
select * from Persons where salary >70000 and job = 'Manager';
-- 3.Lấy ra người có tuổi (dựa trên ngày sinh) từ 25 đến 35.
select * from Persons where year(curdate()) - year(birthday) > 25 and year(curdate()) - year(birthday) < 30;
-- 4.Lấy ra danh sách các quốc gia (country) và tổng số lượng người từng quốc gia.
select count(id) as quantity, country from Persons group by country;
-- 5.Tính số lượng nam (gender = ‘Male’) và nữ (gender = ‘Female’) trong bảng.
select count(id), gender from Persons group by gender;
-- 6.Lấy ra danh sách người có cùng nghề nghiệp (job) và quốc gia (country).
select job,country,count(*) from Persons group by country,job;
-- 8.Lấy ra danh sách người theo thứ tự giảm dần của ngày sinh (birthday).
select * from Persons order by birthday desc;
-- 8.Lấy ra các nghề nghiệp (job) và tổng số lượng người làm nghề đó, nhưng chỉ hiển thị những nghề nghiệp có ít nhất 3 người làm.
select count(job),job from Persons group by job having count(job) >= 3;