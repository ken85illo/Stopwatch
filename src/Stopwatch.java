import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;

public class Stopwatch extends JLabel{
    private long time = 0;
    private final int WIDTH = 400;
    private final int HEIGHT = 100;
    
    public Stopwatch(JLabel label) {
        Border border = BorderFactory.createLineBorder(Color.GRAY, 3);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1);

        this.setBounds(43, 25, this.WIDTH, this.HEIGHT);
        this.setBackground(Color.BLACK);
        this.setBorder(border);
        this.setForeground(Color.WHITE);
        this.setOpaque(true);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setFont(new Font("Open Sans", Font.PLAIN, 60));
        label.add(this);
    }

    public String timeToString(long time) {
        StringBuilder timeText = new StringBuilder();
        int milliseconds = (int) (time % 1000) / 10;
        int seconds = (int) (time % 60000) / 1000;
        int minutes = (int) ((time % 3600000) / 60000);
        int hours = (int) (time / 3600000);

        if(hours < 10)
            timeText.append("0");
        timeText.append(hours + ":");

        if(minutes < 10)
            timeText.append("0");
        timeText.append(minutes + ":");

        if(seconds < 10)
            timeText.append("0");
        timeText.append(seconds + ".");

        if (milliseconds < 10)
            timeText.append("0");
        timeText.append(milliseconds);

        return timeText.toString();
    }

    Stopwatch outer = this;
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            time++;
            outer.setText(timeToString(time));
        }
    };
}
