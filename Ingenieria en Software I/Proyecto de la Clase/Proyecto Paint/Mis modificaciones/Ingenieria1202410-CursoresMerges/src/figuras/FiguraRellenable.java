/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Color;

/**
 *
 * @author josearielpereyra
 */
public abstract class FiguraRellenable extends Figura {

    protected Color colorDeSegundoPlano;
    protected Contorno contorno;
    protected Boolean rellenar = Boolean.FALSE;

    public FiguraRellenable(Color colorDePrimerPlano, Color colorDeSegundoPlano, int grosorFigura) {
        super(colorDePrimerPlano, grosorFigura);
        this.colorDeSegundoPlano = colorDeSegundoPlano;
    }

    public FiguraRellenable(Color colorDeSegundoPlano, Color colorDePrimerPlano) {
        super(colorDePrimerPlano);
        this.colorDeSegundoPlano = colorDeSegundoPlano;
    }

    public FiguraRellenable(Color colorDeSegundoPlano) {
        this.colorDeSegundoPlano = colorDeSegundoPlano;
    }

    public FiguraRellenable() {
        this(Color.GREEN);
    }

    public Contorno getContorno() {
        return contorno;
    }

}
