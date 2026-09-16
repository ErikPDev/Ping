import events.ScoreEvent;
import greenfoot.Color;

public class P1score extends TextDisplay {
    public P1score() {
        super("P1: 0", 24, Color.WHITE);
        
        // Add P1score Event Listener
        ScoreEvent.subscribeTo(() -> {
            PingWorld pingWorld = (PingWorld) this.getWorld();
            this.updateP1score(pingWorld.getScoreManager().getP1score());
        });
    }

    public void updateP1score(int P1score) {
        this.updateText("P1:" + P1score);
    }
}
