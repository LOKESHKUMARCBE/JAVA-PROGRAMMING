import java.io.*;
class demo3
{
	public static void main(String args[]) throws Exception
	{
		String tmp = "ABCDEFGHIJ";
		
		byte b[] = tmp.getBytes();
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		out.write(b);
		
		byte b1[] = out.toByteArray();
		int c;
		
		for(int i=0; i<b1.length;i++)
		{
			System.out.println((char)b1[i]);
		}
		
	}
}