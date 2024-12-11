import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class Stopwatch extends JLabel{
    private long time = 0;
    
    public Stopwatch() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public String timeToString(long time) {
        StringBuilder timeText = new StringBuilder();
        int seconds = (int) (time % 60);
        int minutes = (int) ((time / 60) % 60);
        int hours = (int) (time / 3600);

        if(hours < 10)
            timeText.append("0");
        timeText.append(hours + ":");

        if(minutes < 10)
            timeText.append("0");
        timeText.append(minutes + ":");

        if(seconds < 10)
            timeText.append("0");
        timeText.append(seconds);

        return timeText.toString();
    }

    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            time++;
            System.out.println(timeToString(time));
        }
    };
}
