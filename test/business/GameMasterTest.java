package business;

import business.game.IGame;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

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
    public void documentGameRound1() {
        when(game.isValid()).thenReturn(true);
        when(game.document()).thenReturn("Hello World");
        final GameMaster master = new GameMaster(game, 1, outputStream);

        master.playTheGame();

        verify(outputStream).printf("Round %d: ", 1);
        verify(outputStream).printf("%s\n", "Hello World");
    }
}
