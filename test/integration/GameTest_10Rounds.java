package integration;

import business.organisation.GameMaster;
import business.calc.FourQuadrants;
import business.calc.ProfitMatrix;
import business.game.GasStationGame;
import business.game.IGame;
import business.player.GasStation;
import business.player.Player;
import business.strategy.Alternating;
import business.strategy.AlwaysCooperation;
import business.strategy.AlwaysTreason;
import business.strategy.Strategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest_10Rounds {

    private int roundLimit;
    private ProfitMatrix profitMatrix;

    @Before
    public void setUp() {
        this.roundLimit = 10;
        this.profitMatrix = new FourQuadrants(1000, 300, -500, -3000);
    }

    @Test
    public void testTreasonCoop() {
        // Given
        final Strategy alwaysTreason = new AlwaysTreason();
        final Player player1 = new GasStation(alwaysTreason);
        final Strategy alwaysCoop = new AlwaysCooperation();
        final Player player2 = new GasStation(alwaysCoop);
        final IGame game = new GasStationGame(player1, player2, profitMatrix);

        final GameMaster master = new GameMaster(game, roundLimit, System.out);

        // When
        final int[] result = master.playTheGame();

        // Then
        assertEquals(10000, result[0]);
        assertEquals(-30000, result[1]);
    }

    @Test
    public void testAlternationCoop() {
        // Given
        final Strategy alternation = new Alternating();
        final Player player1 = new GasStation(alternation);
        final Strategy alwaysCoop = new AlwaysCooperation();
        final Player player2 = new GasStation(alwaysCoop);
        final IGame game = new GasStationGame(player1, player2, profitMatrix);

        final GameMaster master = new GameMaster(game, roundLimit, System.out);

        // When
        final int[] result = master.playTheGame();

        // Then
        assertEquals(6500, result[0]);
        assertEquals(-13500, result[1]);
    }

    @Test
    public void testTreasonAlternation() {
        // Given
        final Strategy treason = new AlwaysTreason();
        final Player player1 = new GasStation(treason);
        final Strategy alternation = new Alternating();
        final Player player2 = new GasStation(alternation);
        final IGame game = new GasStationGame(player1, player2, profitMatrix);

        final GameMaster master = new GameMaster(game, roundLimit, System.out);

        // When
        final int[] result = master.playTheGame();

        // Then
        assertEquals(2500, result[0]);
        assertEquals(-17500, result[1]);
    }

}
