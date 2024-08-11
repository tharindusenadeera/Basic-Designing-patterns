import adaptermethod.AudioPlayer;
import bridgeMethod.Circle;
import bridgeMethod.GreenCircle;
import bridgeMethod.RedCircle;
import builderMethod.Phone;
import builderMethod.PhoneBuilder;
import commandMethod.Broker;
import commandMethod.BuyStock;
import commandMethod.SellStock;
import commandMethod.Stock;
import compositeMethod.Employee;
import decoratorMethod.CircleD;
import decoratorMethod.IShape;
import decoratorMethod.RectangleD;
import decoratorMethod.RedShapeDecorator;
import facadeMethod.ShapeMaker;
import factoryMethod.Client;
import factoryMethod.Vehicle;
import factoryMethod.VehicleFactory;
import filterMethod.*;
import flyWeightMethod.CircleFly;
import flyWeightMethod.ShapeFactoryFly;
import interpreterMethod.AndExpression;
import interpreterMethod.IExpress;
import interpreterMethod.OrExpression;
import interpreterMethod.TerminalExpression;
import observerMethod.BinaryObserver;
import observerMethod.HexaObserver;
import observerMethod.OctalObserver;
import observerMethod.Subject;
import prototypeMethod.Shape;
import prototypeMethod.ShapeCache;
import proxyMethod.Image;
import proxyMethod.ProxyImage;
import singletonMethod.SingleObject;
import strategyMethod.Context;
import strategyMethod.OperationAdd;
import strategyMethod.OperationMultiply;
import strategyMethod.OperationSubtract;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };
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

        // With Composite method example
        Employee CEO = new Employee("John","CEO", 30000);
        Employee headSales = new Employee("Robert","Head Sales", 20000);

        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //print all employees of the organization
        System.out.println(CEO);

        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);

            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }

        // With Decorator method example
        IShape circleD = new CircleD();
        IShape redCircleD = new RedShapeDecorator(new CircleD());
        IShape redRectangleD = new RedShapeDecorator(new RectangleD());
        System.out.println("Circle with normal border");
        circleD.draw();

        System.out.println("\nCircle of red border");
        redCircleD.draw();

        System.out.println("\nRectangle of red border");
        redRectangleD.draw();

        // With Facade method example
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();

        // With Proxy method example
        Image image = new ProxyImage("test_10mb.jpg");
        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();

        // With Flyweight method example
        for (int i = 0; i < 20; i++) {
            CircleFly circleFly = (CircleFly) ShapeFactoryFly.getCircle(getRandomColor());
            circleFly.setX(getRandomX());
            circleFly.setY(getRandomY());
            circleFly.setRadius(100);
            circleFly.draw();
        }

        // With Command method example
        Stock stock = new Stock();

        BuyStock buyStockOrder = new BuyStock(stock);
        SellStock sellStockOrder = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();

        // With Interpreter method example
        IExpress isMale = getMaleExpression();
        IExpress isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));

        // With Observer method example
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);

        // With Strategy method example
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeOperation(10, 5));

        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeOperation(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeOperation(10, 5));
    }

    public static void printPersons(List<Person> persons){
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName() + ", Gender : " + person.getGender() + ", Marital Status : " + person.getMaritalStatus() + " ]");
        }
    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }

    //Rule: Robert and John are male
    public static IExpress getMaleExpression(){
        IExpress robert = new TerminalExpression("Robert");
        IExpress john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    //Rule: Julie is a married women
    public static IExpress getMarriedWomanExpression(){
        IExpress julie = new TerminalExpression("Julie");
        IExpress married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }
}