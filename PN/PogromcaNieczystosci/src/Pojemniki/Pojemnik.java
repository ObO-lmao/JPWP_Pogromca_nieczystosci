package Pojemniki;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pojemnik {

    public BufferedImage image;
    public String nazwa;
    public boolean kolizja = false;
    public int x, y;
    public Rectangle Pole_kolizji = new Rectangle(0,0,48,48);
    public int Pole_kolizji_X_domyslny = 0;
    public int Pole_kolizji_Y_domyslny = 0;


    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, x , y , gp.rozmiar_pola, gp.rozmiar_pola, null);

    }
}
