-- 코드를 입력하세요
SELECT
    ICECREAM_INFO.FLAVOR
FROM
    ICECREAM_INFO
INNER JOIN
    FIRST_HALF
    ON
        FIRST_HALF.FLAVOR = ICECREAM_INFO.FLAVOR
WHERE
    INGREDIENT_TYPE = 'fruit_based'
    AND FIRST_HALF.TOTAL_ORDER > 3000;