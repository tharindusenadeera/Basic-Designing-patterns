package strategyMethod;

public class Context {
    private IStrategy iStrategy;

    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public int executeOperation(int num1, int num2){
        return iStrategy.doOperation(num1, num2);
    }
}
