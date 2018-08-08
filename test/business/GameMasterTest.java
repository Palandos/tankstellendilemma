package business;

import business.game.IGame;
import business.organisation.GameMaster;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameMasterTest {

    private final static int ROUND_LIMIT = 10;
    private IGame game;
    private PrintStream outputStream;

    private GameMaster gameMaster;

    @Before
    public void setUp() {
        game = mock(IGame.class);
        outputStream = mock(PrintStream.class);

        gameMaster = new GameMaster(game, ROUND_LIMIT, outputStream);
    }

    @Test
    public void notNullAfterInitialization() {
        assertNotNull(gameMaster);
    }

    @Test
    public void playTheGameOnlyIfGameIsValid() {
        when(game.isValid()).thenReturn(false);

        gameMaster.playTheGame();

        verify(game, times(0)).playIteration();
    }

    @Test
    public void roundLimit10Plays10Rounds() {
        when(game.isValid()).thenReturn(true);

        gameMaster.playTheGame();

        verify(game, times(ROUND_LIMIT)).playIteration();
    }

    @Test
    public void resultGameRound1() {
        when(game.isValid()).thenReturn(true);
        when(game.getResult()).thenReturn(new int[] {300, 200});
        final GameMaster master = new GameMaster(game, 1, outputStream);

        final int[] result = master.playTheGame();

        assertEquals(300, result[0]);
        assertEquals(200, result[1]);
    }
}
