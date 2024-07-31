/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ingenieria1202410;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author josearielpereyra
 */
public class Rectangulo {
    private int x;
    private int y;
    private int anchura;
    private int altura;

    public Rectangulo(Point puntoInicial) {
        x = puntoInicial.x;
        y = puntoInicial.y;
    }
    
  
    public void actualizar(Point puntoActual) {
        anchura = Math.abs(puntoActual.x - x);
        altura = Math.abs(puntoActual.y - y);
    }


    public void dibujar(Graphics g) {
        g.drawRect(x, y, anchura, altura);
    }
    
    
    
    
}
