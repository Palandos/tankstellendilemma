package business.strategy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class AlwaysTreasonTest {

    private Strategy strategy;

    @Before
    public void setUp() {
        strategy = new AlwaysTreason();
    }

    @Test
    public void notNullAfterInitialization() {
        assertNotNull(strategy);
    }

    @Test
    public void applyAlwaysTreasonFirstFalse() {
        assertFalse(strategy.apply());
    }

    @Test
    public void applyAlwaysTreasonFirst100False() {
        for (int n = 0; n < 100; n++) {
            assertFalse(strategy.apply());
        }
    }

    @Test
    public void testToString() {
        assertEquals("AlwaysTreason", strategy.toString());
    }


}
