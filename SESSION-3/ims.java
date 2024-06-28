import java.util.Scanner;

public class ims {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input details for the new product
        System.out.print("Enter Product Category: ");
        String category = scanner.nextLine();

        System.out.print("Enter Product Brand: ");
        String brand = scanner.nextLine();

        // Generate the item code
        String itemCode = generateItemCode(category, brand);

        // Display the generated item code
        System.out.println("\nGenerated Item Code: " + itemCode);

        scanner.close();
    }

    private static String generateItemCode(String category, String brand) {
        // Use string built-in methods to create a concise item code
        String abbreviatedBrand = brand.substring(0, Math.min(3, brand.length())).toUpperCase();
        String abbreviatedCategory = category.substring(0, Math.min(3, category.length())).toUpperCase();

        // Combine the abbreviated category, brand, and a unique identifier (e.g., random number) to form the item code
        String uniqueIdentifier = generateUniqueIdentifier();
        return abbreviatedCategory + abbreviatedBrand + uniqueIdentifier;
    }

    private static String generateUniqueIdentifier() {
        // For simplicity, using a random number as a unique identifier
        int randomNumber = (int) (Math.random() * 1000);
        return String.format("%03d", randomNumber);
    }
}
