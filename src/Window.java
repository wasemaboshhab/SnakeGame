import javax.swing.*;


public class Window extends JFrame {



    public static void main(String[] args) {
        new Window();

    }

    public Window() {
        this.init();

        GameScene gameScene = new GameScene();
        gameScene.setBounds(0, 0, Definitions.WINDOW_WIDTH, Definitions.WINDOW_HEIGHT);
        this.add(gameScene);
        SnakeMovement snakeMovement = new SnakeMovement(gameScene);
       this.addKeyListener(snakeMovement);

    }

    private void init() {
        // this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
        this.setSize(Definitions.WINDOW_WIDTH, Definitions.WINDOW_HEIGHT);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Snake Game");
        this.setResizable(false);
    }




}


