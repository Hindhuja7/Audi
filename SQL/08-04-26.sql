/* Write a SQL query to list employee names and department names for employees 
with a salary greater than 2000 using INNER JOIN.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2)primary key,dname varchar(50)not null, location varchar(50)not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+-------+------------+
| ename | dname      |
+-------+------------+
*/
USE fs; 
select e.ename,d.dname from emp as e 
inner join dept as d 
on e.deptno=d.deptno
where e.sal>2000;

/* Write a SQL query to retrieve all employees and their department locations, 
including those without departments, using LEFT JOIN.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2)primary key,dname varchar(50)not null, location varchar(50)not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+--------+----------+
| ename  | location |
+--------+----------+
*/
USE fs; 

select emp.ename,dept.location from emp left join dept on emp.deptno=dept.deptno;

/* Write a SQL query to list all department numbers, department names and their 
employee counts, including departments with no employees, using RIGHT JOIN.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2)primary key,dname varchar(50)not null, location varchar(50)not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+--------+------------+-----------+
| deptno | dname      | emp_count |
+--------+------------+-----------+
*/
USE fs; 
 select dept.deptno,dept.dname,count(emp.deptno) from emp right join dept on emp.deptno=dept.deptno group by deptno;
+--------+------------+-------------------+
| deptno | dname      | count(emp.deptno) |
+--------+------------+-------------------+
|     10 | Accounting |                 3 |
|     20 | Research   |                 6 |
|     30 | Sales      |                 3 |
|     40 | Operations |                 2 |
|     50 | Finance    |                 0 |
+--------+------------+-------------------+
5 rows in set (0.00 sec)

/* Write a SQL query to simulate a FULL OUTER JOIN to list all employees and 
departments, including unmatched rows.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2)primary key,dname varchar(50)not null, location varchar(50)not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+-------+--------+--------+------------+
| empno | ename  | deptno | dname      |
+-------+--------+--------+------------+
*/
USE fs; 
 select * from emp left join dept on emp.deptno=dept.deptno union select * from emp right join dept on emp.deptno=dept.deptno;

/* Write a SQL query to find employees who are managers of other employees using 
a self-join.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2)primary key,dname varchar(50)not null, location varchar(50)not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+---------+
| manager |
+---------+
*/

USE fs; 
select distinct(e1.ename) as manager from emp as e1 join emp as e2 on e1.empno=e2.mgr;


/* Write a SQL query to generate all possible employee-department combinations 
using CROSS JOIN.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2)primary key,dname varchar(50)not null, location varchar(50)not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)


+--------+------------+
| ename  | dname      |
+--------+------------+
*/
USE fs; 
select ename,dname from emp,dept;
select ename,dname from emp cross join dept;

/* Write a SQL query to list departments with employees earning more than 2500 
using EXISTS.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2)primary key,dname varchar(50)not null, location varchar(50)not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+--------+------------+
| deptno | dname      |
+--------+------------+
*/
USE fs; 

select distinct(dept.deptno),(dept.dname) from dept left join emp on emp.deptno=dept.deptno where sal>2500;

/* Write a SQL query to find departments with number of employees earning less 
than 1000 using NOT EXISTS.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2)primary key,dname varchar(50)not null, location varchar(50)not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)


+------------+--------+
| dname      | deptno |
+------------+--------+
*/
USE fs; 


/* Write a SQL query to find managers and the number of employees they manage in
departments located in 'New York', using the primary key and foreign key 
constraints.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2)primary key,dname varchar(50)not null, location varchar(50)not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+--------------+-----------+
| manager_name | emp_count |
+--------------+-----------+
*/
USE fs; 

/* Write a SQL query to list all employees and departments, including those 
without matches, using a simulated FULL JOIN.

Tables:
------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==>   
deptno int(2)primary key,dname varchar(50)not null, location varchar(50)not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

+-------+--------+--------+------------+----------+
| empno | ename  | deptno | dname      | location |
+-------+--------+--------+------------+----------+
*/
USE fs; 

select empno,ename,dept.deptno,dept.dname,dept.location from emp left join dept on emp.deptno=dept.deptno union
select empno,ename,dept.deptno,dept.dname,dept.location from emp right join dept on emp.deptno=dept.deptno;