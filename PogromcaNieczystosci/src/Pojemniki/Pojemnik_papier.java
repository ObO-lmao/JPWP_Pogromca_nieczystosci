package Pojemniki;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Pojemnik_papier extends Pojemnik {

    public Pojemnik_papier() {
        nazwa = "papier";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Pojemniki/papier.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
        kolizja = true;
    }
}

