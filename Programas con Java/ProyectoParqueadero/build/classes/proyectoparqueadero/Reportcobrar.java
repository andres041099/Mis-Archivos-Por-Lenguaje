/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JDialog;
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
public class Reportcobrar extends JDialog{
  final String separador = File.separator;
  final String ruta = String.format("%s%sDatos%sCobro.txt", System.getProperty("user.home"), separador, separador);
  private final JTable tablaEstudiantes;
  private final JTextField txtBuscar;

  public Reportcobrar(JDialog padre) {
    super(padre, true);
    setTitle( "Cobro" );
    setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
    setSize(600, 500);
    setLocationRelativeTo( padre );
    
    JPanel formulario = new JPanel(new BorderLayout());
    add(formulario, BorderLayout.NORTH);
   
    JLabel lblBuscar = new JLabel("Buscar: ");
    lblBuscar.setHorizontalAlignment( SwingConstants.RIGHT );
   
    txtBuscar = new JTextField();
    txtBuscar.addKeyListener( new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        actualizarTabla();
      }
    });
    
    formulario.add( lblBuscar, BorderLayout.WEST );
    formulario.add( txtBuscar, BorderLayout.CENTER );
    
    tablaEstudiantes = new JTable();
    actualizarTabla();
    add(new JScrollPane( tablaEstudiantes ), BorderLayout.CENTER );
    
   
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
        String linea = entrada.nextLine();
        if( linea.toLowerCase().contains( txtBuscar.getText().trim().toLowerCase() )) {
          String[] arregloFila = linea.split( Pattern.quote("|") );
          Collections.addAll(filaActual, arregloFila);
          datosFilas.add(filaActual);
        }
      }
      DefaultTableModel modelo =  new DefaultTableModel(datosFilas, nombresColumnas){
          @Override
          public boolean isCellEditable(int row, int column) {
              return false;
          }
      
          
      };
      
      tablaEstudiantes.setModel(modelo);
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(this, "No se pudo encontrar la base de datos..");
    }
    
  }
  
  public void guardar( String ruta, String matricula, String nombre, String apellido ) {
    String valorAGuardar = String.format("%s|%s|%s\n", matricula, nombre, apellido);
      
    try {
        Files.write(Paths.get( ruta ), valorAGuardar.getBytes(), StandardOpenOption.APPEND);
    }catch (IOException e) {
        System.out.println("No se pudo Guardar el en el archivo");
    }
  }
  
  public static void main(String[] args) {
    MetodosUtilitarios.cambiarAparencia("Otro");
    
    Reportcobrar ventana = new Reportcobrar(null);
    ventana.setVisible(true);
  }
}
