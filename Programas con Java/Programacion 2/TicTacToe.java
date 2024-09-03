package programacionii202110;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josearielpereyra
 */
public class TicTacToe {
  private String jugador1 = "X";
  private String jugador2 = "O";
  private String jugadorActual = jugador1;
  String[] posiciones = " , , , , , , , , ".split(",");
  int posicionMasReciente;
  
  public void mostrarTableroDeJuego() {
    for (int i = 0; i < 3; i++) {
      limpiarPantalla();
      System.out.println( "+-----+-----+-----+" );
      System.out.println( "|  1  |  2  |  3  |" );
      System.out.println( "+-----+-----+-----+" );
      System.out.println( "|  4  |  5  |  6  |" );
      System.out.println( "+-----+-----+-----+" );
      System.out.println( "|  7  |  8  |  9  |" );
      System.out.println( "+-----+-----+-----+\n\n" );

      System.out.println("+-----+-----+-----+");
      for( int j = 0; j < 3; j++) {
        System.out.printf( "|  %s  ", j == posicionMasReciente && i % 2 == 1 ? posiciones[j].toLowerCase() :  posiciones[j].toUpperCase() );
      }
      System.out.println("|");
      
      System.out.println("+-----+-----+-----+");
      for( int j = 3; j < 6; j++) {
        System.out.printf( "|  %s  ", j == posicionMasReciente && i % 2 == 1 ? posiciones[j].toLowerCase() :  posiciones[j].toUpperCase() );
      }
      System.out.println("|");
      
      System.out.println("+-----+-----+-----+");
      for( int j = 6; j < 9; j++) {
        System.out.printf( "|  %s  ", j == posicionMasReciente && i % 2 == 1 ? posiciones[j].toLowerCase() :  posiciones[j].toUpperCase() );
      }
      System.out.println("|");
      
     
      System.out.println("+-----+-----+-----+");
      
      
      if( i < 2 ) {
        System.out.print("\n\n");
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException ex) {
        Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    if( !haTerminadoElJuego() ) {
      System.out.println("Turno del jugador " + (jugadorActual.equals(jugador1) ? 1 : 2) );
    }
  }
  
  public void limpiarPantalla() {
    for (int i = 0; i < 50; i++) {
      System.out.println();
    }
  }
  
  public void cambiarTurno() {
    jugadorActual = jugadorActual.equals(jugador1) ? jugador2 : jugador1;
  }
  
  public void jugar() {
    Scanner entrada = new Scanner(System.in);
    int posicion;
    boolean posicionEstaOcupada = false;
    
    do{
      do{
        if( jugadorActual.equals( jugador1 ) ) {
          System.out.print("Digite la posicion en la que desea jugar: " );
          posicion = entrada.nextInt();
        }
        else {
          posicion = generarPosicion();
          
          try {
            Thread.sleep(2000);
          } catch (InterruptedException ex) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
          }
        }

        if(posicion >= 1 && posicion <= 9) {
          
          if( posicionEstaOcupada = estaOcupada( posicion - 1 ) ) {
            System.out.println("Posicion ocupada. Intente de nuevo...");
          }
          else {
            posicionMasReciente = posicion - 1;
            posiciones[posicionMasReciente] = jugadorActual;
            
            if( haTerminadoElJuego() ) {
              break;
            }
            else {
              cambiarTurno();
            }
          }
        }
        else {
          System.out.println("La posicion debe ser un numero entre 1 y 9");
        }
      } while( posicion < 1 || posicion > 9 || posicionEstaOcupada);

      limpiarPantalla();
      mostrarTableroDeJuego();
      if( haGanado() ) {
        System.out.println("El Jugador " + (jugadorActual.equals( jugador1 ) ? 1 : 2) + " Ha Ganado!");
      }
      else if( estaEmpatado() ) {
        System.out.println("El juego Está Empate!");
      }
    }while ( !haTerminadoElJuego() );
  }
  
  private boolean estaOcupada( int posicion ) {
    return posiciones[posicion].equals( jugador1 ) || posiciones[posicion].equals( jugador2 );
  } 
  
  public static void main(String[] args) {
    TicTacToe juego = new TicTacToe();
    juego.limpiarPantalla();
    juego.mostrarTableroDeJuego();
    juego.jugar();
  }

  private boolean haGanado() {
    return hizoUnaLineaHorizontal() || hizoUnaLineaVertical() || hizoUnaLineaDiagonal();
  }

  private boolean hizoUnaLineaHorizontal() {
    return ( posiciones[0].equals(jugadorActual) && posiciones[1].equals(jugadorActual) && posiciones[2].equals(jugadorActual) ) ||
            ( posiciones[3].equals(jugadorActual) && posiciones[4].equals(jugadorActual) && posiciones[5].equals(jugadorActual) ) ||
            ( posiciones[6].equals(jugadorActual) && posiciones[7].equals(jugadorActual) && posiciones[8].equals(jugadorActual) );
  }
  
  private boolean hizoUnaLineaVertical() {
    return ( posiciones[0].equals(jugadorActual) && posiciones[3].equals(jugadorActual) && posiciones[6].equals(jugadorActual) ) ||
            ( posiciones[1].equals(jugadorActual) && posiciones[4].equals(jugadorActual) && posiciones[7].equals(jugadorActual) ) ||
            ( posiciones[2].equals(jugadorActual) && posiciones[5].equals(jugadorActual) && posiciones[8].equals(jugadorActual) );
  }
  
  private boolean hizoUnaLineaDiagonal() {            
    return ( posiciones[0].equals(jugadorActual) && posiciones[4].equals(jugadorActual) && posiciones[8].equals(jugadorActual) ) ||
            ( posiciones[6].equals(jugadorActual) && posiciones[4].equals(jugadorActual) && posiciones[2].equals(jugadorActual) );
  }

  private boolean estanTodasLasPosicionesOcupadas() {
    for (int posicion = 0; posicion < posiciones.length; posicion++) {
      if( !estaOcupada(posicion) ) {
        return false;
      }
    }
    return true;
  }
  
  private boolean estaEmpatado() {
    return estanTodasLasPosicionesOcupadas() && !haGanado();
  }

  private boolean haTerminadoElJuego() {
    return haGanado() || estaEmpatado();
  } 

  private int generarPosicion() {
    Random numerosAleatorios = new Random();
    int posicion;
    do {
        int PosicionDeGanar =  obtenerPosicionDeGanar();
        int PosicionDePerder =  obtenerPosicionDeBloquear();
//      if( puedeGanar() ) {
//        posicion =  obtenerPosicionDeGanar();
//      }
//      else if( puedePerder() ) {
//        posicion = obtenerPosicionDeBloquear();
//      }
//      else {
//        //intentar jugar de manera inteligente
//        posicion = numerosAleatorios.nextInt(8) + 1;
//      }

      posicion = numerosAleatorios.nextInt(8) + 1;//borrar esta linea al implementar la funcionalidad
    }while ( estaOcupada( posicion  - 1 ));
    
    return posicion;
  }
  //Private int obtenerPosicionDeGanar(){
  
  }
  
          
}


