package business.player;

import business.strategy.Strategy;

public class GasStation implements Player {

    private final Strategy strategy;
    private int money = 0;

    public GasStation(final Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public boolean applyStrategy() {
        return strategy.apply();
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public void setMoney(final int money) {
        this.money = money;
    }
}
