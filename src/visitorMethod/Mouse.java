package visitorMethod;

public class Mouse implements IComputerPart{
    @Override
    public void accept(IComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
