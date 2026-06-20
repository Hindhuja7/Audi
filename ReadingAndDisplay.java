import java.io.*;

public class ReadingAndDisplay
{
    public static void main(String[] args) 
	{
       BufferedReader br = null;
        try 
		{
           br = new BufferedReader(new FileReader("C:/CP FS-A1 2027/OCP/23_04_2026/schema.sql"));

            String line;
            StringBuilder sql = new StringBuilder();
            while ((line = br.readLine()) != null) 
			{
                sql.append(line);
                if (line.trim().endsWith(";")) {
                     line = sql.toString();
					System.out.println("line: "+line);
                    sql.setLength(0);
                }
            }
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        } 
		finally 
		{
           
        }
    }
}