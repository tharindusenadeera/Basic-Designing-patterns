import factoryMethod.Client;
import factoryMethod.Vehicle;
import factoryMethod.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        // Without Factory method example
        Client pClient = new Client(5);
        Vehicle pVehicle = pClient.getVehicle();

        if (pVehicle != null) {
            pVehicle.printVehicle();
        }
        pClient.cleanUp();

        // With Factory method example
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle = vehicleFactory.getInstance("two");
        vehicle.printVehicle();
    }
}