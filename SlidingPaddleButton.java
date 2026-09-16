import greenfoot.Greenfoot;

public class SlidingPaddleButton extends Button {
    public SlidingPaddleButton() {
        super("Sliding Paddle", 250, 60);
    }

    public void executeAction() {
        GlobalConfig.setGameMode(0);
        Greenfoot.setWorld(new PingWorld());
    }
}
