package programacionii202110;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author josearielpereyra
 */
public class TicTacToeVisual extends JFrame {

  private Jugador jugador1 = new Jugador("Jugador 1", "X");
  private Jugador jugador2 = new Jugador("Jugador 2", "O");
  private Jugador jugadorActual = jugador1;
  private String[] posiciones = " , , , , , , , , ".split(",");
  private JLabel[] botones = new JLabel[9];
  private Color colorDeBotones;
  private JPanel panelDeJuego;
  private JLabel barraDeEstado;
  private Timer temporizador;
  private int ganados;
  private int perdidos;
  private int empatados;
  private JLabel barraDeEstadisticas;

  public TicTacToeVisual() {
    temporizador = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        jugar(-1);
        temporizador.stop();
      }
    });
      
    barraDeEstadisticas = new JLabel();
    this.add(barraDeEstadisticas, BorderLayout.NORTH);
    
    barraDeEstado = new JLabel("");
    this.add(barraDeEstado, BorderLayout.SOUTH);
    
    panelDeJuego = new JPanel();
    panelDeJuego.setLayout(new GridLayout(3, 3));
    this.add(panelDeJuego, BorderLayout.CENTER);
    setSize(300, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    

    for (int i = 0; i < botones.length; i++) {
      JLabel boton = new JLabel("" + i);
      colorDeBotones = boton.getBackground();
      
      boton.setOpaque(true);
      boton.setBorder( new LineBorder(Color.GRAY, 1));
      boton.setHorizontalAlignment( JLabel.CENTER );
      boton.setFont( new Font("Arial", Font.BOLD, 48));
      botones[i] = boton;
      panelDeJuego.add(boton);

      boton.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
          if (jugadorActual.equals(jugador1)) {
            int posicion = -1;
            for (int j = 0; j < botones.length; j++) {
              if (botones[j].equals(boton)) {
                posicion = j;
                break;
              }
            }
            //JOptionPane.showMessageDialog(TicTacToeVisual.this, "posicion: " + posicion);
            jugar(posicion + 1);
          } else {
            System.out.println("Es el turno de la maquina");
          }
        }
      });
    }
    
    mostrarTableroDeJuego("");
  }

  public static void main(String[] args) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Metal".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (Exception ex) {
      java.util.logging.Logger.getLogger(TicTacToeVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    TicTacToeVisual juego = new TicTacToeVisual();
    juego.setVisible(true);
  }

  private void colorearCon(Color color, int a, int b, int c) {
    if (a >= 0 && a < 9 && b >= 0 && b < 9 && c >= 0 && c < 9) {
      botones[a].setBackground(color);
      botones[b].setBackground(color);
      botones[c].setBackground(color);
      
      System.out.printf("a: %s - b: %s - c: %s", a, b, c);
    }
  }

  public void mostrarTableroDeJuego(String mensaje) {
    barraDeEstadisticas.setText( String.format("<html><p>Ganados: %d</p><p>Perdidos: %d</p><p>Empatados: %d</p></html>", ganados, perdidos, empatados) );
    barraDeEstadisticas.setHorizontalAlignment(JLabel.CENTER);
    
    Linea linea = obtenerLineaDeTriunfo();
    Color colorDeFondo = Color.RED;

    if (linea != null) {
      System.out.println("colorear los botones");
      System.out.println("direccion: " + linea.direccion);
      System.out.println("posicion: " + linea.posicion);
      
      int posicion = linea.posicion;
      switch (linea.direccion) {
        case "horizontal":
          if (posicion == 0) {
            colorearCon(colorDeFondo, 0, 1, 2);
          } else if (posicion == 1) {
            colorearCon(colorDeFondo, 3, 4, 5);
          } else {
            colorearCon(colorDeFondo, 6, 7, 8);
          }

          break;
        case "vertical":
          if (posicion == 0) {
            colorearCon(colorDeFondo, 0, 3, 6);
          } else if (posicion == 1) {
            colorearCon(colorDeFondo, 1, 4, 7);
          } else {
            colorearCon(colorDeFondo, 2, 5, 8);
          }

          break;
        case "diagonal":
          if (posicion == 0) {
            colorearCon(colorDeFondo, 0, 4, 8);
          } else if (posicion == 1) {
            colorearCon(colorDeFondo, 2, 4, 6);
          }

          break;
      }
    }
    
    for(int i = 0; i < botones.length; i++ ) {
      String texto = posiciones[i];

      botones[i].setText( texto );

      if(texto.equals( jugador1.representacion) || texto.equals(jugador2.representacion)) {
        botones[i].setEnabled(false);
      }
    }
  
    if (!haTerminadoElJuego()) {
      barraDeEstado.setText("Turno del jugador " + (jugadorActual.representacion.equalsIgnoreCase(jugador1.representacion) ? 1 : 2));
    }
  }

  public void cambiarTurno() {
    jugadorActual = jugadorActual.equals(jugador1) ? jugador2 : jugador1;
  }

  public void jugar(int posicion) {
    String mensaje = "";
    boolean posicionEstaOcupada = false;

    if (jugadorActual.equals(jugador2)) {
      posicion = generarPosicion() + 1;
    }

    if (posicion >= 1 && posicion <= 9) {

      if (posicionEstaOcupada = estaOcupada(posicion - 1)) {
        mensaje = "Posicion ocupada. Intente de nuevo...";
      } else {
        posiciones[posicion - 1] = jugadorActual.representacion;

        if (!haTerminadoElJuego()) {
          cambiarTurno();
        }
      }
    } else {
      System.out.println("La posicion debe ser un numero entre 1 y 9");
    }

    Linea linea = obtenerLineaDeTriunfo();
    if (linea != null) {
      mensaje = "El " + jugadorActual.nombre + " Ha Ganado en la linea " + linea.direccion + " en la posicion " + linea.posicion;
      
      if(jugadorActual.equals(jugador1) ) {
        ganados++;
      }
      else {
        perdidos++;
      }
    } else if (estaEmpatado()) {
      mensaje = "El juego Está Empate!";
      empatados++;
    }

    mostrarTableroDeJuego(mensaje);

    if (haTerminadoElJuego()) {
      int opcion = JOptionPane.showConfirmDialog(this, "Desea jugar de nuevo?");

      if (opcion == JOptionPane.YES_OPTION) {
        inicializar();
      } else {
        JOptionPane.showMessageDialog(this, "Juego terminado");
      }
    } else if (jugadorActual.equals(jugador2)) {
      temporizador.start();
    }
  }

  private boolean estaOcupada(int posicion) {
    return posiciones[posicion].equalsIgnoreCase(jugador1.representacion) || posiciones[posicion].equalsIgnoreCase(jugador2.representacion);
  }

  private Linea obtenerLineaDeTriunfo() {
    Linea[] lineas = {hizoUnaLineaHorizontal(), hizoUnaLineaVertical(), hizoUnaLineaDiagonal()};
    Linea lineaResultado = null;

    for (Linea linea : lineas) {
      if (linea.posicion >= 0) {
        lineaResultado = linea;
        break;
      }
    }

    return lineaResultado;
  }

  private boolean esLinea(int a, int b, int c) {
    String representacion = jugadorActual.representacion;
    return (posiciones[a].equalsIgnoreCase(representacion) && posiciones[b].equalsIgnoreCase(representacion) && posiciones[c].equalsIgnoreCase(representacion));
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
    boolean[] lineas = {esLinea(0, 1, 2), esLinea(3, 4, 5), esLinea(6, 7, 8)};
    int posicion;

    if (lineas[0]) {
      posicion = 0;
    } else if (lineas[1]) {
      posicion = 1;
    } else if (lineas[2]) {
      posicion = 2;
    } else {
      posicion = -1;
    }

    return new Linea("horizontal", posicion);
  }

  private Linea hizoUnaLineaVertical() {
    boolean[] lineas = {esLinea(0, 3, 6), esLinea(1, 4, 7), esLinea(2, 5, 8)};
    int posicion;

    if (lineas[0]) {
      posicion = 0;
    } else if (lineas[1]) {
      posicion = 1;
    } else if (lineas[2]) {
      posicion = 2;
    } else {
      posicion = -1;
    }

    return new Linea("vertical", posicion);
  }

  private Linea hizoUnaLineaDiagonal() {
    boolean[] lineas = {esLinea(0, 4, 8), esLinea(6, 4, 2)};
    int posicion;

    if (lineas[0]) {
      posicion = 0;
    } else if (lineas[1]) {
      posicion = 1;
    } else {
      posicion = -1;
    }

    return new Linea("diagonal", posicion);
  }

  private boolean estanTodasLasPosicionesOcupadas() {
    for (int posicion = 0; posicion < posiciones.length; posicion++) {
      if (!estaOcupada(posicion)) {
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
      if (puedeGanar()) {
        posicion = obtenerPosicionDeGanar(jugador2);
        System.out.println("Intentando ganar");
      } else if (puedePerder()) {
        posicion = obtenerPosicionDeBloquear();
        System.out.println("Intentando bloquear");
      } else {
        do {
          //TODO intentar jugar de manera inteligente
          posicion = numerosAleatorios.nextInt(9);
        } while (estaOcupada(posicion));
      }
      System.out.println("Jugando " + posicion);
      for (String posicionActual : posiciones) {
        System.out.print(posicionActual + "  -");
      }
      System.out.println("Está ocupada: " + estaOcupada(posicion));

    } while (posicion != -1 && estaOcupada(posicion));

    return posicion;
  }

  private boolean puedeGanarUsando(int primeraPosicionLlena, int segundaPosicionLlena, int posicionVacia, Jugador jugador) {
    int ultimo = posiciones.length - 1;
    String representacion = jugador.representacion;
    if (primeraPosicionLlena < 0 || primeraPosicionLlena > ultimo || segundaPosicionLlena < 0 || segundaPosicionLlena > ultimo || posicionVacia < 0 || posicionVacia > ultimo) {
      return false;
    }
    return (posiciones[primeraPosicionLlena].equalsIgnoreCase(representacion) && posiciones[segundaPosicionLlena].equalsIgnoreCase(representacion) && posiciones[posicionVacia].equals(" "));
  }

  private int obtenerPosicionDeGanar(Jugador jugador) {
    /*
      0 1 2
      3 4 5
      6 7 8
     */
    //if\(puedeGanarUsando\([0-8], [0-8], [0-8](\)\))
    int posicion = -1;
    if (puedeGanarUsando(0, 1, 2, jugador)) {
      posicion = 2;
    } else if (puedeGanarUsando(0, 2, 1, jugador)) {
      posicion = 1;
    } else if (puedeGanarUsando(1, 2, 0, jugador)) {
      posicion = 0;
    } else if (puedeGanarUsando(3, 4, 5, jugador)) {
      posicion = 5;
    } else if (puedeGanarUsando(3, 5, 4, jugador)) {
      posicion = 4;
    } else if (puedeGanarUsando(4, 5, 3, jugador)) {
      posicion = 3;
    } else if (puedeGanarUsando(6, 7, 8, jugador)) {
      posicion = 8;
    } else if (puedeGanarUsando(6, 8, 7, jugador)) {
      posicion = 7;
    } else if (puedeGanarUsando(7, 8, 6, jugador)) {
      posicion = 6;
    } else if (puedeGanarUsando(0, 3, 6, jugador))//vertical
    {
      posicion = 6;
    } else if (puedeGanarUsando(0, 6, 3, jugador)) {
      posicion = 3;
    } else if (puedeGanarUsando(6, 3, 0, jugador)) {
      posicion = 0;
    } else if (puedeGanarUsando(1, 4, 7, jugador)) {
      posicion = 7;
    } else if (puedeGanarUsando(1, 7, 4, jugador)) {
      posicion = 4;
    } else if (puedeGanarUsando(4, 7, 1, jugador)) {
      posicion = 1;
    } else if (puedeGanarUsando(2, 5, 8, jugador)) {
      posicion = 8;
    } else if (puedeGanarUsando(2, 8, 5, jugador)) {
      posicion = 5;
    } else if (puedeGanarUsando(5, 8, 2, jugador)) {
      posicion = 2;
    } else if (puedeGanarUsando(0, 4, 8, jugador))//diagonal
    {
      posicion = 8;
    } else if (puedeGanarUsando(0, 8, 4, jugador)) {
      posicion = 4;
    } else if (puedeGanarUsando(4, 8, 0, jugador)) {
      posicion = 0;
    } else if (puedeGanarUsando(2, 4, 6, jugador)) {
      posicion = 6;
    } else if (puedeGanarUsando(2, 6, 4, jugador)) {
      posicion = 4;
    } else if (puedeGanarUsando(4, 6, 2, jugador)) {
      posicion = 2;
    }
    return posicion;
  }

  private boolean puedeGanar() {
    return obtenerPosicionDeGanar(jugador2) >= 0;
  }

  private int obtenerPosicionDeBloquear() {
    return obtenerPosicionDeGanar(jugador1);
  }

  boolean puedePerder() {
    return obtenerPosicionDeBloquear() >= 0;
  }

  private void inicializar() {
    for (int i = 0; i < posiciones.length; i++) {
      posiciones[i] = " ";
      botones[i].setEnabled(true);
      botones[i].setBackground(colorDeBotones);
    }

    mostrarTableroDeJuego("");

    if (jugadorActual.equals(jugador2)) {
      jugar(-1);
    }
  }
}
