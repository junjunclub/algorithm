with car as (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE between '2022-08-01' and '2022-10-31'
    group by CAR_ID
    having count(*) >= 5
)

select
    month(START_DATE) as month, car_id, count(*) as records
from
    car_rental_company_rental_history
where
    DATE_FORMAT(START_DATE, '%Y-%m') between '2022-08' and '2022-10' AND
    CAR_ID IN (SELECT CAR_ID FROM CAR)
GROUP BY
    MONTH(START_DATE), CAR_ID
ORDER BY
    MONTH ASC, CAR_ID DESC;