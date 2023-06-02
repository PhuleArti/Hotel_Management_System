
package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;// package 

public class SearchRoom extends JFrame implements ActionListener{
    
    JTable table;
    JLabel text,bedtype,l1,l2,l3,l4,l5;
    JButton back,submit;
    JComboBox Bedtype;
    JCheckBox Available;
    SearchRoom()
    {
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
  
        text=new JLabel("Search for room");
        text.setFont(new Font("tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        bedtype=new JLabel("Bed Type");
        //text.setFont(new Font("tahoma",Font.PLAIN,20));
        bedtype.setBounds(50,100,100,20);
        add(bedtype);
        
        Bedtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
        Bedtype.setBounds(150,100,150,25);
        Bedtype.setBackground(Color.WHITE);
        add(Bedtype);
        
        Available =new JCheckBox("Only display Available");
        Available.setBounds(650,100,150,25);
        add(Available);
        
        l1= new JLabel("Room number");
        l1.setBounds(50,160,100,20);
        add(l1);
        
        l2= new JLabel("Availability");
        l2.setBounds(270,160,100,20);
        add(l2);
        
         l3= new JLabel("clean-status");
        l3.setBounds(450,160,100,20);
        add(l3);
        
        l4= new JLabel("price");
        l4.setBounds(670,160,100,20);
        add(l4);
        
        l5= new JLabel("bed-type");
        l5.setBounds(860,160,100,20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
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
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300,500,120,30);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500,500,120,30);
        add(back);
        
       setBounds(300,120,1000,600);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==submit)
       {
           try{
             String query1 ="select * from Addroom where Btype='"+Bedtype.getSelectedItem()+"'";
             String query2 ="select * from Addroom where Availability='Available' AND Btype='"+Bedtype.getSelectedItem()+"'";
             
             Conn conn = new Conn();
             ResultSet rs;
             if(Available.isSelected())
             {
                 rs= conn.s.executeQuery(query2);
             }
             else{
                rs= conn.s.executeQuery(query1);
             }
             
              table.setModel(DbUtils.resultSetToTableModel(rs));
             
           }catch(Exception e)
           {
              e.printStackTrace();
           }
       }
       else{
            setVisible(false);
            new Reception();
       }
    }
    
    public static void main(String args[])
    {
       new SearchRoom();
    }
}
