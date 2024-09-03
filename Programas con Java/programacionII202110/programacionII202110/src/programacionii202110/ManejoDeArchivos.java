package programacionii202110;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author josearielpereyra
 */
public class ManejoDeArchivos {
  public static void imprimirLinea(){
    System.out.println("+----------+---------------+---------------+");
  }
  
  public static void mostrarDatos( String ruta ) throws FileNotFoundException {
    File archivo = new File( ruta );

    Scanner entrada = new Scanner( archivo );

    imprimirLinea();
    procesarLinea( entrada.nextLine() );
    imprimirLinea();
    while (entrada.hasNext()) {
      procesarLinea( entrada.nextLine() );
    }
    imprimirLinea();
  }

  private static void procesarLinea(String lineaActual) {
    String[] arregloEstudiante = lineaActual.split( Pattern.quote("|") );
    System.out.printf("|%-10s|%-15s|%-15s|\n", (Object[])arregloEstudiante);
  }
  
  public static void main(String[] args) {
    try { 
      String separador = File.separator;
      String ruta = String.format("%s%sdatos%sestudiantes.txt", System.getProperty("user.home"), separador, separador);
      String matricula, nombre, apellido;
      Scanner entrada = new Scanner(System.in);
      
      System.out.print("Introduzca la matricula del estudiante: ");
      matricula = entrada.nextLine();
      System.out.print("Introduzca el nombre del estudiante: ");
      nombre = entrada.nextLine();
      System.out.print("Introduzca el apellido del estudiante: ");
      apellido = entrada.nextLine();
      
      String valorAGuardar = String.format("%s|%s|%s\n", matricula, nombre, apellido);
      
      try {
          Files.write(Paths.get( ruta ), valorAGuardar.getBytes(), StandardOpenOption.APPEND);
      }catch (IOException e) {
          System.out.println("No se pudo Guardar el Estudiante en el archivo");
      }
      
      mostrarDatos(ruta);
      
    } catch (FileNotFoundException ex) {
      System.out.println("Archivo no encontrado");
    }
  }
  
}
