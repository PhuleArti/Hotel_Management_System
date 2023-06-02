
package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoomCheck extends JFrame implements ActionListener{
    
    JLabel text,lblid,lblroom,lblname,lblcheckin;
    Choice ccustomer;
     JTextField tfroom,tfname,tfcheckin,tfavailable,tfstatus;
    JButton Check,Update,Back;
    UpdateRoomCheck()
    {
       getContentPane().setBackground(Color.white);
       setLayout(null);
        
       text = new JLabel("Update Room status");
       text.setFont(new Font("tahoma",Font.PLAIN,20));
       text.setBounds(30,20,200,30);
       text.setBackground(Color.BLUE);
       add(text);
       
       lblid = new JLabel("Customer Id");
       lblid.setBounds(30,80,100,30);
       add(lblid);
       
       ccustomer = new Choice();
       ccustomer.setBounds(200,80,150,25);
       add(ccustomer);
       
       try{
       
        Conn conn = new Conn();
        ResultSet rs= conn.s.executeQuery("select * from customer ");
        while(rs.next())
        {
           ccustomer.add(rs.getString("Number"));
        }
        
       }catch(Exception e){
          e.printStackTrace();
       }
       
       lblroom = new JLabel("Room number");
       lblroom.setBounds(30,120,100,30);
       add(lblroom);
       
       tfroom = new JTextField();
       tfroom.setBounds(200,120,150,25);
       add(tfroom);
       
       lblname = new JLabel("Availability");
       lblname.setBounds(30,160,100,30);
       add(lblname);
       
       tfname = new JTextField();
       tfname.setBounds(200,160,150,25);
       add(tfname);
       
       lblcheckin = new JLabel("Cleaning status");
       lblcheckin.setBounds(30,200,100,30);
       add(lblcheckin);
       
       tfcheckin = new JTextField();
       tfcheckin.setBounds(200,200,150,25);
       add(tfcheckin);
       
       Check = new JButton("Check");
       Check.setBackground(Color.BLACK);
       Check.setForeground(Color.WHITE);
       Check.setBounds(30,300,100,30);
       Check.addActionListener(this);
       add(Check);
       
       Update = new JButton("Update");
       Update.setBackground(Color.BLACK);
       Update.setForeground(Color.WHITE);
       Update.setBounds(150,300,100,30);
       Update.addActionListener(this);
       add(Update);
       
       Back = new JButton("Back");
       Back.setBackground(Color.BLACK);
       Back.setForeground(Color.WHITE);
       Back.setBounds(270,300,100,30);
       Back.addActionListener(this);
       add(Back);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
       JLabel image = new JLabel(i1);
       image.setBounds(450,50,500,300);
       add(image);
       
       setBounds(300,200,980,500);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource() == Check){
         String Id=ccustomer.getSelectedItem();
         String query ="select * from customer where number ='"+Id+"'";
         
         try{
         Conn c= new Conn();
         ResultSet rs= c.s.executeQuery(query);
         while(rs.next()){
             tfroom.setText(rs.getString("room"));
         }
           ResultSet rs2= c.s.executeQuery("select * from Addroom where Roomno='"+tfroom.getText()+"'");
          while(rs2.next())
             {
                tfavailable.setText(rs2.getString("Availability"));
                tfstatus.setText(rs2.getString("cleaning_status"));
             }
         }
         catch(Exception e){
             e.printStackTrace();
         }
        }else
        {
            setVisible(false);
               new Reception();
        }
       }
    public static void main(String args[])
    {
         new UpdateRoomCheck();
    }
}
