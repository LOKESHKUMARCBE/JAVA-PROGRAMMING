import java.io.*;
class demo1
{
	public static void main(String args[]) throws Exception
	{
		int size;
		FileInputStream f1 = new FileInputStream("file.txt");
		System.out.println("TOTAL AVAILABLE BYTES : " +(size=f1.available()));
		
		for(int i=0;i<size;i++)
		System.out.print((char)f1.read());
		
	}
}