package business.strategy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AlwaysCooperationTest {

    private Strategy strategy;

    @Before
    public void setUp() {
        strategy = new AlwaysCooperation();
    }

    @Test
    public void notNullAfterInitialization() {
        assertNotNull(strategy);
    }

    @Test
    public void applyAlwaysCooperationFirstTrue() {
        assertTrue(strategy.apply());
    }

    @Test
    public void applyAlwaysCooperationFirst100True() {
        for (int n = 0; n < 100; n++) {
            assertTrue(strategy.apply());
        }
    }

    @Test
    public void testToString() {
        assertEquals("AlwaysCooperation", strategy.toString());
    }

}
