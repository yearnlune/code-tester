/* https://programmers.co.kr/learn/courses/30/lessons/59413 */

WITH RECURSIVE hours (hour) AS
                   (SELECT 0
                    UNION ALL
                    SELECT hour + 1
                    FROM hours
                    WHERE hour < 23)
SELECT a.hour, IFNULL(b.count, 0) as count
FROM hours as a
         LEFT OUTER JOIN (SELECT HOUR(DATETIME) as hour, COUNT(1) as count
                          FROM ANIMAL_OUTS
                          GROUP BY hour) as b ON a.hour = b.hour
;