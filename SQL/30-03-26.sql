/* 
Write an sql query to Retrieve the names and salaries of employees 
who have the job title "SALESMAN" and earn more than 1500.

Tables:
-------
salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

dept==> 
deptno int(2)primary key, dname varchar(50)not null,location varchar(50)not null

emp ==>   empno int(4) primary key, ename varchar(50) not null,
          job varchar(50) not null,  mgr int(4),  hiredate date,
          sal decimal(10,2),  comm decimal(10,2),  deptno int(2)
          
Expected Output:
+--------+---------+                                                                                                                                  
| ename  | sal     |                                                                                                                                  
+--------+---------+                                                                                                                                  
| ALLEN  | 1600.00 |                                                                                                                                  
| ALLEN  | 1250.00 |                                                                                                                                  
| MARTIN | 1250.00 |                                                                                                                                  
| KEVIN  | 1500.00 |                                                                                                                                  
+--------+---------+ 
*/

USE fs;
#write your query here
select ename,sal from emp where job="SALESMAN" ;



/* 
Write an sql query to List all employees whose job title is either 
"MANAGER" or "ANALYST".
          
Expected Output:
+-------+---------+                                                                                                                                   
| ename | job     |                                                                                                                                   
+-------+---------+                                                                                                                                   
| JONES | MANAGER |                                                                                                                                   
| BLAKE | MANAGER |                                                                                                                                   
| CLARK | MANAGER |                                                                                                                                   
| SCOTT | ANALYST |                                                                                                                                   
| FORD  | ANALYST |                                                                                                                                   
+-------+---------+

*/
USE fs;
#write your query here
select ename,job from emp where job="MANAGER" or job="ANALYST";


/* 
Write an sql query to Get all the details of employees who do not belong to 
department 20.


Expected Output:
+-------+--------+-----------+------+------------+---------+---------+--------+                                                                       
| empno | ename  | job       | mgr  | hiredate   | sal     | comm    | deptno |                                                                       
+-------+--------+-----------+------+------------+---------+---------+--------+                                                                       
|  7499 | ALLEN  | SALESMAN  | 7698 | 1998-08-15 | 1600.00 |  300.00 |     10 |                                                                       
|  7782 | CLARK  | MANAGER   | 7839 | 1993-05-14 | 2450.00 |    NULL |     10 |                                                                       
|  7934 | FORD   | CLERK     | 7782 | 2000-01-21 | 1300.00 |    NULL |     10 |                                                                       
|  7521 | ALLEN  | SALESMAN  | 7698 | 1996-03-26 | 1250.00 |  500.00 |     30 |                                                                       
|  7698 | BLAKE  | MANAGER   | 7839 | 1992-06-11 | 2850.00 |    NULL |     30 |                                                                       
|  7844 | KEVIN  | SALESMAN  | 7698 | 1995-06-04 | 1500.00 |    0.00 |     30 |                                                                       
|  7654 | MARTIN | SALESMAN  | 7698 | 1998-12-05 | 1250.00 | 1400.00 |     40 |                                                                       
|  7839 | KEVIN  | PRESIDENT | NULL | 1990-06-09 | 5000.00 |    0.00 |     40 |                                                                       
+-------+--------+-----------+------+------------+---------+---------+--------+ 

*/
USE fs;
#write your query here
select * from emp where deptno!=20;


/* 
Write an sql query to Get the employee names and their commission details 
where the job is "CLERK" or the commission is more than 1000.

Expected Output:
+--------+----------+---------+                                                                                                                       
| ename  | job      | comm    |                                                                                                                       
+--------+----------+---------+                                                                                                                       
| SMITH  | CLERK    |    0.00 |                                                                                                                       
| MARTIN | SALESMAN | 1400.00 |                                                                                                                       
| KEVIN  | CLERK    |    NULL |                                                                                                                       
| JAMES  | CLERK    |    NULL |                                                                                                                       
| FORD   | CLERK    |    NULL |                                                                                                                       
+--------+----------+---------+ 
*/
USE fs;
#write your query here
select ename,job,comm from emp where job="CLERK" or (job="SALESMAN" and comm>1000);


/* 
Write an sql query to Get the list of employees who do not have the job title 
"CLERK" or "SALESMAN".

Expected Output:
+-------+-----------+                                                                                                                                 
| ename | job       |                                                                                                                                 
+-------+-----------+                                                                                                                                 
| JONES | MANAGER   |                                                                                                                                 
| BLAKE | MANAGER   |                                                                                                                                 
| CLARK | MANAGER   |                                                                                                                                 
| SCOTT | ANALYST   |                                                                                                                                 
| KEVIN | PRESIDENT |                                                                                                                                 
| FORD  | ANALYST   |                                                                                                                                 
+-------+-----------+   
*/

USE fs;
#write your query here
select ename,job from emp where job!="CLERK" and job!="SALESMAN";

/*
Write an sql query to Retrieve the names and salaries of employees who earn 
between 1000 and 3000 (inclusive).

Expected Output:
+--------+---------+                                                                                                                                  
| ename  | sal     |                                                                                                                                  
+--------+---------+                                                                                                                                  
| ALLEN  | 1600.00 |                                                                                                                                  
| ALLEN  | 1250.00 |                                                                                                                                  
| JONES  | 2975.00 |                                                                                                                                  
| MARTIN | 1250.00 |                                                                                                                                  
| BLAKE  | 2850.00 |                                                                                                                                  
| CLARK  | 2450.00 |                                                                                                                                  
| SCOTT  | 3000.00 |                                                                                                                                  
| KEVIN  | 1500.00 |                                                                                                                                  
| KEVIN  | 1100.00 |                                                                                                                                  
| FORD   | 3000.00 |                                                                                                                                  
| FORD   | 1300.00 |                                                                                                                                  
+--------+---------+   */

select ename,sal from emp where sal > 1000 and sal<=3000;

/*Write an sql query to List all salary grades where the grade is between 2 and 4.
Expected Output:
+-------+---------+---------+                                                                                                                         
| grade | losal   | hisal   |                                                                                                                         
+-------+---------+---------+                                                                                                                         
|     2 | 1201.00 | 3333.00 |                                                                                                                         
|     3 | 1401.00 | 4444.00 |                                                                                                                         
|     4 | 2001.00 | 5555.00 |                                                                                                                         
+-------+---------+---------+ 

*/
USE fs;
#write your query here
select grade,losal,hisal from salgrade where grade between 2 and 4;

/* 
write an sql query to Get employees who are not managers and have a salary 
below 2000.

Expected Output:
+--------+----------+---------+                                                                                                                       
| ename  | job      | sal     |                                                                                                                       
+--------+----------+---------+                                                                                                                       
| SMITH  | CLERK    |  800.00 |                                                                                                                       
| ALLEN  | SALESMAN | 1600.00 |                                                                                                                       
| ALLEN  | SALESMAN | 1250.00 |                                                                                                                       
| MARTIN | SALESMAN | 1250.00 |                                                                                                                       
| KEVIN  | SALESMAN | 1500.00 |                                                                                                                       
| KEVIN  | CLERK    | 1100.00 |                                                                                                                       
| JAMES  | CLERK    |  950.00 |                                                                                                                       
| FORD   | CLERK    | 1300.00 |                                                                                                                       
+--------+----------+---------+ 

*/
USE fs;
#Write your query here
select ename,job,sal from emp where job!="MANAGER" and sal<2000;

/* Write an sql query to Retrieve employees who do not report to any manager.
Expected Output:
+-------+-------+-----------+                                                                                                                         
| empno | ename | job       |                                                                                                                         
+-------+-------+-----------+                                                                                                                         
|  7839 | KEVIN | PRESIDENT |                                                                                                                         
+-------+-------+-----------+ 

*/
USE fs;
select empno,ename,job from emp where mgr is null;


/* Write an sql query to Get clerks or analysts hired between 1996 and 2000
Expected Output:
+-------+-------+------------+                                                                                                                        
| empno | ename | hiredate   |                                                                                                                        
+-------+-------+------------+                                                                                                                        
|  7788 | SCOTT | 1996-03-05 |                                                                                                                        
|  7876 | KEVIN | 1999-06-04 |                                                                                                                        
|  7900 | JAMES | 2000-06-23 |                                                                                                                        
|  7902 | FORD  | 1997-12-05 |                                                                                                                        
|  7934 | FORD  | 2000-01-21 |                                                                                                                        
+-------+-------+------------+ 

*/
USE fs;
#write your query here
select empno,ename,hiredate from emp where (job="CLERK" or job="ANALYST") and year(hiredate) between 1996 and 2000;

/* Write an sql query to Retrieve employees with 'ar' anywhere in their nameExpected Output:
+-------+--------+----------+------+------------+---------+---------+--------+                                                                        
| empno | ename  | job      | mgr  | hiredate   | sal     | comm    | deptno |                                                                        
+-------+--------+----------+------+------------+---------+---------+--------+                                                                        
|  7654 | MARTIN | SALESMAN | 7698 | 1998-12-05 | 1250.00 | 1400.00 |     40 |                                                                        
|  7782 | CLARK  | MANAGER  | 7839 | 1993-05-14 | 2450.00 |    NULL |     10 |                                                                        
+-------+--------+----------+------+------------+---------+---------+--------+

*/
USE fs;
#write your query here
select * from emp where ename like '%ar%';

