package MazeGameTest;

import MazeGame.Timer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class TimerTest {
    Timer timer;

    @BeforeEach
    void setup() {
        //create new Timer Bar
        timer = new Timer();
    }

    @Test
    void generateTimer() {
        //test create the timer bar
        assertNotNull(timer,"Fail to create the timer bar");
    }

    @Test
    void GetRemainingTime() {
        assertNotNull(timer.getTimeRemaining(),"Fail to get the remaining time");
    }

    @Test
    void CheckTheTimeIsChange() throws InterruptedException {
        String old = timer.getTimeRemaining();
        TimeUnit.SECONDS.sleep(1);
        assertNotEquals(old,timer.getTimeRemaining(),"The time in timer is unchanged");
    }
    @Test
    void GetTheScore()
    {
        assertEquals(120,timer.getScore(),"Fail to get the correct time score");
    }
}
