package Rzeczy;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Rzecz {

    public static int x;
    public int y;
    public static int szybkosc;

    public BufferedImage W,S,A,D;
    public static String kierunek;
    public static Rectangle Pole_kolizji;
    public static int Pole_kolizji_X_domyslny;
    public int Pole_kolizji_Y_domyslny;
    public static boolean kolizja_działa = false;



}
