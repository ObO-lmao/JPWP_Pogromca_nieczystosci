package Main;

import Pojemniki.Pojemnik;
import Rzeczy.Smieciarka;
import pole.AdminPola;

import javax.swing.JPanel;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {

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
    public Pojemnik Poj[]= new Pojemnik[10];

    public int StanGry;
    public final int StanMenu = 0;
    public final int StanGranie = 1;
    public final int StanPauza = 2;
    public final int StanInstrukcja = 3;
    public final int StanPorażkaPomieszanie = 4;
    public final int StanPorażkaCzas = 5;
    public int licznikKlatek = 0;
    public final int RESETlicznik = 3600;
    public int liczba_pojemników_1 = 0;




    public GamePanel () {

        this.setPreferredSize(new Dimension(szerokosc, dlugosc));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }
    public void incLicznikKlatek(){
        licznikKlatek++;
    }

    public void Ustawienie_gry() {
        
        Mieczysław.Ustaw_Pojemnik();
        StanGry = StanMenu;
    }
    public void startGameThread() {

        gameThread= new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

            double czas_aktualizacji_ekranu = 1000000000/FPS;
            double nastepna_aktualizacja_ekranu= System.nanoTime() + czas_aktualizacji_ekranu;

            while(gameThread != null) {

                update();

                repaint();



                try {
                    double pozostaly_czas= nastepna_aktualizacja_ekranu - System.nanoTime();
                    pozostaly_czas = pozostaly_czas/1000000;

                    if(pozostaly_czas < 0 ) {
                        pozostaly_czas = 0;
                    }

                    Thread.sleep((long) pozostaly_czas);

                    nastepna_aktualizacja_ekranu += czas_aktualizacji_ekranu;

                    incLicznikKlatek();

                    if (licznikKlatek >= RESETlicznik){
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
        if (StanGry == StanPauza) {

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

            for (int i = 0; i <  Poj.length; i++){
                if (Poj[i] != null) {
                    Poj[i].draw(g2,this);
                }
            }
            smieciarka.draw(g2);

            ui.draw(g2);


        }
        else if (StanGry == StanInstrukcja){
            ui.draw(g2);
        }




        g2.dispose();
    }

}
