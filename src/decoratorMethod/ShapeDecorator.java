package decoratorMethod;

public abstract class ShapeDecorator implements IShape{
    public IShape iShape;

    public ShapeDecorator(IShape iShape) {
        this.iShape = iShape;
    }

    @Override
    public void draw() {
        iShape.draw();
    }
}
