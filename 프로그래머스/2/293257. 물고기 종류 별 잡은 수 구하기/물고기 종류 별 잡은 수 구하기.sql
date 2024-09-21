-- 코드를 작성해주세요
select 
    count(fi.id) as fish_count
    , fn.fish_name
from
    fish_info as fi
join 
    fish_name_info as fn
on  
    fi.fish_type = fn.fish_type
group
    by fish_name
order
    by fish_count desc;