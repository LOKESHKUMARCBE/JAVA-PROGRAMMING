import java.io.*;
import java.util.*;

public class demo10 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file name to write data:");
        String fileName = scanner.nextLine();
        writeToFile(fileName);
        System.out.println("Enter the word to replace (case-insensitive):");
        String wordToReplace = scanner.nextLine();
        System.out.println("Enter the new word:");
        String newWord = scanner.nextLine();
     
        replaceWordInFile(fileName, wordToReplace, newWord);
    }

    private static void writeToFile(String fileName) 
	{
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) 
		{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter data to write to the file (Enter 'done' to finish):");
            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("done")) 
			{
                writer.println(input);
            }
            System.out.println("Data has been written to the file successfully.");
        } catch (IOException e) 
		{
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void replaceWordInFile(String fileName, String wordToReplace, String newWord) {
        try {
            File file = new File(fileName);
            StringBuilder content = new StringBuilder();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replaceAll("(?i)" + wordToReplace, newWord); 
                content.append(line).append("\n");
            }
            scanner.close();

            FileWriter writer = new FileWriter(file);
            writer.write(content.toString());
            writer.close();

            System.out.println("Word '" + wordToReplace + "' replaced with '" + newWord + "' in the file.");
        } catch (IOException e)
		{
            System.err.println("Error replacing word in file: " + e.getMessage());
        }
    }
}
