import java.io.*;
import java.nio.file.*;

public class demo2 
{
    private char lookFor;
    private Path file;

    demo2(char lookFor, Path file) {
        this.lookFor = lookFor;
        this.file = file;
    }

    public int count() throws IOException {
        int count = 0;
        try (InputStream in = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
            {
            String line = null;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (lookFor == line.charAt(i)) {
                        count++;
                    }
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return count;
    }

    static void usage() {
        System.out.println("usage: java CountLetter <letter>");
        System.exit(-1);
    }

    public static void main(String[] args) throws IOException 
	{

        if (args.length != 1 || args[0].length() != 1)
            usage();

        char lookFor = args[0].charAt(0);
        Path file = Paths.get("data.txt");
        int count = new CountLetter(lookFor, file).count();
        System.out.format("File '%s' has %d instances of letter '%c'.%n",
                file, count, lookFor);
    }
}