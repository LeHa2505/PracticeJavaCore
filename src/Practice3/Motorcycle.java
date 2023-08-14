package Practice3;

public class Motorcycle extends Vehicle{
    protected double capacity;

    public Motorcycle(int number, Manufacturer manufacturer, int yearOfManufacture, String color, VehicleOwner owner,
                      double capacity) {
        super(number, manufacturer, yearOfManufacture, color, owner);
        this.capacity = capacity;
    }
}
