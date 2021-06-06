import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {
    private Snake snake;
    private Food food;

    private void gameLoop() {
        new Thread(() -> {

            while (true) {
                if (snake.isAlive()) {
                    snake.move();
                }
                this.snake.checkCollisionWithLimits();
                if (collision(snake, food)){
                    snake.setFoodEaten(snake.getFoodEaten() + 1);
                    this.food.newFood();
                    snake.increaseSnakeBody();
                }
                repaint();
                try {
                    Thread.sleep(this.snake.getSnakeSpeed());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public GameScene(){
        this.setBackground( new Color(32,32,32));
        this.setDoubleBuffered(true);
        this.snake = new Snake();
        this.food = new Food();
        this.gameLoop();
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
            this.snake.paint(graphics);
        this.food.paint(graphics);
    }

    private boolean collision (Snake snake, Food food){
        int snakeHeadX = snake.getBody()[0].getX();
        int snakeHeadY = snake.getBody()[0].getY();
        Rectangle snakeRectangle = new Rectangle(snakeHeadX, snakeHeadY, Definitions.BODY_SIZE, Definitions.BODY_SIZE);
        Rectangle foodRectangle = new Rectangle(food.getX(), food.getY(), Definitions.FOOD_SIZE, Definitions.FOOD_SIZE);
        return snakeRectangle.intersects(foodRectangle);
    }

    public Snake getSnake() {
        return snake;
    }
    public Food getFood() {
        return food;
    }



}
