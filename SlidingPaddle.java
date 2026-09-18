import greenfoot.Greenfoot;

/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 *
 * @author The teachers
 * @version 1
 */
public class SlidingPaddle extends Paddle {

    private int dx = 1;

    public SlidingPaddle(int width, int height) {
        super(width, height, "paddle4.png");
    }

    public void act() {
        setLocation(getX() + dx, getY());
        checkCreateNewBot();
    }

    private void checkCreateNewBot() {
        if (!isAtEdge()) return;

        int worldHeight = this.getWorld().getHeight();
        int botY = Greenfoot.getRandomNumber(worldHeight / 2);

        SlidingPaddle bot = new SlidingPaddle(100, 20);

        getWorld().addObject(bot, 0, botY);
        getWorld().removeObject(this);
    }

}
