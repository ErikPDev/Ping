import greenfoot.Color;
import greenfoot.Font;
import greenfoot.GreenfootImage;
import greenfoot.World;


public class IntroWorld extends World {
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;

    public IntroWorld() {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        setBackground("IntroScreen.jpg");

        createText("THE PING GAME", (WORLD_WIDTH / 2) - 207, WORLD_HEIGHT / 6, 60);
        createText("Made by: Stan, Josip, Erik", 10, 690, 15);
        createText("Use left and right < > or A and D keys to move!", 72, 245, 15);
        
        createText("PLAY WITH A FRIEND!", (WORLD_WIDTH / 2) - 80, 475, 15);

        addObject(new SlidingPaddleButton(), WORLD_WIDTH / 2, 295);
        addObject(new BotPaddleButton(), WORLD_WIDTH / 2, 375);
        addObject(new MultiplayerButton(), WORLD_WIDTH /2, 515);
    }

    private void createText(String text, int x, int y, int fontSize) {
        GreenfootImage background = getBackground();
        Font gameFont = new Font("THE BOLD FONT", true, false, fontSize);
        background.setFont(gameFont);
        background.setColor(new Color(0, 255, 255));
        background.drawString(text, x, y);
    }
    
}
