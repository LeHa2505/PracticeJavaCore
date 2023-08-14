package Practice3;

public class Truck extends Vehicle{
    protected double tonnage;

    public Truck(int number, Manufacturer manufacturer, int yearOfManufacture, String color, VehicleOwner owner,
                      double tonnage) {
        super(number, manufacturer, yearOfManufacture, color, owner);
        this.tonnage = tonnage;
    }
}
