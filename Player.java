import greenfoot.Greenfoot;

public class Player extends Paddle {

    private String left_key;
    private String right_key;
    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Player(int width, int height, String left_key, String right_key) {
        super(width, height, "paddle5.png");
        this.left_key = left_key;
        this.right_key = right_key;
    }

    public Player(int width, int height, String image,  String left_key, String right_key) {
        super(width, height, image);
        this.left_key = left_key;
        this.right_key = right_key;
    }


    public void act() {
        if (Greenfoot.isKeyDown(left_key)) {
            this.move(-PADDLE_SPEED);
            return;
        }
        if (Greenfoot.isKeyDown(right_key)) {
            this.move(PADDLE_SPEED);
        }
    }

}
