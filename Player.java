import greenfoot.*;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * @author The teachers 
 * @version 1
 */
public class Player extends Actor
{
    private int width;
    private int height;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Player(int width, int height)
    {
        this.width = width;
        this.height = height;
        createImage();
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("right")) this.move(1);
        
        else if (Greenfoot.isKeyDown("left")) this.move(-1);
        
        
    }    

    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.BLACK);
        image.fill();
        setImage(image);
    }

}
