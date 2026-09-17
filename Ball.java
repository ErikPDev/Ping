import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;


/**
 * A Ball is a thing that bounces of walls and paddles (or at least i should).
 *
 * @author The teachers
 * @version 1
 */
public class Ball extends Actor {
    private static final int BALL_SIZE = 25;
    private static final int BOUNCE_DEVIANCE_MAX = 5;
    private static final int STARTING_ANGLE_WIDTH = 90;
    private static final int DELAY_TIME = 100;

    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    private boolean hasBouncedOffPaddle;
    private int delay;
    private int roundCounter = 1;

    /**
     * Constructs the ball and sets it in motion!
     */
    public Ball() {
        createImage();
        init();
    }

    /**
     *
     * Creates and sets an image of a ball to this actor.
     */
    private void createImage() {
        GreenfootImage ballImage = new GreenfootImage("ball.png");
        setImage(ballImage);
    }

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (delay > 0) {
            delay--;
        } else {
            move(getSpeed());

            checkBounce();
            checkBounceOffWalls();
            checkBounceOffCeiling();

            checkGameOver();
            checkRestart();

        }
    }

    public boolean isMovingUpwards() {
        return getRotation() < 360 && getRotation() > 180;
    }

    /**
     * Returns true if the ball is touching one of the side walls.
     */
    private boolean isTouchingSides() {
        return (getX() <= BALL_SIZE / 2 || getX() >= getWorld().getWidth() - BALL_SIZE / 2);
    }

    /**
     * Returns true if the ball is touching the ceiling.
     */
    private boolean isTouchingCeiling() {

        return (getY() <= BALL_SIZE / 2);

    }

    /**
     * Returns true if the ball is touching the floor.
     */
    private boolean isTouchingFloor() {
        return (getY() >= getWorld().getHeight() - BALL_SIZE / 2);
    }


    private void setHasBouncedHorizontally(boolean x) {
        this.hasBouncedHorizontally = x;
    }

    private void setHasBouncedVertically(boolean y) {
        this.hasBouncedVertically = y;
    }

    private void setHasBouncedOffPaddle(boolean x) {
        this.hasBouncedOffPaddle = x;
    }

    /**
     * Check to see if the ball should bounce off one of the walls.
     * If touching one of the walls, the ball is bouncing off.
     */
    private void checkBounceOffWalls() {
        if (!isTouchingSides()) {
            setHasBouncedHorizontally(false);
            return;
        }

        if (hasBouncedHorizontally) return;

        revertHorizontally();
        SoundManager.playWallHit();
    }

    private void incrementPlayerScore() {
        PingWorld pingWorld = (PingWorld) this.getWorld();
        pingWorld.getScoreManager().incrementScore();
    }

    private void incrementP1Score() {
        PingWorld pingWorld = (PingWorld) this.getWorld();
        pingWorld.getScoreManager().incrementP1score();
    }

    private void incrementP2Score() {
        PingWorld pingWorld = (PingWorld) this.getWorld();
        pingWorld.getScoreManager().incrementP2score();
    }

    private void incrementRoundCounter() {
        roundCounter++;
    }

    private int getRoundCounter() {
        return roundCounter;
    }


    /**
     * Check to see if the ball should bounce off the ceiling.
     * If touching the ceiling the ball is bouncing off.
     */
    private void checkBounceOffCeiling() {
        if (!isTouchingCeiling()) {
            setHasBouncedVertically(false);
            return;
        }

        if (hasBouncedVertically) return;

        if (GlobalConfig.getGameMode() == 0) {
            revertVertically();
            SoundManager.playWallHit();
        }
    }


    private void checkBounce() {
        if (!isTouching(Player.class) && !isTouching(Player1.class) && !isTouching(SlidingPaddle.class) && !isTouching(Bot.class)) {
            setHasBouncedOffPaddle(false);
            return;
        }

        if (hasBouncedOffPaddle) return;
        if (!isTouching(Paddle.class)) return;

        if (isTouching(SlidingPaddle.class) && !isMovingUpwards()) return;
        if (isTouching(Bot.class) && !isMovingUpwards()) return;

        if (isTouching(Player.class) && (GlobalConfig.getGameMode() == 0)) incrementPlayerScore();

        this.revertVertically();
        SoundManager.playPaddleHit();

        hasBouncedOffPaddle = true;
    }

    /**
     * Check to see if the ball should be restarted.
     * If touching the floor the ball is restarted in initial position and speed
     */
    private void checkRestart() {
        if (GlobalConfig.getGameMode() == 0) return;
        if (!isTouchingFloor() && !isTouchingCeiling()) return;

        if (isTouchingFloor())
        {
            if(GlobalConfig.getGameMode() == 1 ) SoundManager.playBotScore();
            else SoundManager.playScorePoint();
            
            incrementP2Score();
            
        }
        if (isTouchingCeiling()) 
        {
            SoundManager.playScorePoint();
            incrementP1Score();
        }

        incrementRoundCounter();
        init();

        setLocation(this.getWorld().getWidth() / 2, this.getWorld().getHeight() / 2);
    }

    /**
     * Check to see if the ball touched the floor.
     * If touching the floor, the game world is switched to GameOver
     */
    private void checkGameOver() {
        if (!isTouchingFloor() && GlobalConfig.getGameMode() == 0) return;

        PingWorld pingWorld = (PingWorld) this.getWorld();

        if (GlobalConfig.getGameMode()  == 0) {
            SoundManager.playGameOver();
            Greenfoot.setWorld(new GameOver(pingWorld.getScoreManager().getGameLevel()));
            return;
        }

        if (pingWorld.getScoreManager().getP1Score() >= 10) {
            if( GlobalConfig.getGameMode() == 1) Greenfoot.setWorld(new GameOver(pingWorld.getScoreManager().getP1Score(), pingWorld.getScoreManager().getP2Score(), 1));
            else Greenfoot.setWorld(new GameOver("P1", pingWorld.getScoreManager().getP1Score(), pingWorld.getScoreManager().getP2Score()));
        } 
        else if (pingWorld.getScoreManager().getP2Score() >= 10) {
            if(GlobalConfig.getGameMode() == 1) 
            {
                SoundManager.playGameOver();
                Greenfoot.setWorld(new GameOver(pingWorld.getScoreManager().getP1Score(), pingWorld.getScoreManager().getP2Score(), 0));
            } 
            
            
            if(GlobalConfig.getGameMode() == 2) Greenfoot.setWorld(new GameOver("P2", pingWorld.getScoreManager().getP1Score(), pingWorld.getScoreManager().getP2Score()));
            
        }
    }

    /**
     * Bounces the ball back from a vertical surface.
     */
    private void revertHorizontally() {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX) - BOUNCE_DEVIANCE_MAX / 2;
        setRotation((180 - getRotation() + randomness + 360) % 360);
        hasBouncedHorizontally = true;
    }

    /**
     * Bounces the ball back from a horizontal surface.
     */
    private void revertVertically() {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX) - BOUNCE_DEVIANCE_MAX / 2;
        setRotation((360 - getRotation() + randomness + 360) % 360);
        hasBouncedVertically = true;
    }

    /**
     * This returns the ball speed based on the game level
     *
     * @return int - Ball Speed based on the game level
     */
    private int getSpeed() {
        PingWorld pingWorld = (PingWorld) this.getWorld();
        int speed = 4 + pingWorld.getScoreManager().getGameLevel() / 5;
        return Math.min(speed, 10);
    }

    /**
     * Initialize the ball settings.
     */
    private void init() {
        delay = DELAY_TIME;
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
        hasBouncedOffPaddle = false;

        if (getRoundCounter() % 2 == 0)
            setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH) + STARTING_ANGLE_WIDTH / 2);
        else
            setRotation(180 + Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH) + STARTING_ANGLE_WIDTH / 2);
    }

}
