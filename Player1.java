import greenfoot.Greenfoot;

public class Player1 extends Paddle {

    public Player1(int width, int height) {
        super(width, height, "paddle3.png");
    }

    public void act() {
        if (Greenfoot.isKeyDown("D")) this.move(PADDLE_SPEED);
        else if (Greenfoot.isKeyDown("A")) this.move(-PADDLE_SPEED);
    }

}
