
package jopi.hyppely.jutskat;



public class Tormays {
    
    public Tormays() {
    }
    public static boolean tormaako(Pelaaja pelaaja, Este este) {
        int xSama = pelaaja.getX() - este.getX();
        int ySama = pelaaja.getY() - este.getY();
        if (Math.abs(xSama) < Math.max(pelaaja.getWidth(), este.getWidth()) + 1 && Math.abs(ySama) < Math.max(pelaaja.getHeight(), este.getHeight() + 1)) {
            return true;
        } else {
            return false;
        }
    }
    public static void tormays(Pelaaja pelaaja, Este este) {
        este.setxSpeed(este.getxSpeed() + pelaaja.getxSpeed());
        este.setySpeed(-1 * este.getySpeed() + pelaaja.getySpeed());
        este.setY(pelaaja.getY() - este.getHeight());
    }
}
