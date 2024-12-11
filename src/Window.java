import javax.swing.JFrame;

public class Window extends JFrame{
    private final int WIDTH = 500;
    private final int HEIGHT = 400;
    private final String WINDOW_TITLE = "Stopwatch";

    Window() {
        this.setTitle(WINDOW_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
