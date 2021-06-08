import java.awt.*;
import java.util.Random;

public class Food implements Printable {
    private int x;
    private int y;
    private int width;
    private int height;


    public Food() {
        newFood();
    }

    public void newFood() {
        Random random = new Random();
        this.x = random.nextInt(Definitions.RANDOM_FOOD_X ) ;
        this.y = random.nextInt(Definitions.RANDOM_FOOD_Y) ;
        this.width = Definitions.FOOD_SIZE;
        this.height = Definitions.FOOD_SIZE;
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(new Color((255), 228, 181));
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




