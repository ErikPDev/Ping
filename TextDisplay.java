import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Want text? You got some.
 *
 * @version 1.0.0
 */
public class TextDisplay extends Actor {

    private int size;
    private Color color;

    public TextDisplay(String text, int size, Color color) {
        this.setVariables(size, color);
        updateText(text);
    }

    public void updateText(String text) {
        updateText(text, this.size, this.color);
    }

    private void setVariables(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    public void updateText(String text, int size, Color color) {
        this.setVariables(size, color);
        GreenfootImage image = new GreenfootImage(text, size, color, new Color(0, 0, 0, 0));
        setImage(image);
    }

}