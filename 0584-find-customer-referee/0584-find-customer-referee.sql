# Write your MySQL query statement below
Select name from Customer
where referee_id != 2 or referee_id IS null;

-- Note : The 'IS' operator in SQL is primarily used for NULL comparisons, because = does not work with NULL values.