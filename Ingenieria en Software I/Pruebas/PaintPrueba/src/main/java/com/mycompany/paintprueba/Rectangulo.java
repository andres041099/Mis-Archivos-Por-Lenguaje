/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.paintprueba;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Usuario
 */
public class Rectangulo{
     private Point puntoInicial;
       private Point puntoFinal;

       public Rectangulo(Point puntoInicial) {
           this.puntoInicial = puntoInicial;
       }

       public void actualizar(Point puntoFinal) {
           this.puntoFinal = puntoFinal;
       }

       public void dibuja(Graphics g){
       int x = Math.min(puntoInicial.x, puntoFinal.x);
           int y = Math.min(puntoInicial.y, puntoFinal.y);
           int ancho = Math.abs(puntoInicial.x - puntoFinal.x);
           int altura = Math.abs(puntoInicial.y - puntoFinal.y);
           g.setColor(Color.black);
           g.drawRect(x, y, ancho, altura);
       }
}
