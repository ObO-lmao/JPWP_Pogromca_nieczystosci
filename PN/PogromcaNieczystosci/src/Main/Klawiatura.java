package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Klawiatura implements KeyListener {

    GamePanel gp;
    public boolean W_pressed, S_pressed, A_pressed, D_pressed;
    public boolean czy_grano = false;


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

            if (gp.ui.któryEkranMenu == 0){
                if(code == KeyEvent.VK_W){
                    gp.ui.wybrana_opcja--;
                    if(gp.ui.wybrana_opcja < 0){
                        gp.ui.wybrana_opcja = 3;
                    }
                }
                if(code == KeyEvent.VK_S){
                    gp.ui.wybrana_opcja++;
                    if(gp.ui.wybrana_opcja > 3){
                        gp.ui.wybrana_opcja = 0;
                    }
                }
                if(code == KeyEvent.VK_ENTER){
                    if(gp.ui.wybrana_opcja == 0){
                        gp.aktualnaMapa = 0;
                        gp.ui.któryEkranMenu = 1;
                        czy_grano = true;

                    }
                    if(gp.ui.wybrana_opcja == 1){
                        if(czy_grano) {
                            gp.StanGry = gp.StanGranie;
                        }
                    }
                    if(gp.ui.wybrana_opcja == 2){
                        gp.StanGry =  gp.StanInstrukcja;
                    }
                    if(gp.ui.wybrana_opcja == 3){
                        System.exit(0);
                    }
                }
            }
            else if (gp.ui.któryEkranMenu == 1){
                if(code == KeyEvent.VK_W){
                    gp.ui.wybrana_opcja--;
                    if(gp.ui.wybrana_opcja < 0){
                        gp.ui.wybrana_opcja = 3;
                    }
                }
                if(code == KeyEvent.VK_S){
                    gp.ui.wybrana_opcja++;
                    if(gp.ui.wybrana_opcja > 3){
                        gp.ui.wybrana_opcja = 0;
                    }
                }
                if(code == KeyEvent.VK_ENTER){
                    if(gp.ui.wybrana_opcja == 0){
                        gp.aktualnaMapa = 3;
                        gp.ui.czasNaPoziom_default = 3600;
                        gp.ui.czasNaPoziom = gp.ui.czasNaPoziom_default;
                        gp.StanGry = gp.StanGranie;
                        gp.ui.któryEkranMenu = 0;
                        gp.ui.wybrana_opcja =0;
                    }
                    if(gp.ui.wybrana_opcja == 1){
                        gp.aktualnaMapa = 0;
                        gp.ui.czasNaPoziom_default = 4800;
                        gp.ui.czasNaPoziom = gp.ui.czasNaPoziom_default;
                        gp.StanGry = gp.StanGranie;
                        gp.ui.któryEkranMenu = 0;
                        gp.ui.wybrana_opcja =0;

                    }
                    if(gp.ui.wybrana_opcja == 2){
                        gp.aktualnaMapa = 0;
                        gp.ui.czasNaPoziom_default = 6000;
                        gp.ui.czasNaPoziom = gp.ui.czasNaPoziom_default;
                        gp.StanGry = gp.StanGranie;
                        gp.ui.któryEkranMenu = 0;
                        gp.ui.wybrana_opcja =0;
                    }
                    if(gp.ui.wybrana_opcja == 3){
                        gp.ui.któryEkranMenu = 0;
                    }
                }
            }
        }
        else if(gp.StanGry == gp.StanInstrukcja){
            if(code == KeyEvent.VK_B){
                gp.StanGry = gp.StanMenu;
                System.out.println( gp.StanGry);
            }
        }
        else if(gp.StanGry == gp.StanPorażkaCzas || gp.StanGry == gp.StanPorażkaPomieszanie){
            if (code == KeyEvent.VK_W) {
                gp.ui.wybrana_opcja--;
                if(gp.ui.wybrana_opcja < 0){
                    gp.ui.wybrana_opcja =1;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.wybrana_opcja++;
                if(gp.ui.wybrana_opcja > 1){
                    gp.ui.wybrana_opcja = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER) {
                if(gp.ui.wybrana_opcja == 0){
                    gp.StanGry = gp.StanGranie;
                    gp.spróbuj_ponownie();
                }
                if(gp.ui.wybrana_opcja ==1){
                    gp.StanGry = gp.StanMenu;
                    gp.spróbuj_ponownie();
                }
            }
        }
        else if (gp.StanGry == gp.StanKoniec){
            if (code == KeyEvent.VK_W) {
                gp.ui.wybrana_opcja--;
                if(gp.ui.wybrana_opcja < 0){
                    gp.ui.wybrana_opcja =1;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.wybrana_opcja++;
                if(gp.ui.wybrana_opcja > 1){
                    gp.ui.wybrana_opcja = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER) {
                if(gp.ui.wybrana_opcja == 0){
                    gp.StanGry = gp.StanGranie;
                    gp.spróbuj_ponownie();
                }
                if(gp.ui.wybrana_opcja ==1){
                    gp.StanGry = gp.StanMenu;
                    gp.spróbuj_ponownie();
                }
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
        if(code == KeyEvent.VK_ESCAPE){
            gp.StanGry = gp.StanMenu;
        }
        if(code == KeyEvent.VK_R){
            switch (gp.aktualnaMapa){
                case 0: gp.AdminP.LadujMape("Mapy/mapa1.txt",0);
                gp.ui.czasNaPoziom = gp.ui.czasNaPoziom_default;
                break;
                case 1: gp.AdminP.LadujMape("Mapy/mapa2.txt",0);
                gp.ui.czasNaPoziom = gp.ui.czasNaPoziom_default;
                break;
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
