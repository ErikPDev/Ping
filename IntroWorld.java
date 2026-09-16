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

        createText("THE PING GAME", (WORLD_WIDTH / 2) - 200, WORLD_HEIGHT / 6, 50);
        createText("Made by: Stan, Josip, Erik", 10, 690, 15);
        // createText("Press ENTER to start", 130, 350, 20);
        createText("Use left and right < > or A and D keys to move!", 35 , 215, 15);
        
        createText("PLAY WITH A FRIEND!", (WORLD_WIDTH / 2) - 80, 475, 15);

        addObject(new SlidingPaddleButton(), WORLD_WIDTH / 2, 275);
        addObject(new BotPaddleButton(), WORLD_WIDTH / 2, 375);
        addObject(new MultiplayerButton(), WORLD_WIDTH /2, 515);
    }

    private void createText(String text, int x, int y, int fontSize) {
        GreenfootImage background = getBackground();
        Font gameFont = new Font("Courier New", true, false, fontSize);
        background.setFont(gameFont);
        background.setColor(Color.GREEN);
        background.drawString(text, x, y);
    }

    public void act() {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter")) {
            Greenfoot.setWorld(new PingWorld());
        }
    }

}
