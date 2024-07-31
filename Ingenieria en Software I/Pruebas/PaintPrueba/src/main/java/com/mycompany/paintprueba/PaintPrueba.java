/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.paintprueba;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class PaintPrueba extends JFrame{

    public PaintPrueba(){
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setTitle("Paint Prueba"); 
       JPanel panel = new Panel(); 
        this.add(panel);
    }
    public static void main(String[] args) {
       PaintPrueba abrir = new PaintPrueba();
       abrir.setVisible(true);
    }
}
