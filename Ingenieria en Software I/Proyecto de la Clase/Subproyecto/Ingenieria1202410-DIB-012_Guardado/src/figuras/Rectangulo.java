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
public class Rectangulo extends FiguraRellenable {
    
    public Rectangulo(Point puntoInicial) {
        contorno = new Contorno(puntoInicial);
    }
    public Rectangulo(Point puntoInicial, Color colorDeSegundoPlano, Color colorDePrimerPlano, int grosorFigura) {
       super(colorDeSegundoPlano,colorDePrimerPlano, grosorFigura);// Pasa los datos a figuraRellenable
        contorno = new Contorno(puntoInicial);
    }
    @Override
    public void actualizar(Point puntoActual) {
        contorno.width = puntoActual.x - contorno.x;
        contorno.height = puntoActual.y - contorno.y;
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.setColor(super.colorDePrimerPlano); // Accede a los atributos de Figura   
        g.setStroke(new BasicStroke(super.grosorFigura));// 
        int anchura = Math.abs(contorno.width);
        int altura = Math.abs(contorno.height);
        int x = contorno.width < 0 ? contorno.x - anchura : contorno.x;
        int y = contorno.height < 0 ? contorno.y - altura : contorno.y;
        g.drawRect(x, y, anchura, altura);
        
//        boolean anchuraEsNegativa = contorno.width < 0;
//        boolean alturaEsNegativa = contorno.height < 0;
//        
//        contorno.width = Math.abs(contorno.width);
//        contorno.height = Math.abs(contorno.height);
//        contorno.x = anchuraEsNegativa ? contorno.x - contorno.width : contorno.x;
//        contorno.y = alturaEsNegativa ? contorno.y - contorno.height : contorno.y; 
//        g.drawRect(contorno.x, contorno.y, contorno.width, contorno.height);
    }
}
