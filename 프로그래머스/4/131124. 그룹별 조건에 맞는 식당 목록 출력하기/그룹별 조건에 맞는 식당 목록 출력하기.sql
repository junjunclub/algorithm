# SELECT
#     MEMBER_ID
# FROM
#     REST_REVIEW
# GROUP BY
#     MEMBER_ID
# HAVING
#     COUNT(*) = (SELECT
#                     MAX(CNT)
#                 FROM
#                     (
#                         SELECT COUNT(*) CNT
#                         FROM REST_REVIEW
#                         GROUP BY MEMBER_ID
#                 ) A
#             );

SELECT
    MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
FROM
    MEMBER_PROFILE M
LEFT JOIN
    REST_REVIEW R
ON
    M.MEMBER_ID = R.MEMBER_ID
WHERE
    R.MEMBER_ID IN (SELECT
                    MEMBER_ID
                FROM
                    REST_REVIEW
                GROUP BY
                    MEMBER_ID
                HAVING
                    COUNT(*) = (SELECT
                                    MAX(CNT)
                                FROM
                                    (
                                        SELECT COUNT(*) CNT
                                        FROM REST_REVIEW
                                        GROUP BY MEMBER_ID
                                ) A
                            )
                        )
ORDER BY
    R.REVIEW_DATE ASC, R.REVIEW_TEXT ASC;