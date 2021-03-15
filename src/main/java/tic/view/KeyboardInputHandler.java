package tic.view;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tic.model.GameEngine;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class KeyboardInputHandler{
    private final GameEngine model;


    KeyboardInputHandler(GameEngine model) {
        this.model = model;
    }

    void mouseClicked(MouseEvent mouseEvent) {
        model.makeMove(mouseEvent.getSceneX(), mouseEvent.getSceneY());
    }
}
