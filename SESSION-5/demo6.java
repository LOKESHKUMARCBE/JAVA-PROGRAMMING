import java.util.*;
import java.io.*;

class demo6 
{
    static DataInputStream din = new DataInputStream(System.in);
    static StringTokenizer st;

    public static void main(String args[]) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("invent.txt"));

        System.out.println("Enter code number");
        st = new StringTokenizer(din.readLine());
        int code = Integer.parseInt(st.nextToken());

        System.out.println("Enter number of items");
        st = new StringTokenizer(din.readLine());
        int items = Integer.parseInt(st.nextToken());

        System.out.println("Enter cost");
        st = new StringTokenizer(din.readLine());
        double cost = Double.parseDouble(st.nextToken()); // Updated line
     
        dos.writeInt(code);
        dos.writeInt(items);
        dos.writeDouble(cost);
        dos.close();
 
        DataInputStream dis = new DataInputStream(new FileInputStream("invent.txt"));
        int codeNumber = dis.readInt();
        int totalItems = dis.readInt();
        double itemCost = dis.readDouble();
        double totalCost = totalItems * itemCost;
        dis.close();
        System.out.println();
        System.out.println("Code Number: " + codeNumber);
        System.out.println("Item Cost: " + itemCost);
        System.out.println("Total Items: " + totalItems);
        System.out.println("Total Cost: " + totalCost);
    }
}
