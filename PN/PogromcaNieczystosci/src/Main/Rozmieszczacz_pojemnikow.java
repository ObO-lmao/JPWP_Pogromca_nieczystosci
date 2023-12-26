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

        gp.Poj[0][0] = new Pojemnik_papier();
        gp.Poj[0][0].x = 1 * gp.rozmiar_pola;
        gp.Poj[0][0].y = 12 * gp.rozmiar_pola;

        gp.Poj[0][1] = new Pojemnik_papier();
        gp.Poj[0][1].x = 2 * gp.rozmiar_pola;
        gp.Poj[0][1].y = 1 * gp.rozmiar_pola;

        gp.Poj[0][2] = new Pojemnik_szkło();
        gp.Poj[0][2].x = 17 * gp.rozmiar_pola;
        gp.Poj[0][2].y = 1 * gp.rozmiar_pola;

        gp.Poj[0][3] = new Pojemnik_plastik();
        gp.Poj[0][3].x = 17 * gp.rozmiar_pola;
        gp.Poj[0][3].y = 14 * gp.rozmiar_pola;

        gp.Poj[1][0] = new Pojemnik_papier();
        gp.Poj[1][0].x = 13 * gp.rozmiar_pola;
        gp.Poj[1][0].y = 5 * gp.rozmiar_pola;

        gp.Poj[1][1] = new Pojemnik_papier();
        gp.Poj[1][1].x = 15 * gp.rozmiar_pola;
        gp.Poj[1][1].y = 12 * gp.rozmiar_pola;

        gp.Poj[1][2] = new Pojemnik_szkło();
        gp.Poj[1][2].x = 16 * gp.rozmiar_pola;
        gp.Poj[1][2].y = 13 * gp.rozmiar_pola;

        gp.Poj[1][3] = new Pojemnik_plastik();
        gp.Poj[1][3].x = 17 * gp.rozmiar_pola;
        gp.Poj[1][3].y = 14 * gp.rozmiar_pola;


    }

}
