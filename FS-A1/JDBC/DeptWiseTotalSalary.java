// Implement the Java class "DeptWiseTotalSalary" that retrieves department-wise 
// total salary using JDBC and displays them in the required format.

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

// Output:
// -------
// DEPTNO | DNAME | TOTAL_SALARY
// --------------------------------
// 20     | Research | 15695.0
// 10     | Accounting | 7630.0
// ...

// NOTE:
// - Close ResultSet and Statement
// - Handle exceptions properly

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeptWiseTotalSalary {

    public void fetchDeptWiseSalary(Connection conn){
        String sql="select dept.deptno,dname,sum(sal) as total_sal from dept inner join emp on emp.deptno=dept.deptno group by emp.deptno";
        try(Statement smt=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=smt.executeQuery(sql)){
        System.out.println("DEPTNO | DNAME | TOTAL_SALARY");
        System.out.println("--------------------------------");
        while(rs.next())
        {
            int dept=rs.getInt("deptno");
            String dname=rs.getString("dname");
            double sal=rs.getDouble("total_sal");
            System.out.printf("%d | %-5s | %.1f%n",dept,dname,sal);
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        // Write code here to fetch and print records
        
    }
}