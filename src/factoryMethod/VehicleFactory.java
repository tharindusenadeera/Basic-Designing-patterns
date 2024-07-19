package factoryMethod;

public class VehicleFactory {
    public Vehicle getInstance(String str) {
        if (str.equals("two")) {
            return new TwoWheeler();
        }else if (str.equals("three")) {
            return new ThreeWheeler();
        } else {
            return new FourWheeler();
        }
    }
}
