package Rzeczy;

import Main.GamePanel;
import Main.Klawiatura;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Smieciarka extends Rzecz {

    static GamePanel gp;
    Klawiatura keyH;
    public static int papier = 0; // poniższe cztery do sprawdzenia pomieszania śmieci
    public static int plastik = 0;
    public static int szklo = 0;

    public static int mieszane = 0;

    public static int pojemnosc_default = 3; // domyślna pojemność śmiecarki na poziom
    public static int pojemnosc = pojemnosc_default;
    public static int ile_na_pace = 0;      // licznik śmieci, które aktualnie są na śmieciarce
    public static int ile_zebrano = 0;    // licznik śmieci odstawionych na wysypisako


    public Smieciarka(GamePanel gp, Klawiatura keyH) {

        this.gp = gp;
        this.keyH= keyH;

        Pole_kolizji = new Rectangle(6,12, 30, 20);  // ustawienie pola kolizji śmieciarki- 30 pikseli szerokości i 20 wysokości wychodzących z punktu (6,12)
        Pole_kolizji_X_domyslny = Pole_kolizji.x;
        Pole_kolizji_Y_domyslny = Pole_kolizji.y;


        Parametry_podstawowe();
        obrazki_smieciarki();
    }
    public void Parametry_podstawowe(){ // domyślne ustawienie śmieciarki na mapie

        x = 96;
        y = 672;
        szybkosc = 6;
        kierunek = "góra";
    }
    public static void ustawieniaFabryczne(){ // resetowanie wszelkich zmiennych śmieciarki między poziomami i przed rozpoczęciem nowej gry
        x = 96;
        y = 672;
        kierunek = "góra";
        ile_na_pace = 0;
        papier = 0;
        plastik = 0;
        szklo = 0;
        mieszane = 0;
        ile_zebrano = 0;

    }
    public void obrazki_smieciarki() { // ładowanie odpowiednich obrazków śmieciarki przy wciskaniu danego klawisza

        try{

            W= ImageIO.read(getClass().getResourceAsStream("/smieciarka/smieciarka_w.png"));
            S= ImageIO.read(getClass().getResourceAsStream("/smieciarka/smieciarka_s.png"));
            A= ImageIO.read(getClass().getResourceAsStream("/smieciarka/smieciarka_a.png"));
            D= ImageIO.read(getClass().getResourceAsStream("/smieciarka/smieciarka_d.png"));


        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {         // ustawienie poruszania się śmieciarki za pomocą klawiszy WASD

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
        gp.kontroler.SprawdzPiksel(this);    // sprawdzanie każdego pola pod względem kolizyjności w trakcie ruchu śmieciarki

        int Pojemnik_Znacznik = gp.kontroler.SprawdzPojemnik(this, true);
        Podnies_pojemnik(Pojemnik_Znacznik);

        if(kolizja_działa == false){             // zezwolenie na ruch śmieciarki jeżeli nie nastąpił kontakt pola kolizji śmieciarki z blokiem mającym cechę kolizji

            switch(kierunek){                     // zmiana położenia śmieciarki poprzez odjęcie od jej położenia wartości parametru "szybkość"
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

            String Rodzaj_pojemnika = gp.Poj[gp.aktualnaMapa][i].nazwa;

            switch(Rodzaj_pojemnika){        // podniesienie pojemnika polegające na usunięciu pojemnika z tablicy pojemników (w tym obrazu) oraz inkrementacja odpowiedniego licznika w zależnośći od tego, jaki pojemnik podniesiono
                case "papier":
                    papier++;
                    gp.Poj[gp.aktualnaMapa][i]= null;
                    ile_na_pace++;
                    break;
                case "szklo":
                    szklo++;
                    gp.Poj[gp.aktualnaMapa][i]= null;
                    ile_na_pace ++;
                    break;
                case "plastik":
                    plastik++;
                    gp.Poj[gp.aktualnaMapa][i]= null;
                    ile_na_pace++;
                    break;
                case "mieszane":
                    mieszane++;
                    gp.Poj[gp.aktualnaMapa][i]= null;
                    ile_na_pace++;
                    break;

            }
            if (((papier > 0) && (plastik >0) && (szklo>0))||((mieszane > 0) && (plastik >0) && (szklo>0))||((papier > 0) && (mieszane >0) && (szklo>0))||((papier > 0) && (plastik >0) && (mieszane>0))){
                gp.ui.porażka_pomieszanie = true;   // sprawdzanie złamania reguły pomieszania śmieci we wszystkich możliwych kombinacjach
                gp.StanGry = gp.StanPorażkaPomieszanie;
            }

        }


    }
    public void draw(Graphics2D g2) {  // rysowanie ruchu śmieciarki


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
