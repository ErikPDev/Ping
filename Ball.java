import greenfoot.Actor;
import greenfoot.Color;
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
<<<<<<< Updated upstream
=======
    private boolean hasBouncedOffPaddle;
    private boolean isMovingUpward;
>>>>>>> Stashed changes
    private int delay;

    /**
     * Contructs the ball and sets it in motion!
     */
    public Ball() {
        createImage();
        init();
    }

    /**
     * Creates and sets an image of a black ball to this actor.
     */
    private void createImage() {
        GreenfootImage ballImage = new GreenfootImage(BALL_SIZE, BALL_SIZE);
        ballImage.setColor(Color.BLACK);
        ballImage.fillOval(0, 0, BALL_SIZE, BALL_SIZE);
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
            checkBounceOffPlayer();
            checkBounceOffWalls();
            checkBounceOffCeiling();
<<<<<<< Updated upstream
            checkBounceOffBot();
=======
            
            isMovingUpwards();
>>>>>>> Stashed changes

            checkRestart();
        }
    }
    private boolean isMovingUpwards(){
        if(getRotation() <360 && getRotation() >180){
            isMovingUpward = true;
            return true;
        }
        isMovingUpward = false;
            return false;
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

    /**
     * Check to see if the ball should bounce off one of the walls.
     * If touching one of the walls, the ball is bouncing off.
     */
    private void checkBounceOffWalls() {
<<<<<<< Updated upstream
        if (isTouchingSides()) {
            if (!hasBouncedHorizontally) {
                revertHorizontally();
            }
        } else {
            hasBouncedHorizontally = false;
        }
=======
    if (!isTouchingSides()) {
        setHasBouncedHorizontally(false);
        return;
    }
    if (hasBouncedHorizontally) return;

    revertHorizontally();
}

    private void incrementPlayerScore() {
        PingWorld pingWorld = (PingWorld) this.getWorld();
        pingWorld.getScoreManager().incrementScore();
>>>>>>> Stashed changes
    }

    /**
     * Check to see if the ball should bounce off the ceiling.
     * If touching the ceiling the ball is bouncing off.
     */
    private void checkBounceOffCeiling() {
<<<<<<< Updated upstream
        if (isTouchingCeiling()) {
            if (!hasBouncedVertically) {
                revertVertically();
            }
        } else {
            hasBouncedVertically = false;
        }
    }

    private void checkBounceOffPlayer() {
        if (isTouching(Player.class)) {
            if (!hasBouncedHorizontally) {
                PingWorld pingWorld = (PingWorld) this.getWorld();
                pingWorld.getScoreManager().incrementScore();

                revertVertically();
            }
        } else {
            hasBouncedHorizontally = false;
        }
    }
    
       private void checkBounceOffBot() {
        if (isTouching(Bot.class)) {
            if (!hasBouncedHorizontally) {
                revertVertically();
            }
        } else {
            hasBouncedHorizontally = false;
        }
=======
        if (!isTouchingCeiling()) {
         setHasBouncedVertically(false);   
         return;
        }
        if(hasBouncedVertically) return;

        revertVertically();
        SoundManager.playWallHit();
    }

    private void checkBounce(){
        if (!isTouching(Player.class) && !isTouching(Bot.class)) 
        { 
            setHasBouncedOffPaddle(false);
            return;
        }
        
        
        if (hasBouncedOffPaddle) return;

        if(isTouching(Player.class)) incrementPlayerScore();

        this.revertVertically();
        SoundManager.playPaddleHit();
        hasBouncedOffPaddle = true;
        
        if(isTouching(Bot.class) && isMovingUpwards()){
            this.revertVertically();
            SoundManager.playPaddleHit();
            hasBouncedOffPaddle = true;
        }

        
>>>>>>> Stashed changes
    }

    /**
     * Check to see if the ball should be restarted.
     * If touching the floor the ball is restarted in initial position and speed.
     */
    private void checkRestart() {
        if (isTouchingFloor()) {
            init();
            setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
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
     * @return int - Ball Speed based on the game level
     */
    private int getSpeed() {
        PingWorld pingWorld = (PingWorld) this.getWorld();
        int speed = 2 + pingWorld.getScoreManager().getGameLevel()/5;
        return Math.min(speed, 10);
    }

    /**
     * Initialize the ball settings.
     */
    private void init() {
        delay = DELAY_TIME;
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
        setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH) + STARTING_ANGLE_WIDTH / 2);
    }

}
