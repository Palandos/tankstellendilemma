package business.strategy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AlternatingTest {

    private Strategy strategy;

    @Before
    public void setUp() {
        strategy = new Alternating();
    }

    @Test
    public void notNullAfterInitialization() {
        assertNotNull(strategy);
    }

    @Test
    public void applyAlternatingFirstTrue() {
        assertTrue(strategy.apply());
    }

    @Test
    public void applyAlternatingSecondFalse() {
        strategy.apply();
        assertFalse(strategy.apply());
    }

    @Test
    public void applyAlternatingThirdTrue() {
        strategy.apply();
        strategy.apply();
        assertTrue(strategy.apply());
    }

    @Test
    public void testToString() {
        assertEquals("Alternating", strategy.toString());
    }

}
