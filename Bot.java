public class Bot extends Paddle {

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Bot(int width, int height) {
        super(width, height, "paddle2.png");
    }

<<<<<<< Updated upstream
    private void moveTowardsBall(Ball ball) {
        if (ball.getX() > this.getX()) move(PADDLE_SPEED);
        if (ball.getX() < this.getX()) move(-PADDLE_SPEED);
=======
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Find the ball in the game
        Ball ball = this.getWorld().getObjects(Ball.class).getFirst();
        if (!ball.isMovingUpwards()) return;
        
        if(ball.getY() < (getWorld().getHeight()/2)){
            if (ball.getX() > this.getX()) move(PADDLE_SPEED);
            if (ball.getX() < this.getX()) move(-PADDLE_SPEED);
        }
>>>>>>> Stashed changes
    }

    private void moveTowardsCenter(){
        if (this.getX() < 250) move(PADDLE_SPEED);
        if (this.getX() > 250) move(-PADDLE_SPEED);
    }

    public void act() {
        Ball ball = this.getWorld().getObjects(Ball.class).getFirst();
        if (ball == null) return;
        if (ball.isMovingUpwards()) moveTowardsBall(ball);
        if (!ball.isMovingUpwards()) moveTowardsCenter();
    }
}
