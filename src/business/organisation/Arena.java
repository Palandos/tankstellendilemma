package business.organisation;

import business.calc.FourQuadrantHelper;
import business.calc.ProfitMatrix;
import business.game.GasStationGame;
import business.game.IGame;
import business.player.GasStation;
import business.player.Player;
import business.strategy.Strategy;
import business.strategy.StrategyFactory;

import java.io.PrintStream;
import java.util.Scanner;

public class Arena {

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final PrintStream output = System.out;

        playTheGamesOut(input, output);
    }

    private static void playTheGamesOut(final Scanner input, final PrintStream output) {
        // Create Strategy Arrays
        final StrategyFactory strategyFactory = new StrategyFactory();
        final Strategy[] strategiesPlayer1 = strategyFactory.getAllStrategies();
        final Strategy[] strategiesPlayer2 = strategyFactory.getAllStrategies();

        // Create ProfitMatrix
        final FourQuadrantHelper helper = new FourQuadrantHelper(input, output);
        final ProfitMatrix profitMatrix = helper.readFourQuadrant();

        // GetRoundLimit
        output.println("Please provide the amount of rounds to be played.");
        final int roundLimit = input.nextInt();

        for (int i = 0; i < strategiesPlayer1.length; i++) {
            for (int j = i; j < strategiesPlayer2.length; j++) {
                // Create Players for the game
                final Player player1 = new GasStation(strategiesPlayer1[i]);
                final Player player2 = new GasStation(strategiesPlayer2[j]);

                // Create the game
                final IGame game = new GasStationGame(player1, player2, profitMatrix);

                // Create master for the game
                final GameMaster master = new GameMaster(game, roundLimit, output);

                // Play the game
                final int[] result = master.playTheGame();
                output.printf("Player1 with strategy %s: %d, Player2 with strategy %s: %d\n",
                        strategiesPlayer1[i].getName(), result[0],
                        strategiesPlayer2[j].getName(), result[1]);
            }
        }
    }

}
