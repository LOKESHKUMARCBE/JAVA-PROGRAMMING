import java.io.*;
class demo2
{
	public static void main(String args[]) throws Exception
	{
		String tmp = "ABCDEFGHIJ";
		
		byte b[] = tmp.getBytes();
		
		ByteArrayInputStream in = new ByteArrayInputStream(b);
		
		int c;
		
		while((c=in.read())!=-1)
		{
			System.out.println((char)c);
		}
		
	}
}