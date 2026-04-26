import java.sql.*;
public class basic_jdbc {
    public static void main(String[] args)
    {
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/a1",
                "root",
                "Hindhuja@7"
            );
            Statement smt=conn.createStatement();
            ResultSet rs=smt.executeQuery("select * from emp");
            while(rs.next())
            {
                int id=rs.getInt("empno");
                String name=rs.getString("ename");
                System.out.println(id+" "+name);
            }
            conn.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }

    }
}
