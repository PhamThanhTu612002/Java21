-- 1.Lấy thông tin tất cả các sản phẩm đã được đặt trong một đơn đặt hàng cụ thể.
select * from OrderDetails
inner join Products
on OrderDetails.product_id = Products.product_id
where order_detail_id = 1;
-- 2.Tính tổng số tiền trong một đơn đặt hàng cụ thể.
select price*quantity as total_price from OrderDetails
inner join Products
on OrderDetails.product_id = Products.product_id
where order_detail_id = 3;
-- 3.Lấy danh sách các sản phẩm chưa có trong bất kỳ đơn đặt hàng nào.
select Products.product_id,OrderDetails.order_detail_id from Products
left join OrderDetails
on Products.product_id = OrderDetails.product_id 
where order_detail_id is null;
-- 4.Đếm số lượng sản phẩm trong mỗi danh mục. (category_name, total_products)
select category_name,count(product_id) as total_products from Categories
inner join Products
on Categories.category_id = Products.category_id
group by category_name;
-- 5.Tính tổng số lượng sản phẩm đã đặt bởi mỗi khách hàng (customer_name, total_ordered)
select customer_name,count(OrderDetails.order_id) as total_ordered from Orders 
inner join OrderDetails
on Orders.order_id = OrderDetails.order_id
inner join Customers
on Customers.customer_id = Orders.customer_id
group by customer_name;
-- 6.Lấy thông tin danh mục có nhiều sản phẩm nhất (category_name, product_count)
select category_name, count(Products.product_id) as product_count from Categories
inner join Products
on Categories.category_id = Products.category_id
group by category_name
order by product_count desc;
-- 7.Tính tổng số sản phẩm đã được đặt cho mỗi danh mục (category_name, total_ordered)
select category_name, count(OrderDetails.product_id) as total_ordered from Categories
inner join Products
on Categories.category_id = Products.category_id
inner join OrderDetails
on OrderDetails.product_id = Products.product_id
group by category_name;
-- 8.Lấy thông tin về top 3 khách hàng có số lượng sản phẩm đặt hàng lớn nhất (customer_id, customer_name, total_ordered)
select Customers.customer_id,customer_name,count(OrderDetails.order_id) as total_ordered from Orders 
inner join OrderDetails
on Orders.order_id = OrderDetails.order_id
inner join Customers
on Customers.customer_id = Orders.customer_id
group by Customers.customer_id,customer_name
order by total_ordered desc limit 3;
-- 9.Lấy thông tin về khách hàng đã đặt hàng nhiều hơn một lần trong khoảng thời gian cụ thể từ ngày A -> ngày B (customer_id, customer_name, total_orders)
select Customers.customer_id,customer_name,count(OrderDetails.order_id) as total_ordered from Orders 
inner join OrderDetails
on Orders.order_id = OrderDetails.order_id
inner join Customers
on Customers.customer_id = Orders.customer_id
where Orders.order_date between '2023/07/06' and '2023/12/06'
group by Customers.customer_id,customer_name
having total_ordered > 1
order by total_ordered desc;
-- 10.Lấy thông tin về các sản phẩm đã được đặt hàng nhiều lần nhất và số lượng đơn đặt hàng tương ứng (product_id, product_name, total_ordered)
select OrderDetails.product_id, product_name, count(OrderDetails.order_detail_id) as total_ordered from Products
inner join OrderDetails
on Products.product_id = OrderDetails.product_id
group by OrderDetails.product_id, product_name
order by total_ordered desc;

