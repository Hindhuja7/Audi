// Implement the Java class "AboveAverageSal" that retrieves employee details 
// whose salary is greater than the average salary using JDBC and displays them 
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
//     - Creating database connection
//     - Writing main() method

// Output Format:
// --------------
// EMPNO| ENAME | SAL                                                                                                                                   
// -------------------- 
// 7566 | JONES | 2975.00
// ....

// NOTE:
// Ensure proper handling of database resources: Close ResultSet, Statement, and 
// Connection Handle exceptions appropriately.


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

public class AboveAverageSal {
    public void fetchAboveAverageEmployees(Connection conn){
        String sql = "select empno, ename, sal from emp where sal > (select avg(sal) from emp)";

        try (
             Statement smt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = smt.executeQuery(sql)) {
        System.out.println("EMPNO | ENAME | SAL");
        System.out.println("--------------------");
        // print the records from here 
        while (rs.next()) {
                int empno = rs.getInt("empno");
                String name = rs.getString("ename");
                double sal = rs.getDouble("sal");
                System.out.printf("%d | %-5s | %.2f%n", empno, name, sal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        
      }
        

    }

            
}

