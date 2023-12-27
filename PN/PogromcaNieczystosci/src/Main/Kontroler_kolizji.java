package Main;

import Rzeczy.Rzecz;

import static Rzeczy.Smieciarka.*;

public class Kontroler_kolizji {

        GamePanel gp;

    public Kontroler_kolizji(GamePanel gp){
        this.gp = gp;
    }
    public void SprawdzPiksel(Rzecz rzecz){ //definiowanie pikseli pól kolizji, których kontakt ze śmieciarką będzie sprawdzany w zależności od jej kierunku poruszania

        int Lewy_X= rzecz.x+ Rzecz.Pole_kolizji.x;
        int Prawy_X = rzecz.x + Rzecz.Pole_kolizji.x + Rzecz.Pole_kolizji.width;
        int Górny_Y= rzecz.y + Rzecz.Pole_kolizji.y;
        int Dolny_Y= rzecz.y + Rzecz.Pole_kolizji.y + Rzecz.Pole_kolizji.height;

        int lewa_kolumna= Lewy_X/gp.rozmiar_pola;
        int prawa_kolumna= Prawy_X/gp.rozmiar_pola;
        int górny_wiersz= Górny_Y/ gp.rozmiar_pola;
        int dolny_wiersz= Dolny_Y/ gp.rozmiar_pola;

        int Pole1, Pole2;

        switch(Rzecz.kierunek) {  // kolizja jest sprawdzana wyłącznie na dwóch pikselach pola kolizji w zależności od kierunku poruszania się śmieciarki
            case "góra":          // gdy śmieciarka porusza się w górę, kolizja sprawdza jedynie dwa piksele dolne pól kolizji danego elementu tła, co działa analogicznie dla innych kierunków
                    górny_wiersz = (Górny_Y - Rzecz.szybkosc)/gp.rozmiar_pola;
                    Pole1 = gp.AdminP.MapaNumerPola[gp.aktualnaMapa][lewa_kolumna][górny_wiersz];
                    Pole2 = gp.AdminP.MapaNumerPola[gp.aktualnaMapa][prawa_kolumna][górny_wiersz];
                    if(gp.AdminP.pole[Pole1].kolizja == true || gp.AdminP.pole[Pole2].kolizja == true) {
                        Rzecz.kolizja_działa = true;
                    }
                    if(gp.AdminP.pole[Pole1].wysypisko == true || gp.AdminP.pole[Pole2].wysypisko == true ){
                        ile_zebrano += ile_na_pace;
                        ile_na_pace = 0;
                        papier = 0;
                        plastik = 0;
                        szklo =0;
                        mieszane =0;
                    }
                break;
            case "dół":
                    dolny_wiersz = (Dolny_Y + Rzecz.szybkosc)/gp.rozmiar_pola;
                    Pole1 = gp.AdminP.MapaNumerPola[gp.aktualnaMapa][lewa_kolumna][dolny_wiersz];
                    Pole2 = gp.AdminP.MapaNumerPola[gp.aktualnaMapa][prawa_kolumna][dolny_wiersz];
                    if(gp.AdminP.pole[Pole1].kolizja == true || gp.AdminP.pole[Pole2].kolizja == true) {
                        Rzecz.kolizja_działa = true;
                }
                if(gp.AdminP.pole[Pole1].wysypisko == true || gp.AdminP.pole[Pole2].wysypisko == true ){
                    ile_zebrano += ile_na_pace;
                    ile_na_pace = 0;
                    papier = 0;
                    plastik = 0;
                    szklo =0;
                    mieszane =0;
                }
                break;
            case "lewo":
                lewa_kolumna = (Lewy_X - Rzecz.szybkosc)/gp.rozmiar_pola;
                Pole1 = gp.AdminP.MapaNumerPola[gp.aktualnaMapa][lewa_kolumna][górny_wiersz];
                Pole2 = gp.AdminP.MapaNumerPola[gp.aktualnaMapa][lewa_kolumna][dolny_wiersz];
                if(gp.AdminP.pole[Pole1].kolizja == true || gp.AdminP.pole[Pole2].kolizja == true) {
                    Rzecz.kolizja_działa = true;
                }
                if(gp.AdminP.pole[Pole1].wysypisko == true || gp.AdminP.pole[Pole2].wysypisko == true ){
                    ile_zebrano += ile_na_pace;
                    ile_na_pace = 0;
                    papier = 0;
                    plastik = 0;
                    szklo =0;
                    mieszane = 0;
                }
                break;
            case "prawo":
                prawa_kolumna = (Prawy_X + Rzecz.szybkosc)/gp.rozmiar_pola;
                Pole1 = gp.AdminP.MapaNumerPola[gp.aktualnaMapa][prawa_kolumna][górny_wiersz];
                Pole2 = gp.AdminP.MapaNumerPola[gp.aktualnaMapa][prawa_kolumna][dolny_wiersz];
                if(gp.AdminP.pole[Pole1].kolizja == true || gp.AdminP.pole[Pole2].kolizja == true) {
                    Rzecz.kolizja_działa = true;
                }
                if(gp.AdminP.pole[Pole1].wysypisko == true || gp.AdminP.pole[Pole2].wysypisko == true ){
                    ile_zebrano += ile_na_pace;
                    ile_na_pace = 0;
                    papier = 0;
                    plastik = 0;
                    szklo = 0;
                    mieszane = 0;

                }
                break;


        } //dodatkowo weryfikowane jest wejście na wysypisko, co wiąże się z resetem zebranych śmieci

    }
    public int SprawdzPojemnik(Rzecz rzecz, boolean Smieciarka){

        int znacznik = 999;

        for (int i = 0; i < gp.Poj[1].length; i++){

            if(gp.Poj[gp.aktualnaMapa][i] != null){

                Rzecz.Pole_kolizji.x = Rzecz.x + Rzecz.Pole_kolizji.x;
                Rzecz.Pole_kolizji.y= Rzecz.y + Rzecz.Pole_kolizji.y;

                gp.Poj[gp.aktualnaMapa][i].Pole_kolizji.x = gp.Poj[gp.aktualnaMapa][i].x + gp.Poj[gp.aktualnaMapa][i].Pole_kolizji.x;
                gp.Poj[gp.aktualnaMapa][i].Pole_kolizji.y = gp.Poj[gp.aktualnaMapa][i].y + gp.Poj[gp.aktualnaMapa][i].Pole_kolizji.y;

                switch(Rzecz.kierunek){
                    case "góra":
                        Rzecz.Pole_kolizji.y -= Rzecz.szybkosc;
                        if(Rzecz.Pole_kolizji.intersects(gp.Poj[gp.aktualnaMapa][i].Pole_kolizji)){
                            if(gp.Poj[gp.aktualnaMapa][i].kolizja == true) {
                                Rzecz.kolizja_działa = true;
                                if (ile_na_pace == pojemnosc){
                                    gp.ui.pokaz_powiadomienie("Osiągnięto limit załadunku. Rozładuj śmieciarkę na wysypisku");

                                }
                            }
                            if(Smieciarka == true){
                                znacznik =i;
                            }
                            break;
                        }


                    case "dół":
                        Rzecz.Pole_kolizji.y += Rzecz.szybkosc;
                        if(Rzecz.Pole_kolizji.intersects(gp.Poj[gp.aktualnaMapa][i].Pole_kolizji)){
                            if(gp.Poj[gp.aktualnaMapa][i].kolizja == true) {
                                Rzecz.kolizja_działa = true;
                                if (ile_na_pace == pojemnosc){
                                    gp.ui.pokaz_powiadomienie("Osiągnięto limit załadunku. Rozładuj śmieciarkę na wysypisku.");

                                }
                            }
                            if(Smieciarka == true){
                                znacznik =i;
                            }
                            break;
                        }

                    case "lewo":
                        Rzecz.Pole_kolizji.x -= Rzecz.szybkosc;
                        if(Rzecz.Pole_kolizji.intersects(gp.Poj[gp.aktualnaMapa][i].Pole_kolizji)){
                            if(gp.Poj[gp.aktualnaMapa][i].kolizja == true) {
                                Rzecz.kolizja_działa = true;
                                if (ile_na_pace == pojemnosc){
                                    gp.ui.pokaz_powiadomienie("Osiągnięto limit załadunku. Rozładuj śmieciarkę na wysypisku.");

                                }
                            }
                            if(Smieciarka == true){
                                znacznik =i;
                            }
                            break;
                        }

                    case "prawo":
                        Rzecz.Pole_kolizji.x += Rzecz.szybkosc;
                        if(Rzecz.Pole_kolizji.intersects(gp.Poj[gp.aktualnaMapa][i].Pole_kolizji)){
                            if(gp.Poj[gp.aktualnaMapa][i].kolizja == true) {
                                Rzecz.kolizja_działa = true;
                                if (ile_na_pace == pojemnosc){
                                    gp.ui.pokaz_powiadomienie("Osiągnięto limit załadunku. Rozładuj śmieciarkę na wysypisku.");

                                }
                            }
                            if(Smieciarka == true){
                                znacznik =i;
                            }
                            break;
                        }


                }
                Rzecz.Pole_kolizji.x = Rzecz.Pole_kolizji_X_domyslny;
                Rzecz.Pole_kolizji.y = Rzecz.Pole_kolizji_Y_domyslny;
                gp.Poj[gp.aktualnaMapa][i].Pole_kolizji.x = gp.Poj[gp.aktualnaMapa][i].Pole_kolizji_X_domyslny;
                gp.Poj[gp.aktualnaMapa][i].Pole_kolizji.y = gp.Poj[gp.aktualnaMapa][i].Pole_kolizji_Y_domyslny;

            }
        }

        return znacznik;
    }
}
