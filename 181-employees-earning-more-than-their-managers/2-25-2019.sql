SELECT E1.NAME AS 'Employee' FROM Employee E1  INNER JOIN  Employee E2 ON E1.ManagerId = E2.Id AND E1.Salary > E2.Salary;
