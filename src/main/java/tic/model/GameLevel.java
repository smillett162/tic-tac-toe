package tic.model;

import java.util.ArrayList;
import java.util.List;

public class GameLevel implements Level{

    private List<Entity> entities = new ArrayList<>();
    private double width = 640;
    private double height = 400;
    private double board;
    private Entity[][] placements = new Entity[3][3];
    LevelWon levelWon = LevelWon.CONTINUING;

    public GameLevel(){
        if (width > height){
            this.board = height*0.8;
        } else {
            this.board = width*0.8;
        }
    }

    public List<Entity> getEntities(){ return this.entities; }

    public void tick(){return;}

    @Override public double getHeight() { return this.height; }

    @Override public double getWidth() { return this.width; }

    @Override public LevelWon getLevelWon() { return this.levelWon; }

    @Override
    public boolean placeObject(int x, int y, boolean naughts) {
        boolean success = false;
        if (placements[x][y] == null){
            Entity entity = new GameEntity(getCoordinate(x, width), getCoordinate(y, height), board*0.3, naughts);
            placements[x][y] = entity;
            this.entities.add(entity);
            success = true;
            checkForWin(naughts);
            checkFull();
        }
        return success;
    }

    private double getCoordinate(int zone, double overall){ return (overall - board)/2 + (zone*board/3); }

    private void checkForWin(boolean naughts){
        if (checkColumns(naughts) || checkDiagonals(naughts) || checkRows(naughts)) {
            if (naughts) {
                levelWon = LevelWon.NAUGHTS;
            } else {
                levelWon = LevelWon.CROSSES;
            }
        }
    }

    private boolean checkRows(boolean naughts){
        boolean win = false;
        for (int i = 0; i < 3; i++){
            boolean rowWin = true;
            for (int j = 0; j < 3; j++){
                if (placements[i][j] == null || placements[i][j].getNaught() != naughts){
                    rowWin = false;
                    break;
                }
            }
            if (rowWin){
                win = true;
                break;
            }
        }
        return win;
    }

    private boolean checkColumns(boolean naughts){
        boolean win = false;
        for (int j = 0; j < 3; j++){
            boolean columnWin = true;
            for (int i = 0; i < 3; i++){
                if (placements[i][j] == null || placements[i][j].getNaught() != naughts){
                    columnWin = false;
                    break;
                }
            }
            if (columnWin){
                win = true;
                break;
            }
        }
        return win;
    }

    private boolean checkDiagonals(boolean naughts){
        boolean win = false;

        if (placements[1][1] != null && placements[1][1].getNaught() == naughts) {
            boolean diagonal1 = (placements[0][0] != null && placements[0][0].getNaught() == naughts) &&
                    (placements[2][2] != null && placements[2][2].getNaught() == naughts);
            boolean diagonal2 = (placements[0][2] != null && placements[0][2].getNaught() == naughts) &&
                            (placements[2][0] != null && placements[2][0].getNaught() == naughts);
            if (diagonal1 || diagonal2){
                win = true;
            }
        }
        return win;
    }
    private void checkFull(){
        boolean full = true;
        for (int i = 0; i < 3 ; i++){
            for (int j = 0; j < 3; j++){
                if (placements[i][j] == null){
                    full = false;
                    break;
                }
            }
        }
        if (full){
            levelWon = LevelWon.DRAW;
        }
    }


}
