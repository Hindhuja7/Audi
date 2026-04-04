# -----------------------------------------

use test;

DROP VIEW IF EXISTS empDetails;

CREATE VIEW empDetails AS
SELECT 
    empno, ename, job, comm, deptno, count(job) as total 
FROM
    emp
GROUP by job
ORDER BY ename;

select * from empDetails;

# following will throw an error as the view is not updatable
update empDetails set ename='newName';

# -----------------------------------------

CREATE VIEW empInfo
 AS 
   select empno, ename, job, comm
   FROM emp;

select * from empInfo;

UPDATE empInfo 
SET 
    job = 'CEO'
WHERE
    job = 'Manager';

select * from emp;

select * from empInfo;

# -----------------------------------------

SELECT 
    table_name, is_updatable
FROM
    information_schema.views;

# -----------------------------------------

DROP VIEW IF EXISTS empDept;

CREATE or REPLACE VIEW empDept AS
  select emp.empno, emp.ename, dept.dname, emp.job
  from emp
  inner join dept
  on emp.deptno=dept.deptno
  ORDER BY ename;

select * from empDept;

-- Show Create View empDept;

Alter view empDept
As
  select emp.empno, emp.ename, dept.dname
  from emp
  inner join dept
  on emp.deptno=dept.deptno;

select * from empDept;

update empDept set ename='raj' where ename ='Allen';

select * from emp;
select * from empDept;
