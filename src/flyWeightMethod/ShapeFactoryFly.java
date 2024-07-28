package flyWeightMethod;

import java.util.HashMap;

public class ShapeFactoryFly {
    public static final HashMap circleMap = new HashMap();

    public static IShapeFly getCircle(String color){
        CircleFly circleFly = (CircleFly)circleMap.get(color);

        if(circleFly == null) {
            circleFly = new CircleFly(color);
            circleMap.put(color, circleFly);
            System.out.println("Creating circle of color : " + color);
        }
        return circleFly;
    }
}
