package airline.management.system.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class JourneyDetails extends JFrame implements ActionListener
{
    JTable t;
    JTextField tf;
    JButton b;
    public JourneyDetails()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel l=new JLabel("PNR Details");
        l.setFont(new Font("Tohama",Font.BOLD,20));
        l.setBounds(50,50,160,25);
        add(l);
        
        tf=new JTextField();
        tf.setBounds(170,50,120,25);
        add(tf);
        
        b=new JButton("Show Details");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(290,50,120,25);
        b.addActionListener(this);
        add(b);
    
        t=new JTable();
        JScrollPane s=new JScrollPane(t);
        s.setBounds(0,80,800,150);
        s.setBackground(Color.WHITE);
        add(s);
        
        setSize(800,600);
        setLocation(400,150);
        setVisible(true);
     
    }
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from reservation where PNR='"+tf.getText()+"'");
            if(!rs.isBeforeFirst())
            {
                JOptionPane.showMessageDialog(null,"No Details Found");
                return;
            }
            t.setModel(DbUtils.resultSetToTableModel(rs));
        }    
        catch(Exception e)
        {
            System.out.println(e);
           
        }
    }
    public static void main(String args[])
    {
        new JourneyDetails();
    }
    
}