package Practice3;

public class Car extends Vehicle{
    protected int numberOfSeats;
    protected String engineType;

    public Car(int number, Manufacturer manufacturer, int yearOfManufacture, String color, VehicleOwner owner,
               int numberOfSeats,String engineType) {
        super(number, manufacturer, yearOfManufacture, color, owner);
        this.numberOfSeats = numberOfSeats;
        this.engineType = engineType;
    }
}
