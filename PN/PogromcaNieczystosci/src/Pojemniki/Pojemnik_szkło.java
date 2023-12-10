package Pojemniki;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Pojemnik_szkło extends Pojemnik {

    public Pojemnik_szkło() {
        nazwa = "szklo";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Pojemniki/szklo.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
        kolizja = true;
    }
}
