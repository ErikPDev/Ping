import greenfoot.Color;
import greenfoot.Greenfoot;

/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 *
 * @author The teachers
 * @version 1
 */
public class SlidingPaddle extends Paddle {

    private int dx = 1;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public SlidingPaddle(int width, int height) {
        super(width, height, "paddle4.png");
    }

    /**
     * Act - do whatever the Bot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        setLocation(getX() + dx, getY());
        createNewBot();    
    }

    private void createNewBot(){
        if (!isAtEdge()) return;
        
        int WORLD_HEIGHT = this.getWorld().getHeight();
        int botY = Greenfoot.getRandomNumber(WORLD_HEIGHT/2);
        
        SlidingPaddle bot = new SlidingPaddle(100, 20);
        
        getWorld().addObject(bot, 0, botY);      
        getWorld().removeObject(this);       
    }

}
