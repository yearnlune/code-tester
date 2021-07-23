/* https://programmers.co.kr/learn/courses/30/lessons/59041 */
SELECT *
FROM (SELECT NAME, COUNT(1) AS COUNT
      FROM ANIMAL_INS
      WHERE NAME IS NOT NULL
      GROUP BY NAME
     ) as A
WHERE COUNT > 1
ORDER BY NAME