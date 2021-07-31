/* https://programmers.co.kr/learn/courses/30/lessons/59045 */

SELECT O.ANIMAL_ID, O.ANIMAL_TYPE, O.NAME
  FROM ANIMAL_INS AS I INNER JOIN ANIMAL_OUTS AS O
    ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.SEX_UPON_INTAKE IN ('Intact Male', 'Intact Female')
  AND O.SEX_UPON_OUTCOME IN ('Neutered Male', 'Spayed Female')
ORDER BY O.ANIMAL_ID, O.ANIMAL_TYPE, O.NAME