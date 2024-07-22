package bridgeMethod;

public abstract class Shape{
    public DrawAPI drawAPI;

    public Shape(){}

    public String draw(){
        return "Draw";
    }
}
