# Write your MySQL query statement below
SELECT (SELECT max(Salary) FROM Employee WHERE Salary < (SELECT max(Salary) FROM Employee)) AS "SecondHighestSalary"
SELECT max(Salary) AS SecondHighestSalary FROM Employee WHERE Salary < (SELECT max(Salary) FROM Employee)
SELECT (SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT 1, 1) SecondHighestSalary;
