
package jopi.hyppely.pelitilat;

import java.awt.Graphics;


public abstract class PeliTila {
    public PeliTilaHallinta pth;
    
    public PeliTila(PeliTilaHallinta pth ) {
        this.pth = pth;
    }
    
    public abstract void init();
    public abstract void tick();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);
}
