package pole;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AdminPola {

    GamePanel gp;
    public Pole[] pole;
    public int MapaNumerPola[][][];

    public AdminPola (GamePanel gp) {

        this.gp = gp;

        pole = new Pole[10];
        MapaNumerPola = new int[gp.maxMapy][gp.max_kolumna][gp.max_szereg];

        getObrazekPola();
        LadujMape("/Mapy/mapa1.txt", 0);
        LadujMape("/Mapy/mapa2.txt", 1);
        LadujMape("/Mapy/mapa3.txt", 2);
        LadujMape("/Mapy/mapa4.txt", 3);

    }
    public void getObrazekPola() {

        try {

            pole[0] = new Pole ();
            pole[0].image = ImageIO.read(getClass().getResourceAsStream("/pola/droga.png"));
            pole[1] = new Pole ();
            pole[1].image = ImageIO.read(getClass().getResourceAsStream("/pola/dziedzictwo_narodowe_pierwszego_sekretarza_gierka.png"));
            pole[1].kolizja = true;
            pole[2] = new Pole ();
            pole[2].image = ImageIO.read(getClass().getResourceAsStream("/pola/fundament_ziemskiego_ekosystemu.png"));
            pole[2].kolizja = true;
            pole[3] = new Pole();
            pole[3].image = ImageIO.read(getClass().getResourceAsStream("/pola/strzalka.png"));
            pole[3].kolizja = true;
            pole[4] = new Pole();
            pole[4].image = ImageIO.read(getClass().getResourceAsStream("/pola/wysypisko.png"));
            pole[4].wysypisko = true;
            pole[5]= new Pole();
            pole[5].image = ImageIO.read(getClass().getResourceAsStream("/pola/roboczy.png"));
            pole[5].kolizja = true;


        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public void LadujMape(String SciezkaPliku, int mapa){

        try {
            InputStream is = getClass().getResourceAsStream(SciezkaPliku);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int kolumna = 0;
            int rzad = 0;

            while (kolumna < gp.max_kolumna && rzad < gp.max_szereg){

                String line = br.readLine();

                while(kolumna < gp.max_kolumna ){

                    String numerki[]= line.split(" ");

                    int num = Integer.parseInt(numerki[kolumna]);

                    MapaNumerPola[mapa][kolumna][rzad] = num;
                    kolumna++;
                }
                if (kolumna == gp.max_kolumna) {
                    kolumna = 0;
                    rzad++;
                }
            }
            br.close();

        }catch(Exception e){

        }
    }
    public void draw(Graphics2D g2) {

        int kolumna = 0;
        int rzad = 0;
        int x = 0;
        int y = 0;

        while(kolumna < gp.max_kolumna && rzad < gp.max_szereg){

            int NumerPola= MapaNumerPola[gp.aktualnaMapa][kolumna][rzad];

            g2.drawImage(pole[NumerPola].image, x , y , gp.rozmiar_pola, gp.rozmiar_pola, null);

            kolumna++;
            x += gp.rozmiar_pola;

            if(kolumna == gp.max_kolumna){
                kolumna =0;
                x =0;
                rzad++;
                y += gp.rozmiar_pola;

            }
        }

    }
}
