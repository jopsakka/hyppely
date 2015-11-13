/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jopi.hyppely.pelitilat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import jopi.hyppely.main.GamePanel;


public class Menu extends PeliTila{
    
    private String[] valikko = {"Aloita peli", "Poistu"};
    private int current = 0;

    public Menu(PeliTilaHallinta pth) {
        super(pth);
    }


    public void init() {
        
    }


    public void tick() {
        
    }

   
    public void draw(Graphics g) {
        for (int i = 0; i < valikko.length; i++) {
            if (i == current) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.black);
            }
            g.drawString(valikko[i], GamePanel.WIDTH/2, GamePanel.HEIGHT/3 + i * 100);
            
        }
    }

    
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_DOWN) {
            if (current < valikko.length - 1) {
                current++;
            }
        } else if (k == KeyEvent.VK_UP) {
            if (current > 0) {
                current--;
            }
        } else if (k == KeyEvent.VK_ENTER) {
            if (valikko[current].equals("Aloita peli")) {
                pth.tilat.push(new Taso1(pth));
                pth.tilat.peek().init();
            } else if (valikko[current].equals("Poistu")) {
                System.exit(0);
            }
        }
    }

    
    public void keyReleased(int k) {
        
    }
    
}
