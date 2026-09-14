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
     */
    public PingWorld(boolean gameStarted) {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        if (gameStarted) {
            GreenfootImage background = getBackground();
            background.setColor(Color.BLACK);
            // Create a new world with WORLD_WIDTHxWORLD_HEIGHT cells with a cell size of 1x1 pixels.
            addObject(new Ball(), WORLD_WIDTH / 2, WORLD_HEIGHT / 2);
            addObject(new Player(100, 20), 60, WORLD_HEIGHT - 50);
            addObject(new Score(), WORLD_WIDTH - 100, 20);
        } else {
            Greenfoot.setWorld(new IntroWorld());
        }
    }

    public ScoreManager getScoreManager() {
        if (this.scoreManager == null) this.scoreManager = new ScoreManager();
        return this.scoreManager;
    }

}
