/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

/**
 *
 * @author Usuario
 */
/*public class Pruebas {

    /**
     * @param args the command line arguments
     */
   /* public static void main(String[] args) {
        // TODO code application logic here
    }
    
}*/


import javax.swing.*;
import java.awt.event.*;

// Definición de la clase SaludarGUI
public class SaludarGUI {
    public static void main(String[] args) {
        // Crear instancia de la clase Saludar
        Saludar saludar = new Saludar();

        // Crear un botón
        JButton boton = new JButton("Saludar");

        // Agregar un ActionListener al botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al método mostrarMensaje() de la clase Saludar
                saludar.mostrarMensaje();
            }
        });

        // Crear un frame (ventana) para contener el botón
        JFrame frame = new JFrame("Saludar App");

        // Agregar el botón al frame
        frame.getContentPane().add(boton);

        // Configurar el tamaño y hacer visible el frame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

