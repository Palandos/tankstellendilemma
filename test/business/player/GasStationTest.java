package business.player;

import business.strategy.Strategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GasStationTest {

    private Strategy strategy;
    private GasStation player;

    @Before
    public void setUp() {
        strategy = mock(Strategy.class);
        player = new GasStation(strategy);
    }

    @Test
    public void notNullAfterInitialization() {
        assertNotNull(player);
    }

    @Test
    public void applyStrategyReturnsResultOfStrategy() {
        when(strategy.apply()).thenReturn(true);
        assertTrue(player.applyStrategy());

        when(strategy.apply()).thenReturn(false);
        assertFalse(player.applyStrategy());
    }

    @Test
    public void testGetMoney() {
        player.setMoney(200);

        assertEquals(200, player.getMoney());
    }
}
