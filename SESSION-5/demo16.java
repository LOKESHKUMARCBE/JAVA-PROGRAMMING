import java.io.*;
import java.util.Scanner;

public class demo16
{
    public static void main(String[] args) 
	{
        try 
		{
        
            FileWriter fileWriter = new FileWriter("stu_details.txt", true);

            /*Create a BufferedWriter to write data efficiently*/
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Register Number: ");
            String registerNumber = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Mobile: ");
            String mobile = scanner.nextLine();
            System.out.print("Enter E-mail: ");
            String email = scanner.nextLine();

            /* Write student details to the file*/
            bufferedWriter.write("Register Number: " + registerNumber + "\n");
            bufferedWriter.write("Name: " + name + "\n");
            bufferedWriter.write("Mobile: " + mobile + "\n");
            bufferedWriter.write("E-mail: " + email + "\n");
            bufferedWriter.write("\n"); 
            bufferedWriter.close();

    
            FileInputStream fis = new FileInputStream("stu_details.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            boolean registerNumberFound = false;
            boolean cityFound = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Register Number")) {
                    registerNumberFound = true;
                }
                if (line.contains("City")) {
                    cityFound = true;
                }
            }
            reader.close();

            if (registerNumberFound) {
                System.out.println("Keyword 'Register Number' found in the file.");
            }
            if (cityFound) {
                System.out.println("Keyword 'City' found in the file.");
            }

            /*Create a file for each candidate entry with the format RegisterNumber_City*/
            String city = "Chennai"; /* You can change this to get the city from the user*/
            File candidateFile = new File(registerNumber + "_" + city + ".txt");
            if (!candidateFile.exists()) {
                candidateFile.createNewFile();
            }

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
