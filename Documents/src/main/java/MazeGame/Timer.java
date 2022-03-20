package MazeGame;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * Sets the timer
 */
public class Timer {

    private final int amountOfTime = 10;

    Date endTime;

    Timer() {
        Calendar date = Calendar.getInstance();
        long timeInSecs = date.getTimeInMillis();
        endTime = new Date(timeInSecs + (amountOfTime * 60 * 1000));
    }

    public String getTimeRemaining() {
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");

        Date currentTime = new Date();
        long timeSince = endTime.getTime() - currentTime.getTime();
        long differenceInMinutes = (timeSince / (1000 * 60)) % 60;
        long differenceInSeconds = timeSince / 1000 % 60;

        return String.format("%02d", differenceInMinutes) + ":" + differenceInSeconds;
    }

    public int getScore() {
        Date currentTime = new Date();
        long timeSince = endTime.getTime() - currentTime.getTime();
        long differenceInMinutes = (timeSince / (1000 * 60)) % 60;
        long differenceInSeconds = timeSince / 1000 % 60;
        return (int) (differenceInMinutes * 12 + differenceInSeconds / 5);
    }
}
