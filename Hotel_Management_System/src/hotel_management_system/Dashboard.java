
package hotel_management_system;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard()
    {
        setBounds(0,0,1550,1000);
         
        setLayout(null);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
         //to crop image we use image object 2
         Image i2= i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
         //we cannot place image class object on jlabel directly it gives error    
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,1550,1000);
         add(image);
         
         JLabel text = new JLabel("Taj group");
         text.setBounds(400,80,1000,50);
         image.add(text);
         text.setFont(new Font("Tahoma",Font.PLAIN,45));
         
         //menu add in menubar    menuitem add in menubar
         JMenuBar mb = new JMenuBar();
         mb.setBounds(0,0,1500,30);
         image.add(mb);
         
         JMenu hotel = new JMenu("Hotel management");
         hotel.setForeground(Color.RED);
         mb.add(hotel);
         
         JMenuItem reception = new JMenuItem("Reception");
         reception.setForeground(Color.RED);
         reception.addActionListener(this);
         hotel.add(reception);
         
         JMenu admin = new JMenu("Admin");
         admin.setForeground(Color.RED);
         mb.add(admin);
         
         JMenuItem addemployee = new JMenuItem("Add Employees");
         addemployee.setForeground(Color.RED);
         addemployee.addActionListener(this);
         admin.add(addemployee);
         
         JMenuItem addroom = new JMenuItem("Add Rooms");
         addroom.setForeground(Color.RED);
         addroom.addActionListener(this);
         admin.add(addroom);
         
         JMenuItem addDriver = new JMenuItem("Add Drivers");
         addDriver.setForeground(Color.RED);
         addDriver.addActionListener(this);
         admin.add(addDriver);
         
         setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Add Employees"))//to check menu options
        {
           new AddEmployee();
        }
        else if(ae.getActionCommand().equals("Add Rooms"))
        {
          new AddRooms();
        }
        else if(ae.getActionCommand().equals("Add Drivers"))
        {
           new AddDriver();
        }
        else if(ae.getActionCommand().equals("Reception"))
        {
           new Reception();
        }
    }
    public static void main(String args[])
    {
         new Dashboard();
    }
    
}
