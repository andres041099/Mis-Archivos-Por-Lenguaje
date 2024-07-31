/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author josearielpereyra
 */
public class Linea extends Figura {
    private Point puntoInicial;
    private Point puntoFinal;

    public Linea( Point puntoInicial ) {
        this(puntoInicial, puntoInicial);
    }
    
    public Linea( Point puntoInicial, Point puntoFinal ) {
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
    }
    
     public Linea(Point puntoInicial, Color colorDePrimerPlano,int grosorFigura) {
        super(colorDePrimerPlano, grosorFigura);
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoInicial;
       
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.setColor(super.colorDePrimerPlano);   
        g.setStroke(new BasicStroke(super.grosorFigura));
        g.drawLine(puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y);
    }

    @Override
    public void actualizar(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
    }
}