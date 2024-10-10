
package airline.management.system.project;
import java.sql.*;

public class Conn
{
    Connection ca;
    Statement s;
       
    public Conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ca=DriverManager.getConnection("jdbc:mysql:///AirlineMgmtSystem","root","Nimisha@2003");
            s=ca.createStatement();
    
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
