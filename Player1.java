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
public class Player1 extends Paddle {

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Player1(int width, int height) {
        super(width, height, "paddle3.png");
    }

    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        
        if (Greenfoot.isKeyDown("D")) this.move(PADDLE_SPEED);
        else if (Greenfoot.isKeyDown("A")) this.move(-PADDLE_SPEED);
    }
}
