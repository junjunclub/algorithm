-- 코드를 입력하세요
SELECT p.product_code as product_code,
sum(price * o.sales_amount) as sales
from product p
left join offline_sale o
on p.product_id = o.product_id
group by p.product_code
order by sum(price * o.sales_amount) desc,
p.product_code;