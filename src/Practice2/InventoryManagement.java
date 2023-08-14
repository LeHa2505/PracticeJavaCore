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

        System.out.println("Choose the type of goods to add:");
        System.out.println("1. Electronics");
        System.out.println("2. Food");
        System.out.println("3. Crockery");

        int choice = scanner.nextInt(); //Consume newline
        System.out.println("Type the product code: ");
        int newProductCode = scanner.nextInt();

        //check duplicate
        for (Goods good: productList) {
            if (good.code == newProductCode) {
                System.out.println("This product has already existed!");
                return;
            }
        }

        System.out.println("Type the name: ");
        String newProductName = scanner.nextLine();
        System.out.println("Type the quantity: ");
        int newProductQuantity = scanner.nextInt();
        System.out.println("Type the unit price: ");
        int newProductUnitPrice = scanner.nextInt();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


        switch (choice) {
            case 1:
                System.out.println("Type the warranty period (months): ");
                int newWarrantyPeriod = scanner.nextInt();

                System.out.println("Type the capacity (KW): ");
                int newCapacity = scanner.nextInt();

                Electronic electronic = new Electronic(newProductCode, newProductName, newProductQuantity, newProductUnitPrice, newWarrantyPeriod, newCapacity);
                productList.add(electronic);
                break;
            case 2:
                System.out.println("Type the manufacture date (dd-MM-yyyy): ");
                String inputNewManufactureDate = scanner.nextLine();
                LocalDate newManufactureDate = LocalDate.parse(inputNewManufactureDate, formatter);

                System.out.println("Type the expiration date (dd-MM-yyyy): ");
                String inputNewExpirationDate = scanner.nextLine();
                LocalDate newExpirationDate = LocalDate.parse(inputNewExpirationDate, formatter);

                System.out.println("Type the supplier: ");
                String newSupplier = scanner.nextLine();

                Food food = new Food(newProductCode, newProductName, newProductQuantity, newProductUnitPrice, newManufactureDate, newExpirationDate, newSupplier);
                productList.add(food);
                break;
            case 3:
                System.out.println("Type the manufacture information: ");
                String newManufactureInfo = scanner.nextLine();

                System.out.println("Type the date of arrival: ");
                String inputNewArrivalDate = scanner.nextLine();
                LocalDate newArrivalDate = LocalDate.parse(inputNewArrivalDate, formatter);

                Crockery crockery = new Crockery(newProductCode, newProductName, newProductQuantity, newProductUnitPrice, newManufactureInfo, newArrivalDate);
                productList.add(crockery);
                break;
            default:
                System.out.println("Invalid choice.");
        }
        System.out.println("Goods added successfully.");
    }
    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        inventoryManagement.addGoods();
    }
}
