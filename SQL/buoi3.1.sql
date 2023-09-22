-- 1.Lấy ra tên các thành phố và tên các quốc gia tương ứng của thành phố đó
select city,country from country inner join city on country.country_id = city.country_id;
-- 2.Lấy ra tên các thành phố của nước Mỹ
select city from city inner join country on country.country_id = city.country_id where country = 'United States';
-- 3.Lấy ra các địa chỉ của thành phố Hanoi
select address from address inner join city on address.city_id = city.city_id where city = 'Hanoi';
-- 4.Lấy ra tên, mô tả, tên category của các bộ phim có rating = R
select title,film.description,category.name from category inner join film_category on category.category_id = film_category.category_id inner join film on film.film_id = film_category.film_id;
-- 5.Lấy ra thông tin của các bộ phim mà diễn viên NICK WAHLBERG tham gia
select * from film inner join film_actor on film.film_id = film_actor.film_id inner join actor on actor.actor_id = film_actor.actor_id where first_name = 'NICK' and last_name = 'WAHLBERG';
-- 6.Tìm email của các khách hàng ở Mỹ
select email from customer inner join address on customer.address_id = address.address_id inner join city on city.city_id = address.city_id inner join country on country.country_id = city.country_id where country = 'United States';