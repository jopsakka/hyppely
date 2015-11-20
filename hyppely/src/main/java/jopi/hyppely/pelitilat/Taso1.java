
package jopi.hyppely.pelitilat;

import java.awt.Graphics;
import jopi.hyppely.jutskat.Este;
import jopi.hyppely.jutskat.Pelaaja;
import jopi.hyppely.jutskat.Tormays;


public class Taso1 extends PeliTila{
    
    private Pelaaja pelaaja;
    private Este este;
    

    public Taso1(PeliTilaHallinta pth) {
        super(pth);
    }

    
    public void init() {
        pelaaja = new Pelaaja(100, 30);
        este = new Este(400, 100, 0, 0);
    }

    
    public void tick() {
        pelaaja.tick();
        este.tick();
        
        if(Tormays.tormaako(pelaaja, este)) {
            Tormays.tormays(pelaaja, este);
        }
        
    }

    
    public void draw(Graphics g) {
        pelaaja.draw(g);
        este.draw(g);
    }

    
    public void keyPressed(int k) {
        pelaaja.keyPressed(k);
    }

    
    public void keyReleased(int k) {
        pelaaja.keyReleased(k);
    }
    
}
