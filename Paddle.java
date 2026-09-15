import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 *
 * @author The teachers
 * @version 1
 */
public class Paddle extends Actor {
    private final int COLOR_RADIUS = 30;
    private final int width;
    private final int height;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Paddle(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        createImage(color);
    }

    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage(Color color) {
        GreenfootImage image = new GreenfootImage(width, height);

        java.awt.Graphics2D g2 = image.getAwtImage().createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        g2.fillRoundRect(0, 0, this.width, this.height, this.COLOR_RADIUS, this.COLOR_RADIUS);

        g2.dispose();

        setImage(image);
    }


}
