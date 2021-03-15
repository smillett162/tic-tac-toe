package tic.view;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tic.model.Entity;

public class EntityViewImpl implements EntityView {
    private Entity entity;
    private boolean delete = false;
    private ImageView node;
    private String imagePath;

    public EntityViewImpl(Entity entity) {
        this.entity = entity;
        this.imagePath = entity.getImagePath();
        this.node = new ImageView(imagePath);
        this.node.setViewOrder(50.0);
        update(0, 0);
    }

    @Override
    public void update(double xViewportOffset, double yViewportOffset) {
        String newPath = entity.getImagePath();
        if (!imagePath.equals(newPath)) {
            imagePath = newPath;
            node.setImage(new Image(imagePath));
        }
        node.setX(entity.getXPos() - xViewportOffset);
        node.setY(entity.getYPos() - yViewportOffset);
        node.setFitHeight(entity.getHeight());
        node.setFitWidth(entity.getWidth());
        node.setPreserveRatio(false);
        delete = false;

    }

    @Override
    public boolean matchesEntity(Entity entity) {
        return this.entity.equals(entity);
    }

    @Override
    public void markForDelete() {
        this.delete = true;
    }

    @Override
    public Node getNode() {
        return this.node;
    }

    @Override
    public boolean isMarkedForDelete() {
        return this.delete;
    }
}
