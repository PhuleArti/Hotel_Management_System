
package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    JLabel text,lblid,lblroom,lblname,lblcheckin,lblpaid,lblpending;
    Choice ccustomer;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
    JButton Check,Update,Back;
    UpdateCheck()
    {
       getContentPane().setBackground(Color.white);
       setLayout(null);
        
       text = new JLabel("Update status");
       text.setFont(new Font("tahoma",Font.PLAIN,20));
       text.setBounds(90,20,200,30);
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
       
       lblname = new JLabel("Name");
       lblname.setBounds(30,160,100,30);
       add(lblname);
       
       tfname = new JTextField();
       tfname.setBounds(200,160,150,25);
       add(tfname);
       
       lblcheckin = new JLabel("Checkin Time");
       lblcheckin.setBounds(30,200,100,30);
       add(lblcheckin);
       
       tfcheckin = new JTextField();
       tfcheckin.setBounds(200,200,150,25);
       add(tfcheckin);
       
       lblpaid = new JLabel("Amount Paid");
       lblpaid.setBounds(30,240,100,30);
       add(lblpaid);
       
       tfpaid = new JTextField();
       tfpaid.setBounds(200,240,150,25);
       add(tfpaid);
       
        lblpending = new JLabel("Pending Amount");
       lblpending.setBounds(30,280,100,30);
       add(lblpending);
       
       tfpending = new JTextField();
       tfpending.setBounds(200,280,150,25);
       add(tfpending);
       
       Check = new JButton("Check");
       Check.setBackground(Color.BLACK);
       Check.setForeground(Color.WHITE);
       Check.setBounds(30,340,100,30);
       Check.addActionListener(this);
       add(Check);
       
       Update = new JButton("Update");
       Update.setBackground(Color.BLACK);
       Update.setForeground(Color.WHITE);
       Update.setBounds(150,340,100,30);
       Update.addActionListener(this);
       add(Update);
       
       Back = new JButton("Back");
       Back.setBackground(Color.BLACK);
       Back.setForeground(Color.WHITE);
       Back.setBounds(270,340,100,30);
       Back.addActionListener(this);
       add(Back);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
       JLabel image = new JLabel(i1);
       image.setBounds(450,50,500,300);
       add(image);
       
       setBounds(300,200,980,500);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== Check)
        {
            String id = ccustomer.getSelectedItem();
            String query="select * from customer where number='"+id+"'";
            try{
             Conn conn = new Conn();
             ResultSet rs= conn.s.executeQuery(query);
             while(rs.next())
             {
                tfroom.setText(rs.getString("Room"));
                tfname.setText(rs.getString("Name"));
                tfcheckin.setText(rs.getString("Check_time"));
                tfpaid.setText(rs.getString("deposit"));
             }
             ResultSet rs2= conn.s.executeQuery("select * from Addroom where Roomno='"+tfroom.getText()+"'");
             while(rs2.next())
             {
                String Price =rs2.getString("Price");
                int AmountPaid = Integer.parseInt(Price)-Integer.parseInt(tfpaid.getText());
                tfpending.setText(""+AmountPaid);
             }
            }catch(Exception e){
                e.printStackTrace();
            }
           
        }else if(ae.getSource()== Update)
        {
           String number=ccustomer.getSelectedItem();
           String room=tfroom.getText();
           String name=tfname.getText();
           String checkin=tfcheckin.getText();
           String deposit = tfpaid.getText();
           
           try{
           
               Conn conn = new Conn();
               conn.s.executeUpdate("update customer set Room='"+room+"',Name='"+name+"',Check_time='"+checkin+"',Deposit='"+deposit+"'");
               
               JOptionPane.showMessageDialog(null, "data updated successfully");
               
               setVisible(false);
               new Reception();
               
           }catch(Exception e){
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
         new UpdateCheck();
    }
}
