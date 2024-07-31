/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

/**
 *
 * @author Andres
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenTextFileExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Abrir Archivo de Texto por Categoría");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        // Crear el JComboBox con categorías
        String[] categories = { "Categoría 1", "Categoría 2", "Categoría 3" };
        JComboBox<String> categoryComboBox = new JComboBox<>(categories);
        
        // Crear el JButton para abrir el archivo de texto
        JButton openButton = new JButton("Abrir Archivo de Texto");
        
        // Panel para organizar los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(categoryComboBox);
        panel.add(openButton);
        
        // Añadir el panel al frame
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        // Acción del botón
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = (String) categoryComboBox.getSelectedItem();
                openTextFileForCategory(selectedCategory);
            }
        });
        
        frame.setVisible(true);
    }
    
    private static void openTextFileForCategory(String category) {
        String filePath = null;
        
        switch (category) {
            case "Categoría 1":
                filePath = "src/Tarea/Pincel.txt";
                break;
            case "Categoría 2":
                filePath = "ruta/a/tu/archivo2.txt";
                break;
            case "Categoría 3":
                filePath = "ruta/a/tu/archivo3.txt";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Categoría no válida.");
                return;
        }
        
        if (filePath != null) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(filePath)));
                JOptionPane.showMessageDialog(null, "Contenido del archivo:\n\n" + content);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al abrir el archivo de texto: " + ex.getMessage());
            }
        }
    }
}

