
package jopi.hyppely.pelitilat;

import java.awt.Graphics;
import jopi.hyppely.jutskat.Pelaaja;


public class Taso1 extends PeliTila{
    
    private Pelaaja pelaaja;

    public Taso1(PeliTilaHallinta pth) {
        super(pth);
    }

    
    public void init() {
        pelaaja = new Pelaaja(30, 30);
    }

    
    public void tick() {
        pelaaja.tick();
    }

    
    public void draw(Graphics g) {
        pelaaja.draw(g);
    }

    
    public void keyPressed(int k) {
        pelaaja.keyPressed(k);
    }

    
    public void keyReleased(int k) {
        pelaaja.keyReleased(k);
    }
    
}
