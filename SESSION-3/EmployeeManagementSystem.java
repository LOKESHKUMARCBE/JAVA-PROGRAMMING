import java.util.Arrays;

public class EmployeeManagementSystem 
{

    public static void main(String[] args) 
	{
        String[] empIds = new String[]{"E101", "E105", "E102", "E104", "E103"}; // Sample empIds

        // Assign a new empId for a new employee
        String newEmpId = generateNewEmpId(empIds);
        System.out.println("New Employee Joined! Assigned EmpId: " + newEmpId);

        // View active employees in sorted order of EmpId
        viewActiveEmployees(empIds);
    }

    // Function to generate a new empId for a new employee
    private static String generateNewEmpId(String[] empIds) 
	{
        Arrays.sort(empIds); // Sort existing empIds
        int newEmpNum = 1;

        for (String empId : empIds) {
            int currentEmpNum = Integer.parseInt(empId.substring(1));

            if (currentEmpNum != newEmpNum) {
                // Found a gap in empIds, assign the new empId
                return "E" + newEmpNum;
            }

            newEmpNum++;
        }

        // All existing empIds are used, assign the next one
        return "E" + newEmpNum;
    }

    // Function to view active employees in sorted order of EmpId
    private static void viewActiveEmployees(String[] empIds) {
        Arrays.sort(empIds);
        System.out.println("Active Employees in Sorted Order of EmpId:");
        for (String empId : empIds) 
		{
            System.out.println(empId);
        }
    }
}
