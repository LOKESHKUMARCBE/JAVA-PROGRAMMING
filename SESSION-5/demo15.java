import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class demo15
 {
    public static void main(String[] args) {
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader("review.txt"));
            String line;
            String reviewText = "";

            while ((line = reader.readLine()) != null) 
			{
                reviewText += line + " ";
            }

            reader.close();

  
            reviewText = reviewText.toLowerCase();


            int goodCount = countWordOccurrences(reviewText, "good");

            System.out.println("Count of 'good' (case-insensitive): " + goodCount);
			
        } catch (IOException e) 
		{
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    // method to count the occurrences of a word in a given text
    private static int countWordOccurrences(String text, String word) 
	{
        int count = 0;
        int index = text.indexOf(word);

        while (index != -1) {
            count++;
            index = text.indexOf(word, index + word.length());
        }

        return count;
    }
}
