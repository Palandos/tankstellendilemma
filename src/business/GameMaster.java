package business;

import business.game.IGame;

import java.io.PrintStream;

public class GameMaster {

    private int roundLimit;
    private int currentRound;
    private IGame game;
    private PrintStream outputStream;

    public GameMaster(final IGame game, final int roundLimit, final PrintStream outputStream) {
        this.currentRound = 0;
        this.game = game;
        this.roundLimit = roundLimit;
        this.outputStream = outputStream;
    }

    public void playTheGame() {
        if (!game.isValid()) {
            outputStream.println("Game is invalid!");
            return;
        }

        while (currentRound < roundLimit){
            game.playIteration();
            currentRound++;
            document();
        }
    }

    private void document() {
        outputStream.printf("Round %d: ", currentRound);
        outputStream.printf("%s\n", game.document());
    }
}
