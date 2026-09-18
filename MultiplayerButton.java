import greenfoot.Greenfoot;

public class MultiplayerButton extends Button {
    public MultiplayerButton() {
        super("Multiplayer", 250, 60);
    }

    public void executeAction() {
        GlobalConfig.setGameMode(GlobalConfig.GameMode.TWO_PLAYER);
        Greenfoot.setWorld(new PingWorld());
    }
}
