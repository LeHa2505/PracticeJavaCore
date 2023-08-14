package Practice3;

public class Vehicle {
    protected int number;
    protected Manufacturer manufacturer;
    protected int yearOfManufacture;
    protected String color;
    protected VehicleOwner owner;

    public Vehicle(int number, Manufacturer manufacturer, int yearOfManufacture, String color, VehicleOwner owner) {
        this.number = number;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.owner = owner;
    }
}
