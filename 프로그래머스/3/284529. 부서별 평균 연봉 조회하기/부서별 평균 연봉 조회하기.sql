-- 코드를 작성해주세요
select e.dept_id, d.dept_name_en, round(avg(e.sal), 0) as avg_sal
from hr_employees e
left join hr_department d
on e.dept_id = d.dept_id
group by e.dept_id
order by avg_sal desc