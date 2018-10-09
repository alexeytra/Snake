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



    public GameField() {
        setBackground(Color.BLACK);
        loadImage();

    }

    public void loadImage(){
        ImageIcon imageApple = new ImageIcon("apple.png");
        apple = imageApple.getImage();
        ImageIcon imageDotSnake = new ImageIcon("snake.png");
        dotSnake = imageDotSnake.getImage();
    }

    public void initGame() {
        for (int i =0; i < sizeSnake; i++){
            snakeX[i] = 48 - i * DOT_SIZE;
            snakeY[i] = 48;
        }
        timer = new Timer(250, this);
        timer.start();
        createApple();

    }

    public void createApple(){
        appleX = new Random().nextInt(20) * DOT_SIZE;
        appleY= new Random().nextInt(20) * DOT_SIZE;
    }

    public void move() {
        for (int i = sizeSnake; i > 0; i--) {
            snakeX[i] = snakeX[i-1];
            snakeY[i] = snakeY[i-1];
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            move();
        }
        repaint();
    }
}
