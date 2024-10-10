package airline.management.system.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Book extends JFrame implements ActionListener
{
    JTextField t1;
    JLabel t2,t3,t4,t5,t6,t7;
    JButton b1,b2,b3; 
    Choice c1,c2;
    JDateChooser c3;

    public Book()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1=new JLabel("BOOK FLIGHT");
        l1.setBounds(400,20,500,35);
        l1.setFont(new Font("Tohama",Font.BOLD,24));
        add(l1);
        
        JLabel l2=new JLabel("Aadhar Number");
        l2.setBounds(60,100,150,25);
        l2.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l2);
        
        t1=new JTextField();
        t1.setBounds(200,100,150,25);
        add(t1);
        
        b1=new JButton("Fetch");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(360,100,150,25);
        b1.addActionListener(this);
        add(b1);
        
        JLabel l3=new JLabel("Name");
        l3.setBounds(60,150,150,25);
        l3.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l3);
        
        t2=new JLabel();
        t2.setBounds(200,150,150,25);
        add(t2);
        
        
        JLabel l4=new JLabel("Nationality");
        l4.setBounds(60,200,150,25);
        l4.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l4);
        
        
        t3=new JLabel();
        t3.setBounds(200,200,150,25);
        add(t3);
        
        JLabel l5=new JLabel("Address");
        l5.setBounds(60,250,150,25);
        l5.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l5);
        t4=new JLabel();
        t4.setBounds(200,250,150,25);
        add(t4);
        
        JLabel l6=new JLabel("Gender");
        l6.setBounds(60,300,150,25);
        l6.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l6);
        
        t5=new JLabel("Gender");
        t5.setBounds(200,300,150,25);
        add(t5);
        
        JLabel l7=new JLabel("Source");
        l7.setBounds(60,350,150,25);
        l7.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l7);
        
        c1=new Choice();
        c1.setBounds(210,350,150,25);
        add(c1);
      
        JLabel l8=new JLabel("Destination");
        l8.setBounds(60,400,150,25);
        l8.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l8);
        
        c2=new Choice();
        c2.setBounds(210,400,150,25);
        add(c2);
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from fdetails");
            while(rs.next())
            {
                c1.add(rs.getString("f_src"));
                c2.add(rs.getString("f_dest"));

            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        b2=new JButton("Fetch Flights");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(370,400,150,25);
        b2.addActionListener(this);
        add(b2);
        
       
        JLabel l9=new JLabel("Flight Name");
        l9.setBounds(60,450,150,25);
        l9.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l9);
        
        t6=new JLabel();
        t6.setBounds(200,450,150,25);
        add(t6);
       
        JLabel l10=new JLabel("Flight Code");
        l10.setBounds(60,500,150,25);
        l10.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l10);
        
        t7=new JLabel();
        t7.setBounds(200,500,150,25);
        add(t7);
        
        JLabel l11=new JLabel("Date Of Arrival");
        l11.setBounds(60,550,150,25);
        l11.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l11);
        
        c3=new JDateChooser();
        c3.setBounds(200,550,150,25);
        add(c3);
        
        b3=new JButton("Book Flights");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(200,600,150,25);
        b3.addActionListener(this);
        add(b3);
     
        setSize(1050,750);
        setLocation(200,50);
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
              String query="Select * from People where s3='"+a+"'";
              ResultSet rs=c.s.executeQuery(query);
              
              if (rs.next())
              {
                  t2.setText(rs.getString("s1"));
                  t3.setText(rs.getString("s2"));
                  t4.setText(rs.getString("s4"));
                  t5.setText(rs.getString("s6"));
              }
              else
              {
                  JOptionPane.showMessageDialog(null,"Please Enter correct Aadhar");
                  
              }
          }
        
    catch(Exception e)
    {
        System.out.println(e);
    }
        }
        else if (ae.getSource()==b2)
            
            {
              String p=c1.getSelectedItem();
              String q=c2.getSelectedItem();

        try
           {
              Conn c=new Conn();
              String query="Select * from fdetails where f_src='"+p+"' and f_dest='"+q+"'";
              ResultSet rs=c.s.executeQuery(query);
              
              if(rs.next())
              {
                  t6.setText(rs.getString("f_name"));
                  t7.setText(rs.getString("f_code"));
                
              }
              else
              {
                  JOptionPane.showMessageDialog(null,"No Flights Found");
                  
              }
 
            }
          catch(Exception e)
           {
              System.out.println(e);
              
           }
            }
 
        else
        {
            Random r=new Random();
            
            
            String aadhar = t1.getText();
            String name = t2.getText(); 
            String nationality = t3.getText();
            String flightname = t5.getText(); 
            String flightcode = t6.getText();
            String src = c1.getSelectedItem(); 
            String des = c2.getSelectedItem();
            String ddate = ((JTextField) c3.getDateEditor().getUiComponent()).getText();
            
            try
           {
              Conn c=new Conn();
              String query="insert into reservation values('PNR-"+r.nextInt(1000000)+"' , 'TICKET-"+r.nextInt(10000)+"' ,'"+aadhar+"' , '"+name+"' , '"+nationality+"' , '"+flightname+"' ,' "+flightcode+"' , '"+src+"' , '"+des+"','"+ddate+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Ticket Updated Successfully");
              setVisible(false);
           }

catch(Exception e)
{
    System.out.println(e);
}
}
}
     
    public static void main (String args[])
    {
        new Book();
       
    }
}    


