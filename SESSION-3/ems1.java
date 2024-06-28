import java.util.Scanner;

class Employee {
    private int empId;
    private String empName;
    private String empStatus;

    public Employee(int empId, String empName, String empStatus) {
        this.empId = empId;
        this.empName = empName;
        this.empStatus = empStatus;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    // Use string built-in methods to check if the employee's name contains the search string
    public boolean containsSearchString(String searchString) {
        return empName.toLowerCase().contains(searchString.toLowerCase());
    }
}

public class ems1 {
    private static final int MAX_EMPLOYEES = 100;
    private static Employee[] employeeList = new Employee[MAX_EMPLOYEES];
    private static int nextEmpId = 1;
    private static int totalEmployees = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nEmployee Management System - Max Consulting Pvt Ltd.");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    searchEmployee(scanner);
                    break;
                case 3:
                    viewAllEmployees();
                    break;
                case 4:
                    System.out.println("Exiting the Employee Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addEmployee(Scanner scanner) {
        if (totalEmployees < MAX_EMPLOYEES) {
            System.out.print("Enter Employee Name: ");
            String empName = scanner.nextLine();

            employeeList[totalEmployees++] = new Employee(nextEmpId++, empName, "Active");

            System.out.println("Employee added successfully. Employee ID: " + (nextEmpId - 1));
        } else {
            System.out.println("Employee list is full. Cannot add more employees.");
        }
    }

    private static void searchEmployee(Scanner scanner) {
        System.out.print("Enter Employee Name to search: ");
        String searchString = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < totalEmployees; i++) {
            if (employeeList[i].containsSearchString(searchString)) {
                System.out.println("Employee found with details:");
                System.out.println("Employee ID: " + employeeList[i].getEmpId());
                System.out.println("Employee Name: " + employeeList[i].getEmpName());
                System.out.println("Employee Status: " + employeeList[i].getEmpStatus());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found with the given name.");
        }
    }

    private static void viewAllEmployees() {
        System.out.println("\nList of all Employees:");
        for (int i = 0; i < totalEmployees; i++) {
            System.out.println("Employee ID: " + employeeList[i].getEmpId());
            System.out.println("Employee Name: " + employeeList[i].getEmpName());
            System.out.println("Employee Status: " + employeeList[i].getEmpStatus());
            System.out.println("------------------------");
        }
    }
}
