package Practice3;

import java.util.*;
import java.util.stream.Collectors;

public class TransportManagement {
    private List<Vehicle> vehicleList;

    public TransportManagement() {
        vehicleList = new ArrayList<>();
    }

    //2. Search for transport by vehicle number
    public void searchTransport(int number) {
        boolean found = false;
        for (Vehicle vehicle: vehicleList) {
            if (number == vehicle.number) {
                System.out.println("Found!");
                System.out.println("Manufacturer is: " + vehicle.manufacturer);
                System.out.println("Year of manufacture is: " + vehicle.yearOfManufacture);
                System.out.println("Color is: " + vehicle.color);
                System.out.println("Owner is: " + vehicle.owner.fullName);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Vehicle not found.");
    }

    //3. Find the vehicle owner's vehicle with the corresponding cmnd number.
    public void findVehicleFromOwner(String cmndNumber) {
        List<Vehicle> foundVehicleList = vehicleList.stream()
                .filter(vehicle -> vehicle.owner.cmndNumber.equals(cmndNumber))
                .collect(Collectors.toList());

        if (!foundVehicleList.isEmpty()) {
            System.out.println("Found!");
            int index = 1;
            for (Vehicle vehicle: foundVehicleList) {
                System.out.println(index + ". Code number: " + vehicle.number
                                    + ", manufacturer: " + vehicle.manufacturer
                                    + ", year of manufacture: " + vehicle.yearOfManufacture
                                    + ", color: " + vehicle.color);
                index++;
            }
        } else System.out.println("Owner's vehicle not found.");
    }

    //4. Delete all vehicles of any manufacturer.
    public void deleteAllVehicleOfManufacturer(String manufacturer) {
        try {
            Manufacturer checkManufacturer = Manufacturer.valueOf(manufacturer.toUpperCase());
            boolean check = vehicleList.removeIf(vehicle -> vehicle.manufacturer.equals(checkManufacturer));
            if (check) System.out.println("Delete Success!");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Don't have any " + manufacturer + " vehicle!");
        }
    }

    //5. Indicate which manufacturer has the most vehicles under management
    public void findMostCommonManufacturers() {
        Map<Manufacturer, Integer> manufacturerIntegerMap = new HashMap<>();

        for (Vehicle vehicle: vehicleList) {
            manufacturerIntegerMap.put(vehicle.manufacturer, manufacturerIntegerMap.getOrDefault(vehicle.manufacturer, 0)+1);
        }

        //Get the max value of vehicles, default value = 0
        int maxCount = manufacturerIntegerMap.values().stream().max(Comparator.naturalOrder()).orElse(0);

        List<Manufacturer> mostCommonManufacturersList = manufacturerIntegerMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                // just get KEY to put in list
                .map(Map.Entry::getKey) //method reference operator, it is used to create references to methods or constructors
                .collect(Collectors.toList());

        if (!mostCommonManufacturersList.isEmpty()) {
            System.out.println("Most common manufacturersList: ");
            for (Manufacturer manufacturer: mostCommonManufacturersList) {
                System.out.println(manufacturer.toString());
            }
            System.out.print("\n");
        }
        else System.out.print("Not found!");
    }

    //6. Sort vehicles by number of vehicles in descending order
    public void sortVehiclesDSC() {
        vehicleList.sort(Comparator.comparingInt(vehicle -> vehicle.number));
        for (Vehicle vehicle: vehicleList) {
            System.out.println(vehicle.number);
        }
    }

    //7. Statistics of each vehicle type, how many vehicles are being managed.
    public void vehicleTypeManagement() {
        Map<String, Integer> vehicleTypeMap = new HashMap<>();
        for (Vehicle vehicle : vehicleList) {
            vehicleTypeMap.put(vehicle.getClass().getSimpleName(),
                    vehicleTypeMap.getOrDefault(vehicle.getClass().getSimpleName(), 0)+1);
        }

        for (Map.Entry<String, Integer> vehicleType: vehicleTypeMap.entrySet()) {
            System.out.println(vehicleType.getKey() + ": " + vehicleType.getValue());
        }
    }

    // 1. More means of transport
    public static void main(String[] args) {
        TransportManagement transportManagementList = new TransportManagement();
        VehicleOwner owner1 = new VehicleOwner("123456789111", "Person1", "email1@abc.com");
        VehicleOwner owner2 = new VehicleOwner("123456789222", "Person2", "email2@abc.com");

        Car car1 = new Car(34567, Manufacturer.HONDA, 2010, "black", owner1, 4, "Gasoline");
        Motorcycle motorcycle1 = new Motorcycle(45678, Manufacturer.HONDA, 2020, "white", owner1, 12);
        Truck truck1 = new Truck(12345, Manufacturer.SUZUKI, 2015, "pink", owner2, 12);
        Truck truck2 = new Truck(23456, Manufacturer.TOYOTA, 2015, "white", owner2, 12);

        transportManagementList.vehicleList.add(car1);
        transportManagementList.vehicleList.add(motorcycle1);
        transportManagementList.vehicleList.add(truck1);
        transportManagementList.vehicleList.add(truck2);

//        int number = 3;
//        transportManagementList.searchTransport(number);

//        transportManagementList.deleteAllVehicleOfManufacturer("hondaa");

        transportManagementList.vehicleTypeManagement();

    }
}
