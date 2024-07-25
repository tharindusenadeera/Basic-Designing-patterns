import adaptermethod.AudioPlayer;
import bridgeMethod.Circle;
import bridgeMethod.GreenCircle;
import bridgeMethod.RedCircle;
import builderMethod.Phone;
import builderMethod.PhoneBuilder;
import factoryMethod.Client;
import factoryMethod.Vehicle;
import factoryMethod.VehicleFactory;
import filterMethod.*;
import prototypeMethod.Shape;
import prototypeMethod.ShapeCache;
import singletonMethod.SingleObject;

import java.util.ArrayList;
import java.util.List;

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

        // With Prototype method example
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());

        // With Adapter method example
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");

        // With Bridge method example
        bridgeMethod.Shape redCircle = new Circle(100,100, 10, new RedCircle());
        bridgeMethod.Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();

        // With Filter method example
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
    }

    public static void printPersons(List<Person> persons){
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName() + ", Gender : " + person.getGender() + ", Marital Status : " + person.getMaritalStatus() + " ]");
        }
    }
}