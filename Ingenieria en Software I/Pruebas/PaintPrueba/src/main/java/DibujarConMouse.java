/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DibujarConMouse extends JFrame {
    private int xAnterior, yAnterior;
    private boolean dibujando;

    public DibujarConMouse() {
        setTitle("Dibujar con el Mouse");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar un panel de dibujo personalizado
        PanelDibujo panel = new PanelDibujo();
        add(panel);

        // Manejar eventos del mouse
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xAnterior = e.getX();
                yAnterior = e.getY();
                dibujando = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dibujando = false;
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dibujando) {
                    panel.dibujarLinea(xAnterior, yAnterior, e.getX(), e.getY());
                    xAnterior = e.getX();
                    yAnterior = e.getY();
                }
            }
        });
    }

    private class PanelDibujo extends JPanel {
        private void dibujarLinea(int x1, int y1, int x2, int y2) {
            Graphics g = getGraphics();
            g.drawLine(x1, y1, x2, y2);
            g.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DibujarConMouse ventana = new DibujarConMouse();
            ventana.setVisible(true);
        });
    }
}*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DibujarConMouse extends JFrame {
    private int xAnterior, yAnterior;

    public DibujarConMouse() {
        setTitle("Dibujar con el Mouse");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar un panel de dibujo personalizado
        PanelDibujo panel = new PanelDibujo();
        add(panel);

        // Manejar eventos del mouse
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xAnterior = e.getX();
                yAnterior = e.getY();
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                panel.dibujarLinea(xAnterior, yAnterior, e.getX(), e.getY());
                xAnterior = e.getX();
                yAnterior = e.getY();
            }
        });
    }

    private class PanelDibujo extends JPanel {
        private void dibujarLinea(int x1, int y1, int x2, int y2) {
            Graphics g = getGraphics();
            g.drawLine(x1, y1, x2, y2);
            g.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DibujarConMouse ventana = new DibujarConMouse();
            ventana.setVisible(true);
        });
    }
}

