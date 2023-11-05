package Rzeczy;

import Main.GamePanel;
import Main.Klawiatura;

import java.awt.*;

public class Smieciarka extends Rzecz {

    GamePanel gp;
    Klawiatura keyH;


    public Smieciarka(GamePanel gp, Klawiatura keyH) {

        this.gp = gp;
        this.keyH= keyH;
        Parametry_podstawowe();
    }
    public void Parametry_podstawowe(){

        x = 100;
        y = 100;
        szybkosc = 4;
    }
    public void update() {

        if(keyH.W_pressed == true) {
            y -= szybkosc;
        }
        else if(keyH.S_pressed == true){
            y += szybkosc;
        }
        else if(keyH.A_pressed == true){
            x -= szybkosc;
        }
        else if(keyH.D_pressed == true){
            x += szybkosc;
        }
    }
    public void draw(Graphics2D g2) {

        g2.setColor(Color.white);

        g2.fillRect(x, y, gp.rozmiar_pola, gp.rozmiar_pola);
    }
}
