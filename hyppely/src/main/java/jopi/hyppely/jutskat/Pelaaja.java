

package jopi.hyppely.jutskat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import jopi.hyppely.main.GamePanel;


public class Pelaaja{
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
        maxSpeed = 30;
        kitka = (float) 0.1;
        acceleration = (float) 2;
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
        //if ((!vasen && !oikea) && (!ylos && !alas)) {
            ySpeed = ySpeed - (ySpeed * kitka);
            xSpeed = xSpeed - (xSpeed * kitka);
        //}
        if (xSpeed > maxSpeed) {
            xSpeed = maxSpeed;
        } if (xSpeed < (maxSpeed * -1)) {
            xSpeed = maxSpeed * -1;
        } if (ySpeed > maxSpeed) {
            ySpeed = maxSpeed;
        } if (ySpeed < maxSpeed * -1) {
            ySpeed = maxSpeed * -1;
        }
        x += xSpeed;
        y += ySpeed;
        if (x < 0) {
            x = 0;
            xSpeed = xSpeed * -1;
        } if ( x > GamePanel.WIDTH - width) {
            x = GamePanel.WIDTH - width;
            xSpeed = xSpeed * -1;
        } if (y < 0) {
            y = 0;
            ySpeed = ySpeed * -1;
        } if (y > GamePanel.HEIGHT - height) {
            y = GamePanel.HEIGHT - height;
            ySpeed = ySpeed * -1;
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(Math.round(x), Math.round(y), width, height);
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
    public int getX() {
        return Math.round(x);
    }
    public int getY() {
        return Math.round(y);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    
   
}
