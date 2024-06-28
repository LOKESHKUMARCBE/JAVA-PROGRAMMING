import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Transaction {
    private int billNumber;
    private double amount;
    private String date;
    private String time;

    public Transaction(int billNumber, double amount, String date, String time) {
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
        return "Bill Number: " + billNumber + ", Amount: $" + amount + ", Date: " + date + ", Time: " + time;
    }
}

public class demo3 {
    public static void main(String[] args) {
        List<Transaction> transactionHistory = new ArrayList<>();
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
                    System.out.print("Enter transaction amount: $");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter time (HH:MM:SS): ");
                    String time = scanner.nextLine();
                    Transaction transaction = new Transaction(billNumber, amount, date, time);
                    transactionHistory.add(transaction);
                    Collections.sort(transactionHistory, Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime));
                    System.out.println("Transaction added successfully!");
                    break;
                case 2:
                    System.out.print("Enter date & time of transaction to remove (YYYY-MM-DD HH:MM:SS): ");
                    String dateTimeToRemove = scanner.nextLine();
                    for (Transaction t : transactionHistory) {
                        if (t.getDate().equals(dateTimeToRemove.split(" ")[0]) && t.getTime().equals(dateTimeToRemove.split(" ")[1])) {
                            transactionHistory.remove(t);
                            System.out.println("Transaction removed successfully!");
                            break;
                        }
                    }
                    System.out.println("Error: Transaction not found!");
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
                    System.out.println("Total amount of transactions: $" + totalAmount);
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
