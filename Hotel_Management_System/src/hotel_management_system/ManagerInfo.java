
package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener{
    
     JTable table;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton back;
    
    ManagerInfo()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        l1= new JLabel("Name");
        l1.setBounds(20,10,100,20);
        add(l1);
        
        l2= new JLabel("Age");
        l2.setBounds(150,10,100,20);
        add(l2);
        
         l3= new JLabel("gender");
        l3.setBounds(300,10,100,20);
        add(l3);
        
        l4= new JLabel("job");
        l4.setBounds(420,10,100,20);
        add(l4);
        
        l5= new JLabel("salary");
        l5.setBounds(530,10,100,20);
        add(l5);
        
        l6= new JLabel("phone");
        l6.setBounds(650,10,100,20);
        add(l6);
        
        l7= new JLabel("email");
        l7.setBounds(780,10,100,20);
        add(l7);
        
        l8= new JLabel("Aadhar");
        l8.setBounds(900,10,100,20);
        add(l8);
        
         back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(400,400,120,30);
        add(back);
        
         table = new JTable();
        table.setBounds(0,40,1000,550);
        add(table);
        
        try
        {
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select * from Employee where job='Manager'"); //should be taken into result set object.... present in sql package
          table.setModel(DbUtils.resultSetToTableModel(rs));   // to put data into table
        }
        catch( Exception e)
        {
           e.printStackTrace();
        }
           
       
        
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
        new ManagerInfo();
    }
}
