import java.io.*;
import java.util.*;

public class demo8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file/directory path:");
        String path = scanner.nextLine();
        File directory = new File(path);
        File[] fileList = directory.listFiles();
        System.out.println("List of files/directories in " + path + ":");
        if (fileList != null) {
            for (File file : fileList) {
                System.out.println(file.getName());
            }
        }

        File fileToCheck = new File(path);
        System.out.println("Read permission: " + fileToCheck.canRead());
        System.out.println("Write permission: " + fileToCheck.canWrite());

        System.out.println("Enter the file name for which you want to get information:");
        String fileName = scanner.nextLine();
        File fileToInspect = new File(directory, fileName);

        if (fileToInspect.exists()) {
            System.out.println("Last modified time: " + new Date(fileToInspect.lastModified()));
            System.out.println("File size: " + fileToInspect.length() + " bytes");
        } else {
            System.out.println("File does not exist.");
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToInspect));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            System.out.println("Number of lines in the file: " + lines);
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
