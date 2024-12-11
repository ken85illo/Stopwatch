import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    public final int WIDTH = 500;
    public final int HEIGHT = 400;
    private final String WINDOW_TITLE = "Stopwatch";

    Window() {
        ImageIcon icon = new ImageIcon("stopwatch.jpg");
        this.setTitle(WINDOW_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(icon.getImage());
        this.setSize(this.WIDTH, this.HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        addLabel();
    }

    private void addLabel() {
        JLabel label = new JLabel();
        label.setBackground(new Color(0xadacac));
        label.setOpaque(true);

        this.add(label);
        new Stopwatch(label);
    }
}
