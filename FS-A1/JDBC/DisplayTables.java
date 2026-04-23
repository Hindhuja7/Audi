// Implement the Java class "DisplayTables" that retrieves and displays all table 
// names present in the current database (test) using JDBC.

// Tables Available:
// ------------------
// Admissions, Customers, Orders, Patient, dept, emp, salgrade, student_marks, 
// students, transactions

// You are NOT responsible for:
//     -Creating database connection
//     -Writing main() method
    
// Output Format:
// ---------------
// Admissions
// Customers
// Orders
// Patient
// dept
// emp
// salgrade
// student_marks
// students
// transactions

// NOTE:
// Use SQL command SHOW TABLES
// Retrieve table names using ResultSet
// Print only table names (no headers required)
// Ensure proper handling of database resources
// Close ResultSet and Statement
// Handle SQL exceptions appropriately



import java.sql.*;

public class DisplayTables
{
     public void fetchTables(Connection conn)throws SQLException {
        //write your code to here 
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SHOW TABLES");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }
}

    
