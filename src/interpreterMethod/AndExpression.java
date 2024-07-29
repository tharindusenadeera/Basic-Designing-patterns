package interpreterMethod;

public class AndExpression implements IExpress{
    private IExpress expr1 = null;
    private IExpress expr2 = null;

    public AndExpression(IExpress expr1, IExpress expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}
