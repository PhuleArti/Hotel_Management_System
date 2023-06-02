

package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//implpement action listener
import java.sql.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JLabel Heading,lblname,lblage,lblgender,lblcompany,lblmodel,lblavailable,lblloc;
    JTextField tfname ,tfage,tfcompany,tfmodel,tfloc;
    JComboBox gendercombo,availablecombo;
    JButton Add , Cancel;
    AddDriver()
    {
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       Heading = new JLabel("Add Drivers");
       Heading.setBounds(150,10,200,20);
       Heading.setFont(new Font("Tahoma",Font.BOLD,17));
       add(Heading);
       
       lblname = new JLabel("Name");
       lblname.setBounds(60,70,120,30);
       lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblname);
       
       tfname = new JTextField();
       tfname.setBounds(200,70,150,30);
       add(tfname);
       
       lblage = new JLabel("Age");
       lblage.setBounds(60,110,120,30);
       lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblage);
       
        tfage = new JTextField();
       tfage.setBounds(200,110,150,30);
       add(tfage);
     
       lblgender = new JLabel("Gender");
       lblgender.setBounds(60,150,120,30);
       lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblgender);
       
       String cleanOptions[]={"Male","Female"};
       //drop box
       gendercombo = new JComboBox(cleanOptions);
       gendercombo.setBounds(200,150,150,30);
       gendercombo.setBackground(Color.WHITE);
       add(gendercombo);
       
       lblcompany = new JLabel("Car_company");
       lblcompany.setBounds(60,190,120,20);
       lblcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblcompany);
       
       tfcompany = new JTextField();
       tfcompany.setBounds(200,190,150,30);
       add(tfcompany);
       
       lblmodel = new JLabel("Car_model");
       lblmodel.setBounds(60,230,120,20);
       lblmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblmodel);
       
       tfmodel = new JTextField();
       tfmodel.setBounds(200,230,150,30);
       add(tfmodel);
       
       lblavailable = new JLabel("Available");
       lblavailable.setBounds(60,270,120,20);
       lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblavailable);
       
       String availableOptions[]={"Available","Busy"};
       //drop box
       availablecombo = new JComboBox(availableOptions);
       availablecombo.setBounds(200,270,150,30);
       availablecombo.setBackground(Color.WHITE);
       add(availablecombo);
       
       lblloc = new JLabel("Lacation");
       lblloc.setBounds(60,310,120,20);
       lblloc.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblloc);
       
       tfloc = new JTextField();
       tfloc.setBounds(200,310,150,30);
       add(tfloc);
       
       Add = new JButton("Add Driver");
       Add.setForeground(Color.WHITE);
       Add.setBackground(Color.BLACK);
       Add.setBounds(60 ,370,130,30);
       Add.addActionListener(this);
       add(Add);
       
       Cancel = new JButton("Cancel ");
       Cancel.setForeground(Color.WHITE);
       Cancel.setBackground(Color.BLACK);
       Cancel.setBounds(220 ,370,130,30);
       Cancel.addActionListener(this);
       add(Cancel);
       
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
       Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(400,30,500,300);
       add(image);
       
       setBounds(300,200,980,470);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Add)
        {
            String Name = tfname.getText();
            String Age = tfage.getText();
            String Gender= (String)gendercombo.getSelectedItem();
            String Car_company = tfcompany.getText();
            String Car_model = tfmodel.getText();
            String Available= (String)availablecombo.getSelectedItem();
            String Location = tfloc.getText();
            
            try{
               Conn conn = new Conn();
               String str="insert into AddDriver values('"+Name+"','"+Age+"','"+Gender+"','"+Car_company+"','"+Car_model+"','"+Available+"','"+Location+"')";
               
               conn.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
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
        new AddDriver();
    }
    
}
