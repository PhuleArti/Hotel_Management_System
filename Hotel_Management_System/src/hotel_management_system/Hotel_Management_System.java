
package hotel_management_system;
import javax.swing.*; //import jframe class
import java.awt.*; //Color class
import java.awt.event.*;

//abstract method -if we implement interface we have to ddeclare methods else show abstract class
public class Hotel_Management_System extends JFrame implements ActionListener{
    
    Hotel_Management_System()
    {
      // setSize(1366 ,565);
       //setLocation(80,80);
        setBounds(100,100,1250,565);
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
       JLabel image = new JLabel(i1);//if we want to write anything on frame
       image.setBounds(0,0,1250,565);
       add(image);
       
       JLabel text = new JLabel("Hotel Management System");
       text.setBounds(20,430,1000,90);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("serif",Font.PLAIN, 50));
       image.add(text);
       
       JButton next = new JButton("Next");
       next.setBounds(1000,450,140,50);
       next.setBackground(Color.WHITE);
       next.setForeground(Color.BLACK);
       next.addActionListener(this);
       next.setFont(new Font("serif",Font.PLAIN, 18));
       image.add(next);

       setVisible(true);
       
       while(true){   //reverse hide functinality
           text.setVisible(false);
           try{
               Thread.sleep(500);
           }
           catch(Exception e){
                e.printStackTrace();  //print error
           }
           text.setVisible(true);
            try{
               Thread.sleep(500);
           }
           catch(Exception e){
                e.printStackTrace();  //print error
           }
       }
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        
        new Hotel_Management_System();
    }
    
}
