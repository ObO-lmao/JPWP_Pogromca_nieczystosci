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
                Rzecz.Pole_kolizji.y= Rzecz.y + Rzecz.Pole_kolizji.y;

                gp.Poj[i].Pole_kolizji.x = gp.Poj[i].x + gp.Poj[i].Pole_kolizji.x;
                gp.Poj[i].Pole_kolizji.y = gp.Poj[i].y + gp.Poj[i].Pole_kolizji.y;

                switch(Rzecz.kierunek){
                    case "góra":
                        Rzecz.Pole_kolizji.y -= Rzecz.szybkosc;
                        if(Rzecz.Pole_kolizji.intersects(gp.Poj[i].Pole_kolizji)){
                            if(gp.Poj[i].kolizja == true) {
                                Rzecz.kolizja_działa = true;
                                System.out.println("kolizja z " + i + gp.Poj[i].nazwa);
                            }
                            if(Smieciarka == true){
                                znacznik =i;
                            }
                            break;
                        }


                    case "dół":
                        Rzecz.Pole_kolizji.y += Rzecz.szybkosc;
                        if(Rzecz.Pole_kolizji.intersects(gp.Poj[i].Pole_kolizji)){
                            if(gp.Poj[i].kolizja == true) {
                                Rzecz.kolizja_działa = true;
                                System.out.println("kolizja z " + i + gp.Poj[i].nazwa);
                            }
                            if(Smieciarka == true){
                                znacznik =i;
                            }
                            break;
                        }

                    case "lewo":
                        Rzecz.Pole_kolizji.x -= Rzecz.szybkosc;
                        if(Rzecz.Pole_kolizji.intersects(gp.Poj[i].Pole_kolizji)){
                            if(gp.Poj[i].kolizja == true) {
                                Rzecz.kolizja_działa = true;
                                System.out.println("kolizja z " + i + gp.Poj[i].nazwa);
                            }
                            if(Smieciarka == true){
                                znacznik =i;
                            }
                            break;
                        }

                    case "prawo":
                        Rzecz.Pole_kolizji.x += Rzecz.szybkosc;
                        if(Rzecz.Pole_kolizji.intersects(gp.Poj[i].Pole_kolizji)){
                            if(gp.Poj[i].kolizja == true) {
                                Rzecz.kolizja_działa = true;
                                System.out.println("kolizja z " + i + gp.Poj[i].nazwa);
                            }
                            if(Smieciarka == true){
                                znacznik =i;
                            }
                            break;
                        }


                }
                Rzecz.Pole_kolizji.x = Rzecz.Pole_kolizji_X_domyslny;
                Rzecz.Pole_kolizji.y = Rzecz.Pole_kolizji_Y_domyslny;
                gp.Poj[i].Pole_kolizji.x = gp.Poj[i].Pole_kolizji_X_domyslny;
                gp.Poj[i].Pole_kolizji.y = gp.Poj[i].Pole_kolizji_Y_domyslny;

            }
        }

        return znacznik;
    }
}
