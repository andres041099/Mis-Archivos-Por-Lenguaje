/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii202110;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josearielpereyra
 */
public class FormularioEstudiantes extends JFrame{
  final String separador = File.separator;
  final String ruta = String.format("%s%sdatos%sestudiantes.txt", System.getProperty("user.home"), separador, separador);
  private final JTable tablaEstudiantes;
  private String laMatriculaExiste;

  public FormularioEstudiantes() {
    setTitle( "Estudiantes" );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setSize(600, 500);
    
    JPanel formulario = new JPanel(new GridLayout(1, 0));
    add(formulario, BorderLayout.NORTH);
    
    JLabel lblMatricula = new JLabel("Matricula:");
    JLabel lblNombre = new JLabel("Nombre:");
    JLabel lblApellido = new JLabel("Apellido");
    lblMatricula.setHorizontalAlignment( SwingConstants.RIGHT );
    lblNombre.setHorizontalAlignment( SwingConstants.RIGHT );
    lblApellido.setHorizontalAlignment( SwingConstants.RIGHT );
    
    JTextField txtMatricula = new JTextField();
    JTextField txtNombre = new JTextField();
    JTextField txtApellido = new JTextField();
    
    JButton btnGuardar = new JButton("Guardar");
    btnGuardar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        guardar(ruta, txtMatricula.getText(), txtNombre.getText(), txtApellido.getText() );
        actualizarTabla();
      }
    });
    
    
    formulario.add( lblMatricula );
    formulario.add( txtMatricula );
    formulario.add( lblNombre );
    formulario.add( txtNombre );
    formulario.add( lblApellido );
    formulario.add( txtApellido );
    
    formulario.add( btnGuardar );
    
    tablaEstudiantes = new JTable();
    actualizarTabla();
    add(new JScrollPane( tablaEstudiantes ), BorderLayout.CENTER );
    setVisible(true);
  }
  
  public void actualizarTabla() {
    try {
      Vector<String> nombresColumnas = new Vector<>();
      Vector< Vector<String> > datosFilas = new Vector<>();
      
      File archivo = new File( ruta );
      
      Scanner entrada = new Scanner( archivo );
      String[] arregloEncabezados = entrada.nextLine().split( Pattern.quote("|") );
      Collections.addAll(nombresColumnas, arregloEncabezados);
      
      Vector<String> filaActual;
      while (entrada.hasNext()) {
        filaActual = new Vector<>();
        String[] arregloFila = entrada.nextLine().split( Pattern.quote("|") );
        Collections.addAll(filaActual, arregloFila);
        datosFilas.add(filaActual);
      }
      
      tablaEstudiantes.setModel( new DefaultTableModel(datosFilas, nombresColumnas));
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(this, "No se pudo encontrar la base de datos..");
    }
    
  }
  
  public void guardar( String ruta, String matricula, String nombre, String apellido ) {
    String valorAGuardar = String.format("%s|%s|%s\n", matricula, nombre, apellido);
      

    
    try {
        Files.write(Paths.get( ruta ), valorAGuardar.getBytes(), StandardOpenOption.APPEND);
    }catch (IOException e) {
        System.out.println("No se pudo Guardar el Estudiante en el archivo");
    }
  }
  
private void laMatriculaExiste( String ruta, String matricula, String nombre, String apellido ) {
    String valorExistente = String.format("%s|%s|%s\n", matricula, nombre, apellido);
            if (valorExistente == valorExistente) {
                JOptionPane.showMessageDialog(null, "Ya Existe");
                
            } else {
                JOptionPane.showMessageDialog(null, "Nuevo");
            }
             
    
            actualizarTabla();
 }   
   
  public static void main(String[] args) {
    MetodosUtilitarios.cambiarAparencia("Otro");
    
    FormularioEstudiantes ventana = new FormularioEstudiantes();
    ventana.setVisible(true);
  }
}
