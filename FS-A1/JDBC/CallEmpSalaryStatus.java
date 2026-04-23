// /Implement the Java class "EmpSalaryStats" that retrieves maximum salary, 
// minimum salary, and average salary of employees for a given department number, 
// using a stored procedure (CallableStatement) in JDBC, and displays them in the 
// required format.

// Tables:
// --------
// emp ==> empno int(4) primary key,ename varchar(50) not null,job varchar(50) not null,
//         mgr int(4),hiredate date,sal decimal(10,2),comm decimal(10,2),deptno int(2)

// You are NOT responsible for:
//     -Creating database connection
//     -Writing main() method

// Input : 20
// -------
// Output Format:
// --------------
// Max Salary : 3000.0
// Min Salary : 800.0
// Avg Salary : 1970.83

// DELIMITER $$

// CREATE PROCEDURE empSalaryStats(
//     IN p_deptno INT,
//     OUT maxSal DECIMAL(10,2),
//     OUT minSal DECIMAL(10,2),
//     OUT avgSal DECIMAL(10,2)
// )
// BEGIN
//     SELECT 
//         MAX(sal), MIN(sal), AVG(sal)
//     INTO 
//         maxSal, minSal, avgSal
//     FROM emp
//     WHERE deptno = p_deptno;
// END $$

// DELIMITER ;

// CALL empSalaryStats(20, @max, @min, @avg);

// SELECT @max, @min, @avg;

// */

import java.sql.*;
import java.util.*;

public class CallEmpSalaryStatus {
   public void fetchEmpSalaryStatus(Connection conn) throws SQLException{
       //Write your code here
   }

}
