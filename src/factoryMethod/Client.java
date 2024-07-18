package factoryMethod;

public class Client {
    private Vehicle pVehicle;

    public Client(int type) {
        if (type == 1) {
            pVehicle = new TwoWheeler();
        } else if (type == 2) {
            pVehicle = new ThreeWheeler();
        } else {
            pVehicle = new FourWheeler();
        }
    }

    public void cleanUp() {
        if (pVehicle != null){
            pVehicle = null;
        }
    }

    public Vehicle getVehicle() {
        return pVehicle;
    }
}
