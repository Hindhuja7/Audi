1\.

Find employees who earn more than the average salary of all employees.



Expected Output Columns:

\------------------------

+-------+---------+

| ename | sal     |

+-------+---------+



case=1

output=ename   sal                                                                     

JONES   2975.00                                                                 

BLAKE   2850.00                                                                 

CLARK   2450.00                                                                 

SCOTT   3000.00                                                                 

KEVIN   5000.00                                                                 

FORD    3000.00 



**select ename,sal from emp where sal>(select avg(sal) from emp);**



2\.

Find the name and salary of the highest-paid employee.



Expected Output Columns:

\------------------------

+-------+---------+

| ename | sal     |

+-------+---------+



case=1

output=ename   sal                                                                     

KEVIN   5000.00



**select ename,sal from emp where sal=(select max(sal) from emp);**





3\.

Find employees who earn more than the highest-paid employee in department 10.



Expected Output Columns:

\------------------------

+-------+---------+--------+

| ename | sal     | deptno |

+-------+---------+--------+



case=1

output=ename   sal     deptno                                                          

JONES   2975.00 20                                                              

BLAKE   2850.00 30                                                              

SCOTT   3000.00 20                                                              

KEVIN   5000.00 40                                                              

FORD    3000.00 20



**select ename,sal from emp where sal>(select max(sal) from emp where deptno=10);**





4\.

Find employees whose salary is higher than the salary of ‘SCOTT’.



Expected Output Columns:

\------------------------

+-------+---------+

| ename | sal     |

+-------+---------+







case=1

output=ename   sal                                                                     

KEVIN   5000.00



**select ename,sal from emp where sal>(select sal from emp w**here ename="scott");



5\.

Find employee who have the same job title as 'FORD'.



Expected Output Columns:

\------------------------

+-------+---------+

| ename | job     |

+-------+---------+







case=1

output=ename   job                                                                     

SMITH   CLERK                                                                   

SCOTT   ANALYST                                                                 

KEVIN   CLERK                                                                   

JAMES   CLERK                                                                   

FORD    ANALYST                                                                 

FORD    CLERK  



&#x20;**select ename,job from emp where job in (select job from emp where ename="FORD");**



6\.

Find departments that have at least one employee earning more than 3000.



Expected Output Columns:

\------------------------

+--------+------------+

| deptno | dname      |

+--------+------------+







case=1

output=

deptno  dname                                                                   

40      Operations



&#x20;**select deptno,dname from dept where deptno=(select deptno from emp where sal>3000);**



7\.

Find employees who were hired before all employees in department 30.



Expected Output Columns:

\------------------------

+-------+------------+

| ename | hiredate   |

+-------+------------+





case=1

output=ename   hiredate                                                                

KEVIN   1990-06-09



**select ename,hiredate from emp where year(hiredate)<(select min(year(hiredate)) from emp where year(hiredate) in (select year(hiredate) from emp where deptno=30));**



8\.

Find employees who belong to departments located in 'Dallas'.



Expected Output Columns:

\------------------------

+-------+--------+

| ename | deptno |

+-------+--------+







case=1

output=ename   deptno                                                                  

SMITH   20                                                                      

JONES   20                                                                      

SCOTT   20                                                                      

KEVIN   20                                                                      

JAMES   20                                                                      

FORD    20



**select ename,deptno from emp where deptno=(select deptno from dept where location="dallas");**



9\.

Find the second highest salary from employees.



Expected Output Columns:

\------------------------

+-----------------------+

| second\_highest\_salary |

+-----------------------+





case=1

output=second\_highest\_salary                                                           

3000.00 



&#x20;**select sal from emp order by  sal desc limit 1 offset 1;**



10\.

Find employees who have the same manager as ‘BLAKE’.



Expected Output Columns:

\------------------------

+-------+------+

| ename | mgr  |

+-------+------+





case=1

output=ename   mgr                                                                     

JONES   7839                                                                    

CLARK   7839



&#x20;**select ename,mgr from emp where mgr in(select mgr from emp where ename="blake") and ename!="blake";**



11\. 

Find employees who belong to a department with no employees.



Expected Output Columns:

\------------------------

+---------+

| dname   |

+---------+







case=1

output=

+---------+

| dname   |

+---------+

| Finance |

+---------+



**select dname from dept where not exists(select deptno from emp where dept.deptno=emp.deptno);**



12\.

Find the department that has the most employees.



Expected Output Columns:

\------------------------

+--------+----------------+

| deptno | employee\_count |

+--------+----------------+







case=1

output=

+--------+----------------+

| deptno | employee\_count |

+--------+----------------+

|     20 |              6 |

+--------+----------------+



**select deptno,count(\*) from emp group by deptno order by count(\*) desc limit 1 offset 0;**



13\.

&#x20; Find the department name where ‘JONES’ works.



Expected Output Columns:

\------------------------

+----------+

| dname    |

+----------+







case=1

output=

+----------+

| dname    |

+----------+

| Research |

+----------+



&#x20;**select dname from dept where deptno=(select deptno from emp where ename="jones");**



14\.

&#x20; Write a SQL query to find employees whose name contains ‘A’.



Expected Output Columns:

\------------------------

+--------+-------+

| ename  | empno |

+--------+-------+







case=1

output=

+--------+-------+

| ename  | empno |

+--------+-------+

| ALLEN  |  7499 |

| ALLEN  |  7521 |

| MARTIN |  7654 |

| BLAKE  |  7698 |

| CLARK  |  7782 |

| JAMES  |  7900 |

+--------+-------+ 



select ename,empno from emp where ename like '%a%';



15\.

&#x20; Retrieve employees who have a commission greater than their salary.



Expected Output Columns:

\------------------------

+--------+-------+---------+---------+

| ename  | empno | sal     | comm    |

+--------+-------+---------+---------+







case=1

output=

+--------+-------+---------+---------+

| ename  | empno | sal     | comm    |

+--------+-------+---------+---------+

| MARTIN |  7654 | 1250.00 | 1400.00 |

+--------+-------+---------+---------+ 



**select ename,empno,sal,comm from emp where comm>sal;**



16\.

&#x20; Find employees who do not receive commission and whose manager receives commission.



Expected Output Columns:

\------------------------

+-------+-------+------+

| ename | empno | comm |

+-------+-------+------+







case=1

output=

+-------+-------+------+

| ename | empno | comm |

+-------+-------+------+

| JONES |  7566 | NULL |

| BLAKE |  7698 | NULL |

| CLARK |  7782 | NULL |

+-------+-------+------+



**select ename,empno,comm from emp where job="manager";**



17\.

&#x20; Find departments where the number of employees who have a manager is greater than the average number of such employees across all departments.



Expected Output Columns:

\------------------------

+--------+------------------------+

| deptno | employees\_with\_manager |

+--------+------------------------+



**select count(mgr) as cnt,deptno from emp group by deptno having cnt>(select avg(cnt) from (select deptno,count(mgr) as cnt from emp group by deptno) emp);**





case=1

output=

+--------+------------------------+

| deptno | employees\_with\_manager |

+--------+------------------------+

|     20 |                      6 |

+--------+------------------------+



18\.

&#x20; Write a SQL query to find the difference between the highest and second highest salary.



Expected Output Columns:

\------------------------

+-------------------+

| salary\_difference |

+-------------------+







case=1

output=

+-------------------+

| salary\_difference |

+-------------------+

|           2000.00 |

+-------------------+



&#x20;**(select max(sal)-(select sal from emp order by sal desc limit 1 offset 1) from emp);**



19\.

&#x20; Write a SQL query to calculate the total salary and total commission for all employees.



Expected Output Columns:

\------------------------

+--------------+------------------+

| Total Salary | Total Commission |

+--------------+------------------+







case=1

output=

+--------------+------------------+

| total\_salary | total\_commission |

+--------------+------------------+

|     29025.00 |          2200.00 |

+--------------+------------------+



&#x20;**select sum(sal) ,sum(comm) from emp;**



20\.

&#x20; Write a SQL query to calculate the Average salary \& average commission department-wise



Expected Output Columns:

\------------------------

+--------+-------------+----------------+

| deptno | avg\_salary  | avg\_commission |

+--------+-------------+----------------+









case=1

output=

+--------+-------------+----------------+

| deptno | avg\_salary  | avg\_commission |

+--------+-------------+----------------+

|     10 | 1783.333333 |     100.000000 |

|     20 | 1970.833333 |       0.000000 |

|     30 | 1866.666667 |     166.666667 |

|     40 | 3125.000000 |     700.000000 |

+--------+-------------+----------------+



**select avg(sal) ,avg(comm),deptno from emp group by deptno;**



