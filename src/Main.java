import builderMethod.Phone;
import builderMethod.PhoneBuilder;
import factoryMethod.Client;
import factoryMethod.Vehicle;
import factoryMethod.VehicleFactory;
import singletonMethod.SingleObject;

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

        // Without builder method example
        Phone p = new Phone("Andriod", 1, "Octa Core", 5.5, 3100);
        System.out.println(p);

        // With builder method example
        Phone phone = new PhoneBuilder().setOs("Android").setRam(1).getPhone();
        System.out.println(phone);

        // With singleton method example
        SingleObject singleObject = SingleObject.getSingleObject();
        singleObject.showMessage();
    }
}