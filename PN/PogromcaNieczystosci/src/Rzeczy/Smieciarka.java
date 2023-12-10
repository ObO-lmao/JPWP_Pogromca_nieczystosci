package Rzeczy;

import Main.GamePanel;
import Main.Klawiatura;
import pole.Pole;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Smieciarka extends Rzecz {

    GamePanel gp;
    Klawiatura keyH;
    int papier = 0;
    int plastik = 0;
    int szklo = 0;
    public static int pojemnosc = 3;
    public static int ile_na_pace = 0;


    public Smieciarka(GamePanel gp, Klawiatura keyH) {

        this.gp = gp;
        this.keyH= keyH;

        Pole_kolizji = new Rectangle(6,12, 39, 27);
        Pole_kolizji_X_domyslny = Pole_kolizji.x;
        Pole_kolizji_Y_domyslny = Pole_kolizji.y;


        Parametry_podstawowe();
        obrazki_smieciarki();
    }
    public void Parametry_podstawowe(){

        x = 100;
        y = 100;
        szybkosc = 4;
        kierunek = "góra";
    }
    public void obrazki_smieciarki() {

        try{

            W= ImageIO.read(getClass().getResourceAsStream("/smieciarka/smieciarka_w.png"));
            S= ImageIO.read(getClass().getResourceAsStream("/smieciarka/smieciarka_s.png"));
            A= ImageIO.read(getClass().getResourceAsStream("/smieciarka/smieciarka_a.png"));
            D= ImageIO.read(getClass().getResourceAsStream("/smieciarka/smieciarka_d.png"));


        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {

        if(keyH.W_pressed == true) {
            kierunek = "góra";

        }
        else if(keyH.S_pressed == true){
            kierunek = "dół";

        }
        else if(keyH.A_pressed == true){
            kierunek = "lewo";

        }
        else if(keyH.D_pressed == true){
            kierunek = "prawo";

        }
        kolizja_działa = false;
        gp.kontroler.SprawdzPiksel(this);

        int Pojemnik_Znacznik = gp.kontroler.SprawdzPojemnik(this, true);
        Podnies_pojemnik(Pojemnik_Znacznik);

        if(kolizja_działa == false){

            switch(kierunek){
                case "góra":
                    if(keyH.W_pressed == true) {
                        y -= szybkosc;
                    }
                    break;
                case "dół":
                    if(keyH.S_pressed == true) {
                        y += szybkosc;
                    }
                    break;
                case "lewo":
                    if(keyH.A_pressed == true) {
                        x -= szybkosc;
                    }
                    break;
                case "prawo":
                    if(keyH.D_pressed == true) {
                        x += szybkosc;
                    }
                    break;


            }
        }
    }
    public void Podnies_pojemnik (int i){

        if(i != 999 && (ile_na_pace < pojemnosc)) {

            String Rodzaj_pojemnika = gp.Poj[i].nazwa;

            switch(Rodzaj_pojemnika){
                case "papier":
                    papier++;
                    gp.Poj[i]= null;
                    ile_na_pace++;
                    break;
                case "szklo":
                    szklo++;
                    gp.Poj[i]= null;
                    ile_na_pace ++;
                    break;
                case "plastik":
                    plastik++;
                    gp.Poj[i]= null;
                    ile_na_pace++;
                    break;

            }
            if ((papier > 0) && (plastik >0) && (szklo>0)){
                gp.ui.porażka_pomieszanie = true;

            }

        }


    }
    public void draw(Graphics2D g2) {


        BufferedImage image = null;

        switch (kierunek) {
            case "góra":
                image = W;
                break;
            case "dół":
                image = S;
                break;
            case "prawo":
                image = D;
                break;
            case "lewo":
                image = A;
                break;
        }
        g2.drawImage(image, x, y, gp.rozmiar_pola, gp.rozmiar_pola, null);
    }
}
