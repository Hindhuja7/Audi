// Update 

update emp set job = 'analyst', deptno = 30 where empno = 7876;

update salgrade set losal = 1000;

update dept set deptno = 25;

update emp set mgr = NULL where empno = 7876;

/* Alter statement */

// Add column
alter table customer add(city varchar(10));
select * from customer;
alter table customer add(state varchar(20), country varchar(20) not null);
select * from customer;

// works in mysql 5.7 and 5.6
alter table customer add(city2 varchar(10) after 'city');

// add contraint
desc customer;
alter table customer add primary key(custid);
alter table customer add constraint uk_phone UNIQUE(phone);
desc customer;

// modify column
alter table customer modify column city varchar(20);
update customer set city = "Hyderabad city";
desc customer;
alter table customer modify column city varchar(10);

// Rename a column
alter table customer change city town varchar(20);
desc customer;
alter table customer change column town city varchar(40);
desc customer;

// drop column
alter table customer drop column city;
alter table customer drop column state, drop column country;
select * from customer;

alter table customer drop key uk_phone;

// rename table
rename table emp to employee;

// Delete and truncate

delete from salgrade 
  where grade > 5;

delete from salgrade 
  where grade > 3 and losal < 3000;

delete from salgrade;

/*
SET autocommit = 0; // 0 - Off, 1 - On
start transaction;
delete from emp where deptno = 20;
select ename, deptno from emp;
*/

/*
SET autocommit = 1; 
start transaction;
delete from emp where deptno = 10;
rollback;
select ename, deptno from emp;
*/

/*
SET autocommit = 1; 
delete from emp where deptno = 10;
select ename, deptno from emp;
*/

/*
SET autocommit = 0; 
start transaction;
truncate emp;
commit;
select ename, deptno from emp;
*/

/*
SET autocommit = 0; 
start transaction;
delete from emp;
delete from dept;
delete from salgrade;
commit;
select ename, deptno from emp;
*/

// Where clause not allowed in truncate
truncate emp where deptno = 10;

create table emp1 as select * from emp;

create table emp2 as select * from emp where deptno = 30; 

create table emp3 as select * from emp where 10; 

create table emp4 as select empno, ename, job, deptno from emp where deptno = 20; 

create table emp5 as select * from emp where 1=1;
