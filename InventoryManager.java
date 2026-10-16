import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        String choice = "";

        while (!choice.equals("E")) {
            System.out.println();
            System.out.println("=== Inventory Management System ===");
            System.out.println("A. Add New Product");
            System.out.println("B. Remove Product by Code");
            System.out.println("C. Update Product Stock by Code");
            System.out.println("D. Display All Products");
            System.out.println("E. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextLine().toUpperCase();

            if (choice.equals("A")) {
                System.out.print("Enter product name: ");
                String name = input.nextLine();
                System.out.print("Enter product code: ");
                String code = input.nextLine();
                System.out.print("Enter price: ");
                double price = input.nextDouble();
                System.out.print("Enter stock quantity: ");
                int stock = input.nextInt();
                input.nextLine();

                if (price <= 0 || stock < 0) {
                    System.out.println("Invalid price or stock. Product not added.");
                } else {
                    products.add(new Product(name, code, price, stock));
                    System.out.println("Product added!");
                }

            } else if (choice.equals("B")) {
                System.out.print("Enter product code to remove: ");
                String code = input.nextLine();
                Product found = findProduct(products, code);

                if (found == null) {
                    System.out.println("Product not found.");
                } else {
                    products.remove(found);
                    System.out.println("Product removed.");
                }

            } else if (choice.equals("C")) {
                System.out.print("Enter product code: ");
                String code = input.nextLine();
                Product found = findProduct(products, code);

                if (found == null) {
                    System.out.println("Product not found.");
                } else {
                    System.out.print("Enter new stock quantity: ");
                    int newStock = input.nextInt();
                    input.nextLine();
                    found.setStockQuantity(newStock);
                    System.out.println("Stock updated.");
                }

            } else if (choice.equals("D")) {
                if (products.isEmpty()) {
                    System.out.println("No products in inventory.");
                } else {
                    for (Product p : products) {
                        p.displayProduct();
                    }
                    System.out.println("Total products: " + products.size());
                }

            } else if (choice.equals("E")) {
                System.out.println("Thankyou!");
                
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    public static Product findProduct(ArrayList<Product> products, String code) {
        for (Product p : products) {
            if (p.getProductCode().equalsIgnoreCase(code)) {
                return p;
            }
        }
        return null;
    }
}