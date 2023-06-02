
package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Reception extends JFrame implements ActionListener {
    
    JButton newCustomer , rooms,departments,allemployee,customerinfo,managerinfo,checkout,updatestatus,roomstatus,pickup,searchroom,logout;
    Reception()
    {
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       newCustomer= new JButton("New Customer form");
       newCustomer.setBounds(10,30,200,30);
       newCustomer.setBackground(Color.BLACK);
       newCustomer.setForeground(Color.WHITE);
       newCustomer.addActionListener(this);
       add(newCustomer);
       
       rooms= new JButton("Rooms");
       rooms.setBounds(10,70,200,30);
       rooms.setBackground(Color.BLACK);
       rooms.setForeground(Color.WHITE);
       rooms.addActionListener(this);
       add(rooms);
       
       departments= new JButton("Departments");
       departments.setBounds(10,110,200,30);
       departments.setBackground(Color.BLACK);
       departments.setForeground(Color.WHITE);
       departments.addActionListener(this);
       add(departments);
       
       allemployee= new JButton("All Employee");
       allemployee.setBounds(10,150,200,30);
       allemployee.setBackground(Color.BLACK);
       allemployee.setForeground(Color.WHITE);
       allemployee.addActionListener(this);
       add(allemployee);
       
       customerinfo= new JButton("Customer info");
       customerinfo.setBounds(10,190,200,30);
       customerinfo.setBackground(Color.BLACK);
       customerinfo.setForeground(Color.WHITE);
       customerinfo.addActionListener(this);
       add(customerinfo);
       
       managerinfo= new JButton("Manager info");
       managerinfo.setBounds(10,230,200,30);
       managerinfo.setBackground(Color.BLACK);
       managerinfo.setForeground(Color.WHITE);
       managerinfo.addActionListener(this);
       add(managerinfo);
       
       checkout= new JButton("Checkout");
       checkout.setBounds(10,270,200,30);
       checkout.setBackground(Color.BLACK);
       checkout.setForeground(Color.WHITE);
       add(checkout);
       
       
       updatestatus= new JButton("Update status");
       updatestatus.setBounds(10,310,200,30);
       updatestatus.setBackground(Color.BLACK);
       updatestatus.setForeground(Color.WHITE);
       updatestatus.addActionListener(this);
       add(updatestatus);
       
       roomstatus= new JButton("Update Room status");
       roomstatus.setBounds(10,350,200,30);
       roomstatus.setBackground(Color.BLACK);
       roomstatus.setForeground(Color.WHITE);
       add(roomstatus);
       
       pickup= new JButton("Pickup service");
       pickup.setBounds(10,390,200,30);
       pickup.setBackground(Color.BLACK);
       pickup.setForeground(Color.WHITE);
       add(pickup);
       
       searchroom= new JButton("Search room");
       searchroom.setBounds(10,430,200,30);
       searchroom.setBackground(Color.BLACK);
       searchroom.setForeground(Color.WHITE);
       searchroom.addActionListener(this);
       add(searchroom);
       
       logout= new JButton("Log out");
       logout.setBounds(10,470,200,30);
       logout.setBackground(Color.BLACK);
       logout.setForeground(Color.WHITE);
       add(logout);
       
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
       JLabel image = new JLabel(i1);
       image.setBounds(200,30,600,500);
       add(image);
       
       setBounds(300,170,800,550);
       setVisible(true);
    }
    
    public void actionPerformed( ActionEvent ae)
    {
       if(ae.getSource()== newCustomer)
       {
          setVisible(false);
          new AddCustomer();
       }
       else if(ae.getSource()== rooms)
       {
          setVisible(false);
          new Rooms();
       }
       else if(ae.getSource()== departments)
       {
           setVisible(false);
           new Departments();
       }
       else if(ae.getSource()== allemployee)
       {
           setVisible(false);
           new Employees();
       }
       else if(ae.getSource()== managerinfo)
       {
           setVisible(false);
           new ManagerInfo();
       }
       else if(ae.getSource()== customerinfo)
       {
           setVisible(false);
           new Customers();
       }
       else if(ae.getSource()==searchroom)
       {
          setVisible(false);
          new SearchRoom();
       }
       else if(ae.getSource()==updatestatus)
       {
          setVisible(false);
          new UpdateCheck();
       }
    }
    public static void main(String args[])
    {
      new Reception();
    }
}
