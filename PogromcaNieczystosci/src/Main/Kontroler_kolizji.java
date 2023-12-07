package Main;

import Rzeczy.Rzecz;

public class Kontroler_kolizji {

        GamePanel gp;

    public Kontroler_kolizji(GamePanel gp){
        this.gp = gp;
    }
    public void SprawdzPiksel(Rzecz rzecz){

        int Lewy_X= rzecz.x+ Rzecz.Pole_kolizji.x;
        int Prawy_X = rzecz.x + Rzecz.Pole_kolizji.x + Rzecz.Pole_kolizji.width;
        int Górny_Y= rzecz.y + Rzecz.Pole_kolizji.y;
        int Dolny_Y= rzecz.y + Rzecz.Pole_kolizji.y + Rzecz.Pole_kolizji.height;

        int lewa_kolumna= Lewy_X/gp.rozmiar_pola;
        int prawa_kolumna= Prawy_X/gp.rozmiar_pola;
        int górny_wiersz= Górny_Y/ gp.rozmiar_pola;
        int dolny_wiersz= Dolny_Y/ gp.rozmiar_pola;

        int Pole1, Pole2;

        switch(Rzecz.kierunek) {
            case "góra":
                    górny_wiersz = (Górny_Y - Rzecz.szybkosc)/gp.rozmiar_pola;
                    Pole1 = gp.AdminP.MapaNumerPola[lewa_kolumna][górny_wiersz];
                    Pole2 = gp.AdminP.MapaNumerPola[prawa_kolumna][górny_wiersz];
                    if(gp.AdminP.pole[Pole1].kolizja == true || gp.AdminP.pole[Pole2].kolizja == true) {
                        Rzecz.kolizja_działa = true;
                    }
                break;
            case "dół":
                    dolny_wiersz = (Dolny_Y + Rzecz.szybkosc)/gp.rozmiar_pola;
                    Pole1 = gp.AdminP.MapaNumerPola[lewa_kolumna][dolny_wiersz];
                    Pole2 = gp.AdminP.MapaNumerPola[prawa_kolumna][dolny_wiersz];
                    if(gp.AdminP.pole[Pole1].kolizja == true || gp.AdminP.pole[Pole2].kolizja == true) {
                        Rzecz.kolizja_działa = true;
                }
                break;
            case "lewo":
                lewa_kolumna = (Lewy_X - Rzecz.szybkosc)/gp.rozmiar_pola;
                Pole1 = gp.AdminP.MapaNumerPola[lewa_kolumna][górny_wiersz];
                Pole2 = gp.AdminP.MapaNumerPola[lewa_kolumna][dolny_wiersz];
                if(gp.AdminP.pole[Pole1].kolizja == true || gp.AdminP.pole[Pole2].kolizja == true) {
                    Rzecz.kolizja_działa = true;
                }
                break;
            case "prawo":
                prawa_kolumna = (Prawy_X + Rzecz.szybkosc)/gp.rozmiar_pola;
                Pole1 = gp.AdminP.MapaNumerPola[prawa_kolumna][górny_wiersz];
                Pole2 = gp.AdminP.MapaNumerPola[prawa_kolumna][dolny_wiersz];
                if(gp.AdminP.pole[Pole1].kolizja == true || gp.AdminP.pole[Pole2].kolizja == true) {
                    Rzecz.kolizja_działa = true;
                }
                break;


        }

    }
    public int SprawdzPojemnik(Rzecz rzecz, boolean Smieciarka){

        int znacznik = 999;

        for (int i = 0; i < gp.Poj.length; i++){

            if(gp.Poj[i] != null){

                Rzecz.Pole_kolizji.x = Rzecz.x + Rzecz.Pole_kolizji.x;

            }
        }

        return znacznik;
    }
}
