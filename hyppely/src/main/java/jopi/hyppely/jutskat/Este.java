
package jopi.hyppely.jutskat;

import java.awt.Color;
import java.awt.Graphics;
import jopi.hyppely.main.GamePanel;


public class Este {
    private int width = 30;
    private int height = 30;
   
    private float x;
    private float y;
    
    private float xSpeed;
    private float ySpeed;
    
    private float painovoima = (float) 0.5;
    private float vastus = (float) 0.03;
    
    public Este(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public void tick() {
        ySpeed += painovoima;
        ySpeed = ySpeed - (ySpeed * vastus);
        xSpeed = xSpeed - (xSpeed * vastus);
        x += xSpeed;
        y += ySpeed;
        if (x < 0) {
            x = 0;
            xSpeed = xSpeed * -1;
        } if (x > GamePanel.WIDTH - width) {
            x = GamePanel.WIDTH - width;
            xSpeed = xSpeed * -1;
        } if (y < 0) {
            y = 0;
            ySpeed = ySpeed * -1;
        } if (y > GamePanel.HEIGHT- height) {
            y = GamePanel.HEIGHT - height;
            ySpeed = ySpeed * -1;
        }
    }
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(Math.round(x), Math.round(y), width, height);
    }
    public int getX() {
        return Math.round(x);
    }
    public int getY() {
        return Math.round(y);
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    
}
