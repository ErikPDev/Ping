import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.Greenfoot;

/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 *
 * @author The teachers
 * @version 1
 */
public class Bot extends Actor {
    private int width;
    private int height;
    private int dx;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Bot(int width, int height) {
        this.width = width;
        this.height = height;
        dx = 1;
        createImage();
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
        
        Bot bot = new Bot(100, 20);
        
        getWorld().addObject(bot, 0, botY);      
        getWorld().removeObject(this);       
    }
   
    
    /**
     * Will rotate the paddle 180 degrees if the paddle is at worlds edge.
     */
   

    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage() {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.BLACK);
        image.fill();
        setImage(image);
    }

}
