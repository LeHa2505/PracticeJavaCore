package Practice2;

public class Electronic extends Goods {
    private int warrantyPeriod;
    private int capacity;

    public Electronic(int code, String name, int quantity, double unitPrice,
                      int warrantyPeriod, int capacity) {
        super(code, name, quantity, unitPrice);
        if (warrantyPeriod < 0 || capacity < 0) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }

        this.warrantyPeriod = warrantyPeriod;
        this.capacity = capacity;
    }

    @Override
    public double caculatedVAT() {
        return 0.1 * unitPrice * quantity;
    }

    @Override
    public void measureConsumption() {
        if (quantity < 3) {
            System.out.println("Sold");
        }
        else System.out.println("Not evaluated");
    }

}
