package business.strategy;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AlwaysCooperationTest {

    private Strategy strategy;

    @Test
    public void notNullAfterInitialization() {
        strategy = new AlwaysCooperation();
        assertNotNull(strategy);
    }

    @Test
    public void applyAlwaysCooperationFirstTrue() {
        strategy = new AlwaysCooperation();
        assertTrue(strategy.apply());
    }

    @Test
    public void applyAlwaysCooperationFirst100True() {
        strategy = new AlwaysCooperation();
        for (int n = 0; n < 100; n++) {
            assertTrue(strategy.apply());
        }
    }
}
