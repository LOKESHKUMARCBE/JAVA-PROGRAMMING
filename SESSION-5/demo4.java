import java.io.*;
class demo4
{
	public static void main (String args[]) throws Exception
	{
		FileWriter fw = new FileWriter("file1.txt");
		String s = "JAVA PROGRAMMING \n WINTER 2023 \n CSE1007";
		char buf[] = new char[100];
		s.getChars(0,s.length(),buf,0);
		for(int i =0;i<buf.length;i++)
		fw.write(buf[i]);
		fw.close();
			
		FileReader fr = new FileReader("file1.txt");	
		int c;
		System.out.println("THE CONTENTS OF FILE1");
		while((c=fr.read())!=-1)
		{
			System.out.print((char)c);
		}
		
		fr.close();
		
	}
}