

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SnakeMovement implements KeyListener {
    private Snake snake;
    private GameScene gameScene;


    public SnakeMovement(Snake snake, GameScene gameScene) {
        this.snake = snake;
        this.gameScene = gameScene;
    }

    public SnakeMovement(GameScene gameScene) {
        this.gameScene = gameScene;
        this.snake = gameScene.getSnake();
    }


    public void keyTyped(KeyEvent var1) {

    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                if (snake.getDirection() != 'R') {
                    snake.setDirection('L');
                }
                    break;case KeyEvent.VK_RIGHT:
                if (snake.getDirection() != 'L') {
                    snake.setDirection('R');
                }
                break;case KeyEvent.VK_UP:
                if (snake.getDirection() != 'D') {
                    snake.setDirection('U');
                }
                break;case KeyEvent.VK_DOWN:
                if (snake.getDirection() != 'U') {
                    snake.setDirection('D');
                }
                break;

        }




    }

    public void keyReleased(KeyEvent keyEvent) {



    }


}
