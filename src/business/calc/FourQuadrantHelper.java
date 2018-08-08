package business.calc;

import java.io.PrintStream;
import java.util.Scanner;

public class FourQuadrantHelper {

    private Scanner scanner;
    private PrintStream output;

    public FourQuadrantHelper(final Scanner scanner, final PrintStream output) {
        this.scanner = scanner;
        this.output = output;
    }

    public FourQuadrants readFourQuadrant() {
        output.println("Please provide the value for the temptation.");
        final int temptation = scanner.nextInt();
        output.println("Please provide the value for the reward.");
        final int reward = scanner.nextInt();
        output.println("Please provide the value for the penalty.");
        final int penalty = scanner.nextInt();
        output.println("Please provide the value for the suckersPayoff.");
        final int sPayoff = scanner.nextInt();

        return new FourQuadrants(temptation, reward, penalty, sPayoff);
    }


}
