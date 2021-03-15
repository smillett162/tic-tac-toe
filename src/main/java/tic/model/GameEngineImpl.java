package tic.model;

public class GameEngineImpl implements GameEngine{

    private Level level;
    private String[] filePaths;
    private int levelNumber = 1;
    private boolean naughts;

    public GameEngineImpl(String[] filePaths){
        this.filePaths = filePaths;
        startLevel();
    }

    @Override
    public void startLevel(){
        this.level = new GameLevel();
    }

    @Override public Level getCurrentLevel(){
        return this.level;
    }

    @Override
    public void makeMove(double x, double y) {
        if (level.getLevelWon() == Level.LevelWon.CONTINUING){
            int[] coordinates = getIndex(x,y);
            if (coordinates[0] != -1 && coordinates[1] != -1){
                if(level.placeObject(coordinates[0], coordinates[1], naughts)){
                    naughts = !naughts;
                }
            }
        } else {
            System.out.println(level.getLevelWon().toString());
        }

    }

    public void tick() { level.tick(); }

    private int[] getIndex(double x, double y){
        int[] toReturn = {0, 0};
        double height = level.getHeight();
        double width = level.getWidth();
        double board = 0;

        if (width > height){
            board = height*0.8;
        } else {
            board = width*0.8;
        }

        toReturn[0] = getIndex(x, width, board);
        toReturn[1] = getIndex(y, height, board);

        return toReturn;
    }

    private int getIndex(double coordinate, double overall, double board){
        double firstLine = (overall - board/3)/2;
        double secondLine = (overall + board/3)/2;
        int index = -1;
        if (coordinate > (overall - board)/2 && coordinate < (overall + board)/2){
            if (coordinate < firstLine){
                index = 0;
            } else if (coordinate < secondLine) {
                index = 1;
            } else {
                index = 2;
            }
        }
        return index;
    }
}
