// Implement the Java class "MaxDeptSalary" that retrieves all employees who belong
// to the department having the highest total salary using JDBC and displays them 
// in the required format.

// Tables:
// ------
// salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

// dept==>   
// deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

// emp ==>   empno int(4) primary key, ename varchar(50) not null,
//           job varchar(50) not null,  mgr int(4),  hiredate date,
//           sal decimal(10,2),  comm decimal(10,2),  deptno int(2)
          
// Output:
// -------
// EMPNO | ENAME | DEPTNO
// ------------------------
// 7369  | SMITH | 20
// ...

// You are NOT responsible for:
// - Creating database connection
// - Writing main() method

// NOTE:
// - Close ResultSet and Statement
// - Handle exceptions properly

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MaxDeptSalary {

    public void fetchMaxDeptEmployees(Connection conn) {
        String sql="select empno,ename,deptno from emp where deptno=(select deptno from emp group by deptno order by sum(sal) desc limit 1);";
        try(Statement smt=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=smt.executeQuery(sql)){
        System.out.println("EMPNO | ENAME | DEPTNO");
        System.out.println("------------------------");
        while(rs.next())
        {
            int emp=rs.getInt("empno");
            String ename=rs.getString("ename");
            int dept=rs.getInt("deptno");
            System.out.printf("%d | %-5s | %d%n",emp,ename,dept);
        }
        // Write code here to fetch and print records
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}