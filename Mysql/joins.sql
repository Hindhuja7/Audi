/* An SQL JOIN clause is used to combine rows from two or more tables, 
based on a common field between them.

The most common type of join is: SQL INNER JOIN (simple join). 
An SQL INNER JOIN returns all rows from multiple tables where 
the join condition is met.

The INNER JOIN keyword selects all rows from both tables as long as there is 
a match between the columns. If there are rows in the "emp" table that do not 
have matches in "dept", these employees will not be listed.

Inner Join and Join are same */

select emp.empno, emp.ename, dept.dname, emp.job, emp.deptno, dept.deptno
from emp
inner join dept
on emp.deptno!=dept.deptno;

or 

select emp.empno, emp.ename, dept.dname, emp.job
from emp
join dept
on emp.deptno=dept.deptno;

or

select e.empno, e.ename, d.dname, e.job
from emp as e, dept as d
where e.deptno=d.deptno;

/* Different SQL JOINs

INNER JOIN: Returns all rows when there is at least one match in BOTH tables

LEFT JOIN: Return all rows from the left table, 
  and the matched rows from the right table

RIGHT JOIN: Return all rows from the right table, 
and the matched rows from the left table

FULL JOIN: Return all rows when there is a match in ONE of the tables */

/*  The LEFT JOIN keyword returns all rows from the left table (table1), with 
the matching rows in the right table (table2). 
The result is NULL in the right side when there is no match.

Note: The LEFT JOIN keyword returns all the rows from the left table (emp), 
even if there are no matches in the right table (dept). */

SELECT emp.empno, emp.ename, dept.dname, emp.job
FROM emp
LEFT JOIN dept
ON emp.deptno=dept.deptno;

/* The RIGHT JOIN or RIGHT OUTER JOIN keyword returns all rows from the 
right table (table2), with the matching rows in the left table (table1). 
The result is NULL in the left side when there is no match.

Note: The RIGHT JOIN keyword returns all the rows from the right table 
(dept), even if there are no matches in the left table (emp). */

SELECT emp.empno, emp.ename, dept.dname, emp.job
FROM emp
RIGHT JOIN dept
ON emp.deptno=dept.deptno;

/* The FULL OUTER JOIN keyword returns all rows from the left table (table1) 
and from the right table (table2).

The FULL OUTER JOIN keyword combines the result of both LEFT and RIGHT joins.

MySQL doesn't support this. We can use union to achieve the same.

The UNION operator is used to combine the result-set of two or 
more SELECT statements.

Notice that each SELECT statement within the UNION must have the same number 
of columns. The columns must also have similar data types. 
Also, the columns in each SELECT statement must be in the same order. */

SELECT * FROM emp
LEFT JOIN dept ON emp.deptno=dept.deptno
UNION
SELECT * FROM emp
RIGHT JOIN dept ON emp.deptno=dept.deptno;

/* The SELECT INTO statement selects data from one table and inserts 
it into a new table. */

create table empTemp (select * from emp)

insert into empTemp 
select * from emp;
