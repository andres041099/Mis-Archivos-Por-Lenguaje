/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author josearielpereyra
 */
public class PuntoDeArrastre extends JPanel{
    public static int anchura = 8;
    public PuntoDeArrastre(int tipoCursor) {
        this.setSize(anchura,anchura);
        this.setBorder(new LineBorder(Color.BLUE, 1));
        this.setCursor(new Cursor(tipoCursor));
    }
}
