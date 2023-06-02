
package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//JFrame class contain all set function
public class Login extends JFrame implements ActionListener { 
    
    JTextField Username,Password;
    JButton Login,Cancel;
    
    Login()
    {
        //to get whole frame use getCOntentPane
         getContentPane().setBackground(Color.WHITE);
         
         setLayout(null);
         
         JLabel User = new JLabel("Username");
         User.setBounds(40,20,100,30);
         add(User);
         
         
         Username = new JTextField();
         Username.setBounds(150,20,150,30);
         add(Username);
         
         JLabel Pass = new JLabel("Password");
         Pass.setBounds(40,70,100,30);
         add(Pass);
         
         Password = new JTextField();
         Password.setBounds(150,70,150,30);
         add(Password);
         
         Login = new JButton("Login");
         Login.setBounds(40,150,120,30);
         Login.setBackground(Color.BLACK); //background color
         Login.setForeground(Color.WHITE); //text color
         Login.setFont(new Font("serif",Font.PLAIN,18));
         Login.addActionListener(this);
         add(Login);
         
         Cancel = new JButton("Cancel");
         Cancel.setBounds(180,150,120,30);
         Cancel.setBackground(Color.BLACK); //background color
         Cancel.setForeground(Color.WHITE); //text color
         Cancel.setFont(new Font("serif",Font.PLAIN,18));
         Cancel.addActionListener(this);
         add(Cancel);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
         //to crop image we use image object 2
         Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
         //we cannot place image class object on jlabel directly it gives error    
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(350,10,200,200);
         add(image);
         
         setBounds(500,200,600,300);
         setVisible(true); 
    }   
    
    public void actionPerformed(ActionEvent ae)
    {
       if (ae.getSource() == Login)
       {
           String user = Username.getText();
           String pass = Password.getText();
           
           try{
               Conn c = new Conn();
               
               String query = "select * from Login where Username = '"+user+"' and Password ='"+pass+"'";
               
              ResultSet rs = c.s.executeQuery(query);
              //to check data by next function
              if(rs.next())
              {
                  setVisible(false);
                  new Dashboard();
                  
              }else
              {//pop up message
                 JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                 setVisible(false);
              }
           }
           catch(Exception e){
              e.printStackTrace();
           }
       }
       else if(ae.getSource()==Cancel)
       {
           setVisible(false);
           
       }
    }
    
    public static void main(String args[])
    {
         new Login();
    }
    
}
