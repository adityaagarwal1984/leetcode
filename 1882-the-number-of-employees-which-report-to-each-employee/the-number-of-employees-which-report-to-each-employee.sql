select a.employee_id,a.name,count(*) as reports_count,round(avg(b.age)) as average_age
from Employees a cross join Employees b
where a.employee_id=b.reports_to
group by a.employee_id order by a.employee_id asc;