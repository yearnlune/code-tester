/* https://programmers.co.kr/learn/courses/30/lessons/59040 */

SELECT ANIMAL_TYPE,
       COUNT(1) as 'count'
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;

SELECT *
FROM (SELECT ANIMAL_TYPE,
             COUNT(1) as 'count'
      FROM ANIMAL_INS
      GROUP BY ANIMAL_TYPE) as s
ORDER BY s.ANIMAL_TYPE;