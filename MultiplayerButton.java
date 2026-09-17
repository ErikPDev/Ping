import greenfoot.Greenfoot;

public class MultiplayerButton extends Button {
    public MultiplayerButton() {
        super("Multiplayer", 250, 60);
    }

    public void executeAction() {
        GlobalConfig.setGameMode(2);
        Greenfoot.setWorld(new PingWorld());
    }
}
