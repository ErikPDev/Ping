import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.World;


/**
 * The Ping World is where Balls and Paddles meet to play pong.
 *
 * @author The teachers
 * @version 1
 */
public class PingWorld extends World {
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;

    private ScoreManager scoreManager;

    public PingWorld() {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);

        setPaintOrder(Ball.class, Paddle.class, TextDisplay.class);

        String backgroundImage = "field.png";
        if (GlobalConfig.getGameMode() == GlobalConfig.GameMode.TWO_PLAYER)
            backgroundImage = "field-multiplayer.png";

        setBackground(new GreenfootImage(backgroundImage));

        addObject(new Ball(), WORLD_WIDTH / 2, WORLD_HEIGHT / 2);

        // Two Player Mode, Sliding AI, and BOT
        // Multiplayer & Bot both have P1 and P2
        GlobalConfig.GameMode gameMode = GlobalConfig.getGameMode();

        switch(gameMode) {
            case TWO_PLAYER:
                this.twoPlayerMode();
                addPlayerScores("P2");
                break;

            case SLIDING_AI:
                this.slidingAIMode();
                addGameLevel();
                break;

            case BOT:
                this.botMode();
                addPlayerScores("BOT");
                break;
        }

    }

    private void addPlayerScores(String label2){
        addObject(new Score("P1", Score.ScoreType.P1SCORE), WORLD_WIDTH - 57, (WORLD_HEIGHT / 2) + 20);
        addObject(new Score(label2, Score.ScoreType.P2SCORE), WORLD_WIDTH - 57, (WORLD_HEIGHT / 2) - 20);
    }

    private void addGameLevel(){
        this.addObject(new Score("Game Level", Score.ScoreType.GAME_LEVEL), WORLD_WIDTH - 100, 20);
    }

    private void botMode(){
        this.addObject(new Player(100, 20, "left", "right"), 60, WORLD_HEIGHT - 50);
        this.addObject(new Bot(100, 20), (WORLD_WIDTH/2) - 50, 50);
    }

    private void slidingAIMode(){
        this.addObject(new Player(100, 20, "left", "right"), 60, WORLD_HEIGHT - 50);
        this.addObject(new SlidingPaddle(100, 20), WORLD_WIDTH - 100, 20);
    }

    private void twoPlayerMode(){
        this.addObject(new Player(100, 20, "paddle1.png", "left", "right"), 60, WORLD_HEIGHT - 50);
        this.addObject(new Player(100, 20, "a", "d"), 60, 50);
    }

    public ScoreManager getScoreManager() {
        if (this.scoreManager == null) this.scoreManager = new ScoreManager();
        return this.scoreManager;
    }

}
