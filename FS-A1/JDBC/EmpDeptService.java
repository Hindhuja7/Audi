// Implement the Java class "EmpDeptService" that retrieves employee details such 
// as empno, ename, job, deptno, dname, and location for a given department number, 
// using PreparedStatement in JDBC, and displays them in the required format.

// Tables:
// --------
// dept ==>deptno int(2) primary key,dname varchar(50) not null,
//         location varchar(50) not null

// emp ==>empno int(4) primary key,ename varchar(50) not null,job varchar(50) not null,
//         mgr int(4),hiredate date,sal decimal(10,2),comm decimal(10,2),deptno int(2)

// You are NOT responsible for:
//     - Creating database connection
//     - Writing main() method
// Input : 
// --------
// 20
// Output :
// --------
// EmpNo	EName	Job	DeptNo	DeptName	Location
// 7369	SMITH	CLERK	20	Research	Dallas
// 7566	JONES	MANAGER	20	Research	Dallas
// 7788	SCOTT	ANALYST	20	Research	Dallas
// 7876	KEVIN	CLERK	20	Research	Dallas
// 7900	JAMES	CLERK	20	Research	Dallas
// 7902	FORD	ANALYST	20	Research	Dallas 

// NOTE:
// Use PreparedStatement with parameterized query (?)
// Use INNER JOIN between emp and dept tables
// Read department number from input
// Ensure proper handling of database resources
// Close ResultSet and PreparedStatement
// Handle SQL exceptions appropriately
 

import java.sql.*;
import java.util.*;


public class EmpDeptService {

    public void fetchEmpDeptDetails(Connection conn)throws SQLException {

        //Write your code here
        }
    }
