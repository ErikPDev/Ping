import greenfoot.Color;
import greenfoot.Font;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Write a description of class IntroWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntroWorld extends World {
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;

    /**
     * Constructor for objects of class IntroWorld.
     */
    public IntroWorld() {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        setBackground("space.jpg");

        createText("THE PING GAME", (WORLD_WIDTH / 2) - 200, WORLD_HEIGHT / 6, 50, Color.GREEN);
        createText("Made by: Space Pong", 10, 690, 15, Color.GREEN);
        createText("Press ENTER to start", 130, 350, 20, Color.GREEN);
        createText("Use left and right => keys to move!", 95 , 450, 15, Color.GREEN );
    }

    private void createText(String text, int x, int y, int fontSize, Color color) {
        GreenfootImage background = getBackground();
        Font gameFont = new Font("Courier New", true, false, fontSize);
        background.setFont(gameFont);
        background.setColor(Color.GREEN);
        background.drawString(text, x, y);
    }

    public void act() {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter")) {
            Greenfoot.setWorld(new PingWorld(true));
        }
    }

}
