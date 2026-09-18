import greenfoot.Greenfoot;

public class Player extends Paddle {

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Player(int width, int height) {
        super(width, height, "paddle5.png");
    }

    public Player(int width, int height, String image) {
        super(width, height, image);
    }

    /**
     * TODO: Refactor this
     */
    public void act() {
        if (!(GlobalConfig.getGameMode() == GlobalConfig.GameMode.TWO_PLAYER)) {
            if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("D")) this.move(PADDLE_SPEED);
            else if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("A")) this.move(-PADDLE_SPEED);
        } else {
            if (Greenfoot.isKeyDown("right")) this.move(PADDLE_SPEED);
            else if (Greenfoot.isKeyDown("left")) this.move(-PADDLE_SPEED);
        }
    }

}
