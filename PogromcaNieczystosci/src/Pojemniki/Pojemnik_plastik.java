package Pojemniki;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Pojemnik_plastik extends Pojemnik{

    public Pojemnik_plastik() {
        nazwa = "plastik";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Pojemniki/plastik.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
