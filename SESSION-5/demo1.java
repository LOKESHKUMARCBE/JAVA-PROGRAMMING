import java.io.*;
class demo1
{
public static void main(String args[]) throws Exception
{
	String str = " JAVA PROGRAMMING \n WINTER SEM 2024 \n CSE1007";
	FileOutputStream f1 = new FileOutputStream("X2.txt");
	byte buf [] = str.getBytes();
	for(int i=0; i<buf.length;i++)
	f1.write(buf[i]);
	f1.close();
	
	FileInputStream f2 = new FileInputStream("X2.txt");
	int s = f2.available();
	for(int i=0 ;i<s;i++)
	System.out.print((char)f2.read());
	f2.close();
}

}