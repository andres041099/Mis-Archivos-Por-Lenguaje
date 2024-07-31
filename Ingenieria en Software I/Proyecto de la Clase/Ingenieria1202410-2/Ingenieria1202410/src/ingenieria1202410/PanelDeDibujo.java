/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ingenieria1202410;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author josearielpereyra
 */
public class PanelDeDibujo extends JPanel {
    Linea miLinea;
    
    ArrayList<Linea> lineas = new ArrayList<>();
    
    public PanelDeDibujo() {
        this.setBackground(Color.WHITE);
        
        //Pasos para manejar eventos en java
        //1- Crear una clase para que funcione como manejador de eventos
        //2- Hacer que la clase del paso 1 implemente la interfaz de manejo de evento deseada
        //3- Decirle al objeto para el cual manejaremos el evento a cual objeto de la clase creada debe 
        //  notificarle cuando suceda el evento
        class Manejador extends MouseAdapter{
            @Override
            public void mousePressed(MouseEvent e) {
                miLinea = new Linea( e.getPoint() );
                lineas.add(miLinea);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                miLinea.actualizar(e.getPoint());
                repaint();
            }
        }
        
        Manejador manejador = new Manejador();
        
        this.addMouseListener( manejador );
        this.addMouseMotionListener( manejador );
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for( Linea lineaActual : lineas ) {
            lineaActual.dibujar(g);
        }
    }
}
