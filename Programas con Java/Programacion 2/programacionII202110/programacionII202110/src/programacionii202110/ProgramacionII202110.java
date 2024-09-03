/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii202110;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author josearielpereyra
 */
public class ProgramacionII202110 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println("Hola Mundo");
    }
    
//    Scanner entrada = new Scanner(System.in);
//    System.out.print("Cual es tu nombre? ");
//    String nombre = entrada.nextLine();
//    
//    System.out.println("Hola " + nombre); 
//    
//    System.out.print("Cuantos años tienes? ");
//    int edad = entrada.nextInt();
//    
//    int anioActual = Calendar.getInstance().get(Calendar.YEAR);
//    System.out.println("O sea que naciste en el año " + (anioActual - (edad + 1) ) + " o en el " + (anioActual - edad));
    
    
    //esto es UNa caDENa de tEXTO para haCer una pRUEBa - > Esto Es Una Cadena de Texto Para Hacer Una Prueba
    
    String cadena = "esto es UNa caDENa de tEXTO para haCer una pRUEBa";
    
    
    System.out.println( capitalizar( cadena ) );
    
    System.out.println( capitalizar("otra prueba mAs a realizar, paRA VEr qUE Funciona biEN."));
    
    String cadenaGrande = "Santo Domingo (oficialmente llamada Santo Domingo de Guzmán) es la capital y ciudad más poblada de la República Dominicana. La ciudad está situada sobre el mar Caribe, en la desembocadura del río Ozama, en la costa sur de la isla a 155 km al sureste de Santiago de los Caballeros.\n" +
"\n" +
"Fundada por Bartolomé Colón el 5 de agosto de 1498,5​ en la margen oriental del río Ozama y luego trasladada por Nicolás de Ovando en 1502 a la margen occidental del mismo río. Conocida por ser el lugar del primer asentamiento europeo permanente en América, y por ser la primera sede del gobierno de la Corona de Castilla en el Nuevo Mundo. Se encuentra dentro de los límites del Distrito Nacional, este último bordeado a su vez por tres costados por la provincia Santo Domingo. Limita al sur con el mar Caribe, al este con el municipio Santo Domingo Este, al oeste con Santo Domingo Oeste y al norte con Santo Domingo Norte; entre todas forman el Gran Santo Domingo, cuya área metropolitana supera ya los 4 millones de habitantes.\n" +
"\n" +
"La ciudad fue elegida Capital Americana de la Cultura en el 2010, ha sido sede de los Juegos Panamericanos del 2003, de los Juegos Centroamericanos y del Caribe 1974 y de la serie del Caribe en varias ocasiones.\n" +
"\n" +
"En Santo Domingo se encuentran la primera catedral y el primer castillo de América; ambos ubicados en la Ciudad Colonial, zona declarada como Patrimonio de la Humanidad por la UNESCO. Gracias a esto, la ciudad, especialmente su Centro Histórico reciben aproximadamente un millón de visitantes internacionales cada año.\n" +
"\n" +
"Hoy, Santo Domingo constituye el mayor centro cultural, financiero, político, comercial e industrial de la República Dominicana. Santo Domingo también sirve como el principal puerto del país. Uno de los puertos de la ciudad se encuentra en la desembocadura del río Ozama, acoge a los buques más grandes, y es capaz de recibir tráfico de pasajeros así como carga a de mercancías.\n" +
"\n" +
"Santo Domingo llevó el nombre de \"Ciudad Trujillo\" desde 1936 hasta 1961, debido a un cambio hecho por el dictador Rafael Leónidas Trujillo Molina. Hoy en día, Santo Domingo es la metrópolis más importante del país, dado su PIB Paridad de poder adquisitivo US$ 90 000 millones y además es la ciudad más poblada del Caribe.";
    
  
    System.out.println( capitalizar(cadenaGrande));
  }
  
  public static String capitalizar( String cadena ) {
    //TODO implementar que funcione para cuando el caracter separador es el salto de linea
    cadena = cadena.toUpperCase();
    String[] arreglo = cadena.split(" ");
    
    String cadenaResultante = "";
    
    for (int i = 0; i < arreglo.length; i++) {
      int indiceDeLetra = 0;
      String prefijo = "";
      
      for( int j = 0; j < arreglo[i].length(); j++) {
        if(arreglo[i].charAt(j) >= 65 && arreglo[i].charAt(j) <= 90 ) {
          indiceDeLetra = j;
          break;
        }
      }
            
              
      cadenaResultante = cadenaResultante + arreglo[i].substring(0,indiceDeLetra + 1 ).toUpperCase();
      cadenaResultante = cadenaResultante + arreglo[i].substring(indiceDeLetra + 1).toLowerCase() + " ";
    }
    
    return cadenaResultante;
  }
}
