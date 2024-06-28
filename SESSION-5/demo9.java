import java.io.*;
import java.util.*;

public class demo9 {
    public static void main(String[] args) 
	{
        String fileName = "data.txt";

        String wordToSearch = "Vellore"; 

        File file = new File(fileName);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Invalid file path.");
            return;
        }

        int occurrences = countWordOccurrences(file, wordToSearch);
        System.out.println("Occurrences of '" + wordToSearch + "' in file '" + fileName + "': " + occurrences);
    }

    private static int countWordOccurrences(File file, String word)
	{
        int count = 0;
        try (Scanner scanner = new Scanner(file)) 
		{
            while (scanner.hasNext()) {
                String nextWord = scanner.next();
                if (nextWord.equals(word)) 
				{
                    count++;
                }
            }
        } catch (FileNotFoundException e)
		{
            System.err.println("Error reading file: " + e.getMessage());
        }
        return count;
    }
}
