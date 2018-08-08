package business.strategy;

public class AlwaysTreason implements Strategy {

    public AlwaysTreason() {}

    @Override
    public boolean apply() {
        return false;
    }

    @Override
    public String toString() {
        return "AlwaysTreason";
    }
}
