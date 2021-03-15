package tic.model;

public interface GameEngine {
    Level getCurrentLevel();

    void startLevel();

    void tick();

    void makeMove(double x, double y);

}
