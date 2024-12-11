import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class Stopwatch extends JLabel{
    private long time = 0;
    
    public Stopwatch() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1);
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

    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            time++;
            System.out.println(timeToString(time));
        }
    };
}
