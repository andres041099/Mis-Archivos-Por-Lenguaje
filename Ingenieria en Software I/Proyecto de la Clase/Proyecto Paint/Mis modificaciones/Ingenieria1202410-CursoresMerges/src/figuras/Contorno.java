/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author josearielpereyra
 */
public class Contorno extends Rectangle {

    public final static PuntoDeArrastre puntoArrastreN = new PuntoDeArrastre(Cursor.N_RESIZE_CURSOR);
    public final static PuntoDeArrastre puntoArrastreS = new PuntoDeArrastre(Cursor.S_RESIZE_CURSOR);
    public final static PuntoDeArrastre puntoArrastreE = new PuntoDeArrastre(Cursor.E_RESIZE_CURSOR);
    public final static PuntoDeArrastre puntoArrastreO = new PuntoDeArrastre(Cursor.W_RESIZE_CURSOR);
    public final static PuntoDeArrastre puntoArrastreNE = new PuntoDeArrastre(Cursor.NE_RESIZE_CURSOR);
    public final static PuntoDeArrastre puntoArrastreNO = new PuntoDeArrastre(Cursor.NW_RESIZE_CURSOR);
    public final static PuntoDeArrastre puntoArrastreSO = new PuntoDeArrastre(Cursor.SW_RESIZE_CURSOR);
    public final static PuntoDeArrastre puntoArrastreSE = new PuntoDeArrastre(Cursor.SE_RESIZE_CURSOR);

    public Contorno(Point puntoInicial) {
        x = puntoInicial.x;
        y = puntoInicial.y;
    }

    public void actualizarPuntosDeArrastre(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int anchura = PuntoDeArrastre.anchura;
        puntoArrastreNO.setLocation(x - anchura / 2, y - anchura / 2);
        puntoArrastreN.setLocation(x + width / 2 - anchura / 2, y - anchura / 2);
        puntoArrastreNE.setLocation(x + width - anchura / 2, y - anchura / 2);
        puntoArrastreE.setLocation(x + width - anchura / 2, y + height / 2 - anchura / 2);
        puntoArrastreSE.setLocation(x + width - anchura / 2, y + height - anchura / 2);
        puntoArrastreS.setLocation(x + width / 2 - anchura / 2, y + height - anchura / 2);
        puntoArrastreSO.setLocation(x - anchura / 2, y + height - anchura / 2);
        puntoArrastreO.setLocation(x - anchura / 2, y + height / 2 - anchura / 2);

        //TODO: Verificar que los puntos de arrastre de los centros funcionen bien
        Point puntoAuxiliar;
        if (puntoArrastreNE.getLocation().x < puntoArrastreNO.getLocation().x) {
            puntoAuxiliar = puntoArrastreNE.getLocation();
            puntoArrastreNE.setLocation(puntoArrastreNO.getLocation());
            puntoArrastreNO.setLocation(puntoAuxiliar);
        }

        if (puntoArrastreSE.getLocation().x < puntoArrastreSO.getLocation().x) {
            puntoAuxiliar = puntoArrastreSE.getLocation();
            puntoArrastreSE.setLocation(puntoArrastreSO.getLocation());
            puntoArrastreSO.setLocation(puntoAuxiliar);
        }

        if (puntoArrastreSE.getLocation().y < puntoArrastreNE.getLocation().y) {
            puntoAuxiliar = puntoArrastreSE.getLocation();
            puntoArrastreSE.setLocation(puntoArrastreNE.getLocation());
            puntoArrastreNE.setLocation(puntoAuxiliar);
        }

        if (puntoArrastreSO.getLocation().y < puntoArrastreNO.getLocation().y) {
            puntoAuxiliar = puntoArrastreSO.getLocation();
            puntoArrastreSO.setLocation(puntoArrastreNO.getLocation());
            puntoArrastreNO.setLocation(puntoAuxiliar);
        }

        dibujar(g2);
    }

    void dibujar(Graphics2D g) {
        int variacion = 0;
        int anchura = Math.abs(width) + variacion;
        int altura = Math.abs(height) + variacion;
        int x1 = (width < 0 ? x - anchura : x) - variacion / 2;
        int y1 = (height < 0 ? y - altura : y) - variacion / 2;
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.red);
        //g.drawRect(x1, y1, anchura, altura);

        int longitudLinea = 6;
        for (int i = x1; i < x1 + anchura; i += longitudLinea * 2) {
            g.drawLine(i, y1, i + longitudLinea, y1);
            g.drawLine(i, y1 + altura, i + longitudLinea, y1 + altura);
        }

        for (int i = y1; i < y1 + altura; i += longitudLinea * 2) {
            g.drawLine(x1, i, x1, i + longitudLinea);
            g.drawLine(x1 + anchura, i, x1 + anchura, i + longitudLinea);
        }
    }
}
