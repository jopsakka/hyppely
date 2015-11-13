/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jopi.hyppely.main;

import jopi.hyppely.pelitilat.PeliTilaHallinta;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable, KeyListener{
    private static final long serialVersionUID = 1L;
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    private Thread thread;
    private Boolean isRunning;
    
    private int FPS = 60;
    private long targetTime = 1000 / FPS;
    
    private PeliTilaHallinta pth;
    
    
    public GamePanel() {
        addKeyListener(this);
        setFocusable(true);
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        start();
    }
    
    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        long start, elapsed, wait;
        
        pth = new PeliTilaHallinta();
        while(isRunning) {
            start = System.nanoTime();
            tick();
            repaint();
            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            
            if (wait <= 0) {
                wait = 5;
            }
            
            try {
                Thread.sleep(wait);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void tick() {
        pth.tick();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, WIDTH, HEIGHT);
        pth.draw(g);
    }

    public void keyTyped(KeyEvent e) {
        
    }


    public void keyPressed(KeyEvent e) {
        pth.keyPressed(e.getKeyCode());
    }
    public void keyReleased(KeyEvent e) {
        pth.KeyReleased(e.getKeyCode());
    }
}
