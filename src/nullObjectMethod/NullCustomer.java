package nullObjectMethod;

public class NullCustomer extends AbstractCustomer{
    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }
}
