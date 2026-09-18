import greenfoot.Greenfoot;

public class Player extends Paddle {

    private String leftKey;
    private String rightKey;
    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Player(int width, int height, String leftKey, String rightKey) {
        super(width, height, "paddle5.png");
        this.leftKey = leftKey;
        this.rightKey = rightKey;
    }

    public Player(int width, int height, String image,  String leftKey, String rightKey) {
        super(width, height, image);
        this.leftKey = leftKey;
        this.rightKey = rightKey;
    }


    public void act() {
        if (Greenfoot.isKeyDown(this.leftKey)) {
            this.move(-PADDLE_SPEED);
            return;
        }
        if (Greenfoot.isKeyDown(this.rightKey)) {
            this.move(PADDLE_SPEED);
        }
    }

}
