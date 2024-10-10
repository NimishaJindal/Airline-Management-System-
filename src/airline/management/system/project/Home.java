package airline.management.system.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener
{
   public Home()
    {
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airline/management/system/project/icons/Aeroplane.jpg"));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        Image scaledImage = i1.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel j=new JLabel(scaledIcon);
        j.setBounds(0,0,screenWidth, screenHeight);
        add(j); 
        JLabel j1=new JLabel("INDIGO WELCOMES YOU");
        j1.setBounds(600,20,400,40);
        j1.setForeground(Color.WHITE);
        j1.setFont(new Font("Tahoma",Font.BOLD,30));
        j.add(j1);
        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);
        JMenu m1=new JMenu("Details");
        mb.add(m1);
        JMenuItem mi1=new JMenuItem("Flight Details");
        mi1.addActionListener(this);
        m1.add(mi1);
        JMenuItem mi2=new JMenuItem("Add Customer Details");
        mi2.addActionListener(this);
        m1.add(mi2);
        JMenuItem mi3=new JMenuItem("Book Flight");
        mi3.addActionListener(this);
        m1.add(mi3);
        JMenuItem mi4=new JMenuItem("Journey Details");
        m1.add(mi4);
        mi4.addActionListener(this);
        JMenuItem mi5=new JMenuItem("Cancel Ticket");
        mi5.addActionListener(this);
        m1.add(mi5);  
        JMenu m2=new JMenu("Ticket");
        mb.add(m2);
        JMenuItem Boardingpass=new JMenuItem("Boarding Pass");
        m2.add(Boardingpass);
        Boardingpass.addActionListener(this);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae)
   {
       String s=ae.getActionCommand();
       if (s.equals("Add Customer Details"))
       {
           new Customer();
       }
   
       else if (s.equals("Flight Details"))
       {
           new FlightDetails();
           
       }
       else if(s.equals("Book Flight"))
       {
           new Book();
       }
       else if(s.equals("Journey Details"))
       {
           new JourneyDetails();
       }
       else if(s.equals("Cancel Ticket"))
       {
           new Cancel();
       }
       else if(s.equals("Boarding Pass"))
       {
           new Boarding();
       }
   }
    public static void main(String args[])
    {
        new Home();
    }
}    
    

