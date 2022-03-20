package MazeGame;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Sets the timer
 *
 * @author Hoomehr Mangoli
 */
public class Timer {
	
	private final int amountOfTime = 10;
	
	Date endTime;

	/**
	 * Creates a timer on the game
	 */
	Timer() {
		Calendar date = Calendar.getInstance();
		long timeInSecs = date.getTimeInMillis();
		endTime = new Date(timeInSecs + (amountOfTime * 60 * 1000));
	}

	/**
	 * Returns a string that shows the remaining time in the game
	 *
	 * @return the remaining time
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
	 * Returns the score of the user when the game ends
	 *
	 * @return integer that shows the score
	 */
	public int getScore()
	{
		Date currentTime = new Date();
		long timeSince = endTime.getTime() - currentTime.getTime();
		long differenceInMinutes = (timeSince / (1000 * 60)) % 60;
		long differenceInSeconds = timeSince / 1000 % 60;
		return (int) (differenceInMinutes*12+differenceInSeconds/5);
	}
}
