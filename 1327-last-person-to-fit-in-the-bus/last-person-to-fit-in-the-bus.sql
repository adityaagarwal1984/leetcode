# Write your MySQL query statement below
select a.person_name

from
(select person_name,sum(weight) over(order by turn ) as total_weight
from Queue

)a
where a.total_weight<=1000
order by a.total_weight desc
limit 1;
