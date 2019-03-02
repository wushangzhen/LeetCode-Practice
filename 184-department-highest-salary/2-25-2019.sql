# Write your MySQL query statement below
SELECT 
    D.Name AS 'Department',
    E.Name AS 'Employee',
    E.Salary AS 'Salary'
FROM
    Department D,
    Employee E,
    (SELECT DepartmentId, MAX(Salary) Salary FROM Employee GROUP BY DepartmentId) M
WHERE
    D.Id = E.DepartmentId
    AND E.DepartmentId = M.DepartmentId
    AND E.Salary = M.Salary;
    
