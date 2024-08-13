package stateMethod;

public class StopState implements IState{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setiState(this);
    }

    public String toString(){
        return "Stop State";
    }
}
