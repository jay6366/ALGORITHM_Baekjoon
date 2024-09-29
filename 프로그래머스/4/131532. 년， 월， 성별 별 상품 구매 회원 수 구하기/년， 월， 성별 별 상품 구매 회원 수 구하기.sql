-- 코드를 입력하세요
SELECT TO_NUMBER(TO_CHAR(SAL.SALES_DATE,'YYYY')) AS YEAR,
       TO_NUMBER(TO_CHAR(SAL.SALES_DATE,'MM')) AS MONTH,
       USR.GENDER, COUNT(DISTINCT(USR.USER_ID)) AS USERS
FROM USER_INFO USR
JOIN ONLINE_SALE SAL
ON USR.USER_ID = SAL.USER_ID
WHERE USR.GENDER IS NOT NULL
GROUP BY  TO_NUMBER(TO_CHAR(SAL.SALES_DATE,'YYYY')), TO_NUMBER(TO_CHAR(SAL.SALES_DATE,'MM')), USR.GENDER
ORDER BY YEAR asc ,MONTH ASC ,GENDER ASC