package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Klawiatura implements KeyListener {

    public boolean W_pressed, S_pressed, A_pressed, D_pressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            W_pressed = true;
        }
        if(code == KeyEvent.VK_S){
            S_pressed = true;
        }
        if(code == KeyEvent.VK_A){
            A_pressed = true;
        }
        if(code == KeyEvent.VK_D){
            D_pressed = true;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            W_pressed = false;
        }
        if(code == KeyEvent.VK_S){
            S_pressed = false;
        }
        if(code == KeyEvent.VK_A){
            A_pressed = false;
        }
        if(code == KeyEvent.VK_D){
            D_pressed = false;
        }

    }
}
