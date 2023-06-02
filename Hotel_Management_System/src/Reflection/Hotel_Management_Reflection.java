
package Reflection;

import java.lang.reflect.*;

public class Hotel_Management_Reflection {
    
    public static void main(String args[]) throws ClassNotFoundException{
        Class c=Class.forName("hotel_management_system.Reception");
		System.out.println(c);
		Class sname= c.getSuperclass();
		System.out.println(sname);
                System.out.println("---get declared methods------");
                Method [] arr= c.getDeclaredMethods();
                for(int i= 0;i<arr.length;i++){
                   System.out.println(arr[i]);
                }
                 System.out.println("---methods------");
                Method [] brr= c.getMethods();
                for(int i= 0;i<brr.length;i++){
                   System.out.println(brr[i]);
                }
                 System.out.println("---get Constructor------");
                Constructor [] crr= c.getConstructors();
                for(int i= 0;i<crr.length;i++){
                   System.out.println(crr[i]);
                }
                 System.out.println("---get fields------");
                Field [] drr= c.getFields();
                for(int i= 0;i<drr.length;i++){
                   System.out.println(drr[i]);
                }
                 System.out.println("---get declared fields------");
                Field [] err= c.getDeclaredFields();
                for(int i= 0;i<err.length;i++){
                   System.out.println(err[i]);
                }
    
    }
    
}
