package decoratorMethod;

public class RedShapeDecorator extends ShapeDecorator{
    public IShape iShape;
    public RedShapeDecorator(IShape iShape) {
        super(iShape);
        this.iShape = iShape;
    }

    @Override
    public void draw() {
        setRedBorder(iShape);
    }

    private void setRedBorder(IShape shape) {
        System.out.println("Border Color: Red");
    }
}
