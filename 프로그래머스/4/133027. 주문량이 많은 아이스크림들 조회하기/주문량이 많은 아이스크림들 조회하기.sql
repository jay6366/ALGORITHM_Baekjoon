-- 코드를 입력하세요
SELECT TOTAL.FLAV
FROM (SELECT ha.flavor as FLAV
FROM FIRST_HALF HA, JULY JU
WHERE HA.FLAVOR = JU.FLAVOR
group by ha.flavor
order by SUM(ha.total_order)+sum(ju.total_order) desc) TOTAL
where rownum <= 3;


