-- 코드를 작성해주세요
WITH MAX_SIZE AS
    (
    SELECT 
        YEAR(DIFFERENTIATION_DATE) YEAR, MAX(SIZE_OF_COLONY) MAX_SIZE
    FROM
        ECOLI_DATA
    GROUP BY
        YEAR
    )
SELECT 
    M.YEAR, (MAX_SIZE-SIZE_OF_COLONY) YEAR_DEV, ID
FROM    
    ECOLI_DATA E
LEFT JOIN
    MAX_SIZE M
    ON
    YEAR(E.DIFFERENTIATION_DATE) = M.YEAR
ORDER BY
    YEAR, YEAR_DEV
