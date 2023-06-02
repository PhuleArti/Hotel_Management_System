
package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname,tfage,tfphone,tfsalary,tfemail,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    AddEmployee(){
       setLayout(null);
       
       JLabel lblname = new JLabel("NAME");
       lblname.setBounds(60,30,100,30);
       lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(lblname);
       
        tfname = new JTextField();
       tfname.setBounds(200,30,150,30);
       add(tfname);
       
       JLabel lblage = new JLabel("AGE");
       lblage.setBounds(60,80,100,30);
       lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(lblage);
       
        tfage= new JTextField();
       tfage.setBounds(200,80,150,30);
       add(tfage);
       
        JLabel lblgender = new JLabel("GENDER");
       lblgender.setBounds(60,130,100,30);
       lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(lblgender);
       
        rbmale = new JRadioButton("MALE");
       rbmale.setBounds(200,130,70,30);
       rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
       rbmale.setBackground(Color.WHITE);
       add(rbmale);
       
       rbfemale = new JRadioButton("FEMALE");
       rbfemale.setBounds(280,130,70,30);
       rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
       rbfemale.setBackground(Color.WHITE);
       add(rbfemale);
       
       JLabel lbljob = new JLabel("JOB");
       lbljob.setBounds(60,180,100,30);
       lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(lbljob);
       
       String str[]={"Front Desk clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
       cbjob =new JComboBox(str);
       cbjob.setBounds(200,180,150,30);
       cbjob.setBackground(Color.WHITE);
       add(cbjob);
       
       JLabel lblsalary = new JLabel("SALARY");
       lblsalary.setBounds(60,230,100,30);
       lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(lblsalary);
       
       tfsalary= new JTextField();
       tfsalary.setBounds(200,230,150,30);
       add(tfsalary);
       
       JLabel lblphone = new JLabel("PHONE");
       lblphone.setBounds(60,280,100,30);
       lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(lblphone);
       
       tfphone= new JTextField();
       tfphone.setBounds(200,280,150,30);
       add(tfphone);
       
       JLabel lblemail = new JLabel("EMAIL");
       lblemail.setBounds(60,330,100,30);
       lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(lblemail);
       
        tfemail= new JTextField();
       tfemail.setBounds(200,330,150,30);
       add(tfemail);
       
       ButtonGroup bg = new ButtonGroup();
       bg.add(rbmale);
       bg.add(rbfemale);
       
       JLabel lblaadhar = new JLabel("AADHAR");
       lblaadhar.setBounds(60,380,100,30);
       lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(lblaadhar);
       
       tfaadhar= new JTextField();
       tfaadhar.setBounds(200,380,150,30);
       add(tfaadhar);
       
        submit = new JButton("SUBMIT");
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.setBounds(60,430,150,30);
       submit.addActionListener(this);
       add(submit);
      
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
       Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(380,60,450,370);
       add(image);
       
       getContentPane().setBackground(Color.WHITE);
       setBounds(350,200,850,540);
       setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String name= tfname.getText();  
        String age= tfage.getText();
        String gender = null;
        if(rbmale.isSelected())
        {
            gender="MALE";
        }
        else if(rbfemale.isSelected())
        {
            gender="FEMALE";
        }
        
        String job= (String)cbjob.getSelectedItem();
        String salary= tfsalary.getText();
        String phone= tfphone.getText();
        String email= tfemail.getText();
        String aadhar=tfaadhar.getText();
            
        try{
            
            Conn conn = new Conn();
            
            String query= "INSERT INTO EMPLOYEE values ('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')"; 
        
            conn.s.executeUpdate(query); //insert tabel
            
            JOptionPane.showMessageDialog(null,"Employee added successfully");
             setVisible(false);
             
        }catch(Exception e){
           e.printStackTrace();
        }
    }

   public static void main(String[]args)
   {
       new AddEmployee();
   }

}
