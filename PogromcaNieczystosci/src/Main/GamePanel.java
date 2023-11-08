package Main;

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
    Klawiatura keyH = new Klawiatura();
    Thread gameThread;
    Smieciarka smieciarka = new Smieciarka(this, keyH);


    public GamePanel () {

        this.setPreferredSize(new Dimension(szerokosc, dlugosc));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

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

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
    public void update() {

        smieciarka.update();

    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        AdminP.draw(g2);

        smieciarka.draw(g2);

        g2.dispose();
    }
}
