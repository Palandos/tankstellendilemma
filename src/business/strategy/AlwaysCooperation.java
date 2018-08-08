package business.strategy;

public class AlwaysCooperation implements Strategy {

    public AlwaysCooperation() {}

    @Override
    public boolean apply() {
        return true;
    }

}
