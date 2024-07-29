package interpreterMethod;

public class TerminalExpression implements IExpress{
    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }
    @Override
    public boolean interpret(String context) {

        if(context.contains(data)){
            return true;
        }
        return false;
    }
}
