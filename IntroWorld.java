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
        GreenfootImage background = getBackground();
        Font gameFont = new Font("Courier New", true, false, 50);
        background.setFont(gameFont);
        background.setColor(Color.GREEN);
        background.drawString("THE PING GAME", WORLD_WIDTH / 2 - 200, WORLD_HEIGHT / 6 );
        Font gameFont1 = new Font("Courier New", true, false, 15);
        background.setFont(gameFont1);
        background.drawString("Made by : Space Pong",  10, 690 );
        Font gameFont2 = new Font("Courier New", true, false, 20);
        background.setFont(gameFont2);
        background.setColor(Color.GREEN);
        background.drawString("Press ENTER to start", 130 , 350 );
        Font gameFont3 = new Font("Courier New", true, false, 15);
        background.setFont(gameFont3);
        background.setColor(Color.GREEN);
        background.drawString("Use left and right => keys to move!", 95 , 450 );
    }

    public void act() {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter")) {
            Greenfoot.setWorld(new PingWorld(true));
        }
    }

}
