package PlaneObjects.Methods;
import PlaneObjects.Interfaces.Defense.ChaffFlares;

public interface DeployChaffFlares {
    ChaffFlares getChaffFlares(); // Each aircraft must implement this

    default void deployCountermeasures() {
        getChaffFlares().deploy();
    }

    default void reloadCountermeasures() {
        getChaffFlares().reload();
    }
}