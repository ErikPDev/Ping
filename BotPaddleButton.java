import greenfoot.Greenfoot;

public class BotPaddleButton extends Button {
    public BotPaddleButton() {
        super("Bot Paddle", 250, 60);
    }

    public void executeAction() {
        GlobalConfig.setGameMode(1);
        Greenfoot.setWorld(new PingWorld());
    }
}
