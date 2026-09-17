import events.ScoreEvent;

public class ScoreManager {
    private int  score, P1score, P2score = 0;



    public int getScore() {
        return this.score;
    }
    
    public int getP1Score() {
        return this.P1score;
    }
    
    public int getP2Score() {
        return this.P2score;
    }

    public void incrementScore() {
        this.score++;
        ScoreEvent.fireEvent();
    }
    
    public void incrementP1score() {
        this.P1score++;
        ScoreEvent.fireEvent();
    }
    
    public void incrementP2score() {
        this.P2score++;
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
