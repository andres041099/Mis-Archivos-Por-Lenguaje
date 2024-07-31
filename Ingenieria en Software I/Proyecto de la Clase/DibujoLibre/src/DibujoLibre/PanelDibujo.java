/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DibujoLibre;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class PanelDibujo extends JPanel{
    
    private int CoordenaX, CoordenadaY;
    
     public PanelDibujo() {
        this.setBackground(Color.black);
        
        MouseAdapter ev = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                CoordenaX = e.getX();
                CoordenadaY = e.getY();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                dibujarLinea(CoordenaX, CoordenadaY, e.getX(), e.getY());
                CoordenaX = e.getX();
                CoordenadaY = e.getY();  
            }
        };

        addMouseListener(ev);
        addMouseMotionListener(ev);
    }
    private void dibujarLinea(int x1, int y1, int x2, int y2) {
        Graphics g = getGraphics();
        g.setColor(Color.RED);
        g.drawLine(x1, y1, x2, y2);
        g.dispose();
    }
    
@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawLine(10,10, 100,200);
    }    
}
