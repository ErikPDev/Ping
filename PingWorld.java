import greenfoot.Color;
import greenfoot.Greenfoot;
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

    /**
     * Constructor for objects of class PingWorld.
     * TODO: refactor this class
     */
    public PingWorld() {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);

        setPaintOrder(Ball.class, Paddle.class, TextDisplay.class);

        int botX = Greenfoot.getRandomNumber(WORLD_WIDTH);
        int botY = Greenfoot.getRandomNumber(WORLD_HEIGHT / 2);

        if (GlobalConfig.getGameMode() == GlobalConfig.GameMode.TWO_PLAYER) setBackground(new GreenfootImage("field-multiplayer.png"));
        else setBackground(new GreenfootImage("field.png"));

        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);

        addObject(new Ball(), WORLD_WIDTH / 2, WORLD_HEIGHT / 2);

        /*
         * TODO: Refactor everything below - Erik
         * Split it into different functions and logics
         */
        if (GlobalConfig.getGameMode() != GlobalConfig.GameMode.TWO_PLAYER) addObject(new Player(100, 20, "left", "right"), 60, WORLD_HEIGHT - 50);
        else addObject(new Player(100, 20, "paddle1.png", "left", "right"), 60, WORLD_HEIGHT - 50);


        if (GlobalConfig.getGameMode() == GlobalConfig.GameMode.SLIDING_AI)
            addObject(new SlidingPaddle(100, 20), botX, botY);

        else if (GlobalConfig.getGameMode() == GlobalConfig.GameMode.BOT)
            addObject(new Bot(100, 20), botX, 50);
        else
            addObject(new Player(100, 20, "a", "d"), 60, 50);

        if (GlobalConfig.getGameMode() == GlobalConfig.GameMode.SLIDING_AI) addObject(new Score("Game Level", Score.ScoreType.GAME_LEVEL), WORLD_WIDTH - 100, 20);
        else {
            addObject(new Score("P1", Score.ScoreType.P1SCORE), WORLD_WIDTH - 47, (WORLD_HEIGHT / 2) + 20);
            addObject(new Score("Bot", Score.ScoreType.P2SCORE), WORLD_WIDTH - 57, (WORLD_HEIGHT / 2) - 20);
        }
    }

    public ScoreManager getScoreManager() {
        if (this.scoreManager == null) this.scoreManager = new ScoreManager();
        return this.scoreManager;
    }

}
