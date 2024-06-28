import java.util.Scanner;

class WaterBillCalculator 
{
    private int consumerNo;
    private String consumerName;
    private String consumerType;
    private int daysInMonth;
    private double inflowRate;
    private int duration;

    public WaterBillCalculator(int consumerNo, String consumerName, String consumerType, int daysInMonth, double inflowRate, int duration) 
	{
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.consumerType = consumerType;
        this.daysInMonth = daysInMonth;
        this.inflowRate = inflowRate;
        this.duration = duration;
    }

    public double calculateBillAmount() 
	{
        double chargesPerLiter;
		
        if ("Household".equalsIgnoreCase(consumerType)) 
		{
            inflowRate = 1; 
            chargesPerLiter = 10; 
			
        } else if ("Commercial".equalsIgnoreCase(consumerType)) 
		{
            inflowRate = 5; 
            chargesPerLiter = 20; 
        } else 
		{
            System.out.println("Invalid consumer type");
            return 0;
        }

        double totalLiters = inflowRate * duration * 60 * 60 * 24 * daysInMonth; // Total liters consumed
        double billAmount = totalLiters * chargesPerLiter; // Calculate bill amount

        return billAmount;
    }

    public void displayConsumerDetails() 
	{
        System.out.println("Consumer No: " + consumerNo);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Consumer Type: " + consumerType);
        System.out.println("No of days in Month: " + daysInMonth);
        System.out.println("Inflow rate: " + inflowRate + " Liter/Sec");
		System.out.println("Duration: " + duration + " seconds");
        System.out.println("Bill Amount: " + calculateBillAmount() + " NP");
    }
}

public class WaterBillMain
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Consumer No: ");
        int consumerNo = scanner.nextInt();

        System.out.print("Enter Consumer Name: ");
        String consumerName = scanner.next();

        System.out.print("Enter Consumer Type (Household/Commercial): ");
        String consumerType = scanner.next();

        System.out.print("Enter No of days in Month: ");
        int daysInMonth = scanner.nextInt();

        System.out.print("Enter Duration of Water supply (in seconds): ");
        int duration = scanner.nextInt();

        WaterBillCalculator consumer = new WaterBillCalculator(consumerNo, consumerName, consumerType, daysInMonth, 0, duration);
        consumer.displayConsumerDetails();
        scanner.close();
    }
}
