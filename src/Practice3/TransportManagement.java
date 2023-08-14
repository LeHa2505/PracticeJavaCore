package Practice3;

import java.util.ArrayList;
import java.util.List;

public class TransportManagement {
    private List<Vehicle> vehicleList;

    public TransportManagement() {
        vehicleList = new ArrayList<>();
    }

    // 1. More means of transport
    public static void main(String[] args) {
        TransportManagement transportManagementList = new TransportManagement();
        VehicleOwner owner1 = new VehicleOwner("123456789111", "Person1", "email1@abc.com");
        VehicleOwner owner2 = new VehicleOwner("123456789222", "Person2", "email2@abc.com");

        Car car1 = new Car(1, Manufacturer.HONDA, 2010, "black", owner1, 4, "Gasoline");
        Motorcycle motorcycle1 = new Motorcycle(2, Manufacturer.HONDA, 2020, "white", owner1, 12);
        Truck truck1 = new Truck(3, Manufacturer.SUZUKI, 2015, "pink", owner2, 12);

        transportManagementList.vehicleList.add(car1);
        transportManagementList.vehicleList.add(motorcycle1);
        transportManagementList.vehicleList.add(truck1);


    }
}
