package business.calc;

public class FourQuadrants implements ProfitMatrix {

    private final int temptation;
    private final int reward;
    private final int penalty;
    private final int sPayoff;

    public FourQuadrants(final int temptation, final int reward, final int penalty, final int sPayoff) {
        this.temptation = temptation;
        this.reward = reward;
        this.penalty = penalty;
        this.sPayoff = sPayoff;
    }

    @Override
    public boolean isValidProfitMatrix() {
        if (temptation <= reward) {
            return false;
        }
        if (reward <= penalty) {
            return false;
        }
        if (penalty <= sPayoff) {
            return false;
        }

        return  (temptation + sPayoff) / 2 < reward;
    }

    @Override
    public int calculateFor(boolean activePlayerCooperates, boolean otherPlayerCooperates) {
        if (activePlayerCooperates) {
            if (otherPlayerCooperates) {
                return reward;
            } else {
                return sPayoff;
            }
        } else {
            if (otherPlayerCooperates) {
                return temptation;
            } else {
                return penalty;
            }
        }
    }
}
