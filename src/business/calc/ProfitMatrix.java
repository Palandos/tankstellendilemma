package business.calc;

public interface ProfitMatrix {

    int calculateFor(final boolean activePlayerCooperates, final boolean otherPlayerCooperates);
    boolean isValidProfitMatrix();

}
