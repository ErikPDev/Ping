import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World {

    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int gameLevel) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        setBackground(new GreenfootImage("space.jpg"));
        createText("Game Over!", (WORLD_WIDTH/2) - 135, (WORLD_HEIGHT / 3), 50);
        createText("Press ENTER to start again", (WORLD_WIDTH/2) - 150, WORLD_HEIGHT / 2, 20);
        createText("Game Level:" + gameLevel, (WORLD_WIDTH/2) - 55, WORLD_HEIGHT / 2 + 30, 20);
    }
    
    public GameOver(String winner, int P1score, int P2score) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        setBackground(new GreenfootImage("space.jpg"));
        createText(winner + " IS \nTHE WINNER!", (WORLD_WIDTH/2) - 150  , (WORLD_HEIGHT / 3), 50);
        createText("Press ENTER to start again", (WORLD_WIDTH/2) - 150, WORLD_HEIGHT / 2, 20);
        createText("Final score:" + P1score + " : " + P2score , (WORLD_WIDTH/2) - 100, WORLD_HEIGHT / 2 + 30, 20);
    }

    public void act(){
        if (Greenfoot.isKeyDown("enter"))
            Greenfoot.setWorld(new IntroWorld());
    }
    
    private void createText(String text, int x, int y, int fontSize) {
        GreenfootImage background = getBackground();
        Font gameFont = new Font("Courier New", true, false, fontSize);
        background.setFont(gameFont);
        background.setColor(Color.GREEN);
        background.drawString(text, x, y);
    }
}
