package tic.view;

import javafx.scene.layout.Pane;
import tic.model.GameEngine;

public interface BackgroundDrawer {
    void draw(GameEngine model, Pane pane);
    void update(double xViewportOffset, double yViewportOffset);
}
