package business.strategy;

public class StrategyFactory {

    public Strategy[] getAllStrategies() {
        return new Strategy[] {
            new Alternating(),
            new AlwaysCooperation(),
            new AlwaysTreason()
        };
    }
}
