import events.ScoreEvent;
import greenfoot.Color;

public class Score extends TextDisplay {
    private final String scoreName;
    private final ScoreType scoreType;
    public Score(String scoreName, ScoreType scoreType) {
        super(scoreName + ": 0", 24, Color.WHITE);
        this.scoreName = scoreName;
        this.scoreType = scoreType;

        ScoreEvent.subscribeTo(() -> {
            this.updateScore(getScore());
        });
    }

    private int getScore() {
        PingWorld pingWorld = (PingWorld) this.getWorld();

        if (this.scoreType == ScoreType.GAME_LEVEL)
            return pingWorld.getScoreManager().getGameLevel();

        if (this.scoreType == ScoreType.P1SCORE)
            return pingWorld.getScoreManager().getP1Score();

        if (this.scoreType == ScoreType.P2SCORE)
            return pingWorld.getScoreManager().getP2Score();

        return 0;
    }

    public void updateScore(int score) {
        this.updateText(this.scoreName + ": " + score);
    }

    public enum ScoreType {GAME_LEVEL, P1SCORE, P2SCORE}
}
