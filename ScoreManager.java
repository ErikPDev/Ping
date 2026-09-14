public class ScoreManager {
    private int score = 0;

    public ScoreManager() {
    }

    public int getScore() {
        return this.score;
    }

    public void incrementScore() {
        this.score++;
    }

    public void resetScore() {
        this.score = 0;
    }

    public int getGameLevel() {
        return Math.floorDiv(this.score, 10);
    }
}
