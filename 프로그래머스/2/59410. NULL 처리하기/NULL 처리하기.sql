-- 코드를 입력하세요
SELECT ANIMAL_TYPE, CASE WHEN NAME is null THEN 'No name'
                         ELSE NAME
                     END
    , SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;