-- 코드를 작성해주세요
SELECT
    ID, FISH_NAME, LENGTH
FROM
    FISH_INFO AS A
LEFT JOIN
    FISH_NAME_INFO AS B
    ON
    B.FISH_TYPE = A.FISH_TYPE
WHERE
    (FISH_NAME, LENGTH) IN (SELECT
                                FISH_NAME, MAX(LENGTH) AS LENGTH
                           FROM
                                FISH_INFO AS A
                           LEFT JOIN
                                FISH_NAME_INFO AS B
                            ON
                                A.FISH_TYPE = B.FISH_TYPE
                           GROUP BY
                                A.FISH_TYPE, FISH_NAME)