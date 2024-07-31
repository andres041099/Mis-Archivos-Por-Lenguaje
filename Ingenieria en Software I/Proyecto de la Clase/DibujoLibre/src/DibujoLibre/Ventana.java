/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DibujoLibre;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Ventana extends JFrame{
    
    public Ventana(){
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setTitle("My Paint Coustommer");
        
        JPanel panel = new PanelDibujo(); 
        this.add(panel);
        
    }
    
    public static void main(String[] args) {
       Ventana abrir = new Ventana ();
       abrir.setVisible(true);
    }
}
