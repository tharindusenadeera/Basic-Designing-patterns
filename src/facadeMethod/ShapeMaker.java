package facadeMethod;

public class ShapeMaker {
    private IShapeF circle;
    private IShapeF rectangle;
    private IShapeF square;

    public ShapeMaker() {
        circle = new CircleF();
        rectangle = new RectangleF();
        square = new SquareF();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}
