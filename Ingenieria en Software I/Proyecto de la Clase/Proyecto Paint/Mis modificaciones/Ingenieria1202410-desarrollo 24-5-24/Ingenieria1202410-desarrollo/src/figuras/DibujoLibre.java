/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @Andres Rodriguez
 */
public class DibujoLibre extends Figura{
   
    ArrayList<Point> puntos = new ArrayList<>();
    public DibujoLibre(Point puntoInicial) {
        puntos.add(puntoInicial);
    }
        public DibujoLibre(Point puntoInicial, Color colorDePrimerPlano,int grosorFigura) {
        super(colorDePrimerPlano, grosorFigura);
        puntos.add(puntoInicial);
        
    }
       public DibujoLibre(Point puntoInicial, Color colorDePrimerPlano) {
        super(colorDePrimerPlano);
        puntos.add(puntoInicial);  
    }
    @Override
    public void dibujar(Graphics2D g) {
        g.setColor(super.colorDePrimerPlano);
        g.setStroke(new BasicStroke(super.grosorFigura));
        if (puntos.size() == 1) {
            g.drawLine(puntos.get(0).x, puntos.get(0).y, puntos.get(0).x, puntos.get(0).y);
        } else {
            for (int i = 1; i < puntos.size(); i++) {
                g.drawLine(puntos.get(i - 1).x, puntos.get(i - 1).y, puntos.get(i).x, puntos.get(i).y);
            }
        }
    } 

    @Override
    public void actualizar(Point puntoFinal) {
         puntos.add(puntoFinal);
    }
}
