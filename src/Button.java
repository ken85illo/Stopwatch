import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Button implements ActionListener{
    private final int WIDTH = 120;
    private final int HEIGHT = 75;

    Stopwatch stopwatch;
    JButton startStopButton = new JButton();
    JButton resetButton = new JButton();

    public Button(JPanel panel, Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
        panel.add(startStopButton);
        panel.add(resetButton);

        initButton(startStopButton, 108, 150, "Start");
        initButton(resetButton, 258, 150, "Reset");
    }

    private void initButton(JButton button, int x, int y, String text) {
        button.setBounds(x, y, WIDTH, HEIGHT);
        button.setText(text);
        button.setFont(new Font("Open Sans", Font.BOLD, 15));
        button.setFocusable(false);
        button.setBackground(Color.LIGHT_GRAY);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startStopButton) {
            if(stopwatch.isPaused()) {
                stopwatch.setPaused(false);
                startStopButton.setText("Stop");
            }
            else {
                stopwatch.setPaused(true);
                startStopButton.setText("Start");
            }

        }
        else if(e.getSource() == resetButton) {
            stopwatch.resetTimer();
            stopwatch.setPaused(true);
            startStopButton.setText("Start");
        }
            
    }


}
