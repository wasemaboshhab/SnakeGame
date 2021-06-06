import java.awt.*;
import java.util.Random;

public class Food implements Printable {
    private int x;
    private int y;
    private int width;
    private int height;

//    public Food(int x, int y, int width, int height) {
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//    }

    public Food() {
        newFood();

    }

    public void newFood() {
        Random random = new Random();
        this.x = random.nextInt(Definitions.WINDOW_WIDTH - Definitions.FOOD_SIZE) + Definitions.FOOD_SIZE / 2;
        this.y = (int) (random.nextInt((int) (Definitions.WINDOW_HEIGHT - Definitions.FOOD_SIZE * 3)) + 1.5 * Definitions.FOOD_SIZE);
        this.width = Definitions.FOOD_SIZE;
        this.height = Definitions.FOOD_SIZE;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, width, height);


    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}




