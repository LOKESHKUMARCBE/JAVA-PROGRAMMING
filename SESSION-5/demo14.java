import java.io.*;

class FileReadWriteThread extends Thread 
{
    private final String fileName;
    private final String data;
    private final boolean isWrite;
    private final Object lock;

public FileReadWriteThread(String fileName, String data, boolean isWrite, Object lock) 
	{
        this.fileName = fileName;
        this.data = data;
        this.isWrite = isWrite;
        this.lock = lock;
    }

    @Override
    public void run() 
	{
        if (isWrite)
			{
            writeToFile();
			} else 
			{
            readFromFile();
			}
    }

    private void writeToFile() 
	{
        synchronized (lock) 
		{
            try (FileWriter writer = new FileWriter(fileName, true))
			{
                writer.write(data + "\n");
                System.out.println("Data written to file by Thread-" + Thread.currentThread().getId());
            } catch (IOException e) 
			{
                e.printStackTrace();
            }
        }
    }

    private void readFromFile()
	{
        synchronized (lock) 
		{
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) 
			{
                String line;
                while ((line = reader.readLine()) != null) 
				{
                    System.out.println("Data read from file by Thread-" + Thread.currentThread().getId() + ": " + line);
                }
            } catch (IOException e) 
			{
                e.printStackTrace();
            }
        }
    }
}

public class demo14 
{
    public static void main(String[] args) 
	{
        String fileName = "sharedFile1.txt";
        Object lock = new Object();

        FileReadWriteThread writerThread1 = new FileReadWriteThread(fileName, "Data from Thread 1", true, lock);
        FileReadWriteThread writerThread2 = new FileReadWriteThread(fileName, "Data from Thread 2", true, lock);
        FileReadWriteThread readerThread1 = new FileReadWriteThread(fileName, null, false, lock);
        FileReadWriteThread readerThread2 = new FileReadWriteThread(fileName, null, false, lock);

        writerThread1.start();
        writerThread2.start();
        readerThread1.start();
        readerThread2.start();
    }
}
