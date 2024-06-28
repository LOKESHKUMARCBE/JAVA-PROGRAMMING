import java.io.*;
import java.util.*;

class demo7 {
    public static void main(String args[]) 
	{
        Scanner scanner = new Scanner(System.in);
        try {

            FileWriter writer = new FileWriter("invent2.csv");
            BufferedWriter bw = new BufferedWriter(writer);

            System.out.println("Enter code number");
            int code = scanner.nextInt();
            bw.write("Code Number," + code);
            bw.newLine();

            System.out.println("Enter number of items");
            int items = scanner.nextInt();
            bw.write("Total Items," + items);
            bw.newLine();

            System.out.println("Enter cost");
            double cost = scanner.nextDouble();
            bw.write("Item Cost," + cost);
            bw.newLine();

            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("invent2.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];
                    System.out.println(key + ": " + value);
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
