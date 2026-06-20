USE test;

START TRANSACTION;

select count(*) from emp;

insert into emp values (8143,'Ravi','Manager',7839,'93/6/13',800,0.00,20);

SELECT * FROM emp;

SAVEPOINT tran1;

insert into emp values (8343,'Teja','Manager',7839,'93/6/13',800,0.00,20);

SELECT * FROM emp;

SAVEPOINT tran2;

ROLLBACK TO tran2;

SELECT  * FROM    emp;

ROLLBACK TO tran1;

SELECT  * FROM    emp;

/* Update line 19 with Commit */