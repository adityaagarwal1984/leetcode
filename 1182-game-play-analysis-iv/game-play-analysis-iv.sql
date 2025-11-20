# Write your MySQL query statement below
select round(count(distinct player_id)/(select count(distinct player_id) from Activity),2) as  fraction
from Activity
where
(
(player_id,event_date)
in
(
select player_id,date_add(min(event_date),Interval 1 day)
from Activity
group by player_id
)
);

