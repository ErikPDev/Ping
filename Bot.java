public class Bot extends Paddle {

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Bot(int width, int height) {
        super(width, height, "paddle2.png");
    }


    private void moveTowardsBall(Ball ball) {
        if(ball.getY() < (getWorld().getHeight()/2)){
            if(ball.getX() > this.getX()) move(PADDLE_SPEED);
            if (ball.getX() < this.getX()) move(-PADDLE_SPEED);
        }
        
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
