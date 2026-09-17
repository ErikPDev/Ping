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

        setPaintOrder(Ball.class, Paddle.class,TextDisplay.class);
        
        int botX = Greenfoot.getRandomNumber(WORLD_WIDTH);
        int botY = Greenfoot.getRandomNumber(WORLD_HEIGHT/2);
        
        if(GlobalConfig.getGameMode()== 2) setBackground(new GreenfootImage("field-multiplayer.png"));
        else setBackground(new GreenfootImage("field.png"));

        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);

        addObject(new Ball(), WORLD_WIDTH / 2, WORLD_HEIGHT / 2);
        if(GlobalConfig.getGameMode() != 2 ) addObject(new Player(100, 20), 60, WORLD_HEIGHT - 50);
        else addObject(new Player(100, 20, "paddle1.png"), 60, WORLD_HEIGHT - 50);
        

        if (GlobalConfig.getGameMode() == 0)
            addObject(new SlidingPaddle(100, 20), botX, botY);
        else if (GlobalConfig.getGameMode() == 1)
            addObject(new Bot(100, 20), botX, 50);
        else 
            addObject(new Player1(100, 20), 60, 50);

        if (!(GlobalConfig.getGameMode() == 2)) addObject(new Score(), WORLD_WIDTH - 100, 20);
        else{
            addObject(new P1Score(), WORLD_WIDTH - 47, (WORLD_HEIGHT/2) + 20);
            addObject(new P2Score(), WORLD_WIDTH - 47, (WORLD_HEIGHT/2) - 20);
        }
    }

    public ScoreManager getScoreManager() {
        if (this.scoreManager == null) this.scoreManager = new ScoreManager();
        return this.scoreManager;
    }

}
