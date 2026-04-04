select * from emp where deptno = getDewp
(select deptno from dept where dname = "operations");

select * from emp where deptno in
(select deptno from dept where location = "boston");

select * from emp where deptno not in
(select deptno from dept where location = "boston");
/* Test with greater than (>), less than < etc */

select ename, empno, sal
from emp
where sal = (
select max(sal) from emp
);

select avg(sal) from emp;

select ename, empno, sal
from emp
where sal < (
select avg(sal) from emp
);

select ename, empno, sal, avg(sal), count(*)
from emp
where sal < (
select avg(sal) from emp
);

select deptno, dname
from dept
where
deptno in (select distinct(deptno) from dept);


select ename, sal, deptno
from emp
where
deptno in (select deptno from dept where deptno > 20);
