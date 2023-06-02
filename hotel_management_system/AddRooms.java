
package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//implpement action listener
import java.sql.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JLabel Heading,lblRoomno,lblAvailable,lblClean,lblPrice,lblBedtype;
    JTextField tfroom,tfprice;
    JComboBox Availablecombo,Cleancombo,Btypecombo;
    JButton Add , Cancel;
    AddRooms()
    {
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       Heading = new JLabel("Add Rooms");
       Heading.setBounds(150,20,200,20);
       Heading.setFont(new Font("Tahoma",Font.BOLD,17));
       add(Heading);
       
       lblRoomno = new JLabel("Room Number");
       lblRoomno.setBounds(60,80,120,20);
       lblRoomno.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblRoomno);
       
       tfroom = new JTextField();
       tfroom.setBounds(200,80,150,30);
       add(tfroom);
       
       lblAvailable = new JLabel("Available");
       lblAvailable.setBounds(60,130,120,30);
       lblAvailable.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblAvailable);
       
       String availableOptions[]={"Available","Occupied"};
       //drop box
       Availablecombo = new JComboBox(availableOptions);
       Availablecombo.setBounds(200,130,150,30);
       Availablecombo.setBackground(Color.WHITE);
       add(Availablecombo);
     
       lblClean = new JLabel("Clean");
       lblClean.setBounds(60,180,120,30);
       lblClean.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblClean);
       
       String cleanOptions[]={"Clean","Unclean"};
       //drop box
       Cleancombo = new JComboBox(cleanOptions);
       Cleancombo.setBounds(200,180,150,30);
       Cleancombo.setBackground(Color.WHITE);
       add(Cleancombo);
       
       lblPrice = new JLabel("Price");
       lblPrice.setBounds(60,230,120,20);
       lblPrice.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblPrice);
       
       tfprice = new JTextField();
       tfprice.setBounds(200,230,150,30);
       add(tfprice);
       
       lblBedtype = new JLabel("Clean");
       lblBedtype.setBounds(60,270,120,30);
       lblBedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblBedtype);
       
       String bedOptions[]={"Single Bed","Double Bed"};
       //drop box
       Btypecombo = new JComboBox(bedOptions);
       Btypecombo.setBounds(200,270,150,30);
       Btypecombo.setBackground(Color.WHITE);
       add(Btypecombo);
       
       
       Add = new JButton("Add Rooms");
       Add.setForeground(Color.WHITE);
       Add.setBackground(Color.BLACK);
       Add.setBounds(60 ,350,130,30);
       Add.addActionListener(this);
       add(Add);
       
       Cancel = new JButton("Cancel ");
       Cancel.setForeground(Color.WHITE);
       Cancel.setBackground(Color.BLACK);
       Cancel.setBounds(220 ,350,130,30);
       Cancel.addActionListener(this);
       add(Cancel);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
       JLabel image = new JLabel(i1);
       image.setBounds(400,30,500,300);
       add(image);
       
       setBounds(330,200,940,470);
       setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Add)
        {
            String Roomno = tfroom.getText();
            String Availability = (String)Availablecombo.getSelectedItem();
            String Clean= (String)Cleancombo.getSelectedItem();
            String Price = tfprice.getText();
            String Btype = (String)Btypecombo.getSelectedItem();
            
            try{
               Conn conn = new Conn();
               String str="insert into AddRoom values('"+Roomno+"','"+Availability+"','"+Clean+"','"+Price+"','"+Btype+"')";
               
               conn.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null,"New Room Added Successfully");
               setVisible(false);
            }
            catch( Exception e)
            {
               e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new AddRooms();
    }
    
}
