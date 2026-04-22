// Implement the Java class "NewYorkEmployees" that retrieves employees working in 
// the NEW YORK location using JDBC and displays them in the required format.

// Tables:
// ------
// salgrade ==> grade int(4) primary key, losal decimal(10,2),  hisal decimal(10,2) 

// dept==>   
// deptno int(2) primary key, dname varchar(50) not null, location varchar(50) not null

// emp ==>   empno int(4) primary key, ename varchar(50) not null,
//           job varchar(50) not null,  mgr int(4),  hiredate date,
//           sal decimal(10,2),  comm decimal(10,2),  deptno int(2)

// You are NOT responsible for:
// Creating database connection
// Writing main() method

// Output Format:

// EMPNO | ENAME
// ----------------
// 7499  | ALLEN
// 7782  | CLARK
// 7934  | FORD
// ...

// NOTE:
// Close ResultSet and Statement
// Handle exceptions properly
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewYorkEmployees {

    public void fetchNewYorkEmployees(Connection conn) {
        String sql="select empno,ename from emp where deptno in (select deptno from dept where location='new york')";
        try(Statement ps=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=ps.executeQuery(sql))
        {
            System.out.println("EMPNO | ENAME");
            System.out.println("----------------");
            while(rs.next())
            {
                int emp=rs.getInt("empno");
                String ename=rs.getString("ename");
                System.out.printf("%d | %-5s%n",emp,ename);
            }
            // Write code here to fetch and print records
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}