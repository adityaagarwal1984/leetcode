SELECT employee_id, department_id
FROM Employee
WHERE primary_flag = 'Y'
UNION
SELECT employee_id,department_id
FROM Employee
WHERE employee_id NOT IN (
    SELECT DISTINCT employee_id
    FROM Employee
    WHERE primary_flag = 'Y'
)
GROUP BY employee_id;
