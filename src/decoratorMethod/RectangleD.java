package decoratorMethod;

public class RectangleD implements IShape{
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
