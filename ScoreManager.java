import events.ScoreEvent;

public class ScoreManager {
    private int score = 0;


    public int getScore() {
        return this.score;
    }

    public void incrementScore() {
        this.score++;
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
