import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;

public class Stopwatch extends JLabel{
    private long time = 0;
    private final int WIDTH = 400;
    private final int HEIGHT = 100;

    private boolean paused = true;
    
    public Stopwatch(JPanel panel) {
        Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1);

        this.setBounds(43, 25, this.WIDTH, this.HEIGHT);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(border);
        this.setForeground(Color.WHITE);
        this.setOpaque(true);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setFont(new Font("Open Sans", Font.PLAIN, 60));
        panel.add(this);
    }

    public String timeToString(long time) {
        StringBuilder timeText = new StringBuilder();
        int milliseconds = (int) (time % 1000) / 10;
        int seconds = (int) (time % 60000) / 1000;
        int minutes = (int) ((time % 3600000) / 60000);
        int hours = (int) (time / 3600000);
        
        format(hours, timeText);
        format(minutes, timeText);
        format(seconds, timeText);
        format(milliseconds, timeText);

        timeText.deleteCharAt(timeText.length() - 1);
        timeText.setCharAt(timeText.length() - 3, '.');

        return timeText.toString();
    }

    private void format(int time, StringBuilder timeText) {
        if(time < 10)
            timeText.append("0");
        timeText.append(time + ":");
    }

    Stopwatch outer = this;
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if(!paused)
                time++;
            outer.setText(timeToString(time));
        }
    };

    public void resetTimer() {
        time = 0;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean x) {
        this.paused = x;
    }
}
