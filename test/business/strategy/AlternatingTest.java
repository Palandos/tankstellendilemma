package business.strategy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AlternatingTest {

    private Strategy strategy;

    @Test
    public void notNullAfterInitialization() {
        strategy = new Alternating();
        assertNotNull(strategy);
    }

    @Test
    public void applyAlternatingFirstTrue() {
        strategy = new Alternating();
        assertTrue(strategy.apply());
    }

    @Test
    public void applyAlternatingSecondFalse() {
        strategy = new Alternating();
        strategy.apply();
        assertFalse(strategy.apply());
    }

    @Test
    public void applyAlternatingThirdTrue() {
        strategy = new Alternating();
        strategy.apply();
        strategy.apply();
        assertTrue(strategy.apply());
    }

}
