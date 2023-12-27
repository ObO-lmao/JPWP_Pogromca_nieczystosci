package Main;

import Pojemniki.Pojemnik_mieszane;
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
        gp.Poj[1][0].x = 15 * gp.rozmiar_pola;
        gp.Poj[1][0].y = 1 * gp.rozmiar_pola;

        gp.Poj[1][1] = new Pojemnik_papier();
        gp.Poj[1][1].x = 15 * gp.rozmiar_pola;
        gp.Poj[1][1].y = 10 * gp.rozmiar_pola;

        gp.Poj[1][2] = new Pojemnik_szkło();
        gp.Poj[1][2].x = 17 * gp.rozmiar_pola;
        gp.Poj[1][2].y = 1 * gp.rozmiar_pola;

        gp.Poj[1][3] = new Pojemnik_plastik();
        gp.Poj[1][3].x = 17 * gp.rozmiar_pola;
        gp.Poj[1][3].y = 14 * gp.rozmiar_pola;

        gp.Poj[1][4] = new Pojemnik_papier();
        gp.Poj[1][4].x = 14 * gp.rozmiar_pola;
        gp.Poj[1][4].y = 10 * gp.rozmiar_pola;

        gp.Poj[1][5] = new Pojemnik_mieszane();
        gp.Poj[1][5].x = 17 * gp.rozmiar_pola;
        gp.Poj[1][5].y = 12 * gp.rozmiar_pola;

        gp.Poj[1][6] = new Pojemnik_szkło();
        gp.Poj[1][6].x = 17 * gp.rozmiar_pola;
        gp.Poj[1][6].y = 9 * gp.rozmiar_pola;

        gp.Poj[1][7] = new Pojemnik_szkło();
        gp.Poj[1][7].x = 9 * gp.rozmiar_pola;
        gp.Poj[1][7].y = 3 * gp.rozmiar_pola;

        gp.Poj[1][8] = new Pojemnik_mieszane();
        gp.Poj[1][8].x = 8 * gp.rozmiar_pola;
        gp.Poj[1][8].y = 10 * gp.rozmiar_pola;

        gp.Poj[1][9] = new Pojemnik_mieszane();
        gp.Poj[1][9].x = 2 * gp.rozmiar_pola;
        gp.Poj[1][9].y = 10 * gp.rozmiar_pola;

        gp.Poj[1][10] = new Pojemnik_mieszane();
        gp.Poj[1][10].x = 2 * gp.rozmiar_pola;
        gp.Poj[1][10].y = 3 * gp.rozmiar_pola;

        gp.Poj[1][11] = new Pojemnik_plastik();
        gp.Poj[1][11].x = 2 * gp.rozmiar_pola;
        gp.Poj[1][11].y = 1 * gp.rozmiar_pola;

        gp.Poj[1][12] = new Pojemnik_plastik();
        gp.Poj[1][12].x = 4 * gp.rozmiar_pola;
        gp.Poj[1][12].y = 7 * gp.rozmiar_pola;

        gp.Poj[1][13] = new Pojemnik_plastik();
        gp.Poj[1][13].x = 4 * gp.rozmiar_pola;
        gp.Poj[1][13].y = 14 * gp.rozmiar_pola;

        gp.Poj[2][0] = new Pojemnik_plastik();
        gp.Poj[2][0].x = 4 * gp.rozmiar_pola;
        gp.Poj[2][0].y = 14 * gp.rozmiar_pola;

        gp.Poj[2][1] = new Pojemnik_plastik();
        gp.Poj[2][1].x = 1 * gp.rozmiar_pola;
        gp.Poj[2][1].y = 1 * gp.rozmiar_pola;

        gp.Poj[2][2] = new Pojemnik_plastik();
        gp.Poj[2][2].x = 8 * gp.rozmiar_pola;
        gp.Poj[2][2].y = 13 * gp.rozmiar_pola;

        gp.Poj[2][3] = new Pojemnik_plastik();
        gp.Poj[2][3].x = 14 * gp.rozmiar_pola;
        gp.Poj[2][3].y = 4 * gp.rozmiar_pola;

        gp.Poj[2][4] = new Pojemnik_plastik();
        gp.Poj[2][4].x = 15 * gp.rozmiar_pola;
        gp.Poj[2][4].y = 7 * gp.rozmiar_pola;

        gp.Poj[2][5] = new Pojemnik_szkło();
        gp.Poj[2][5].x = 1 * gp.rozmiar_pola;
        gp.Poj[2][5].y = 7 * gp.rozmiar_pola;

        gp.Poj[2][6] = new Pojemnik_szkło();
        gp.Poj[2][6].x = 2 * gp.rozmiar_pola;
        gp.Poj[2][6].y = 12 * gp.rozmiar_pola;

        gp.Poj[2][7] = new Pojemnik_papier();
        gp.Poj[2][7].x = 4 * gp.rozmiar_pola;
        gp.Poj[2][7].y = 7 * gp.rozmiar_pola;

        gp.Poj[2][8] = new Pojemnik_papier();
        gp.Poj[2][8].x = 18 * gp.rozmiar_pola;
        gp.Poj[2][8].y = 1 * gp.rozmiar_pola;

        gp.Poj[2][9] = new Pojemnik_szkło();
        gp.Poj[2][9].x = 11 * gp.rozmiar_pola;
        gp.Poj[2][9].y = 9 * gp.rozmiar_pola;

        gp.Poj[2][10] = new Pojemnik_szkło();
        gp.Poj[2][10].x = 11 * gp.rozmiar_pola;
        gp.Poj[2][10].y = 14 * gp.rozmiar_pola;

        gp.Poj[2][11] = new Pojemnik_mieszane();
        gp.Poj[2][11].x = 5 * gp.rozmiar_pola;
        gp.Poj[2][11].y = 4 * gp.rozmiar_pola;

        gp.Poj[2][12] = new Pojemnik_mieszane();
        gp.Poj[2][12].x = 8 * gp.rozmiar_pola;
        gp.Poj[2][12].y = 9 * gp.rozmiar_pola;

        gp.Poj[2][12] = new Pojemnik_mieszane();
        gp.Poj[2][12].x = 18 * gp.rozmiar_pola;
        gp.Poj[2][12].y = 12 * gp.rozmiar_pola;

        gp.Poj[3][0] = new Pojemnik_plastik();
        gp.Poj[3][0].x = 4 * gp.rozmiar_pola;
        gp.Poj[3][0].y = 14 * gp.rozmiar_pola;

        gp.Poj[3][1] = new Pojemnik_szkło();
        gp.Poj[3][1].x = 4 * gp.rozmiar_pola;
        gp.Poj[3][1].y = 10 * gp.rozmiar_pola;

        gp.Poj[3][2] = new Pojemnik_papier();
        gp.Poj[3][2].x = 4 * gp.rozmiar_pola;
        gp.Poj[3][2].y = 6 * gp.rozmiar_pola;

        gp.Poj[3][3] = new Pojemnik_mieszane();
        gp.Poj[3][3].x = 4 * gp.rozmiar_pola;
        gp.Poj[3][3].y = 2 * gp.rozmiar_pola;

        gp.Poj[3][4] = new Pojemnik_mieszane();
        gp.Poj[3][4].x = 5 * gp.rozmiar_pola;
        gp.Poj[3][4].y = 12 * gp.rozmiar_pola;

        gp.Poj[3][5] = new Pojemnik_mieszane();
        gp.Poj[3][5].x = 17 * gp.rozmiar_pola;
        gp.Poj[3][5].y = 14 * gp.rozmiar_pola;

        gp.Poj[3][6] = new Pojemnik_plastik();
        gp.Poj[3][6].x = 6 * gp.rozmiar_pola;
        gp.Poj[3][6].y = 14 * gp.rozmiar_pola;

        gp.Poj[3][7] = new Pojemnik_szkło();
        gp.Poj[3][7].x = 9 * gp.rozmiar_pola;
        gp.Poj[3][7].y = 14 * gp.rozmiar_pola;

        gp.Poj[3][8] = new Pojemnik_szkło();
        gp.Poj[3][8].x = 11 * gp.rozmiar_pola;
        gp.Poj[3][8].y = 14 * gp.rozmiar_pola;

        gp.Poj[3][9] = new Pojemnik_papier();
        gp.Poj[3][9].x = 13 * gp.rozmiar_pola;
        gp.Poj[3][9].y = 14 * gp.rozmiar_pola;

        gp.Poj[3][10] = new Pojemnik_papier();
        gp.Poj[3][10].x = 15 * gp.rozmiar_pola;
        gp.Poj[3][10].y = 14 * gp.rozmiar_pola;

        gp.Poj[3][11] = new Pojemnik_papier();
        gp.Poj[3][11].x = 10 * gp.rozmiar_pola;
        gp.Poj[3][11].y = 12 * gp.rozmiar_pola;

        gp.Poj[3][12] = new Pojemnik_papier();
        gp.Poj[3][12].x = 14 * gp.rozmiar_pola;
        gp.Poj[3][12].y = 12 * gp.rozmiar_pola;

        gp.Poj[3][13] = new Pojemnik_papier();
        gp.Poj[3][13].x = 8 * gp.rozmiar_pola;
        gp.Poj[3][13].y = 8 * gp.rozmiar_pola;

        gp.Poj[3][14] = new Pojemnik_papier();
        gp.Poj[3][14].x = 13 * gp.rozmiar_pola;
        gp.Poj[3][14].y = 8 * gp.rozmiar_pola;

        gp.Poj[3][15] = new Pojemnik_szkło();
        gp.Poj[3][15].x = 8 * gp.rozmiar_pola;
        gp.Poj[3][15].y = 6 * gp.rozmiar_pola;

        gp.Poj[3][16] = new Pojemnik_szkło();
        gp.Poj[3][16].x = 13 * gp.rozmiar_pola;
        gp.Poj[3][16].y = 6 * gp.rozmiar_pola;

        gp.Poj[3][17] = new Pojemnik_plastik();
        gp.Poj[3][17].x = 12 * gp.rozmiar_pola;
        gp.Poj[3][17].y = 2 * gp.rozmiar_pola;

        gp.Poj[3][18] = new Pojemnik_plastik();
        gp.Poj[3][18].x = 17 * gp.rozmiar_pola;
        gp.Poj[3][18].y = 1 * gp.rozmiar_pola;












    }

}
