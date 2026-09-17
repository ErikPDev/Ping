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
        setBackground(new GreenfootImage("GameOverScreen.jpg"));
        
        createText("Game Level:" + gameLevel, (WORLD_WIDTH/2) - 200, WORLD_HEIGHT / 2, 60);
        createText("Press ENTER to start again", (WORLD_WIDTH/2) - 175, WORLD_HEIGHT / 2 + 105, 27);
        
    }
    
    public GameOver(String winner, int P1score, int P2score) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        setBackground(new GreenfootImage("GameOverScreenMultiplayer.jpg"));
        createText(winner + " IS THE", 30  , 95, 110);
        createText("WINNER!", 43, 200, 110);
        
        createText("Final score:  " + P1score + " - " + P2score , (WORLD_WIDTH/2) - 233, WORLD_HEIGHT / 2, 50);
        createText("Press ENTER to start again", (WORLD_WIDTH/2) - 175, WORLD_HEIGHT / 2 + 105, 27);
    }

    public void act(){
        if (Greenfoot.isKeyDown("enter"))
            Greenfoot.setWorld(new IntroWorld());
    }
    
    private void createText(String text, int x, int y, int fontSize) {
        GreenfootImage background = getBackground();
        Font gameFont = new Font("THE BOLD FONT", true, false, fontSize);
        background.setFont(gameFont);
        background.setColor(Color.WHITE);
        background.drawString(text, x, y);
    }
}
