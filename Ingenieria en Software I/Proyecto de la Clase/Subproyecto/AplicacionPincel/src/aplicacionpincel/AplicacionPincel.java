/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacionpincel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class AplicacionPincel extends JFrame{
     public int CoordenaX, CoordenadaY;
     private boolean botonPresionado = false;
    public  AplicacionPincel(){
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Aplicacion Pincel");
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(700, 700);
        panel.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(panel);
        
        JButton boton = new JButton();
        boton.setText("Pincel");
        boton.setFont(new Font("Algerian", Font.TRUETYPE_FONT, 25));
        boton.setForeground(Color.CYAN);
        boton.setSize(100, 50);
        boton.setLocation(150, 0);
        boton.setBackground(Color.DARK_GRAY);
        panel.add(boton);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonPresionado = !botonPresionado;
                if (botonPresionado) {
                    metodomouse(); 
                } else {
                  removeMouseListener(getMouseListeners()[0]);
                  removeMouseMotionListener(getMouseMotionListeners()[0]);
                }  
            }
        });
        panel.add(boton);
    }
    public void  metodomouse(){
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
       
    public static void main(String[] args) {
        AplicacionPincel ventana = new AplicacionPincel();
        ventana.setVisible(true);
    }
}
