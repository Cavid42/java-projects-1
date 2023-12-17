import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class snakegame extends JFrame implements KeyListener, ActionListener {

    private ArrayList<Point> snake;
    private Point fruit;
    private Timer timer;
    private boolean left, right, up, down;
    private boolean running = false;
    private final int SCALE = 10;
    private final int WIDTH = 30;
    private final int HEIGHT = 30;

    public snakegame() {
        setTitle("Snake Game");
        setSize(WIDTH * SCALE, HEIGHT * SCALE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(this);

        snake = new ArrayList<>();
        fruit = new Point(10, 10);
        timer = new Timer(100, this);
        startgame();
    }

    private void startgame() {
        snake.clear();
        snake.add(new Point(15, 15));
        timer.start();
        running = true;
    }

    private void move() {
        if (left) {
            if (snake.get(0).x - 1 >= 0 && noTailAt(snake.get(0).x - 1, snake.get(0).y)) {
                snake.add(0, new Point(snake.get(0).x - 1, snake.get(0).y));
            } else {
                running = false;
            }
        }
        if (right) {
            if (snake.get(0).x + 1 < WIDTH && noTailAt(snake.get(0).x + 1, snake.get(0).y)) {
                snake.add(0, new Point(snake.get(0).x + 1, snake.get(0).y));
            } else {
                running = false;
            }
        }
        if (up) {
            if (snake.get(0).y - 1 >= 0 && noTailAt(snake.get(0).x, snake.get(0).y - 1)) {
                snake.add(0, new Point(snake.get(0).x, snake.get(0).y - 1));
            } else {
                running = false;
            }
        }
        if (down) {
            if (snake.get(0).y + 1 < HEIGHT && noTailAt(snake.get(0).x, snake.get(0).y + 1)) {
                snake.add(0, new Point(snake.get(0).x, snake.get(0).y + 1));
            } else {
                running = false;
            }
        }

        if (snake.get(0).equals(fruit)) {
            fruit.setLocation(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT));
        } else {
            snake.remove(snake.size() - 1);
        }
    }

    private boolean noTailAt(int x, int y) {
        for (Point point : snake) {
            if (point.equals(new Point(x, y))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        g.setColor(Color.GREEN);

        for (Point point : snake) {
            g.fillRect(point.x * SCALE, point.y * SCALE, SCALE, SCALE);
        }

        g.setColor(Color.RED);
        g.fillRect(fruit.x * SCALE, fruit.y * SCALE, SCALE, SCALE);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && !right) {
            left = true;
            up = false;
            down = false;
        }
        if (key == KeyEvent.VK_RIGHT && !left) {
            right = true;
            up = false;
            down = false;
        }
        if (key == KeyEvent.VK_UP && !down) {
            up = true;
            right = false;
            left = false;
        }
        if (key == KeyEvent.VK_DOWN && !up) {
            down = true;
            right = false;
            left = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        new snakegame();
    }
}