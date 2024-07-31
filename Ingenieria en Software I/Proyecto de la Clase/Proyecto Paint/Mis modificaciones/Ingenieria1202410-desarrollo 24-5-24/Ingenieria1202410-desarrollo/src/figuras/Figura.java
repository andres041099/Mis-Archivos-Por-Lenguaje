/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author josearielpereyra
 */
public abstract class Figura implements Serializable {

    Color colorDePrimerPlano;
    int grosorFigura;

    private static final long serialVersionUID = 1L;

    public Figura(Color colorDePrimerPlano) {
        this.colorDePrimerPlano = colorDePrimerPlano;
    }

    public Figura() {
        this(Color.BLACK, 1);
    }

    public Figura(int grosorFigura) {
        this.grosorFigura = grosorFigura;
    }

    public Figura(Color colorDePrimerPlano, int grosorFigura) {
        this.colorDePrimerPlano = colorDePrimerPlano;
        this.grosorFigura = grosorFigura;

    }

    public abstract void dibujar(Graphics2D g);

    public abstract void actualizar(Point puntoActual);
}
