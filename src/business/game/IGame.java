package business.game;

public interface IGame {

    boolean isValid();
    void playIteration();
    int[] getResult();

}
