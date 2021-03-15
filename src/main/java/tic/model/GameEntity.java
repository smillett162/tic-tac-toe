package tic.model;

public class GameEntity implements Entity{

    protected int size;
    protected double xPos;
    protected double yPos;
    protected String imagePath;
    protected boolean naught;

    public GameEntity(double x, double y, double size, boolean naught){
        this.xPos = x;
        this.yPos = y;
        this.size = (int) Math.round(size);
        if (naught){
            this.imagePath = "slimeRb.png";
        } else {
            this.imagePath = "fireball.png";
        }
        this.naught = naught;
    }

    @Override public double getXPos() { return this.xPos; }

    @Override public double getYPos() { return this.yPos; }

    @Override public double getHeight() { return this.size; }

    @Override public double getWidth() { return this.size; }

    @Override public String getImagePath(){
        return this.imagePath;
    }

    @Override
    public boolean getNaught() { return this.naught; }
}
