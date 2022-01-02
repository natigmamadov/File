/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author natiq
 */
public class FileUtility2 {

    public static void writeIntoFile(String fileName, String text) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write(text);

    }

    public static void wtiteIntoFile2(String fileName, byte[] data) throws FileNotFoundException, IOException {
        FileOutputStream fop = new FileOutputStream(fileName);
        fop.write(data);
        fop.flush();
        fop.close();

    }

    public static String read(String fileName) throws Exception {
        InputStream in = new FileInputStream(fileName);
        InputStreamReader r = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(r);
        String line = null;
        String result = "";
        while ((line = reader.readLine()) != null) {
            result += line;
        }
        return result;
    }

    public static byte[] readBytes(String fileName) throws Exception {
        File file = new File(fileName);
        byte[] bytesArray = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bytesArray);
        return bytesArray;
    }

    public static void writeBytes(String fileName, byte[] data) throws FileNotFoundException, IOException {
        FileOutputStream fop = new FileOutputStream(fileName);
        fop.write(data);
        fop.flush();
        fop.close();

    }

    public static void writeObjectToFile(Serializable object, String name) throws Exception {
        try (
                FileOutputStream fout = new FileOutputStream(name);
                ObjectOutputStream oos = new ObjectOutputStream(fout);) {
            oos.writeObject(object);
        }
    }
    
    public static Object readFileDeserialize(String name)throws Exception{
        Object obj = null;
        FileInputStream fi =new FileInputStream(name);
       try( ObjectInputStream in = new ObjectInputStream(fi)){
             obj = in.readObject();  
       }
        return obj;
    
    }

    public static void writeBytes(byte[] arr, String cUsersNatiqPicturesScreenshotsScreenshot_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
       public static void writeBytesNio(byte[] data, String fileName) throws Exception{
        Path filePath = Paths.get(fileName);
        Files.write(filePath, data);
    }
    
    public static byte[] readBytesNio(String fileName) throws Exception{
        Path filePath = Paths.get(fileName);
        byte[] byteArray = Files.readAllBytes(filePath);
        return byteArray;
}

}
