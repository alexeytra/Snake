import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {

    private final int SIZE = 320;
    private final int DOT_SIE = 16;
    private final int ALL_DOTS = 400;
    private Image dotSnake;
    private Image apple;

    private int appleX;
    private int appleY;

    private int[] snakeX = new int[ALL_DOTS];
    private int[] snakeY = new int[ALL_DOTS];

    private int sizeSnake;
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
}
