package Main;

import Pojemniki.Pojemnik_papier;
import Pojemniki.Pojemnik_plastik;
import Pojemniki.Pojemnik_szkło;

public class Rozmieszczacz_pojemnikow {

    GamePanel gp;

    public Rozmieszczacz_pojemnikow(GamePanel gp){
        this.gp = gp;
    }

    public void Ustaw_Pojemnik(){

        gp.Poj[0] = new Pojemnik_papier();
        gp.Poj[0].x = 13 * gp.rozmiar_pola;
        gp.Poj[0].y = 9 * gp.rozmiar_pola;

        gp.Poj[1] = new Pojemnik_papier();
        gp.Poj[1].x = 15 * gp.rozmiar_pola;
        gp.Poj[1].y = 11 * gp.rozmiar_pola;

        gp.Poj[2] = new Pojemnik_szkło();
        gp.Poj[2].x = 16 * gp.rozmiar_pola;
        gp.Poj[2].y = 11 * gp.rozmiar_pola;

        gp.Poj[3] = new Pojemnik_plastik();
        gp.Poj[3].x = 17 * gp.rozmiar_pola;
        gp.Poj[3].y = 11 * gp.rozmiar_pola;

    }

}
