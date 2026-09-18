import events.ScoreEvent;

public class ScoreManager {
    private int score, P1Score, P2Score = 0;

    public int getScore() {
        return this.score;
    }

    public int getP1Score() {
        return this.P1Score;
    }

    public int getP2Score() {
        return this.P2Score;
    }

    public void incrementScore() {
        this.score++;
        ScoreEvent.fireEvent();
    }

    public void incrementP1Score() {
        this.P1Score++;
        ScoreEvent.fireEvent();
    }

    public void incrementP2Score() {
        this.P2Score++;
        ScoreEvent.fireEvent();
    }

    public void resetScore() {
        this.score = 0;
        ScoreEvent.fireEvent();
    }

    public int getGameLevel() {
        return Math.floorDiv(this.score, 10);
    }
}
