/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.IOException;

/**
 *
 * @author natiq
 */
public class Main {
    public static void main(String[] args) throws Exception {
        
      
        FileUtility.writeIntoFile("test.txt", "Salam");
        User u = new User();
        u.name = "test";
        FileUtility.writeObjectToFile(u,"test.obj");
                System.out.println(u.name);

        User u1 =(User) FileUtility.readFileDeserialize("test.obj");
        System.out.println(u.name);
        
        byte[] str = FileUtility.readBytes("test.txt");
        System.out.println(new String(str));
//                
    }
}
