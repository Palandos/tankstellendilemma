package business.strategy;

public interface Strategy {

    boolean apply();

    default String getName() {
        return this.getClass().getSimpleName();
    }

}
