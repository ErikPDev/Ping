import events.ScoreEvent;
import greenfoot.Color;

public class Score extends TextDisplay {
    public Score() {
        super("Game Level: 0", 24, Color.WHITE);

        // Add Score Event Listener
        ScoreEvent.subscribeTo(() -> {
            PingWorld pingWorld = (PingWorld) this.getWorld();
            this.updateGameLevel(pingWorld.getScoreManager().getGameLevel());
        });
    }

    public void updateGameLevel(int level) {
        this.updateText("Game Level: " + level);
    }
}
