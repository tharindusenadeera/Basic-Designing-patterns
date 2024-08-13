package stateMethod;

public class StartState implements IState{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setiState(this);
    }

    public String toString(){
        return "Start State";
    }
}
