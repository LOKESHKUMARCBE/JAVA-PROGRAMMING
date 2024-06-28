import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Transaction implements Comparable<Transaction> 
{
    private int billNumber;
    private double amount;
    private String date;
    private String time;

    public Transaction(int billNumber, double amount, String date, String time) 
	{
        this.billNumber = billNumber;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Bill Number: " + billNumber + ", Amount: Rs." + amount + ", Date: " + date + ", Time: " + time;
    }

    @Override
    public int compareTo(Transaction other) {
        // Compare transactions based on their date and time
        int dateComparison = this.date.compareTo(other.date);
        if (dateComparison != 0) {
            return dateComparison;
        }
        return this.time.compareTo(other.time);
    }
}

public class demo2
 {
    public static void main(String[] args) {
        Set<Transaction> transactionHistory = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to ABC Corp Financial Management System!");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Transaction");
            System.out.println("2. Remove Transaction");
            System.out.println("3. Display Transaction History");
            System.out.println("4. Calculate Total Amount of Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter bill number: ");
                    int billNumber = scanner.nextInt();
                    System.out.print("Enter transaction amount: Rs.");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter time (HH:MM:SS): ");
                    String time = scanner.nextLine();
                    Transaction transaction = new Transaction(billNumber, amount, date, time);
                    transactionHistory.add(transaction);
                    System.out.println("Transaction added successfully!");
                    break;
                case 2:
                    System.out.print("Enter date & time of transaction to remove (YYYY-MM-DD HH:MM:SS): ");
                    String dateTimeToRemove = scanner.nextLine();
                    Transaction dummyTransaction = new Transaction(0, 0, dateTimeToRemove.split(" ")[0], dateTimeToRemove.split(" ")[1]);
                    if (transactionHistory.contains(dummyTransaction)) {
                        transactionHistory.remove(dummyTransaction);
                        System.out.println("Transaction removed successfully!");
                    } else {
                        System.out.println("Error: Transaction not found!");
                    }
                    break;
                case 3:
                    System.out.println("\nTransaction History:");
                    transactionHistory.forEach(System.out::println);
                    break;
                case 4:
                    double totalAmount = 0;
                    for (Transaction t : transactionHistory) {
                        totalAmount += t.getAmount();
                    }
                    System.out.println("Total amount of transactions: Rs." + totalAmount);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 5.");
                    break;
            }
        }

        System.out.println("\nThank you for using ABC Corp Financial Management System!");
        scanner.close();
    }
}
