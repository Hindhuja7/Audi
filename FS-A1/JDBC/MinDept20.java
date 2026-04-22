// Implement the Java class "MinDept20" that retrieves employees whose salary is 
// greater than the minimum salary of department 20 using JDBC and displays them 
// in the required format.

// Tables:
// ------
// salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

// dept==>   
// deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

// emp ==>   empno int(4) primary key, ename varchar(50) not null,
//           job varchar(50) not null,  mgr int(4),  hiredate date,
//           sal decimal(10,2),  comm decimal(10,2),  deptno int(2)
          
// You are NOT responsible for:
// - Creating database connection
// - Writing main() method

// Output Format:
// EMPNO | ENAME | SAL
// --------------------
// 7499  | ALLEN | 2520.0
// ...

// NOTE:
// Close ResultSet and Statement
// Handle exceptions properly

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MinDept20 {

    public void fetchEmployees(Connection conn){
        String sql="select empno,ename,sal from emp where sal>(select min(sal) from emp where deptno=20)";
        try(Statement smt=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=smt.executeQuery(sql)){
        System.out.println("EMPNO | ENAME | SAL");
        System.out.println("--------------------");
        while(rs.next())
        {
            int emp=rs.getInt("empno");
            String ename=rs.getString("ename");
            double sal=rs.getDouble("sal");
            System.out.printf("%d | %-5s | %.1f%n",emp,ename,sal);
        }
        // Write code here to fetch and print records
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}