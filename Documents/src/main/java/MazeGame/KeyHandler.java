package MazeGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public static boolean upPressed, downPressed, leftPressed, rightPressed;

    public static boolean isDownPressed() {
        return downPressed;
    }

    public static boolean isLeftPressed() {
        return leftPressed;
    }

    public static boolean isRightPressed() {
        return rightPressed;
    }

    public static boolean isUpPressed() {
        return upPressed;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
}
