package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import static java.awt.Color.*;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 700;
    static final int SCREEN_HEIGHT = 500;
    static final int UNITE_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNITE_SIZE;
    static int DELAY = 90;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts;
    int appleEaten;
    int applex;
    int appley;
//    char deriction='R';
    boolean running = false;
    Timer timer;
    Random random;
    MoveSnake Snake;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        Snake = new MoveSnake(x,y,4);
        StartGame();
    }

    public void StartGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
       
    }
   @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void generateApple(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(applex, appley, UNITE_SIZE, UNITE_SIZE);
    }

    public void generateSnake(Graphics g) {
        for (int i = 0; i < Snake.bodyParts; i++) {
            if (i == 0) {
                g.setColor(YELLOW);
                g.fillRect(x[i], y[i], UNITE_SIZE, UNITE_SIZE);
            } else {
                g.setColor(green);
                g.fillRect(x[i], y[i], UNITE_SIZE, UNITE_SIZE);
            }
        }
    }

    public void draw(Graphics g) {
        if (running) {
            generateApple(g);
            generateSnake(g);
            
            score(g);
        } else {
            gameOver(g);
            score(g);
        }
    }

    public void newApple() {
        applex = random.nextInt((int) (SCREEN_WIDTH / UNITE_SIZE)) * UNITE_SIZE;
        appley = random.nextInt((int) (SCREEN_HEIGHT / UNITE_SIZE)) * UNITE_SIZE;
    }
 

//    public void move() {
//        for (int i = bodyParts; i > 0; i--) {
//            x[i] = x[i - 1];
//            y[i] = y[i - 1];
//        }
//        switch (deriction) {
//            case 'U' -> y[0] = y[0] - UNITE_SIZE;
//            case 'D' -> y[0] = y[0] + UNITE_SIZE;
//            case 'R' -> x[0] = x[0] + UNITE_SIZE;
//            case 'L' -> x[0] = x[0] - UNITE_SIZE;
//        }
//
//    }

    public void checkApple() {
        if ((x[0] == applex) && (y[0] == appley)) {
            Snake.bodyParts++;
            appleEaten++;
            if ((appleEaten % 10 == 0) && (DELAY > 20)) {
                DELAY = DELAY - 20;
            }
            newApple();
        }
    }

    public void checkCollsion() {
        for (int i = Snake.bodyParts; i > 0; i--) {
            // itself
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }
        // left border
        if (x[0] < 0) {
            x[0]=SCREEN_WIDTH-UNITE_SIZE;
        }
        // right border
        if (x[0] == SCREEN_WIDTH) {
            x[0] = 0;
        }
        // top border
        if (y[0] < 0) {
           y[0]=SCREEN_HEIGHT-UNITE_SIZE;
        }
        // bottom
        if (y[0] == SCREEN_HEIGHT) {
            y[0]=0;
        }
//      if(!running){
//      timer.stop();
//      }
    }

    public void score(Graphics g) {
        g.setColor(red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score :  " + appleEaten, (SCREEN_WIDTH - metrics.stringWidth("Score :  " + appleEaten)) / 2, 50);
    }

    public void gameOver(Graphics g) {
        g.setColor(red);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("متاكلش نفسك !!", (SCREEN_WIDTH - metrics.stringWidth("متاكلش نفسك !!")) / 2, SCREEN_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            Snake.move();
            checkApple();
            checkCollsion();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> {
                    if (Snake.deriction!= 'R') {
                        Snake.deriction = 'L';
                    }
                }
                case KeyEvent.VK_RIGHT  -> {
                    if (Snake.deriction != 'L') {
                        Snake.deriction = 'R';
                    }
                }
                case KeyEvent.VK_UP -> {
                    if (Snake.deriction != 'D') {
                        Snake.deriction = 'U';
                    }
                }
                case KeyEvent.VK_DOWN -> {
                    if (Snake.deriction != 'U') {
                        Snake.deriction = 'D';
                    }
                }
                case KeyEvent.VK_W -> {
                    if (Snake.deriction != 'D') {
                        Snake.deriction = 'U';
                    }
                }
                case KeyEvent.VK_A -> {
                    if (Snake.deriction != 'R') {
                        Snake.deriction = 'L';
                    }
                }
                case KeyEvent.VK_S -> {
                    if (Snake.deriction != 'U') {
                        Snake.deriction = 'D';
                    }
                }
                case KeyEvent.VK_D -> {
                    if (Snake.deriction != 'L') {
                        Snake.deriction = 'R';
                    }
                }

            }
        }
    }
}
