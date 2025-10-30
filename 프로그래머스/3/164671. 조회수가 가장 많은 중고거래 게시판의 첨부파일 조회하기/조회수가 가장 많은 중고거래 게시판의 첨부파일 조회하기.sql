-- 코드를 입력하세요
SELECT
    CONCAT('/home/grep/src/', 
                   (SELECT
            U.BOARD_ID
        FROM
            USED_GOODS_BOARD U
        WHERE
            U.VIEWS = (
                SELECT
                    MAX(U.VIEWS)
                FROM
                    USED_GOODS_BOARD U
            )), '/',
           FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH
FROM
    USED_GOODS_FILE F
WHERE
    F.BOARD_ID = (SELECT
                    U.BOARD_ID
                FROM
                    USED_GOODS_BOARD U
                WHERE
                    U.VIEWS = (
                        SELECT
                            MAX(U.VIEWS)
                        FROM
                            USED_GOODS_BOARD U
                    )
                  )
ORDER BY
    F.FILE_ID DESC;
    

# SELECT
#     U.BOARD_ID
# FROM
#     USED_GOODS_BOARD U
# WHERE
#     U.VIEWS = (
#         SELECT
#             MAX(U.VIEWS)
#         FROM
#             USED_GOODS_BOARD U
#     );


# SELECT
#     MAX(U.VIEWS)
# FROM
#     USED_GOODS_BOARD U;