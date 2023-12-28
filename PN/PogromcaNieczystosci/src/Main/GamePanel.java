package Main;

import Pojemniki.Pojemnik;
import Rzeczy.Smieciarka;
import pole.AdminPola;

import javax.swing.JPanel;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {

    /**
     *
     */




    // USTAWIENIA POLA GRAFICZNEGO
    final int org_rozmiar_pola = 16; // 16x16
    final int skalowanie = 3;

    public final int rozmiar_pola = org_rozmiar_pola * skalowanie; // 48x48
    public final int max_kolumna = 20;
    public final int max_szereg = 16;
    final int szerokosc = rozmiar_pola * max_kolumna; // 960px
    final int dlugosc = rozmiar_pola * max_szereg; // 768px

    int FPS = 60;
    AdminPola AdminP = new AdminPola(this);
    Klawiatura keyH = new Klawiatura(this);
    public UI ui = new UI(this);
    Thread gameThread;
    public Kontroler_kolizji kontroler = new Kontroler_kolizji(this);
    public Rozmieszczacz_pojemnikow Mieczysław = new Rozmieszczacz_pojemnikow(this);
    Smieciarka smieciarka = new Smieciarka(this, keyH);


    public int StanGry;
    public int StanMenu = 0;
    public final int StanGranie = 1;
    public final int StanPauza = 2;
    public final int StanInstrukcja = 3;
    public final int StanPorażkaPomieszanie = 4;
    public final int StanPorażkaCzas = 5;
    public final int StanKoniec = 6;
    public int licznikKlatek = 0;
    public final int RESETlicznik = 3600;
    public final int maxMapy = 10;
    public int aktualnaMapa = 0;
    public Pojemnik Poj[][]= new Pojemnik[maxMapy][20];
    public static int próg_poziomu =4;




    public GamePanel () {

        this.setPreferredSize(new Dimension(szerokosc, dlugosc));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }
    public void incLicznikKlatek(){
        licznikKlatek++;
    } // licznik stosowany do odliczania czas na danym poziomie

    public int ilezebrać(int który_poziom){             // wyznacznenie ilości śmieci na danym poziomie
        int prog = 0;
        for (int i = 0; i < Poj[który_poziom].length ; i++){
            if (Poj[który_poziom][i] != null){
                prog++;
            }
        }
        return prog;

    }

    public void czy_kolejny_poziom(int próg){ // sprawdzenie czy zebrano wszystkie śmieci z poziomu


        if (Smieciarka.ile_zebrano == próg){
            System.out.println("spełniono");
            kolejny_poziom();
        }

    }
    public void kolejny_poziom(){            // przejście na kolejny poziom wraz z resetowaniem pozycji śmieciarki, jej atrybutów oraz czasu
        Smieciarka.ustawieniaFabryczne();
        aktualnaMapa ++;

        switch (aktualnaMapa) {
            case 0:
                AdminP.LadujMape("Mapy/mapa1.txt", 0);
                System.out.println(aktualnaMapa);
                ui.resetCzasu();
                Smieciarka.pojemnosc = Smieciarka.pojemnosc_default;
                próg_poziomu = ilezebrać(aktualnaMapa);
                System.out.println(próg_poziomu);

                break;
            case 1:
                AdminP.LadujMape("Mapy/mapa2.txt", 1);
                System.out.println(aktualnaMapa);
                ui.resetCzasu();
                próg_poziomu = ilezebrać(aktualnaMapa);
                Smieciarka.pojemnosc = 4;

                break;
            case 2:
                AdminP.LadujMape("Mapy/mapa3.txt", 2);
                ui.resetCzasu();
                Smieciarka.pojemnosc = Smieciarka.pojemnosc_default;
                System.out.println(aktualnaMapa);
                próg_poziomu = ilezebrać(aktualnaMapa);
                break;
            case 3:
                AdminP.LadujMape("Mapy/mapa4.txt", 3);
                ui.resetCzasu();
                Smieciarka.pojemnosc = 4;
                System.out.println(aktualnaMapa);
                próg_poziomu = ilezebrać(aktualnaMapa);
                break;
            case 4:
                StanGry = StanKoniec;
                Smieciarka.pojemnosc = Smieciarka.pojemnosc_default;
                break;

        }
    }

    public void Ustawienie_gry() {
        

        StanGry = StanMenu;
    }
    public void startGameThread() {

        gameThread= new Thread(this);
        gameThread.start();
    }
    public void spróbuj_ponownie(){

        Smieciarka.ustawieniaFabryczne();
        ui.resetCzasu();
        Mieczysław.Ustaw_Pojemnik();

    }

    @Override
    public void run() {                  // wprawienie gry w ruch poprzez aktualizację tego, co dzieje się na ekranie

            double czas_aktualizacji_ekranu = 1000000000/FPS;
            double nastepna_aktualizacja_ekranu= System.nanoTime() + czas_aktualizacji_ekranu;

            while(gameThread != null) {

                update();

                repaint();



                try {                                      // aktualizowanie ekranu 60 razy na sekundę
                    double pozostaly_czas= nastepna_aktualizacja_ekranu - System.nanoTime();
                    pozostaly_czas = pozostaly_czas/1000000;

                    if(pozostaly_czas < 0 ) {
                        pozostaly_czas = 0;
                    }

                    Thread.sleep((long) pozostaly_czas);

                    nastepna_aktualizacja_ekranu += czas_aktualizacji_ekranu;

                    incLicznikKlatek();

                    if (licznikKlatek >= RESETlicznik){   // resetowanie licznika klatek używanego do odliczania w dół na danym poziomie
                        licznikKlatek =0;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
    public void update() {
        if (StanGry == StanGranie) {
            smieciarka.update();
        }
        if (StanGry == StanPauza) {   // zatrzymanie gry w trakcie pauzy

        }

    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        if (StanGry == StanMenu){
            ui.draw(g2);

        }
        else if (StanGry != StanInstrukcja){
            AdminP.draw(g2);

            for (int i = 0; i <  Poj[1].length; i++){ // ciągłe rysowanie ekranu na każdej klatce, dające efekt tła
                if (Poj[aktualnaMapa][i] != null) {
                    Poj[aktualnaMapa][i].draw(g2,this);
                }
            }
            smieciarka.draw(g2);   // rysowanie śmieciarki z aktualizacją pozycji z częstotliwością 60 klatek na sekundę

            ui.draw(g2);


        }
        else if (StanGry == StanInstrukcja){
            ui.draw(g2);
        }




        g2.dispose();
    }

}
