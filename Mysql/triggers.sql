# -----------------------------------------
# MySQL does not allow the ROLLBACK statement itself within 
# procedures and triggers.

use test;

DROP TABLE IF EXISTS emp_audit;

CREATE TABLE emp_audit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    empno INT NOT NULL,
    ename VARCHAR(50) NOT NULL,
    changedat DATETIME DEFAULT NULL,
    action VARCHAR(50) DEFAULT NULL
);

DROP TRIGGER IF EXISTS before_emp_update;

DELIMITER $$
CREATE TRIGGER before_emp_update 
    BEFORE UPDATE ON emp
    FOR EACH ROW 
BEGIN
    INSERT INTO emp_audit
    SET action = 'Before update',
      empno = OLD.empno,
      ename = OLD.ename,
      changedat = NOW(); 
END$$
DELIMITER ;


DROP TRIGGER IF EXISTS after_emp_update;

DELIMITER $$
CREATE TRIGGER after_emp_update 
    AFTER UPDATE ON emp
    FOR EACH ROW 
BEGIN
    INSERT INTO emp_audit
    SET action = 'After update',
      empno = NEW.empno,
      ename = NEW.ename,
      changedat = NOW(); 
END$$
DELIMITER ;

update emp set sal = '5000' where empno = 7876;
update emp set job = 'analyst', deptno = 30 where empno = 7876;

select * from emp_audit;

# -----------------------------------------

DROP TRIGGER IF EXISTS after_insert_emp;

DELIMITER $$
CREATE TRIGGER after_insert_emp 
    AFTER INSERT ON emp
    FOR EACH ROW 
BEGIN
    INSERT INTO emp_audit
    SET action = 'After insert',
      empno = NEW.empno,
      ename = NEW.ename,
      changedat = NOW(); 
END$$
DELIMITER ;

insert into emp values (9999,'David','Manager',7902,'93/6/13',800,0.00,20);
insert into emp values (8888,'Roger','Manager',7902,'93/6/13',800,0.00,20);

select * from emp_audit;

# -----------------------------------------

DROP TRIGGER IF EXISTS after_delete_emp;

DELIMITER $$
CREATE TRIGGER after_delete_emp 
    AFTER DELETE ON emp
    FOR EACH ROW 
BEGIN
    INSERT INTO emp_audit
    SET action = 'After delete',
      empno = OLD.empno,
      ename = OLD.ename,
      changedat = NOW(); 
END$$
DELIMITER ;

delete from emp where empno = 9999;
delete from emp where empno = 8888;

select * from emp_audit;

# -----------------------------------------

DROP TRIGGER IF EXISTS cust_age_check_before_insert;

DELIMITER $$

CREATE TRIGGER cust_age_check_before_insert 
  BEFORE INSERT ON customers 
  FOR EACH ROW 
BEGIN 
  IF NEW.age<18 THEN 
  SET NEW.age=18; 
  END IF; 
END$$
DELIMITER ;


# SIGNAL is the way to “return” an error. SIGNAL provides error information
# to a handler, to an outer portion of the application, or to the client.
# The condition_value in a SIGNAL statement indicates the error value to be 
# returned. It can be an SQLSTATE value (a 5-character string literal)

DROP TRIGGER IF EXISTS cust_age_check_before_insert2;

DELIMITER $$
CREATE TRIGGER cust_age_check_before_insert2
  BEFORE INSERT ON customers 
FOR EACH ROW
BEGIN
    IF NEW.AGE < 18 THEN
        SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'check constraint on Test.AGE failed';
    END IF;
END$$   
DELIMITER ; 