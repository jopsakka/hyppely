

package jopi.hyppely.jutskat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import jopi.hyppely.main.GamePanel;


public class Pelaaja extends Rectangle{
    private static final long serialVersionUID = 1L;
    
    private boolean oikea = false, vasen = false, ylos = false, alas = false;
    
    private int width, height;
    
    private float x, y;
    private float xSpeed, ySpeed, maxSpeed, maxAcceleration;
    
    private float acceleration;
    private float kitka;
    
    public Pelaaja(int width, int height) {
        x = GamePanel.WIDTH / 2;
        y = GamePanel.HEIGHT / 2;
        xSpeed = 0;
        ySpeed = 0;
        maxSpeed = 100;
        kitka = (float) 0.05;
        acceleration = (float) 0.1;
        this.width = width;
        this.height = height;
    }
    
    public void tick() {
        if(vasen) {
            xSpeed -= acceleration; 
        }
        if(oikea) {
            xSpeed += acceleration;
        }
        if(ylos) {
            ySpeed -= acceleration;
        }
        if (alas) {
            ySpeed += acceleration;
        }
        if ((!vasen && !oikea) && (!ylos && !alas)) {
            ySpeed = ySpeed - (ySpeed * kitka);
            xSpeed = xSpeed - (xSpeed * kitka);
        }
        x += xSpeed;
        y += ySpeed;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(Math.round(x), Math.round(y), width, height);
        //g.fillRect(Math.round(x), Math.round(y), width, height);
    }
    
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_LEFT) {
            vasen = true;
        }
        if (k == KeyEvent.VK_RIGHT) {
            oikea = true;
        }
        if (k == KeyEvent.VK_UP) {
            ylos = true;
        }   
        if (k == KeyEvent.VK_DOWN) {
            alas = true;
        }
    }
    
    public void keyReleased(int k) {
        if (k == KeyEvent.VK_LEFT) {
            vasen = false;
        }
        if (k == KeyEvent.VK_RIGHT) {
            oikea = false;
        }
        if (k == KeyEvent.VK_UP) {
            ylos = false;
        }   
        if (k == KeyEvent.VK_DOWN) {
            alas = false;
        }
    }
}
