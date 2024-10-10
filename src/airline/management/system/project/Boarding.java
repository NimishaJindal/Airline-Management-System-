package airline.management.system.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Boarding extends JFrame implements ActionListener
{
    JTextField t1;
    JLabel t2,t3,t4,t5,t6,t7,t8;
    JButton b1; 

    public Boarding()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1=new JLabel("INDIGO");
        l1.setBounds(420,20,500,35);
        l1.setFont(new Font("Tohama",Font.BOLD,24));
        add(l1);
        
        JLabel l2=new JLabel("Boarding Pass");
        l2.setBounds(380,50,500,35);
        l2.setFont(new Font("Tohama",Font.BOLD,24));
        add(l2);
        
        
        JLabel l3=new JLabel("PNR Details");
        l3.setBounds(60,100,150,25);
        l3.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l3);
        
        t1=new JTextField();
        t1.setBounds(200,100,150,25);
        add(t1);
        
        b1=new JButton("Enter");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(360,100,150,25);
        b1.addActionListener(this);
        add(b1);
        
        JLabel l4=new JLabel("Name");
        l4.setBounds(60,150,150,25);
        l4.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l4);
        
        t2=new JLabel();
        t2.setBounds(200,150,150,25);
        add(t2);
       
        JLabel l5=new JLabel("Nationality");
        l5.setBounds(60,200,150,25);
        l5.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l5);
       
        t3=new JLabel();
        t3.setBounds(200,200,150,25);
        add(t3);

        JLabel l6=new JLabel("Source");
        l6.setBounds(60,250,150,25);
        l6.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l6);
        
        t4=new JLabel();
        t4.setBounds(200,250,150,25);
        add(t4);

        JLabel l7=new JLabel("Destination");
        l7.setBounds(300,250,150,25);
        l7.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l7);
        
        t5=new JLabel();
        t5.setBounds(460,250,150,25);
        add(t5);

        JLabel l8=new JLabel("Flight Name");
        l8.setBounds(60,300,150,25);
        l8.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l8);
        
        t6=new JLabel();
        t6.setBounds(200,300,150,25);
        add(t6);
   
        JLabel l9=new JLabel("Flight Code");
        l9.setBounds(300,300,150,25);
        l9.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l9);
        
        t7=new JLabel();
        t7.setBounds(360,500,150,25);
        add(t7);
        
        JLabel l10=new JLabel("Date");
        l10.setBounds(60,350,150,25);
        l10.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l10);
        
        t8=new JLabel();
        t8.setBounds(200,350,150,25);
        add(t8);
        
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("airline/management/system/project/icons/logo.png"));
        JLabel l=new JLabel(i);
        l.setBounds(600,50,300,300);
        add(l);
     
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
        
    }

   
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==b1)
        {
          String a=t1.getText();
         
          try
          {
              Conn c=new Conn();
              String query="select * from reservation where PNR='"+a+"'";
              ResultSet rs=c.s.executeQuery(query);
              
              if (rs.next())
              {
                  t2.setText(rs.getString("name"));
                  t3.setText(rs.getString("nationality"));
                  t4.setText(rs.getString("src"));
                  t5.setText(rs.getString("des"));
                  t6.setText(rs.getString("flightname"));
                  t7.setText(rs.getString("flightcode"));
                  t8.setText(rs.getString("ddate"));
                  
              }
              else
              {
                  JOptionPane.showMessageDialog(null,"Please Enter correct PNR Details");
                  
              }
          }
        
    catch(Exception e)
    {
        System.out.println(e);
    }
        }
    }
    public static void main (String args[])
    {
        new Boarding();
       
    }
}    


