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

    private boolean simetria;

    public Rectangulo(Point puntoInicial) {
        contorno = new Contorno(puntoInicial);
    }

    public Rectangulo(Point puntoInicial, Color colorDePrimerPlano, Color colorDeSegundoPlano, int grosorFigura, boolean rellenar, boolean simetria) {
        super(colorDePrimerPlano, colorDeSegundoPlano, grosorFigura);// Pasa los datos a figuraRellenable
        this.rellenar = rellenar;
        this.simetria = simetria;
        contorno = new Contorno(puntoInicial);
    }

    @Override
    public void actualizar(Point puntoActual) {
        contorno.width = puntoActual.x - contorno.x;
        contorno.height = puntoActual.y - contorno.y;
    }

    @Override
    public void dibujar(Graphics2D g) {

        if (this.simetria) {
            int anchura = Math.max(Math.abs(contorno.width),Math.abs(contorno.height));
            int altura = Math.max(Math.abs(contorno.width),Math.abs(contorno.height));
            
            int x = contorno.width < 0 ? contorno.x - anchura : contorno.x;
            int y = contorno.height < 0 ? contorno.y - altura : contorno.y;
            if (this.rellenar) {
                g.setColor(colorDePrimerPlano);
                g.setStroke(new BasicStroke(super.grosorFigura));
                g.fillRect(x, y, anchura, altura);
            } else {
                g.setColor(super.colorDePrimerPlano); // Accede a los atributos de Figura
                g.setStroke(new BasicStroke(super.grosorFigura));
                g.drawRect(x, y, anchura, altura);
            }
        } else {
            int anchura = Math.abs(contorno.width);
            int altura = Math.abs(contorno.height);
            int x = contorno.width < 0 ? contorno.x - anchura : contorno.x;
            int y = contorno.height < 0 ? contorno.y - altura : contorno.y;
            if (this.rellenar) {
                g.setColor(colorDePrimerPlano);
                g.setStroke(new BasicStroke(super.grosorFigura));
                g.fillRect(x, y, anchura, altura);
            } else {
                g.setColor(super.colorDePrimerPlano); // Accede a los atributos de Figura
                g.setStroke(new BasicStroke(super.grosorFigura));
                g.drawRect(x, y, anchura, altura);
            }
        }
    }
}
