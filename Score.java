import greenfoot.Color;

public class Score extends TextDisplay {
    public Score(){
        super("Game Level: 0", 24, Color.BLACK);
    }

    public void act(){
        PingWorld pingWorld = (PingWorld) this.getWorld();
        this.updateText("Game Level:" + pingWorld.getScoreManager().getGameLevel());
    }
}
