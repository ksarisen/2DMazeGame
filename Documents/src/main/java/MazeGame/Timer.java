package MazeGame;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Creates a timer to track game progress.
 *
 * @author Reece Landry
 */
public class Timer {

    private final int amountOfTime = 10;

    Date endTime;

    public Timer() {
        Calendar date = Calendar.getInstance();
        long timeInSecs = date.getTimeInMillis();
        endTime = new Date(timeInSecs + (amountOfTime * 60 * 1000));
    }

    /**
     * Return the remaining time to finish the game
     *
     * @return String formatted time string showing time remaining in game
     */
    public String getTimeRemaining() {
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");

        Date currentTime = new Date();
        long timeSince = endTime.getTime() - currentTime.getTime();
        long differenceInMinutes = (timeSince / (1000 * 60)) % 60;
        long differenceInSeconds = timeSince / 1000 % 60;

        return String.format("%02d", differenceInMinutes) + ":" + differenceInSeconds;
    }

    /**
     * Returns the player's modified end-game score
     *
     * @return the user score
     */
    public int getScore() {
        Date currentTime = new Date();
        long timeSince = endTime.getTime() - currentTime.getTime();
        long differenceInMinutes = (timeSince / (1000 * 60)) % 60;
        long differenceInSeconds = timeSince / 1000 % 60;
        return (int) (differenceInMinutes * 12 + differenceInSeconds / 5);
    }
}
