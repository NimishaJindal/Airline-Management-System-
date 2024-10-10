
package airline.management.system.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener
{
    JButton b1,b2,b3;
    JTextField tuser,tpass;
    public Login()
    {
        setLayout(null);
        JLabel juser=new JLabel("Username");
        juser.setBounds(20,20,100,20);
        add(juser);
        JLabel jpass=new JLabel("Password");
        jpass.setBounds(20,60,100,20);
        add(jpass);
        tuser=new JTextField();
        tuser.setBounds(130,20,200,20);
        add(tuser);
        tpass=new JPasswordField();
        tpass.setBounds(130,60,200,20);
        add(tpass);
        b1=new JButton("Reset");
        b1.setBounds(40,120,120,20);
        b1.addActionListener(this);
        add(b1);
        b2=new JButton("Submit");
        b2.setBounds(190,120,120,20);
        b2.addActionListener(this);
        add(b2);
        b3=new JButton("Close");
        b3.setBounds(120,160,120,20);
        b3.addActionListener(this);
        add(b3);
     
        setSize(400,250);
        setLocation(600,250);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b2)
        { 
            String username= tuser.getText();
            String password= tpass.getText();
            try
            {
                Conn ca=new Conn();
                String query="Select * from login where username='"+username+"' and password='"+password+"'";
                ResultSet rs=ca.s.executeQuery(query);
                if (rs.next())
                {
                   new Home();
                   setVisible(false);
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    setVisible(false);
                }
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
        
        else if(ae.getSource()==b3)
        {    
           setVisible(false);
        }   
                
        else if(ae.getSource()==b1)
        {
            tuser.setText("");
            tpass.setText("");
            
        }
    }    
 
    public static void main(String args[])
    {
        new Login();
    }
    
}
