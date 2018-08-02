package business.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FourQuadrantTest {

    private final static int TEMPTATION = 1000;
    private final static int REWARD = 300;
    private final static int PENALTY = -500;
    private final static int SPAYOFF = -3000;

    private final static boolean COOPERATION = true;
    private final static boolean TREASON = false;

    private ProfitMatrix profits;

    @Before
    public void setUp() {
        profits = new FourQuadrants(TEMPTATION, REWARD, PENALTY, SPAYOFF);
    }

    @Test
    public void notNullAfterInitialization() {
        FourQuadrants fourQuadrants = new FourQuadrants(1, 1, 1, 1);
        assertNotNull(fourQuadrants);
    }

    @Test
    public void rewardGreaterTemptationIsInvalid() {
        FourQuadrants fourQuadrants = new FourQuadrants(1, 3, 2, 1);
        assertFalse(fourQuadrants.isValidProfitMatrix());
    }

    @Test
    public void penaltyGreaterRewardIsInvalid() {
        FourQuadrants fourQuadrants = new FourQuadrants(3, 1, 2, 1);
        assertFalse(fourQuadrants.isValidProfitMatrix());
    }

    @Test
    public void suckersPayoffGreaterPenaltyIsInvalid() {
        FourQuadrants fourQuadrants = new FourQuadrants(3, 2, -1, 1);
        assertFalse(fourQuadrants.isValidProfitMatrix());
    }

    @Test
    public void sixThreeTwoOneIsInvalidDueToTPlusSDividedByTwoNeedsToBeLessThanR() {
        FourQuadrants fourQuadrants = new FourQuadrants(6, 3, 2, 1);
        assertFalse(fourQuadrants.isValidProfitMatrix());
    }

    @Test
    public void temptation1000Reward300PenaltyMinus500SPayoffMinus3000IsValid() {
        assertTrue(profits.isValidProfitMatrix());
    }

    @Test
    public void calculateForTreasonCoopIsTemptation() {
        assertEquals(TEMPTATION, profits.calculateFor(TREASON, COOPERATION));
    }

    @Test
    public void calculateForCoopCoopIsReward() {
        assertEquals(REWARD, profits.calculateFor(COOPERATION, COOPERATION));
    }

    @Test
    public void calculateForTreasonTreasonIsPenalty() {
        assertEquals(PENALTY, profits.calculateFor(TREASON, TREASON));
    }

    @Test
    public void calculateForCoopTreasonIsSuckersPayoff() {
        assertEquals(SPAYOFF, profits.calculateFor(COOPERATION, TREASON));
    }

}
