package Main;

import Pojemniki.Pojemnik_papier;
import Pojemniki.Pojemnik_plastik;
import Pojemniki.Pojemnik_szkło;
import Rzeczy.Smieciarka;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    Font calibri_36, calibri_48B;
    BufferedImage symbol_plastik, symbol_szklo, symbol_papier;
    public boolean czy_powiadomienie = false;
    public String powiadomienie ="";
    public int czas_powiadomienia = 0;
    public boolean porażka_pomieszanie = false;

    public UI(GamePanel gp){
        this.gp = gp;
        calibri_36 = new Font("calibri", Font.PLAIN, 36);
        calibri_48B = new Font("calibri", Font.BOLD, 48);
        Pojemnik_papier papier = new Pojemnik_papier();
        Pojemnik_szkło szklo = new Pojemnik_szkło();
        Pojemnik_plastik plastik = new Pojemnik_plastik();
        symbol_plastik = plastik.image;
        symbol_papier = papier.image;
        symbol_szklo = szklo.image;

    }

    public void pokaz_powiadomienie(String text){

        powiadomienie = text;
        czy_powiadomienie = true;
    }
    public void draw(Graphics2D g2){

        if(porażka_pomieszanie == true){

            g2.setFont(calibri_36);
            g2.setColor(Color.white);

            String text;
            int długość_tekstu;
            int x;
            int y;

            text = "O ty łobuzie! Czego śmieci mieszasz?!";
            długość_tekstu = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.szerokosc/2 - długość_tekstu/2;
            y = gp.dlugosc/2 - (gp.rozmiar_pola*3);
            g2.drawString(text, x,y);

            g2.setFont(calibri_48B);
            g2.setColor(Color.RED);

            text = "KONIEC GRY";
            długość_tekstu = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.szerokosc/2 - długość_tekstu/2;
            y = gp.dlugosc/2 - (gp.rozmiar_pola*2);
            g2.drawString(text, x,y);

            gp.gameThread = null;


        }
        else{
            g2.setFont(calibri_36);
            g2.setColor(Color.white);
            g2.drawImage(symbol_szklo, gp.rozmiar_pola, gp.rozmiar_pola, gp.rozmiar_pola, gp.rozmiar_pola, null);
            g2.drawImage(symbol_papier, 2*gp.rozmiar_pola, gp.rozmiar_pola, gp.rozmiar_pola, gp.rozmiar_pola, null);
            g2.drawImage(symbol_plastik, 3*gp.rozmiar_pola, gp.rozmiar_pola, gp.rozmiar_pola, gp.rozmiar_pola, null);
            g2.drawString(": " + Smieciarka.ile_na_pace +"/"+Smieciarka.pojemnosc, 200, 90);

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
}
