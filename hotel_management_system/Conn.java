//step 1 -register driver class  
//2-add jar file contain jdbc using driver manager class
//3-creating statement
//4-executing mysql queries
package hotel_management_system;

import java.sql.*;

public class Conn {
    
    Connection c; //connection string by using driver manager class
    Statement s; //create statement
    Conn()
    {
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           c = DriverManager.getConnection("jdbc:mysql:///hotel_management_system","root","ARTI@123root");//mysql connection string
           s = c.createStatement();
           
       }
       catch(Exception e)
       {
          e.printStackTrace();
       }
        
    } 
    
    public static void main(String args[])
    {
        new Conn();
    }
}
