package Practice2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InventoryManagement {
    private List<Goods> productList;

    public InventoryManagement() {
        productList = new ArrayList<>();
    }

    public void addGoods() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type the product code: ");
        int newProductCode = scanner.nextInt();
        scanner.nextLine();

        //check duplicate
        for (Goods good: productList) {
            if (good.code == newProductCode) {
                System.out.println("This product has already existed!");
                return;
            }
        }

        System.out.print("Type the name: ");
        String newProductName = scanner.nextLine();
        System.out.print("Type the quantity: ");
        int newProductQuantity = scanner.nextInt();
        scanner.nextLine(); // Xử lý newline còn lại
        System.out.print("Type the unit price: ");
        int newProductUnitPrice = scanner.nextInt();
        scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("1. Electronics");
        System.out.println("2. Food");
        System.out.println("3. Crockery");
        System.out.print("Choose the type of goods to add: ");
        int choice =  scanner.nextInt();
        scanner.nextLine(); //Consume newline

        switch (choice) {
            case 1:
                System.out.print("Type the warranty period (months): ");
                int newWarrantyPeriod = scanner.nextInt();

                System.out.print("Type the capacity (KW): ");
                int newCapacity = scanner.nextInt();

                Electronic electronic = new Electronic(newProductCode, newProductName, newProductQuantity, newProductUnitPrice, newWarrantyPeriod, newCapacity);
                productList.add(electronic);
                break;
            case 2:
                System.out.print("Type the manufacture date (dd-MM-yyyy): ");
                String inputNewManufactureDate = scanner.nextLine();
                LocalDate newManufactureDate = LocalDate.parse(inputNewManufactureDate, formatter);

                System.out.print("Type the expiration date (dd-MM-yyyy): ");
                String inputNewExpirationDate = scanner.nextLine();
                LocalDate newExpirationDate = LocalDate.parse(inputNewExpirationDate, formatter);

                System.out.print("Type the supplier: ");
                String newSupplier = scanner.nextLine();

                Food food = new Food(newProductCode, newProductName, newProductQuantity, newProductUnitPrice, newManufactureDate, newExpirationDate, newSupplier);
                productList.add(food);
                break;
            case 3:
                System.out.print("Type the manufacture information: ");
                String newManufactureInfo = scanner.nextLine();

                System.out.print("Type the date of arrival: ");
                String inputNewArrivalDate = scanner.nextLine();
                LocalDate newArrivalDate = LocalDate.parse(inputNewArrivalDate, formatter);

                Crockery crockery = new Crockery(newProductCode, newProductName, newProductQuantity, newProductUnitPrice, newManufactureInfo, newArrivalDate);
                productList.add(crockery);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        System.out.println("Goods added successfully.");
    }
    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        inventoryManagement.addGoods();
    }
}
