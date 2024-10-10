
package airline.management.system.project;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class FlightDetails extends JFrame 
{
    public FlightDetails()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JTable t=new JTable();
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from fdetails");
            t.setModel(DbUtils.resultSetToTableModel(rs));
        }    
        catch(Exception e)
        {
            System.out.println(e);
           
        }
       
        JScrollPane s=new JScrollPane(t);
        s.setBounds(0,0,800,500);
        add(s);
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
     
    }
    public static void main(String args[])
    {
        new FlightDetails();
    }
    
}
