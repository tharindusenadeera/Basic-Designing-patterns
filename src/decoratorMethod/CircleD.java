package decoratorMethod;

public class CircleD implements IShape{
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
