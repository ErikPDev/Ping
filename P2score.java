import events.ScoreEvent;
import greenfoot.Color;

public class P2score extends TextDisplay {
    public P2score() {
        super("P2: 0", 24, Color.WHITE);
        
        // Add P2score Event Listener
        ScoreEvent.subscribeTo(() -> {
            PingWorld pingWorld = (PingWorld) this.getWorld();
            this.updateP2score(pingWorld.getScoreManager().getP2score());
        });
    }

    public void updateP2score(int P2score) {
        this.updateText("P2:" + P2score);
    }
}
