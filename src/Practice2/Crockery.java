package Practice2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Crockery extends Goods{
    private String manufactureInfo;
    private LocalDate dateOfArrival;

    public Crockery(int code, String name, int quantity, double unitPrice,
                    String manufactureInfo, LocalDate dateOfArrival) {
        super(code, name, quantity, unitPrice);
        this.manufactureInfo = manufactureInfo;
        this.dateOfArrival = dateOfArrival;
    }

    @Override
    public double caculatedVAT() {
        return 0.1 * unitPrice * quantity;
    }

    @Override
    public void measureConsumption() {
        LocalDate currentDate = LocalDate.now();
        if (quantity > 50 && ChronoUnit.DAYS.between(currentDate, dateOfArrival) > 10) {
            System.out.println("Slow sale");
        }
        else System.out.println("Not evaluated");
    }

}
