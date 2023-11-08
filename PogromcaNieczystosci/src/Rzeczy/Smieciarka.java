package Rzeczy;

import Main.GamePanel;
import Main.Klawiatura;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Smieciarka extends Rzecz {

    GamePanel gp;
    Klawiatura keyH;


    public Smieciarka(GamePanel gp, Klawiatura keyH) {

        this.gp = gp;
        this.keyH= keyH;
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
            y -= szybkosc;
        }
        else if(keyH.S_pressed == true){
            kierunek = "dół";
            y += szybkosc;
        }
        else if(keyH.A_pressed == true){
            kierunek = "lewo";
            x -= szybkosc;
        }
        else if(keyH.D_pressed == true){
            kierunek = "prawo";
            x += szybkosc;
        }
    }
    public void draw(Graphics2D g2) {

        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.rozmiar_pola, gp.rozmiar_pola);

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
