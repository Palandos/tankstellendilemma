package business.game;

import business.calc.ProfitMatrix;
import business.player.GasStation;
import business.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GasStationGameTest {

    private Player player1;
    private Player player2;
    private ProfitMatrix profits;

    private GasStationGame game;

    @Before
    public void setUp() {
        player1 = mock(Player.class);
        player2 = mock(GasStation.class);
        profits = mock(ProfitMatrix.class);

        game = new GasStationGame(player1, player2, profits);
    }

    @Test
    public void notNullAfterInitialization() {
        assertNotNull(game);
    }

    @Test
    public void isValidIfProfitMatrixIsValid() {
        when(profits.isValidProfitMatrix()).thenReturn(true);

        assertTrue(game.isValid());
    }

    @Test
    public void isValidIfProfitMatrixIsInvalid() {
        when(profits.isValidProfitMatrix()).thenReturn(false);

        assertFalse(game.isValid());
    }

    @Test
    public void playIterationAppliesStrategiesAndSetsMoney() {
        when(player1.applyStrategy()).thenReturn(true);
        when(player2.applyStrategy()).thenReturn(true);
        when(player1.getMoney()).thenReturn(100);
        when(player2.getMoney()).thenReturn(100);
        when(profits.calculateFor(true, true)).thenReturn(100);

        game.playIteration();

        verify(player1).applyStrategy();
        verify(player2).applyStrategy();
        verify(player1).setMoney(200);
        verify(player2).setMoney(200);
    }

    @Test
    public void documentsRightString() {
        when(player1.getMoney()).thenReturn(100);
        when(player2.getMoney()).thenReturn(200);

        assertEquals("Player1: 100; Player2: 200;", game.document());
    }

}
