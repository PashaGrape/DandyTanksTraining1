import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;


    // 1 - Up, 2 - Down, 3 - Left, 4 - Right
    int direction = 4;

    int bulletX = 320;
    int bulletY = 320;




    int x = 256;
    int y = 256;

    void move(int direction) throws Exception {
        this.direction = direction;

        if (direction == 1) {
            y--;
        } else if (direction == 2) {
            y++;
        } else if (direction == 3) {
            x--;
        } else if (direction == 4) {
            x++;
        }
        Thread.sleep(33);
        repaint();
    }

    void runTheGame() throws Exception {
        while (y != BF_HEIGHT - 64) {
            move(2);

        }

    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.runTheGame();
    }

    Main() {
        JFrame frame = new JFrame("Dendy Tanks");
        frame.setMinimumSize(new Dimension(BF_WIDTH + 16,BF_HEIGHT + 38));
        frame.getContentPane().add(this);
        frame.setLocation(0,0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color cc = new Color(0x35492D);
        g.setColor(cc);
        g.fillRect(x, y, 64, 64);

        Color cc1 = new Color(0x202A1A);
        g.setColor(cc1);
        if (direction == 1) {
            g.fillRect(x + 20, y + 20 , 24, 34);
            g.fillRect(x, y  , 10, 63);
            g.fillRect(x + 54, y, 10, 63);
            g.fillRect(x + 29, y, 6, 20);
        } else if (direction == 2) {
            g.fillRect(x + 20, y + 10, 24, 34);
            g.fillRect(x, y  , 10, 63);
            g.fillRect(x + 54, y, 10, 63);
            g.fillRect(x + 29, y + 44, 6, 20);
        } else if (direction == 3) {
            g.fillRect(x + 20, y + 20, 34, 24);
            g.fillRect(x, y , 63, 10);
            g.fillRect(x , y + 54, 63, 10);
            g.fillRect(x, y + 29, 20, 6);
        } else if (direction == 4) {
            g.fillRect(x + 10, y + 20, 34, 24);
            g.fillRect(x, y , 63, 10);
            g.fillRect(x , y + 54, 63, 10);
            g.fillRect(x + 44, y + 29, 20, 6);
        }

        Color cc2 = new Color(0xE3C132);
        g.setColor(cc2);
        g.fillRect(bulletX, bulletY, 10, 10);
    }

}
