package Main;

import Rzeczy.Smieciarka;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Klawiatura implements KeyListener {

    /**
     * klasa odpowiedzialna za połączenie wciskanych przez gracza klawiszy z odpowiednimi akcjami
     */


    GamePanel gp;
    public boolean W_pressed, S_pressed, A_pressed, D_pressed;
    public static boolean czy_grano = false;


    public Klawiatura(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(gp.StanGry == gp.StanMenu){            // nasłuchiwanie klawiatury w menu i implementacja strzałek przy aktualnie wybranej opcji

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
                if(code == KeyEvent.VK_ENTER){    // przejście do wyboru czasu na poziom
                    if(gp.ui.wybrana_opcja == 0){
                        Smieciarka.pojemnosc = Smieciarka.pojemnosc_default;
                        gp.aktualnaMapa = 0;
                        gp.ui.któryEkranMenu = 1;
                        czy_grano = false;

                    }
                    if(gp.ui.wybrana_opcja == 1){  // przejście do gry od ostaniego postępu
                        if(czy_grano) {
                            gp.StanGry = gp.StanGranie;
                        }
                    }
                    if(gp.ui.wybrana_opcja == 2){  // przejście do instrukcji
                        gp.StanGry =  gp.StanInstrukcja;
                    }
                    if(gp.ui.wybrana_opcja == 3){
                        System.exit(0);
                    }
                }
            }
            else if (gp.ui.któryEkranMenu == 1){  // nasłuchiwanie klawiatury w trakcie wyboru czasu na poziom
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
                if(code == KeyEvent.VK_ENTER){            // przygotowanie nowej gry w 3 różniących się wybranym czasem
                    if(gp.ui.wybrana_opcja == 0){
                        Klawiatura.czy_grano = true;
                        gp.aktualnaMapa = 0;
                        gp.ui.czasNaPoziom = gp.ui.czasNaPoziom_default1;
                        gp.ui.czasNaPoziom_default = gp.ui.czasNaPoziom;
                        gp.StanGry = gp.StanGranie;
                        Smieciarka.ustawieniaFabryczne();
                        gp.Mieczysław.Ustaw_Pojemnik();
                        gp.próg_poziomu = gp.ilezebrać(gp.aktualnaMapa);
                        gp.ui.któryEkranMenu = 0;
                        gp.ui.wybrana_opcja =0;
                    }
                    if(gp.ui.wybrana_opcja == 1){
                        gp.aktualnaMapa = 0;
                        Klawiatura.czy_grano = true;
                        gp.ui.czasNaPoziom = gp.ui.czasNaPoziom_default2;
                        gp.ui.czasNaPoziom_default = gp.ui.czasNaPoziom;
                        Smieciarka.ustawieniaFabryczne();
                        gp.Mieczysław.Ustaw_Pojemnik();
                        gp.próg_poziomu = gp.ilezebrać(gp.aktualnaMapa);
                        gp.StanGry = gp.StanGranie;
                        gp.ui.któryEkranMenu = 0;
                        gp.ui.wybrana_opcja =0;

                    }
                    if(gp.ui.wybrana_opcja == 2){
                        gp.aktualnaMapa = 0;
                        Klawiatura.czy_grano = true;
                        Smieciarka.ustawieniaFabryczne();
                        gp.Mieczysław.Ustaw_Pojemnik();
                        gp.ui.czasNaPoziom = gp.ui.czasNaPoziom_default3;
                        gp.ui.czasNaPoziom_default = gp.ui.czasNaPoziom;
                        gp.StanGry = gp.StanGranie;
                        gp.próg_poziomu = gp.ilezebrać(gp.aktualnaMapa);
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

            }
        }
        else if(gp.StanGry == gp.StanPorażkaCzas || gp.StanGry == gp.StanPorażkaPomieszanie){ // nasłuchiwanie klawiatury w trakcie ekranu dowolnej z opcji porażki
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
        else if (gp.StanGry == gp.StanKoniec){  //nasłuchiwanie na ekranie końcowym
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
                    gp.Mieczysław.Ustaw_Pojemnik();
                    gp.aktualnaMapa =0;
                    gp.StanGry = gp.StanGranie;
                    gp.ui.resetCzasu();

                }
                if(gp.ui.wybrana_opcja ==1){
                    gp.StanGry = gp.StanMenu;
                    gp.spróbuj_ponownie();
                }
            }
        }
                                               // nasłuchiwanie w trakcie gry
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

    }


    @Override
    public void keyReleased(KeyEvent e) { //zatrzymywanie śmieciarki po puszczeniu klawisza

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
