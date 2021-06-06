import java.awt.*;

public class Snake implements Printable {
    private Body[] body;
    private boolean alive;
    private char direction ;
    private int snakeSpeed;
    private int foodEaten;


    public Snake() {
        initBody();
        this.alive = true;
        this.direction = Definitions.DIRECTION;
        this.snakeSpeed = Definitions.SNAKE_SPEED;
        this.foodEaten = Definitions.FOOD_EATEN;
    }

    public void paint(Graphics g) {
        if (isAlive()) {
            for (int i = 0; i < this.body.length; i++) {
                if (i == Definitions.SNAKE_HEAD) {
                    g.setColor(new Color	(139,69,19));
                    body[i].paint(g);
                } else if (i == 1 || i == 2) {
                    g.setColor(new Color(160, 82, 45));
                    body[i].paint(g);
                } else if (i == 3 || i ==4) {
                    g.setColor(new Color(205, 133, 63));
                    body[i].paint(g);
                } else {
                    g.setColor(new Color(244, 164, 96));
                    body[i].paint(g);
                }
            }
            if (foodEaten >= 2) {
                this.snakeSpeed = Definitions.SNAKE_SPEED - Definitions.BODY_SIZE;
                highLevel(g);
            }

        } else
            gameOver(g);
    }
    private void initBody() {
        this.body = new Body[]{
                new Body(Definitions.START_BODY_X, Definitions.START_BODY_Y, Definitions.BODY_SIZE, Definitions.BODY_SIZE),
                new Body(Definitions.START_BODY_X - Definitions.BODY_SIZE, Definitions.START_BODY_Y, Definitions.BODY_SIZE, Definitions.BODY_SIZE),
                new Body(Definitions.START_BODY_X - 2 * Definitions.BODY_SIZE, Definitions.START_BODY_Y, Definitions.BODY_SIZE, Definitions.BODY_SIZE),
                new Body(Definitions.START_BODY_X - 3 * Definitions.BODY_SIZE, Definitions.START_BODY_Y, Definitions.BODY_SIZE, Definitions.BODY_SIZE),
                new Body(Definitions.START_BODY_X - 4 * Definitions.BODY_SIZE, Definitions.START_BODY_Y, Definitions.BODY_SIZE, Definitions.BODY_SIZE),
        };
    }
    public void increaseSnakeBody() {
        Body[] biggerBody = new Body[this.body.length + 1];
        for (int i = 0; i < this.body.length; i++) {
            biggerBody[i] = this.body[i];
        }
        biggerBody[this.body.length] = new Body(this.body[body.length - 1].getX() - Definitions.BODY_SIZE, this.body[body.length - 1].getY(), Definitions.BODY_SIZE, Definitions.BODY_SIZE);
        this.body = biggerBody;

    }
    public void move() {
        for (int i = body.length - 1; i > 0; i--) {
            body[i].setX(body[i - 1].getX());
            body[i].setY(body[i - 1].getY());
        }
        switch (this.direction) {
            case 'U':
                body[0].setY(body[0].getY() - Definitions.BODY_SIZE);
                break;

            case 'D':
                body[0].setY(body[0].getY() + Definitions.BODY_SIZE);

                break;

            case 'L':
                body[0].setX(body[0].getX() - Definitions.BODY_SIZE);


                break;
            case 'R':
                body[0].setX(body[0].getX() + Definitions.BODY_SIZE);
                break;
        }
    }
    public void gameOver(Graphics g) {
//        this lines of code taken from the internet
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = g.getFontMetrics(g.getFont());
        g.drawString("GameOver", (Definitions.WINDOW_WIDTH - metrics2.stringWidth("Game Over")) / 2, Definitions.WINDOW_HEIGHT / 2);
        g.setColor(Color.green);
        g.setFont(new Font("Ink Free", Font.ITALIC, 30));
        g.drawString("Score: " + this.foodEaten, Definitions.WINDOW_WIDTH /2, (Definitions.WINDOW_HEIGHT/2)+Definitions.BODY_SIZE);
    }
    public void highLevel(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 20));
        FontMetrics metrics2 = g.getFontMetrics(g.getFont());
        g.drawString("High Level", (Definitions.FOOD_SIZE / 3), Definitions.FOOD_SIZE);
    }


    public Body[] getBody() {
        return body;
    }

    public void setBody(Body[] body) {
        this.body = body;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getSnakeSpeed() {
        return snakeSpeed;
    }

    public void setSnakeSpeed(int snakeSpeed) {
        this.snakeSpeed = snakeSpeed;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }





}


