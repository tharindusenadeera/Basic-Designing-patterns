package visitorMethod;

public class Computer implements IComputerPart{
    IComputerPart[] parts;

    public Computer(){
        parts = new IComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }
    @Override
    public void accept(IComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
