# Write your MySQL query statement below
select max(num) as num
from MyNumbers
where (num,1)
in
(
select num,count(*)
from MyNumbers group by num
);

