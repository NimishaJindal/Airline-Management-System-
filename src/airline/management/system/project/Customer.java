
package airline.management.system.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Customer extends JFrame implements ActionListener
{
    JTextField t1,t2,t3,t4,t5;
    JRadioButton b1,b2;
    public Customer()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1=new JLabel("ENTER CUSTOMER DETAILS");
        l1.setBounds(250,20,500,35);
        l1.setFont(new Font("Tohama",Font.BOLD,24));
        add(l1);
        
        JLabel l2=new JLabel("Name");
        l2.setBounds(60,100,150,25);
        l2.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l2);
        
        t1=new JTextField();
        t1.setBounds(200,100,150,25);
        add(t1);
        
        JLabel l3=new JLabel("Nationality");
        l3.setBounds(60,150,150,25);
        l3.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l3);
        
        t2=new JTextField();
        t2.setBounds(200,150,150,25);
        add(t2);
        
            
        JLabel l4=new JLabel("Aadhar Number");
        l4.setBounds(60,200,150,25);
        l4.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l4);
        
        t3=new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);
        
        JLabel l5=new JLabel("Address");
        l5.setBounds(60,250,150,25);
        l5.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l5);
        
        t4=new JTextField();
        t4.setBounds(200,250,150,25);
        add(t4);
        
        JLabel l6=new JLabel("Gender");
        l6.setBounds(60,300,150,25);
        l6.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l6);
        
        b1=new JRadioButton("Male");
        b1.setBounds(200,300,70,25);
        add(b1);
        
        b2=new JRadioButton("Female");
        b2.setBounds(280,300,70,25);
        add(b2);
        
        ButtonGroup b3=new ButtonGroup();
        b3.add(b1);
        b3.add(b2);
       
        JLabel l7=new JLabel("Phone");
        l7.setBounds(60,350,150,25);
        l7.setFont(new Font("Tohama",Font.PLAIN,18));
        add(l7);
        
        t5=new JTextField();
        t5.setBounds(200,350,150,25);
        add(t5);
        
        JButton b = new JButton("SAVE");
        b.setForeground(Color.WHITE);
        b.setBackground(Color.BLACK);
        b.setBounds(200,400,150,25);
        b.addActionListener(this);
        add(b);
        
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("airline/management/system/project/icons/Customers1.png"));
        JLabel l=new JLabel(i);
        l.setBounds(400,80,396,393);
        add(l);
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);  
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s1=t1.getText();
        String s2=t2.getText();
        String s3=t3.getText();
        String s4=t4.getText();
        String s5=t5.getText();
        String s6=null;
        if(b1.isSelected())
        {
            s6="Male";
        }
        else
        {
            s6="Female";
        }
    try
    {
        Conn c=new Conn();
        String query="insert into People values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Customer Details Added Successfully!!!");
        setVisible(false);
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    }                
 
    public static void main (String args[])
    {
        new Customer();
       
    }
}    


