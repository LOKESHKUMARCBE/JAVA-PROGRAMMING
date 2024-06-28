import java.io.FileWriter;
import java.io.IOException;

class FileWriterThread extends Thread 
{
    private final String fileName;
    private final String data;
    private final Object lock;

    public FileWriterThread(String fileName, String data, Object lock) 
	{
        this.fileName = fileName;
        this.data = data;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try (FileWriter writer = new FileWriter(fileName, true)) 
			{
                writer.write(data + "\n");
                System.out.println("Data written to file by Thread-" + Thread.currentThread().getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class demo13
{
    public static void main(String[] args) 
	{
        String fileName = "sharedFile.txt";
        Object lock = new Object();

        FileWriterThread thread1 = new FileWriterThread(fileName, "Data from Thread 1", lock);
        FileWriterThread thread2 = new FileWriterThread(fileName, "Data from Thread 2", lock);
        FileWriterThread thread3 = new FileWriterThread(fileName, "Data from Thread 3", lock);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
