package airline.management.system.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener
{
    JTextField t1;
    JLabel t2,t3,t4,t5;
    JButton b1,b2; 
   
    public Cancel()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1=new JLabel("CANCELLATION");
        l1.setBounds(300,20,500,35);
        l1.setFont(new Font("Tohama",Font.BOLD,24));
        add(l1);
        
        JLabel l2=new JLabel("PNR NO");
        l2.setBounds(60,100,150,25);
        l2.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l2);
        
        t1=new JTextField();
        t1.setBounds(250,100,150,25);
        add(t1);
        
        b1=new JButton("Show Details");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(410,100,150,25);
        b1.addActionListener(this);
        add(b1);
        
        
        JLabel l4=new JLabel("CANCELLATION NO");
        l4.setBounds(60,150,180,25);
        l4.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l4);
        
        Random r=new Random();
        t3=new JLabel(""+r.nextInt(1000000));
        t3.setBounds(250,150,150,25);
        add(t3);
     
        JLabel l3=new JLabel("Name");
        l3.setBounds(60,200,150,25);
        l3.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l3);
    
        t2=new JLabel();
        t2.setBounds(200,200,150,25);
        add(t2);

        JLabel l5=new JLabel("Flight Code");
        l5.setBounds(60,250,150,25);
        l5.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l5);
        
        t4=new JLabel();
        t4.setBounds(200,250,150,25);
        add(t4);
        
        JLabel l6=new JLabel("Date");
        l6.setBounds(60,300,150,25);
        l6.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l6);
        
        t5=new JLabel();
        t5.setBounds(200,300,150,25);
        add(t5);
   
        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300,350,150,25);
        b2.addActionListener(this);
        add(b2);

        setSize(800,500);
        setLocation(350,150);
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
              String query="Select * from reservation where PNR='"+a+"'";
              ResultSet rs=c.s.executeQuery(query);
              
              if (rs.next())
              {
                  t2.setText(rs.getString("name"));
                  t4.setText(rs.getString("flightcode"));
                  t5.setText(rs.getString("ddate"));
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

            String name = t2.getText(); 
            String pnr= t1.getText();
            String cancelno= t3.getText(); 
            String fcode = t4.getText();
            String date = t5.getText();
            
            try
           {
              Conn c=new Conn();
              String query="insert into cancel values('"+pnr+"' ,'"+name+"' , '"+cancelno+"' , '"+fcode+"' ,'"+date+"')";
              c.s.executeUpdate(query);
              c.s.executeUpdate("Delete from reservation where PNR='"+pnr+"'");
                     
              JOptionPane.showMessageDialog(null,"Ticket Cancelled");
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
        new Cancel();
       
    }
}    


