package Pojemniki;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Pojemnik_mieszane extends Pojemnik {

    public Pojemnik_mieszane() {
        nazwa = "mieszane";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Pojemniki/mieszane.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
        kolizja = true;
    }
}