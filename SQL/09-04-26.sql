/* Write a SQL query to list employee names and department names where the 
department is in 'Chicago' using INNER JOIN.

+-------+-------+
| ename | dname |
+-------+-------+
*/
USE fs; 
select ename,dname from emp join dept on emp.deptno=dept.deptno
where dept.location="chicago";

/* 
Retrieve Department-wise Total Salary and Number of Employees (Using GROUP BY and JOIN)

+------------+---------------+--------------+
| dname      | num_employees | total_salary |
+------------+---------------+--------------+

*/
USE fs; 

select dept.dname,count(emp.deptno) as num_employees,sum(sal) as total_salary from emp right join dept on emp.deptno=dept.deptno group by dept.deptno;

/* Write a SQL query to list departments with no assigned employees using 
RIGHT JOIN.

+--------+---------+
| deptno | dname   |
+--------+---------+

*/
USE fs; 

select dept.deptno,dname from emp right join dept on emp.deptno=dept.deptno where emp.empno is null;

/* Write a SQL query to combine employee and department data with duplicates 
using UNION ALL.


+--------+------------+
| ename  | dname      |
+--------+------------+

*/
USE fs; 

select ename,dname from emp left join dept on emp.deptno=dept.deptno union all select ename,dname from emp right join dept on emp.deptno=dept.deptno;
+--------+------------+
| ename  | dname      |
+--------+------------+
| SMITH  | Research   |
| ALLEN  | Accounting |
| ALLEN  | Sales      |
| JONES  | Research   |
| MARTIN | Operations |
| BLAKE  | Sales      |
| CLARK  | Accounting |
| SCOTT  | Research   |
| KEVIN  | Operations |
| KEVIN  | Sales      |
| KEVIN  | Sales      |
| JAMES  | Research   |
| FORD   | Research   |
| FORD   | Accounting |
| ALLEN  | Accounting |
| CLARK  | Accounting |
| FORD   | Accounting |
| SMITH  | Research   |
| JONES  | Research   |
| SCOTT  | Research   |
| JAMES  | Research   |
| FORD   | Research   |
| ALLEN  | Sales      |
| BLAKE  | Sales      |
| KEVIN  | Sales      |
| KEVIN  | Sales      |
| MARTIN | Operations |
| KEVIN  | Operations |
| NULL   | Finance    |
+--------+------------+
29 rows in set (0.01 sec)
/* Write a SQL query to list employees and their managers’ names using a LEFT 
JOIN for employees without managers.

+----------+---------+
| employee | manager |
+----------+---------+

*/
USE fs; 
select e1.ename,e2.ename from emp as e1 left join emp as e2 on e1.mgr=e2.empno;
+--------+-------+
| ename  | ename |
+--------+-------+
| SMITH  | FORD  |
| ALLEN  | BLAKE |
| ALLEN  | BLAKE |
| JONES  | KEVIN |
| MARTIN | BLAKE |
| BLAKE  | KEVIN |
| CLARK  | KEVIN |
| SCOTT  | JONES |
| KEVIN  | NULL  |
| KEVIN  | BLAKE |
| KEVIN  | SCOTT |
| JAMES  | BLAKE |
| FORD   | JONES |
| FORD   | CLARK |
+--------+-------+
14 rows in set (0.00 sec)
/* Write a SQL query to retrieve average salaries per department using INNER 
JOIN and GROUP BY.

+--------+------------+-------------+
| deptno | dname      | avg_salary  |
+--------+------------+-------------+

*/
USE fs; 
 select dept.deptno,dname,avg(emp.sal) from dept join emp on emp.deptno=dept.deptno group by emp.deptno;
+--------+------------+--------------+
| deptno | dname      | avg(emp.sal) |
+--------+------------+--------------+
|     20 | Research   |  2145.000000 |
|     10 | Accounting |  1783.333333 |
|     30 | Sales      |  2650.000000 |
|     40 | Operations |  3125.000000 |
+--------+------------+--------------+
4 rows in set (0.01 sec)

/* Write a SQL query to find departments with more than 3 employees using 
INNER JOIN and HAVING.

+--------+----------+-----------+
| deptno | dname    | emp_count |
+--------+----------+-----------+

*/
USE fs; 
select dept.deptno,dname,count(emp.deptno) from dept join emp on emp.deptno=dept.deptno group by emp.deptno having count(emp.deptno)>3;
+--------+----------+-------------------+
| deptno | dname    | count(emp.deptno) |
+--------+----------+-------------------+
|     20 | Research |                 5 |
|     30 | Sales    |                 4 |
+--------+----------+-------------------+
2 rows in set (0.01 sec)

/* Write a SQL query to list employees and departments where the employee’s 
hire date is after 1980 using INNER JOIN.

+--------+------------+------------+
| ename  | dname      | hiredate   |
+--------+------------+------------+
*/
USE fs; 
 select ename,dname,hiredate from emp join dept on emp.deptno=dept.deptno where year(hiredate)>1980;
+--------+------------+------------+
| ename  | dname      | hiredate   |
+--------+------------+------------+
| ALLEN  | Accounting | 1998-08-15 |
| CLARK  | Accounting | 1993-05-14 |
| FORD   | Accounting | 2000-01-21 |
| SMITH  | Research   | 1993-06-13 |
| JONES  | Research   | 1995-10-31 |
| SCOTT  | Research   | 1996-03-05 |
| JAMES  | Research   | 2000-06-23 |
| FORD   | Research   | 1997-12-05 |
| ALLEN  | Sales      | 1996-03-26 |
| BLAKE  | Sales      | 1992-06-11 |
| KEVIN  | Sales      | 1995-06-04 |
| KEVIN  | Sales      | 1999-06-04 |
| MARTIN | Operations | 1998-12-05 |
| KEVIN  | Operations | 1990-06-09 |
+--------+------------+------------+
14 rows in set (0.00 sec)
/* 
Find Departments Without Employees (Using LEFT JOIN and NULL Check)

+------------+----------+
| Department | Location |
+------------+----------+


*/
USE fs; 
select dname,location from dept left join emp on emp.deptno=dept.deptno where emp.empno is null;
+---------+----------+
| dname   | location |
+---------+----------+
| Finance | Tempe    |
+---------+----------+
1 row in set (0.00 sec)

/* Write a SQL query to list employee names and department names using an
implicit join, ordered by employee name.

+--------+------------+
| ename  | dname      |
+--------+------------+

*/
USE fs; 

 select ename,dname from emp,dept where emp.deptno=dept.deptno order by ename;
+--------+------------+
| ename  | dname      |
+--------+------------+
| ALLEN  | Accounting |
| ALLEN  | Sales      |
| BLAKE  | Sales      |
| CLARK  | Accounting |
| FORD   | Research   |
| FORD   | Accounting |
| JAMES  | Research   |
| JONES  | Research   |
| KEVIN  | Operations |
| KEVIN  | Sales      |
| KEVIN  | Sales      |
| MARTIN | Operations |
| SCOTT  | Research   |
| SMITH  | Research   |
+--------+------------+
14 rows in set (0.00 sec)