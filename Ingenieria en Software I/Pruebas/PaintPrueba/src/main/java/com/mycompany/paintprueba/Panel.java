/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.paintprueba;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Panel extends JPanel{
     private Rectangulo rectag;
     private ArrayList<Rectangulo> lisRectacgulo = new ArrayList<>();
     
    public Panel (){
    this.setBackground(Color.WHITE);
        JButton botonRectangulo = new JButton();
        botonRectangulo.setText("Dibujar Rectangulo");
        botonRectangulo.setFont(new Font("Algerian", Font.TRUETYPE_FONT, 25));
        botonRectangulo.setForeground(Color.CYAN);
        botonRectangulo.setSize(100, 50);
        botonRectangulo.setLocation(50, 130);
        botonRectangulo.setBackground(Color.lightGray);
        this.add(botonRectangulo); 
        
        ActionListener eventoRectangulo= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                if (EventoMouserectangulo ==condiccion) {
                    
                }
               ();
            }
        };
        botonRectangulo.addActionListener(eventoRectangulo);
    }
    
    private void Condicional(boolean  condicion){
        EventoMouserectangulo rec;
        new EventoMousere
    }
 
    private void EventoMouserectangulo(){
           MouseAdapter ev;
         ev = new MouseAdapter(){
             @Override
             public void mousePressed(MouseEvent e){
                 rectag = new Rectangulo(e.getPoint());
                 lisRectacgulo.add(rectag);
             }
             @Override
            public void mouseDragged(MouseEvent e) {
                rectag.actualizar(e.getPoint());
                
                repaint();  
            }
         };
       addMouseListener(ev);
       addMouseMotionListener(ev);
    }
    

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g); 
        for (Rectangulo rectanguloActual : lisRectacgulo) {
            rectanguloActual.dibuja(g);
        }
    }
}
