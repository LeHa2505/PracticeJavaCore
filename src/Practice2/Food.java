package Practice2;

import java.time.LocalDate;

public class Food extends Goods{
    private LocalDate manufactureDate;
    private LocalDate expirationDate;
    private String supplier;

    public Food(int code, String name, int quantity, double unitPrice,
                LocalDate manufactureDate, LocalDate expirationDate, String supplier) {
        super(code, name, quantity, unitPrice);

        if (expirationDate.isBefore(manufactureDate)) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }

        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.supplier = supplier;
    }

    @Override
    public double caculatedVAT() {
        return 0.05 * unitPrice * quantity;
    }

    @Override
    public void measureConsumption() {
        LocalDate currentDate = LocalDate.now();
        if (quantity > 0 && expirationDate.isBefore(currentDate)) {
            System.out.println("Hard to sell");
        }
        else System.out.println("Not evaluated");
    }
}
