package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Klawiatura implements KeyListener {

    GamePanel gp;
    public boolean W_pressed, S_pressed, A_pressed, D_pressed;


    public Klawiatura(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(gp.StanGry == gp.StanMenu){

            if(code == KeyEvent.VK_W){
                gp.ui.wybrana_opcja--;
                if(gp.ui.wybrana_opcja < 0){
                    gp.ui.wybrana_opcja = 2;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.wybrana_opcja++;
                if(gp.ui.wybrana_opcja > 2){
                    gp.ui.wybrana_opcja = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.wybrana_opcja == 0){
                    gp.StanGry = gp.StanGranie;
                }
                if(gp.ui.wybrana_opcja == 1){
                    gp.StanGry =  gp.StanInstrukcja;
                    System.out.println(gp.StanGry);
                }
                if(gp.ui.wybrana_opcja == 2){
                    System.exit(0);
                }
            }


        }
        else if(gp.StanGry == gp.StanInstrukcja){
            if(code == KeyEvent.VK_B){
                gp.StanGry = gp.StanMenu;
                System.out.println( gp.StanGry);
            }
        }

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
        if(code == KeyEvent.VK_P){
            if(gp.StanGry == gp.StanGranie){
                gp.StanGry = gp.StanPauza;
            }
            else if (gp.StanGry == gp.StanPauza){
                gp.StanGry = gp.StanGranie;
            }
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
