To retrive word containing only of certain length we will use 
Example: select * from emp where ename like '_____';

To retrive chars containing anywhere in word
Example: select * from emp where ename like '%ab%';

it doesnt matter u use '%%' or '%' works same
Example: select * from emp where ename like "%%";
select * from emp where ename like "%";

count,avg,max,min,sum only consider integer and decimal
while doing avg internally it calculates sum%count it takes only the values of integer and decimal but not NULL values


mysql>  select ename from emp where ename rlike '[KE]'; retrives containg K or E

WE use if exists while writing query because to ensure safety ,stability 
without it it works better for 1 run but not for many times, we will use IF EXISTS for multiple runs and to avoid system crash

we use decimal(10,2) etc..this represents total 10 digits are allowed after decimal 2 digits ,before decimal 10-2=8 digits.

while inserting values to a table, if we use column names order doesnt matter ,if we use without column name order matters if order mismatches sql throws a error

Unique constraint -> it is used to uniquely identify the attributes,it allows the NULL values than primary key,it checks the uniqueness only for non-null values

MYSQl is case-insensitive by default 

if 2 attributes are mentioned as primary key then mysql internally checks the combination of uniqueness
Example: CREATE TABLE student4(
    firstname VARCHAR(10),
    lastname VARCHAR(10),
    Marks INTEGER,
    PRIMARY KEY(firstname, lastname)
);

Insert into student4 values('ravi','Reddy',40);
Insert into student4 values('Ravi','Reddy',40);  it throws error due to case-insensitive and duplicate entry

when a attribute used as primary key in one table and foreign key in another table , then u cannot delete a value from primary key attribute because it is used as foreign key in another table.

ON DELETE CASCADE - it is used during performing operation on 2 tables when one attribute is primary key and foreign key in another table then it works as when a value is deleted in parent table(primary key attribute) then values related fields/rows are also deleted automatically in child table...but it can dangerous because deletion of one value can lead to deleted of many related rows

ON UPDATE CASCADE - it is used during performing operations on 2 tables when one attribute is primary key and foreign key in another table then it works as when a value is updated in parent table then automatically update the child table values.

indexing of string starts from 1 not 0.

order by sort ascending order by default

if u have custid,totalvalue attributes in a table u are sorting the data..sorting happens in client side or server side?

if it is dynamic data sorting done by server side if it is historical data sorting done by client side


we can use the combination of where and group by but after executing the where clause 

to know a value is inserted or not in a table we use count(*) and where condition

When u want to retrive data from any table consisiting of multiple values of a row then we "in" to retrive any data 
Example: Expected Output Columns:
------------------------
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

select ename,job from emp where job in(select job from emp where ename="FORD");
employee ford has 2 job titles analyst and clerk so we use "in" to retrive both


SELECT * FROM salgrade WHERE grade = 3 or 1=1; , SELECT * FROM salgrade WHERE ""=""; respective of grade=3 it returns all values from table becuase 1=1/""="" return true for all data

select (timestampdiff(year,'2020-10-10',sysdate())) ; it retrives the diff btw yrs from 2020-10-10 to current
select (timestampdiff(day,'2020-10-10',sysdate())) ; it retrives how many days had passed btw start and current
select (timestampdiff(hour,'2020-10-10',sysdate())) ; it retrives how many hours had passed btw start and current


Find employees who belong to a department with no employees.

Expected Output Columns:
------------------------
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

 select dname from dept where not exists(select deptno from emp where dept.deptno=emp.deptno);


17.
  Find departments where the number of employees who have a manager is greater than the average number of such employees across all departments.

Expected Output Columns:
------------------------
+--------+------------------------+
| deptno | employees_with_manager |
+--------+------------------------+

select count(mgr) as cnt,deptno from emp group by deptno having cnt>(select avg(cnt) from (select deptno,count(mgr) as cnt from emp group by deptno) emp);


cross join is used to retrive each and every possible combination from multiple tables 
Example:  Write a SQL query to generate all possible employee-department combinations 
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
+--------+------------+
| ename  | dname      |
+--------+------------+
| SMITH  | Finance    |
| SMITH  | Operations |
| SMITH  | Sales      |
| SMITH  | Research   |
| SMITH  | Accounting |
| ALLEN  | Finance    |
| ALLEN  | Operations |
| ALLEN  | Sales      |
| ALLEN  | Research   |
| ALLEN  | Accounting |
| ALLEN  | Finance    |
| ALLEN  | Operations |
| ALLEN  | Sales      |
| ALLEN  | Research   |
| ALLEN  | Accounting |
| JONES  | Finance    |
| JONES  | Operations |
| JONES  | Sales      |
| JONES  | Research   |
| JONES  | Accounting |
| MARTIN | Finance    |
| MARTIN | Operations |
| MARTIN | Sales      |
| MARTIN | Research   |
| MARTIN | Accounting |
| BLAKE  | Finance    |
| BLAKE  | Operations |
| BLAKE  | Sales      |
| BLAKE  | Research   |
| BLAKE  | Accounting |
| CLARK  | Finance    |
| CLARK  | Operations |
| CLARK  | Sales      |
| CLARK  | Research   |
| CLARK  | Accounting |
| SCOTT  | Finance    |
| SCOTT  | Operations |
| SCOTT  | Sales      |
| SCOTT  | Research   |
| SCOTT  | Accounting |
| KEVIN  | Finance    |
| KEVIN  | Operations |
| KEVIN  | Sales      |
| KEVIN  | Research   |
| KEVIN  | Accounting |
| KEVIN  | Finance    |
| KEVIN  | Operations |
| KEVIN  | Sales      |
| KEVIN  | Research   |
| KEVIN  | Accounting |
| KEVIN  | Finance    |
| KEVIN  | Operations |
| KEVIN  | Sales      |
| KEVIN  | Research   |
| KEVIN  | Accounting |
| JAMES  | Finance    |
| JAMES  | Operations |
| JAMES  | Sales      |
| JAMES  | Research   |
| JAMES  | Accounting |
| FORD   | Finance    |
| FORD   | Operations |
| FORD   | Sales      |
| FORD   | Research   |
| FORD   | Accounting |
| FORD   | Finance    |
| FORD   | Operations |
| FORD   | Sales      |
| FORD   | Research   |
| FORD   | Accounting |
+--------+------------+
70 rows in set (0.01 sec)