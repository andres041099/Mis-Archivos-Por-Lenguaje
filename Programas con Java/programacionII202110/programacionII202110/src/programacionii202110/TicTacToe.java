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
  private Jugador jugador1 = new Jugador("Jugador 1","X");
  private Jugador jugador2 = new Jugador("Jugador 2","O");
  private Jugador jugadorActual = jugador1;
  private String[] posiciones = " , , , , , , , , ".split(",");
  int posicionMasReciente;
  
  public void mostrarTableroDeJuego(String mensaje) {
    limpiarPantalla();
    imprimirLineaHorizontal();
    imprimirLineaDeRelleno( );
    System.out.println( "|  1  |  2  |  3  |" );
    imprimirLineaDeSeparacion();
    System.out.println( "|  4  |  5  |  6  |" );
    imprimirLineaDeSeparacion();
    System.out.println( "|  7  |  8  |  9  |" );
    imprimirLineaDeRelleno( );
    imprimirLineaHorizontal( );
    System.out.println("\n\n");

    Linea linea = obtenerLineaDeTriunfo();
    if( linea == null ) {
      imprimirLineaHorizontal();
      imprimirLineaDeRelleno( );
      System.out.printf( "|  %s  |  %s  |  %s  |\n", posiciones[0], posiciones[1], posiciones[2]);
      imprimirLineaDeSeparacion();
      System.out.printf( "|  %s  |  %s  |  %s  |\n", posiciones[3], posiciones[4], posiciones[5]);
      imprimirLineaDeSeparacion();
      System.out.printf( "|  %s  |  %s  |  %s  |\n", posiciones[6], posiciones[7], posiciones[8]);
      imprimirLineaDeRelleno( );
      System.out.println("+-----+-----+-----+  " + mensaje);
    }
    else if( linea.direccion.equals( "horizontal" ) ) {
      String lineaDeTriunfo = "|--%s--|--%s--|--%s--|\n";
      String lineaNormal = "|  %s  |  %s  |  %s  |\n";
      
      imprimirLineaHorizontal();
      imprimirLineaDeRelleno( );
      System.out.printf( linea.posicion == 0 ? lineaDeTriunfo : lineaNormal, posiciones[0], posiciones[1], posiciones[2]);
      imprimirLineaDeSeparacion();
      System.out.printf( linea.posicion == 1 ? lineaDeTriunfo : lineaNormal, posiciones[3], posiciones[4], posiciones[5]);
      imprimirLineaDeSeparacion();
      System.out.printf( linea.posicion == 2 ? lineaDeTriunfo : lineaNormal, posiciones[6], posiciones[7], posiciones[8]);
      imprimirLineaDeRelleno( );
      System.out.println("+-----+-----+-----+  " + mensaje);
    }
    else if(linea.direccion.equals("vertical")) {
      int posicion = linea.posicion;
      imprimirLineaHorizontal();
      imprimirLineaDeRelleno(posicion);
      System.out.printf( "|  %s  |  %s  |  %s  |\n", posiciones[0], posiciones[1], posiciones[2]);
      imprimirLineaDeRelleno(posicion);
      imprimirLineaHorizontal();
      imprimirLineaDeRelleno(posicion);
      System.out.printf( "|  %s  |  %s  |  %s  |\n", posiciones[3], posiciones[4], posiciones[5]);
      imprimirLineaDeRelleno(posicion);
      imprimirLineaHorizontal();
      imprimirLineaDeRelleno(posicion);
      System.out.printf( "|  %s  |  %s  |  %s  |\n", posiciones[6], posiciones[7], posiciones[8]);
      imprimirLineaDeRelleno(posicion);
      System.out.println("+-----+-----+-----+  " + mensaje);
    }
    else if(linea.direccion.equals("diagonal")) {
      int posicion = linea.posicion;
      
      if(posicion == 0) {
        imprimirLineaHorizontal();
        System.out.println( "| \\   |     |     |" );
        System.out.printf( "|  %s  |  %s  |  %s  |\n", posiciones[0], posiciones[1], posiciones[2]);
        System.out.println( "|   \\ |     |     |" );
        imprimirLineaHorizontal();
        System.out.println( "|     | \\   |     |" );
        System.out.printf( "|  %s  |  %s  |  %s  |\n", posiciones[3], posiciones[4], posiciones[5]);
        System.out.println( "|     |   \\ |     |" );
        imprimirLineaHorizontal();
        System.out.println( "|     |     | \\   |" );
        System.out.printf( "|  %s  |  %s  |  %s  |\n", posiciones[6], posiciones[7], posiciones[8]);
        System.out.println( "|     |     |   \\ |" );
      }
      else {
        imprimirLineaHorizontal();
        System.out.println( "|     |     |   / |" );
        System.out.printf( "|  %s  |  %s  |  %s  |\n", posiciones[0], posiciones[1], posiciones[2]);
        System.out.println( "|     |     | /   |" );
        imprimirLineaHorizontal();
        System.out.println( "|     |   / |     |" );
        System.out.printf( "|  %s  |  %s  |  %s  |\n", posiciones[3], posiciones[4], posiciones[5]);
        System.out.println( "|     | /   |     |" );
        imprimirLineaHorizontal();
        System.out.println( "|   / |     |     |" );
        System.out.printf( "|  %s  |  %s  |  %s  |\n", posiciones[6], posiciones[7], posiciones[8]);
        System.out.println( "| /   |     |     |" );
      }
      
      System.out.println("+-----+-----+-----+  " + mensaje);
    }
      
    
    if( !haTerminadoElJuego() ) {
      System.out.println("Turno del jugador " + (jugadorActual.representacion.equalsIgnoreCase(jugador1.representacion) ? 1 : 2) );
    }
  }

  private void imprimirLineaHorizontal() {
    System.out.println( "+-----+-----+-----+" );
  }

  private void imprimirLineaDeRelleno() {
    System.out.println( "|     |     |     |" );
  }
  
  private void imprimirLineaDeRelleno(int posicion) {
    System.out.printf( "|  %s  |  %s  |  %s  |\n", posicion == 0 ? "|" : " ", posicion == 1 ? "|" : " ", posicion == 2 ? "|" : " ");
  }
  
  private void imprimirLineaDeSeparacion() {
    imprimirLineaDeRelleno();
    imprimirLineaHorizontal();
    imprimirLineaDeRelleno();
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
    String mensaje = "";
    boolean posicionEstaOcupada = false;
    
    do{
      do{
        if( jugadorActual.equals( jugador1 ) ) {
          System.out.print("Digite la posicion en la que desea jugar: " );
          posicion = entrada.nextInt();
        }
        else {
          posicion = generarPosicion() + 1;
          
          try {
            Thread.sleep(2000);
          } catch (InterruptedException ex) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        if(posicion >= 1 && posicion <= 9) {
          
          if( posicionEstaOcupada = estaOcupada( posicion -1 ) ) {
            mensaje = "Posicion ocupada. Intente de nuevo...";
          }
          else {
            posicionMasReciente = posicion - 1;
            posiciones[posicionMasReciente] = jugadorActual.representacion;
            
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

      Linea linea = obtenerLineaDeTriunfo();
      if( linea != null ) {
        mensaje = "El " + jugadorActual.nombre + " Ha Ganado en la linea " + linea.direccion + " en la posicion " + linea.posicion;
      }
      else if( estaEmpatado() ) {
        mensaje = "El juego Está Empate!";
      }
      
      limpiarPantalla();
      mostrarTableroDeJuego(mensaje);
      
    }while ( !haTerminadoElJuego() );
    
    System.out.println("Desea jugar de nuevo? s/n");
    entrada.nextLine();
    String opcion = entrada.nextLine();
    if (opcion.equalsIgnoreCase("s"))
    {
        inicializar();
    }
    else
    {
        System.out.println("Juego terminado");
    }
  }
  
  private boolean estaOcupada( int posicion ) {
    return posiciones[posicion].equalsIgnoreCase(jugador1.representacion ) || posiciones[posicion].equalsIgnoreCase(jugador2.representacion );
  } 
  
  public static void main(String[] args) {
    TicTacToe juego = new TicTacToe();
    juego.inicializar();
  }

  private Linea obtenerLineaDeTriunfo() {
    Linea[] lineas = { hizoUnaLineaHorizontal(), hizoUnaLineaVertical(), hizoUnaLineaDiagonal() };
    Linea lineaResultado = null;
    
    for ( Linea linea : lineas ) {
      if(linea.posicion >= 0) {
         lineaResultado = linea;
         break;
      }
    }
    
    return lineaResultado;
  }
  private boolean esLinea(int a, int b, int c)
  {
      String representacion = jugadorActual.representacion;
      return ( posiciones[a].equalsIgnoreCase(representacion) && posiciones[b].equalsIgnoreCase(representacion) && posiciones[c].equalsIgnoreCase(representacion) );
  }
  
  
  class Linea {
    String direccion;//horizontal, vertical o diagonal
    int posicion;//basado en la fila (comenzando en cero)

    public Linea(String direccion, int posicion) {
      this.direccion = direccion;
      this.posicion = posicion;
    }

  }
  
  private Linea hizoUnaLineaHorizontal() {
    boolean[] lineas = { esLinea(0,1,2), esLinea(3, 4, 5), esLinea(6, 7, 8)};
    int posicion;
    
    if(lineas[0]) {
      posicion = 0;
    }
    else if(lineas[1]) {
      posicion = 1;
    }
    else if(lineas[2]) {
      posicion = 2;
    }
    else {
      posicion = -1;
    }
    
    return new Linea( "horizontal", posicion);
  }
  
  private Linea hizoUnaLineaVertical() {
    boolean[] lineas = { esLinea(0,3,6), esLinea(1, 4, 7), esLinea(2, 5, 8)};
    int posicion;
    
    if(lineas[0]) {
      posicion = 0;
    }
    else if(lineas[1]) {
      posicion = 1;
    }
    else if(lineas[2]) {
      posicion = 2;
    }
    else {
      posicion = -1;
    }
    
    return new Linea( "vertical", posicion);
  }
  
  private Linea hizoUnaLineaDiagonal() {                
    boolean[] lineas = { esLinea(0,4,8), esLinea(6, 4, 2)};
    int posicion;
    
    if(lineas[0]) {
      posicion = 0;
    }
    else if(lineas[1]) {
      posicion = 1;
    }
    else {
      posicion = -1;
    }
    
    return new Linea( "diagonal", posicion);
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
    return estanTodasLasPosicionesOcupadas() && obtenerLineaDeTriunfo() == null;
  }

  private boolean haTerminadoElJuego() {
    return obtenerLineaDeTriunfo() != null || estaEmpatado();
  } 

  private int generarPosicion() {
    Random numerosAleatorios = new Random();
    int posicion;
    do {
      if( puedeGanar() ) {
        posicion =  obtenerPosicionDeGanar(jugador2);
          System.out.println("Intentando ganar");
      }
      else if( puedePerder() ) {
        posicion = obtenerPosicionDeBloquear();
        System.out.println("Intentando bloquear");
      }
      else {
        //intentar jugar de manera inteligente
        posicion = numerosAleatorios.nextInt(9);
        
      }
      System.out.println("Jugando "+ posicion);
        for (String posicionActual : posiciones) {
            System.out.print(posicionActual + "  -");
        }
        System.out.println("Está ocupada: "+ estaOcupada(posicion));
    }while ( posicion != -1 && estaOcupada( posicion ));
    
    return posicion;
  }
  
  private boolean puedeGanarUsando(int primeraPosicionLlena, int segundaPosicionLlena, int posicionVacia, Jugador jugador)
  {
      int ultimo = posiciones.length - 1;
      String representacion = jugador.representacion;
      if(primeraPosicionLlena < 0 || primeraPosicionLlena > ultimo || segundaPosicionLlena < 0 || segundaPosicionLlena > ultimo || posicionVacia < 0 || posicionVacia > ultimo )
      {
          return false;
      }
      return (posiciones[primeraPosicionLlena].equalsIgnoreCase(representacion) && posiciones[segundaPosicionLlena].equalsIgnoreCase(representacion) && posiciones[posicionVacia].equals(" "));
  }
  private int obtenerPosicionDeGanar(Jugador jugador)
  {
      /*
      0 1 2
      3 4 5
      6 7 8
      */
      //if\(puedeGanarUsando\([0-8], [0-8], [0-8](\)\))
      int posicion = -1;
      if(puedeGanarUsando(0, 1, 2, jugador))
      {
          posicion = 2;
      }
      else if(puedeGanarUsando(0, 2, 1, jugador))
      {
          posicion = 1;
      }
      else if(puedeGanarUsando(1, 2, 0, jugador))
      {
          posicion = 0;
      }
      else if(puedeGanarUsando(3, 4, 5, jugador))
      {
          posicion = 5;
      }
      else if(puedeGanarUsando(3, 5, 4, jugador))
      {
          posicion = 4;
      }
      else if(puedeGanarUsando(4, 5, 3, jugador))
      {
          posicion = 3;
      }
      else if(puedeGanarUsando(6, 7, 8, jugador))
      {
          posicion = 8;
      }
      else if(puedeGanarUsando(6,8,7, jugador))
      {
          posicion = 7;
      }
      else if(puedeGanarUsando(7,8,6, jugador))
      {
          posicion = 6;
      }
      else if(puedeGanarUsando(0,3,6, jugador))//vertical
      {
          posicion = 6;
      }
      else if(puedeGanarUsando(0,6,3, jugador))
      {
          posicion = 3;
      }
      else if(puedeGanarUsando(6,3,0, jugador))
      {
          posicion = 0;
      }
      else if(puedeGanarUsando(1,4,7, jugador))
      {
          posicion = 7;
      }
      else if(puedeGanarUsando(1,7,4, jugador))
      {
          posicion = 4;
      }
      else if(puedeGanarUsando(4,7,1, jugador))
      {
          posicion = 1;
      }
      else if(puedeGanarUsando(2,5,8, jugador))
      {
          posicion = 8;
      }
      else if(puedeGanarUsando(2,8,5, jugador))
      {
          posicion = 5;
      }
      else if(puedeGanarUsando(5,8,2, jugador))
      {
          posicion = 2;
      }
      else if(puedeGanarUsando(0,4,8, jugador))//diagonal
      {
          posicion = 8;
      }
      else if(puedeGanarUsando(0,8,4, jugador))
      {
          posicion = 4;
      }
      else if(puedeGanarUsando(4,8,0, jugador))
      {
          posicion = 0;
      }
      else if(puedeGanarUsando(2,4,6, jugador))
      {
          posicion = 6;
      }
      else if(puedeGanarUsando(2,6,4, jugador))
      {
          posicion = 4;
      }
      else if(puedeGanarUsando(4,6,2, jugador))
      {
          posicion = 2;
      }
      return posicion;
  }
  
  private boolean puedeGanar()
  {
      return obtenerPosicionDeGanar(jugador2) >= 0;
  }
  
  
  private int obtenerPosicionDeBloquear()
  {
      return obtenerPosicionDeGanar(jugador1);
  }
  
  boolean puedePerder()
  {
      return obtenerPosicionDeBloquear() >= 0;
  }

    private void inicializar() {
        for (int i = 0; i < posiciones.length; i++) {
            posiciones[i] = " ";
        }
        limpiarPantalla();
        mostrarTableroDeJuego("");
        jugar();
    }
}