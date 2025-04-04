-- 코드를 작성해주세요
select year(ym) as YEAR
, round(sum(pm_val1) / count(*), 2) as "PM10"
, round(sum(pm_val2) / count(*), 2) as "PM2.5"
from air_pollution
where location2 = "수원"
group by year(ym)
order by year(ym)