
package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; //resultset
import java.util.Date;//date package 

public class AddCustomer extends JFrame implements ActionListener {
    
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom; 
    JLabel checkintime;
    JButton add,back;
    AddCustomer()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("New Customer form");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        JLabel Cust_Id = new JLabel("Cust_ID");
        Cust_Id.setBounds(35,80,100,20);
        Cust_Id.setFont(new Font("Raleway",Font.PLAIN,20));
        add(Cust_Id);
        
        String Options[]={"Aadhar card"," Passport","Driving License","voter id card","Ration card"};
        comboid = new JComboBox(Options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel number = new JLabel("Number");
        number.setBounds(35,120,100,25);
        number.setFont(new Font("Raleway",Font.PLAIN,20));
        add(number);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
        
         JLabel name = new JLabel("Name");
        name.setBounds(35,160,100,25);
        name.setFont(new Font("Raleway",Font.PLAIN,20));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(35,200,100,25);
        gender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(gender);
        
        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);
        
         JLabel country = new JLabel("Country");
        country.setBounds(35,240,100,25);
        country.setFont(new Font("Raleway",Font.PLAIN,20));
        add(country);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
           
        JLabel room = new JLabel("Allocated Room");
        room.setBounds(35,280,150,25);
        room.setFont(new Font("Raleway",Font.PLAIN,20));
        add(room);
        
        croom = new Choice();
        croom.setBounds(200,280,150,25);
        add(croom);
        
        try{
          Conn conn= new Conn();
          
          String query= "select * from AddRoom where Availability ='Available'";
          
           ResultSet ret = conn.s.executeQuery(query);// as it returns something we have to store in result set object
           while(ret.next())
           {
             croom.add(ret.getString("Roomno"));//dynamically value insertion
           }
        }
        catch( Exception e)
        {
          e.printStackTrace();
        }
        
        JLabel check_time = new JLabel("Checkin time");
        check_time.setBounds(35,320,150,25);
        check_time.setFont(new Font("Raleway",Font.PLAIN,20));
        add(check_time);
        
        //checkin time should be system generated wihout user addition for that we should use date class
        Date date = new Date();
        //we cant insert dateclass in jlabel directly for that we have to create string
        //1+2+3+4+5+" code"+1+2+3+4+5
        
        checkintime = new JLabel(""+date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,15));
        add(checkintime);
        
         JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(35,360,100,25);
        deposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(deposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        
        add= new JButton("Add");
        add.setBounds(50,410,140,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back= new JButton("Back");
        back.setBounds(200,410,140,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        setBounds(350,200,800,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
       if (ae.getSource()== add)
       {
           String Cust_Id = (String)comboid.getSelectedItem();
           String number= tfnumber.getText();
           String name = tfname.getText();
           String gender=null;
           
           if(rmale.isSelected())
           {
              gender = "Male";
           }
           else
           {
              gender = "Female";
           }
           
           String country = tfcountry.getText();
           String room = croom.getSelectedItem();
           String check_time = checkintime.getText();
           String deposit= tfdeposit.getText();
           
           try{
               
               String Query = "insert into Customer values('"+Cust_Id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+check_time+"','"+deposit+"')";
               String Query2= "update Addroom set Availability = 'Occupied' where Roomno = '"+room+"'";
               
               Conn conn = new Conn();
               
               conn.s.executeUpdate(Query);
               conn.s.executeUpdate(Query2);
               
               JOptionPane.showMessageDialog(null, "new customer added succesfully");
              
               setVisible(false);
               new Reception();
           
           }catch(Exception e)
           {
             e.printStackTrace();
           }
       }
       else if(ae.getSource()== back)
       {
            setVisible(false);
               new Reception();
       }    
    }
    
    public static void main(String args[])
    {
        new AddCustomer();
    }
}
