import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {

    private final int SIZE = 320;
    private final int DOT_SIZE = 16;
    private final int ALL_DOTS = 400;
    private Image dotSnake;
    private Image apple;

    private int appleX;
    private int appleY;

    private int[] snakeX = new int[ALL_DOTS];
    private int[] snakeY = new int[ALL_DOTS];

    private int sizeSnake = 3;
    private Timer timer;

    private boolean left;
    private boolean right = true;
    private boolean up;
    private boolean down;

    private boolean inGame = true;



    GameField() {
        setBackground(Color.BLACK);
        loadImage();
        initGame();

    }

    private void loadImage(){
        ImageIcon imageApple = new ImageIcon("apple.png");
        apple = imageApple.getImage();
        ImageIcon imageDotSnake = new ImageIcon("snake.png");
        dotSnake = imageDotSnake.getImage();
    }

    private void initGame() {
        for (int i =0; i < sizeSnake; i++){
            snakeX[i] = 48 - i * DOT_SIZE;
            snakeY[i] = 48;
        }
        timer = new Timer(250, this);
        timer.start();
        createApple();

    }

    private void createApple(){
        appleX = new Random().nextInt(20) * DOT_SIZE;
        appleY= new Random().nextInt(20) * DOT_SIZE;
    }

    private void move() {
        for (int i = sizeSnake; i > 0; i--) {
            snakeX[i] = snakeX[i-1];
            snakeY[i] = snakeY[i-1];
        }

        if (right){
            snakeX[0] += DOT_SIZE;
        }
        if (left) {
            snakeX[0] -= DOT_SIZE;
        }
        if (up) {
            snakeY[0] -= DOT_SIZE;
        }
        if (down){
            snakeY[0] += DOT_SIZE;
        }
    }

    private void checkApple(){
        if (snakeX[0] == appleX && snakeY[0] == appleY) {
            sizeSnake++;
            createApple();
        }
    }

    private void checkWalls() {
        for (int i = sizeSnake; i > 0 ; i--) {
            if (i > 4 && snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]){
                inGame = false;
            }
            if (snakeX[0] > SIZE) inGame = false;
            if (snakeX[0] < 0) inGame = false;
            if (snakeY[0] > SIZE) inGame = false;
            if (snakeY[0] < 0) inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkApple();
            checkWalls();
            move();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.drawImage(apple, appleX, appleY, this);
            for (int i = 0; i < sizeSnake; i++) {
                g.drawImage(dotSnake, snakeX[i], snakeY[i], this);
            }
        }
    }
}
