import java.io.*;

class demo5 {
    public static void main(String args[]) 
	{
        Double principalAmount = 0.0; // Use autoboxing
        Double rateOfInterest = 0.0; // Use autoboxing
        int numberOfYears = 0;

        DataInputStream in = new DataInputStream(System.in);
        String tempString;

        try {
            System.out.print("Enter Principal Amount: ");
            System.out.flush();
            tempString = in.readLine();
            principalAmount = Double.valueOf(tempString);

            System.out.print("Enter Rate of Interest: ");
            System.out.flush();
            tempString = in.readLine();
            rateOfInterest = Double.valueOf(tempString);

            System.out.print("Enter Number of Years: ");
            System.out.flush();

            tempString = in.readLine();
            numberOfYears = Integer.parseInt(tempString);
        } catch (IOException e) 
		{
            // Handle the exception by printing an error message
            System.err.println("An error occurred while reading input: " + e.getMessage());
            // Optionally, you can add more error handling code here.
        }

        // Input is over: calculate the interest
        Double interestTotal = principalAmount * rateOfInterest * numberOfYears * 0.01f;

        System.out.println("Total Interest = " + interestTotal);
    }
}
