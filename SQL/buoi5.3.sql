-- 1.Lấy danh sách tên các diễn viên (actors) có họ bắt đầu bằng chữ “S”.
select * from actor where first_name like 'S%';
-- 2.Lấy danh sách các bộ phim (films) được phát hành trong khoảng từ năm 2000 đến năm 2010.
select * from film where release_year between 2000 and 2010;
-- 3.Lấy danh sách các bộ phim (films) có rating là “PG” hoặc “PG-13”.
select * from film where rating = 'PG' or rating = 'PG-13';
-- 4.Lấy danh sách diễn viên (actors) và số lượng bộ phim (films) mà họ tham gia, sắp xếp theo số lượng bộ phim giảm dần.
select first_name,last_name, count(film.film_id) 
from actor inner join film_actor
on actor.actor_id = film_actor.actor_id
inner join film
on film_actor.film_id = film.film_id
group by first_name,last_name
order by count(film.film_id) desc;
-- 5.Lấy danh sách các bộ phim (films) và thể loại (categories) của chúng.
select title,name from film
inner join film_category
on film.film_id = film_category.film_id
inner join category
on film_category.category_id = category.category_id;
-- 6.Lấy danh sách các bộ phim (films) và tổng số diễn viên (actors) tham gia trong mỗi bộ phim, sắp xếp theo tổng số diễn viên giảm dần.
select title,count(actor.actor_id) from film
inner join film_actor
on film.film_id = film_actor.film_id
inner join actor
on film_actor.actor_id = actor.actor_id
group by title
order by count(actor.actor_id);
-- 7.Lấy danh sách các diễn viên (actors) có số lượng bộ phim (films) tham gia lớn hơn 30.
select first_name,last_name, count(film.film_id) from actor inner join film_actor
on actor.actor_id = film_actor.actor_id
inner join film
on film_actor.film_id = film.film_id
group by first_name,last_name
having count(film.film_id) > 30;
-- 8.Lấy danh sách các diễn viên (actors) không tham gia trong bất kỳ bộ phim nào.
select actor_id from actor 
where actor_id not in (select actor.actor_id from actor 
left join film_actor
on actor.actor_id = film_actor.actor_id
group by actor.actor_id);
-- 9.Lấy danh sách bộ phim (films) và tổng doanh thu (revenue) của từng bộ phim, sắp xếp theo tổng doanh thu giảm dần.
select *,film.rental_rate* film.rental_duration as revenue from film ;
-- 10.Lấy danh sách các bộ phim (films) và thể loại (categories) của chúng, với điều kiện mỗi bộ phim thuộc thể loại “Horror”
select title,name from film
inner join film_category
on film.film_id = film_category.film_id
inner join category
on film_category.category_id = category.category_id
where category.name = 'Horror';