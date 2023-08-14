package Practice2;

abstract class Goods {
    protected int code;
    protected String name;
    protected int quantity;
    protected double unitPrice;

    public Goods(int code, String name, int quantity, double unitPrice) {
        this.code = code;
        this.name = name;

        if (quantity < 0) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }

        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public abstract double caculatedVAT();

    public abstract void measureConsumption();



}
