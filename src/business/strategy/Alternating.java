package business.strategy;

public class Alternating implements Strategy {

    private boolean lastDecision;

    public Alternating() {
        this.lastDecision = false;
    }

    @Override
    public boolean apply() {
        lastDecision  = !lastDecision;
        return lastDecision;
    }

}
