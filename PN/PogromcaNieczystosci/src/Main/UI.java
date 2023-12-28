package Main;

import Pojemniki.Pojemnik_mieszane;
import Pojemniki.Pojemnik_papier;
import Pojemniki.Pojemnik_plastik;
import Pojemniki.Pojemnik_szkło;
import Rzeczy.Smieciarka;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font calibri_36, calibri_48B, calibri_18, calibri_18B;
    BufferedImage symbol_plastik, symbol_szklo, symbol_papier, symbol_mieszane;
    public boolean czy_powiadomienie = false;
    public String powiadomienie ="";
    public int czas_powiadomienia = 0;
    public boolean porażka_pomieszanie = false;
    public int wybrana_opcja = 0;
    public int czasNaPoziom_default1 = 600;
    public int czasNaPoziom_default2 = 7200;
    public int czasNaPoziom_default3 = 8400;

    public int czasNaPoziom_default = 0;
    public int czasNaPoziom = czasNaPoziom_default1;
    private int klatki = 60;
    public int któryEkranMenu = 0;


    private boolean odliczanie = false;

    public UI(GamePanel gp){
        this.gp = gp;
        calibri_36 = new Font("calibri", Font.PLAIN, 36);
        calibri_48B = new Font("calibri", Font.BOLD, 48);
        calibri_18 = new Font("calibri", Font.PLAIN, 18);
        calibri_18B = new Font("calibri", Font.BOLD, 18);
        Pojemnik_papier papier = new Pojemnik_papier();
        Pojemnik_szkło szklo = new Pojemnik_szkło();
        Pojemnik_plastik plastik = new Pojemnik_plastik();
        Pojemnik_mieszane mieszane = new Pojemnik_mieszane();
        symbol_plastik = plastik.image;
        symbol_papier = papier.image;
        symbol_szklo = szklo.image;
        symbol_mieszane = mieszane.image;

    }

    public void pokaz_powiadomienie(String text){

        powiadomienie = text;
        czy_powiadomienie = true;
    }
    public void draw(Graphics2D g2){
        this.g2=g2;
        licznik_zebranych_śmieci();
        if (gp.StanGry == gp.StanMenu){
            rysujMenu();
        }
        if(gp.StanGry == gp.StanGranie){
            gp.czy_kolejny_poziom(gp.próg_poziomu);
            startLicznikCzasu();
            if(gp.licznikKlatek % klatki ==0 ){
            updateLicznikCzasu();}
            rysujLicznikCzasu();
        }
        if(gp.StanGry == gp.StanPauza){
            rysujPauze();
            rysujLicznikCzasu();
            stopLicznikCzasu();
        }
        if (gp.StanGry == gp.StanInstrukcja){
            rysujInstrukcje();
        }
        if (gp.StanGry == gp.StanPorażkaPomieszanie){
            koniecGryPomieszanie();
        }
        if (gp.StanGry == gp.StanPorażkaCzas){
            koniecGryCzas();
        }
        if (gp.StanGry == gp.StanKoniec){
            koniecGry();
        }


    }
    public void rysujMenu(){
        if(któryEkranMenu == 0){

            g2.setColor(Color.gray);
            g2.fillRect(0, 0, gp.szerokosc, gp.dlugosc);
            g2.setFont(calibri_48B);
            String text = "Pogromca nieczystości - przygody Pana Areczka";
            int x = Srodek_ośX(text);
            int y = gp.rozmiar_pola * 3;


            g2.setColor(Color.black);
            g2.drawString(text, x+3, y+3);

            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            x = gp.szerokosc/2 - gp.rozmiar_pola;
            y += gp.rozmiar_pola * 2;
            g2.drawImage(gp.smieciarka.A, x, y, gp.rozmiar_pola*2, gp.rozmiar_pola *2, null);

            g2.setFont(calibri_36);
            text = "DO ROBOTY (OD NOWA)";
            x = Srodek_ośX(text);
            y += gp.rozmiar_pola*4;
            g2.drawString(text, x, y);
            if (wybrana_opcja == 0){
                g2.drawString(">", x - gp.rozmiar_pola, y);
            }

            text = "DO ROBOTY (KONTYNUUJ)";
            x = Srodek_ośX(text);
            y += gp.rozmiar_pola;
            g2.drawString(text, x, y);
            if (wybrana_opcja == 1){
                g2.drawString(">", x - gp.rozmiar_pola, y);
            }

            text = "INSTRUKCJA";
            x = Srodek_ośX(text);
            y += gp.rozmiar_pola;
            g2.drawString(text, x, y);
            if (wybrana_opcja == 2){
                g2.drawString(">", x - gp.rozmiar_pola, y);
            }

            text = "DO DOMU";
            x = Srodek_ośX(text);
            y += gp.rozmiar_pola;
            g2.drawString(text, x, y);
            if (wybrana_opcja == 3 ){
                g2.drawString(">", x - gp.rozmiar_pola, y);
            }
        }
        else if (któryEkranMenu == 1){
            g2.setColor(Color.gray);
            g2.fillRect(0,0, gp.szerokosc, gp.dlugosc);
            g2.setFont(calibri_36);
            g2.setColor(Color.black);

            String text;
            int długość_tekstu;
            int x;
            int y;

            text = "Ile potrzebuje pan czasu na dzielnicę panie Areczku?";
            długość_tekstu = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.szerokosc/2 - długość_tekstu/2;
            y = gp.dlugosc/2 - (gp.rozmiar_pola*3);
            g2.drawString(text, x,y);
            g2.setColor(Color.white);
            g2.drawString(text, x-3, y-3);

            g2.setColor(Color.white);
            g2.setFont(calibri_36);
            text = "Mało (OSTROŻNIE !!!!1)";
            x = Srodek_ośX(text);
            y += gp.rozmiar_pola * 3;
            g2.drawString(text, x ,y);
            if (wybrana_opcja == 0){
                g2.drawString( ">", x-20, y);
            }

            text = "No tak średnio";
            x = Srodek_ośX(text);
            y += gp.rozmiar_pola ;
            g2.drawString(text, x ,y);
            if (wybrana_opcja == 1){
                g2.drawString( ">", x-20, y);
            }

            text = "Dużo";
            x = Srodek_ośX(text);
            y += gp.rozmiar_pola ;
            g2.drawString(text, x ,y);
            if (wybrana_opcja == 2){
                g2.drawString( ">", x-20, y);
            }

            text = "Powrót do menu";
            x = Srodek_ośX(text);
            y += gp.rozmiar_pola * 2 ;
            g2.drawString(text, x ,y);
            if (wybrana_opcja == 3){
                g2.drawString( ">", x-20, y);
            }

        }


    }
    public void rysujInstrukcje(){
        g2.setColor(Color.gray);
        g2.fillRect(0, 0, gp.szerokosc, gp.dlugosc);
        g2.setFont(calibri_18);
        g2.setColor(Color.white);
        String text = "Panie Areczku. Zarząd ma dla Pana bojowe zadanie.\nPo naszym ostatnim, jak najbardziej legalnym przedsięwzięciu zostało trochę śmieci. \nNa domiar złego mamy dzisiaj ogromne luki kadrowe, więc musi Pan sobie, panie Areczku, poradzić z tym samodzielne.\n" +
                "Za nim jednak weźmie się Pan za robotę, zarząd przedstawia Panu zasady postępowania.\n 1. Problem zaśmiecenia należy rozwiązać błyskawicznie, gdyż jak się za nas weźmie sanepid, to za nim poleci skarbówka.\n Faktur natomiast z tamtego wydarzenia nie mamy, bo kto tyle faktury trzyma?\n" +
                "Czas na wykonanie zadania będzie Pan miał pokazany na pulpicie operacyjnym.\n" +
                "2. Nasza śmieciarka ma limit przewozu, gdyż koszta operacyjne aktualnie nas przerastają.\nMusi Pan zatem co jakiś czas zajeżdżać na wysypisko, celem opróżnienia jej.\n" +
                "3. Wolno Panu na raz przewozić najwyżej dwa rodzaje śmieci bo za to jest na tyle mała kara, że pańska pensja to pokryje.\n Gdyby Pan przekroczył tę liczbę, to zarząd musiałby się dokładać do konsekwencji pańskich mankamentów.\n" +
                "4. Po wciśnięciu klawisza P na pulpicie, rozpocznie się przerwa. Lecz prosze pamiętać Pani Areczku,\n że zarząd płaci Panu za wykonanie bojowego zadania, a nie za przerwy w trakcie jego wykonania.\n" +
                "To tyle Panie Areczku. Proszę wcisnąć B na pulpicie i brać się za robotę. Los łaskawie panu panującego zarządu jest w Pana rękach.";
        String[] lines = text.split("\n");
        int y = gp.dlugosc - (gp.dlugosc - gp.rozmiar_pola);
        for (String line : lines){
            int x = Srodek_ośX(line);
            g2.drawString(line, x, y);
            y += g2.getFontMetrics().getHeight();
        }
    }

    public void licznik_zebranych_śmieci(){
        if(gp.StanGry == gp.StanGranie){
            updateLicznikCzasu();
        }
        if (gp.StanGry != gp.StanMenu || gp.StanGry != gp.StanKoniec){
            g2.setFont(calibri_36);
            g2.setColor(Color.white);
            g2.drawImage(symbol_mieszane, gp.rozmiar_pola/4, -10, gp.rozmiar_pola, gp.rozmiar_pola, null);
            g2.drawImage(symbol_szklo, 3*gp.rozmiar_pola/4, -10, gp.rozmiar_pola, gp.rozmiar_pola, null);
            g2.drawImage(symbol_papier, 5*gp.rozmiar_pola/4, -10, gp.rozmiar_pola, gp.rozmiar_pola, null);
            g2.drawImage(symbol_plastik, 7*gp.rozmiar_pola/4,  -10, gp.rozmiar_pola, gp.rozmiar_pola, null);
            g2.drawString(": " + Smieciarka.ile_na_pace +"/"+Smieciarka.pojemnosc, 150, 35);

            if(czy_powiadomienie == true){
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(powiadomienie, gp.rozmiar_pola/2, gp.rozmiar_pola*5);

                czas_powiadomienia++;

                if(czas_powiadomienia > 240){
                    czas_powiadomienia =0;
                    czy_powiadomienie = false;
                }
            }}

    }
    public void rysujPauze(){

        String text = "Panie Areczku, tylko bez szaleństw z tą przerwą.";
        int x = Srodek_ośX(text);

        int y= gp.dlugosc/2;

        g2.drawString(text, x, y);
    }
    public int Srodek_ośX(String text){

        int długość = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x= gp.szerokosc/2 - długość/2;
        return x;

    }
    public void updateLicznikCzasu(){
        if (odliczanie) {
            czasNaPoziom--;
        }
        if(czasNaPoziom <=0){
            gp.StanGry = gp.StanPorażkaCzas;

        }
    }
    public void startLicznikCzasu(){
        odliczanie = true;
    }
    public void stopLicznikCzasu(){
        odliczanie = false;
    }
    public void rysujLicznikCzasu(){
        g2.setFont(calibri_18B);
        g2.setColor(Color.red);

        String text = "Wizyta sanepidu nastąpi za " + czasNaPoziom / (gp.FPS) ;
        int x = gp.szerokosc - gp.rozmiar_pola * 6;
        int y = gp.rozmiar_pola/2;

        g2.drawString(text, x, y);
    }

    public void koniecGryPomieszanie(){

        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0, gp.szerokosc, gp.dlugosc);
        g2.setFont(calibri_36);
        g2.setColor(Color.black);

        String text;
        int długość_tekstu;
        int x;
        int y;

        text = "Panie Areczku, mieszanie śmieci jest dla zarządu. Dla pana mamy";
        długość_tekstu = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        x = gp.szerokosc/2 - długość_tekstu/2;
        y = gp.dlugosc/2 - (gp.rozmiar_pola*3);
        g2.drawString(text, x,y);
        g2.setColor(Color.white);
        g2.drawString(text, x-3, y-3);

        g2.setFont(calibri_48B);
        g2.setColor(Color.black);

        text = "KONIEC GRY";
        długość_tekstu = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        x = gp.szerokosc/2 - długość_tekstu/2;
        y = gp.dlugosc/2 - (gp.rozmiar_pola*2);
        g2.drawString(text, x,y);
        g2.setColor(Color.RED);
        g2.drawString(text, x-3, y-3);

        g2.setColor(Color.white);
        g2.setFont(calibri_36);
        text = "Spróbuj ponownie";
        x = Srodek_ośX(text);
        y += gp.rozmiar_pola * 3;
        g2.drawString(text, x ,y);
        if (wybrana_opcja == 0){
            g2.drawString( ">", x-20, y);
        }

        text = "Menu";
        x = Srodek_ośX(text);
        y += gp.rozmiar_pola ;
        g2.drawString(text, x ,y);
        if (wybrana_opcja == 1){
            g2.drawString( ">", x-20, y);
        }



    }
    public void koniecGryCzas(){

        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0, gp.szerokosc, gp.dlugosc);
        g2.setFont(calibri_36);
        g2.setColor(Color.white);

        String text;
        int długość_tekstu;
        int x = 0;
        int y;

        text = "Panie Areczku, właśnie dzwoni do nas sanepid.\n Dla pana zaś mamy zaproszenie na dywanik i";
        String[] lines = text.split("\n");
        y = gp.dlugosc - (gp.dlugosc - (gp.rozmiar_pola*3));
        for (String line : lines){
            x = Srodek_ośX(line);
            g2.drawString(line, x, y);
            y += g2.getFontMetrics().getHeight();
        }


        g2.setFont(calibri_48B);
        g2.setColor(Color.black);

        text = "KONIEC GRY";
        długość_tekstu = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        x = gp.szerokosc/2 - długość_tekstu/2;
        y = gp.dlugosc/2 - (gp.rozmiar_pola*2);
        g2.drawString(text, x,y);
        g2.setColor(Color.RED);
        g2.drawString(text, x-3, y-3);

        g2.setColor(Color.white);
        g2.setFont(calibri_36);
        text = "Spróbuj ponownie";
        x = Srodek_ośX(text);
        y += gp.rozmiar_pola * 3;
        g2.drawString(text, x ,y);
        if (wybrana_opcja == 0){
            g2.drawString( ">", x-20, y);
        }

        text = "Menu";
        x = Srodek_ośX(text);
        y += gp.rozmiar_pola ;
        g2.drawString(text, x ,y);
        if (wybrana_opcja == 1){
            g2.drawString( ">", x-20, y);
        }
    }
    public void koniecGry(){

        Klawiatura.czy_grano = false;
        Smieciarka.ustawieniaFabryczne();
        Smieciarka.pojemnosc = Smieciarka.pojemnosc_default;

        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0, gp.szerokosc, gp.dlugosc);
        g2.setFont(calibri_36);
        g2.setColor(Color.white);

        String text;
        int długość_tekstu;
        int x = 0;
        int y;

        text = "Panie Areczku, gratulujemy wykonania zadania.\n Jednakże Panie Areczku: premie są dla zarządu.\n" +
                "Dla pana zaś mamy owocowe czwartki lub powtórkę z rozrywki.";
        String[] lines = text.split("\n");
        y = gp.dlugosc - (gp.dlugosc - (gp.rozmiar_pola*3));
        for (String line : lines){
            x = Srodek_ośX(line);
            g2.drawString(line, x, y);
            y += g2.getFontMetrics().getHeight();
        }

        g2.setColor(Color.white);
        g2.setFont(calibri_36);
        text = "Spróbuj ponownie";
        x = Srodek_ośX(text);
        y += gp.rozmiar_pola * 3;
        g2.drawString(text, x ,y);
        if (wybrana_opcja == 0){
            g2.drawString( ">", x-20, y);
        }

        text = "Menu";
        x = Srodek_ośX(text);
        y += gp.rozmiar_pola ;
        g2.drawString(text, x ,y);
        if (wybrana_opcja == 1){
            g2.drawString( ">", x-20, y);
        }
    }
    public void resetCzasu(){
        czasNaPoziom = czasNaPoziom_default;
    }

}
