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
public class Player extends Paddle {

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Player(int width, int height) {
        super(width, height, "paddle5.png");
       
        
    }
    
    public Player(int width, int height, String image){
        super(width, height, image);
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(!(GlobalConfig.getGameMode() == 2)){
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("D")) this.move(PADDLE_SPEED);
        else if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("A")) this.move(-PADDLE_SPEED);
        }
        else{
            if (Greenfoot.isKeyDown("right")) this.move(PADDLE_SPEED);
            else if (Greenfoot.isKeyDown("left")) this.move(-PADDLE_SPEED);
        }
}
}
