/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triangulo;

/**
 *
 * @author Andres
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Triangulo extends JFrame {

    private int[] xPoints = new int[3];
    private int[] yPoints = new int[3];
    private int contador = 0;

    public Triangulo() {
        setTitle("Dibujar Triángulo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarTriangulo(g);
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (contador < 3) {
                    xPoints[contador] = e.getX();
                    yPoints[contador] = e.getY();
                    contador++;
                    panel.repaint();
                }
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (contador < 3) {
                    xPoints[contador] = e.getX();
                    yPoints[contador] = e.getY();
                    panel.repaint();
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    private void dibujarTriangulo(Graphics g) {
        if (contador == 3) {
            g.setColor(Color.BLUE);
            g.fillPolygon(xPoints, yPoints, 3);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Triangulo::new);
    }
}




