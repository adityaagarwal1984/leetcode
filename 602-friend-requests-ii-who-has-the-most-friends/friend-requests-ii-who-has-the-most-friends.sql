# Write your MySQL query statement below
select p.a as id,count(*) as num
from

(select requester_id as a ,accepter_id as b
from RequestAccepted
union all
select accepter_id as a ,requester_id as b
from RequestAccepted)p
group by p.a
order by count(*) desc
limit 1;
