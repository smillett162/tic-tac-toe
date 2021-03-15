package tic.view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import tic.model.GameEngine;

public class BlockedBackground implements BackgroundDrawer {
    private Rectangle sky;
    private Rectangle horizontalTop;
    private Rectangle horizontalBottom;
    private Rectangle verticalLeft;
    private Rectangle verticalRight;
    private Pane pane;
    private GameEngine model;

    @Override
    public void draw(GameEngine model, Pane pane) {
        this.model = model;
        this.pane = pane;

        double width = pane.getWidth();
        double height = pane.getHeight();

        this.sky = new Rectangle(0, 0, width, height);
        sky.setFill(Paint.valueOf("BLACK"));
        sky.setViewOrder(1000.0);

        double boardHeight = height*0.8;
        double boardWidth = height*0.8;

        if (width > height){
            boardWidth = boardHeight;
        } else {
            boardHeight = boardWidth;
        }

        this.verticalLeft = new Rectangle((width - boardWidth/3 - boardWidth/10)/2, (height - boardHeight)/2 , boardWidth*0.05, boardHeight);
        this.verticalLeft.setFill(Paint.valueOf("WHITE"));
        verticalLeft.setViewOrder(0);

        this.verticalRight = new Rectangle((width + boardWidth/3 - boardWidth/10)/2, (height - boardHeight)/2, boardWidth*0.05, boardHeight);
        this.verticalRight.setFill(Paint.valueOf("WHITE"));
        verticalRight.setViewOrder(0);

        this.horizontalTop = new Rectangle((width - boardWidth)/2, (height - boardHeight/3 - boardHeight/10)/2, boardWidth, boardHeight*0.05);
        this.horizontalTop.setFill(Paint.valueOf("WHITE"));
        horizontalTop.setViewOrder(0);

        this.horizontalBottom = new Rectangle((width - boardWidth)/2, (height + boardHeight/3 - boardHeight/10)/2, boardWidth,boardHeight*0.05);
        this.horizontalBottom.setFill(Paint.valueOf("WHITE"));
        horizontalBottom.setViewOrder(0);

        pane.getChildren().addAll(sky, verticalLeft, verticalRight, horizontalBottom, horizontalTop);
    }

    @Override
    public void update(double xViewportOffset, double yViewportOffset) {
        ;
    }
}
