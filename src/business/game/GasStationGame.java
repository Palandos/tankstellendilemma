package business.game;

import business.calc.ProfitMatrix;
import business.player.Player;

public class GasStationGame implements IGame {

    private final Player player1;
    private final Player player2;
    private final ProfitMatrix profits;

    public GasStationGame(final Player player1, final Player player2, final ProfitMatrix profitMatrix) {
        this.player1 = player1;
        this.player2 = player2;
        this.profits = profitMatrix;
    }

    @Override
    public boolean isValid() {
        return profits.isValidProfitMatrix();
    }

    @Override
    public void playIteration() {
        final boolean player1Cooperates = player1.applyStrategy();
        final boolean player2Cooperates = player2.applyStrategy();

        player1.setMoney(player1.getMoney() + profits.calculateFor(player1Cooperates, player2Cooperates));
        player2.setMoney(player2.getMoney() + profits.calculateFor(player2Cooperates, player1Cooperates));
    }

    @Override
    public String document() {
        return "Player1: " + player1.getMoney() + "; Player2: " + player2.getMoney() + ";";
    }
}
