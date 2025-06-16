-- 코드를 입력하세요
select i.name, i.datetime
from animal_ins as i
left join animal_outs as o
on o.animal_id = i.animal_id
where o.datetime is null
order by i.datetime
limit 3