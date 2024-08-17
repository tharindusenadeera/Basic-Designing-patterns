package visitorMethod;

public interface IComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Monitor monitor);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
}
