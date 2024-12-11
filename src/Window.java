import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    private final int WIDTH = 500;
    private final int HEIGHT = 400;
    private final String WINDOW_TITLE = "Stopwatch";

    Window() {
        ImageIcon icon = new ImageIcon("stopwatch.jpg");
        JLabel label = new JLabel();
        label.setBackground(new Color(0xadacac));
        label.setOpaque(true);

        this.add(label);
        this.setTitle(WINDOW_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(icon.getImage());
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
