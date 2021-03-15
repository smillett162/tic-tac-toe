package tic.model;

import java.util.List;

public interface Level {

    List<Entity> getEntities();

    double getHeight();

    double getWidth();

    boolean placeObject(int x, int y, boolean naughts);

    void tick();

    enum LevelWon {
        NAUGHTS, CROSSES, DRAW, CONTINUING
    }

    LevelWon getLevelWon();

}
