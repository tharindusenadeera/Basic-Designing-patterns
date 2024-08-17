package visitorMethod;

public class Keyboard implements IComputerPart{
    @Override
    public void accept(IComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
