package MazeGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * It handles the keyboard actions of the user
 *
 * @author Hoomehr Mangoli
 */
public class KeyHandler implements KeyListener {

    public static boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void setUpPressed(boolean val) {
        upPressed = val;
    }
    public void setDownPressed(boolean val) {
        downPressed = val;
    }
    public void setLeftPressed(boolean val) {
        leftPressed = val;
    }
    public void setRightPressed(boolean val) {
        rightPressed = val;
    }

    /**
     * Checks if one of the "W, A, S, D" is pressed.
     *
     * @param e key action
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
    }

    /**
     * Checks if the key that is pressed is released or not
     *
     * @param e key action
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}

