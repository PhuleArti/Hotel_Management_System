
package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;// package 

public class Rooms extends JFrame implements ActionListener{
    
    JTable table;
    JLabel l1,l2,l3,l4,l5;
    JButton back;
    
    Rooms()
    {
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,500,550);
        add(image);
  
        l1= new JLabel("Room number");
        l1.setBounds(10,10,100,20);
        add(l1);
        
        l2= new JLabel("Availability");
        l2.setBounds(120,10,100,20);
        add(l2);
        
         l3= new JLabel("clean-status");
        l3.setBounds(210,10,100,20);
        add(l3);
        
        l4= new JLabel("price");
        l4.setBounds(320,10,100,20);
        add(l4);
        
        l5= new JLabel("bed-type");
        l5.setBounds(400,10,100,20);
        add(l5);
        
        
        
        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        try
        {
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select * from Addroom"); //should be taken into result set object.... present in sql package
          table.setModel(DbUtils.resultSetToTableModel(rs));   // to put data into table
        }
        catch( Exception e)
        {
           e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);
        
       setBounds(300,120,1000,600);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
       setVisible(false);
       new Reception();
    }
    
    public static void main(String args[])
    {
       new Rooms();
    }
}
