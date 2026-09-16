import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 *
 * @author The teachers
 * @version 1
 */
public class Bot extends Paddle {

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Bot(int width, int height) {
        super(width, height, "paddle2.png");
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Find the ball in the game
        Ball ball = this.getWorld().getObjects(Ball.class).getFirst();
        if (!ball.isMovingUpwards()) return;
        if (ball.getX() > this.getX()) move(PADDLE_SPEED);
        if (ball.getX() < this.getX()) move(-PADDLE_SPEED);
    }
}
