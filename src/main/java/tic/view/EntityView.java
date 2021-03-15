package tic.view;

import javafx.scene.Node;
import tic.model.Entity;

public interface EntityView {
    void update(double xViewportOffset, double yViewportOffset);

    boolean matchesEntity(Entity entity);

    void markForDelete();

    Node getNode();

    boolean isMarkedForDelete();
}
