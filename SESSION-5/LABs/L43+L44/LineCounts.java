import java.io.File;
import java.io.FileInputStream;
public class LineCounts 
{
   public static void main(String args[]) throws Exception{

      int count =0;
      File file = new File("data.txt");
      FileInputStream fis = new FileInputStream(file);
      byte[] bytesArray = new byte[(int)file.length()];
      fis.read(bytesArray);
      String s = new String(bytesArray);
      String [] data = s.split(" ");
      for (int i=0; i<data.length; i++) {
         count++;
      }
      System.out.println("Number of lines in the given file are " +count);
   }
}