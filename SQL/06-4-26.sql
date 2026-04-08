-- Write a SQL query to find the average salary and number of employees per 
-- department, ordered by average salary in descending order.

-- Tables:
-- ------
-- salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

-- dept==>   
-- deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

-- emp ==>   empno int(4) primary key, ename varchar(50) not null,
--           job varchar(50) not null,  mgr int(4),  hiredate date,
--           sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

-- Expected Output Columns:
-- ------------------------
-- +--------+-------------+----------+
-- | deptno | AVG(sal)    | COUNT(*) |

USE fs; 
select deptno,avg(sal),count(*) from emp group by deptno order by avg(sal) desc;


/*  Write a SQL query to list the total salary and employee count per job, 
excluding clerks.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+-----------+----------+----------+
| job       | SUM(sal) | COUNT(*) |
+-----------+----------+----------+

*/
USE fs; 
select job,sum(sal),count(*) from emp group by job having job!="clerk";


/*  Write a SQL query to show the total salary per department where the 
total salary exceeds 5000, ordered by department number.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+--------+----------+
| deptno | SUM(sal) |
+--------+----------+

*/
USE fs; 
select deptno,sum(sal) from emp group by deptno having sum(sal)>5000 order by deptno;

/*  Write a SQL query to display the number of employees per job, sorted by job 
title alphabetically.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)
          
+-----------+----------+
| job       | COUNT(*) |
+-----------+----------+



*/
USE fs; 
select job,count(*) from emp group by job order by job;

/*  Write a SQL query to find the minimum and maximum salaries per department, 
excluding department 20.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+--------+----------+----------+
| deptno | MIN(sal) | MAX(sal) |
+--------+----------+----------+

*/
USE fs; 
select deptno,min(sal),max(sal) from emp group by deptno having deptno!=20;

/*  Write a SQL query to list departments with more than 3 employees, ordered 
by total salary descending.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+--------+----------+----------+
| deptno | SUM(sal) | COUNT(*) |
+--------+----------+----------+

*/
USE fs; 
select deptno,sum(sal),count(*) from emp group by deptno having count(*)>3 order by sum(sal) desc;

/* Write a SQL query to show the total commission and average salary per job 
for jobs with at least 2 employees.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+----------+-----------+-------------+
| job      | SUM(comm) | AVG(sal)    |
+----------+-----------+-------------+

*/
USE fs; 
select job,sum(comm),avg(sal) from emp group by job having count(*)>=2;

/* Write a SQL query to retrieve employees ordered by hire date and salary 
in descending order.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)
          
+-------+--------+-----------+------+------------+---------+---------+--------+
| empno | ename  | job       | mgr  | hiredate   | sal     | comm    | deptno |
+-------+--------+-----------+------+------------+---------+---------+--------+

*/
USE fs; 
select * from emp order by hiredate,sal desc;

/* Write a SQL query to find the total salary per department and job
combination, excluding the president job.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+--------+----------+----------+
| deptno | job      | SUM(sal) |
+--------+----------+----------+

*/
USE fs; 
select deptno,job,sum(sal) from emp group by deptno,job having job!="president"; 


/* Write a SQL query to list departments with an average salary above 2000, 
ordered by average salary.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+--------+-------------+
| deptno | AVG(sal)    |
+--------+-------------+

*/
USE fs; 
select deptno,avg(sal) from emp group by deptno having avg(sal)>2000 order by avg(sal);