# Write your MySQL query statement below

Select em.unique_id, e.name 
from Employees as e
left join
EmployeeUNI as em
on e.id = em.id; 