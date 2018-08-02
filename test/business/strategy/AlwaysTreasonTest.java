package business.strategy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class AlwaysTreasonTest {

    private Strategy strategy;

    @Test
    public void notNullAfterInitialization() {
        strategy = new AlwaysTreason();
        assertNotNull(strategy);
    }

    @Test
    public void applyAlwaysTreasonFirstFalse() {
        strategy = new AlwaysTreason();
        assertFalse(strategy.apply());
    }

    @Test
    public void applyAlwaysTreasonFirst100False() {
        strategy = new AlwaysTreason();
        for (int n = 0; n < 100; n++) {
            assertFalse(strategy.apply());
        }
    }

}
