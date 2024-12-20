--AUTHOR_ID/ AUTHOR_NAME / CATEGORY / TOTAL_SALES

SELECT B.AUTHOR_ID, A.AUTHOR_NAME,B.CATEGORY,SUM(B.PRICE*S.SALES) AS TOTAL_SALES
FROM BOOK B, AUTHOR A, BOOK_SALES S
WHERE B.AUTHOR_ID = A.AUTHOR_ID
AND B.BOOK_ID = S.BOOK_ID
AND SALES_DATE 
BETWEEN TO_DATE('2022-01-01','YYYY-MM-DD') AND TO_DATE('2022-01-31','YYYY-MM-DD')
GROUP BY B.AUTHOR_ID, A.AUTHOR_NAME,B.CATEGORY
ORDER BY B.AUTHOR_ID, B.CATEGORY DESC
